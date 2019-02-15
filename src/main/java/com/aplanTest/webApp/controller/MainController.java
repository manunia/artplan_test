package com.aplanTest.webApp.controller;

import com.aplanTest.webApp.domain.Animal;
import com.aplanTest.webApp.domain.User;
import com.aplanTest.webApp.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Map;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/")
    public String greeting(Map<String,Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user, @RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Animal> animals;

        if (filter != null && !filter.isEmpty()) {
            try {//пытаемся получить по id
                animals = animalRepository.findById(Long.parseLong(filter));
            } catch (NumberFormatException e) {//если строка, то получаем по типу
                animals = animalRepository.findByType(filter);
            }

        } else {
            animals = animalRepository.findAll();
        }
        model.addAttribute("animals", animals);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String name, @RequestParam String type,
                      @RequestParam String gender, @RequestParam Date birthDate,
                      Map<String,Object> model) {
        //проверяем уникальность имени животного
        Animal animalFromDb = animalRepository.findByName(name);
        if (animalFromDb != null) {
            model.put("message","Животное с таким именем уже зарегестрировано. Имя животного должно быть уникальным");
        } else {

            Animal animal = new Animal(type, birthDate, gender, name, user);
            animalRepository.save(animal);

            Iterable<Animal> animals = animalRepository.findAll();
            model.put("animals", animals);
        }
        return "main";
    }

    @GetMapping("/user-animals/{user}")
    public String userAnimals(@AuthenticationPrincipal User currentuser,
                              @PathVariable User user, Model model,
                              @RequestParam(required = false) Animal animal) {
        Set<Animal> animals = user.getAnimals();

        model.addAttribute("animals",animals);
        model.addAttribute("animal",animal);
        model.addAttribute("isCurrentUser",currentuser.equals(user));

        return "userAnimals";
    }

    @PostMapping("/user-animals/{user}")
    public String update(@AuthenticationPrincipal User currentUser,
                         @PathVariable Long user,
                         @RequestParam("id") Animal animal,
                         @RequestParam("name") String name, @RequestParam("type") String type,
                         @RequestParam("gender") String gender, @RequestParam("birthDate") Date birthDate,
                         Model model) {
        //проверяем уникальность имени животного
        Animal animalFromDb = animalRepository.findByName(name);
        if (animalFromDb != null) {
            model.addAttribute("message","Животное с таким именем уже зарегестрировано. Имя животного должно быть уникальным");
        } else {

            if (animal.getOwner().equals(currentUser)) {
                if (!StringUtils.isEmpty(name)) {
                    animal.setName(name);
                }
                if (!StringUtils.isEmpty(type)) {
                    animal.setType(type);
                }
                if (!StringUtils.isEmpty(gender)) {
                    animal.setGender(gender);
                }
                if (!StringUtils.isEmpty(birthDate)) {
                    animal.setBirthDate(birthDate);
                }
                animalRepository.save(animal);
            }
        }

        return "redirect:/user-animals/" + user;
    }

    @DeleteMapping("/user-animals/{user}")
    public void delete(@AuthenticationPrincipal User currentUser, @RequestParam("id") Animal animal) {
        if (animal.getOwner().equals(currentUser)) {
            animalRepository.delete(animal);
            System.out.println(animal.getId());
        }
    }
}
