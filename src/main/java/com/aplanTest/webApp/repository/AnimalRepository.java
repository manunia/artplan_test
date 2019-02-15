package com.aplanTest.webApp.repository;

import com.aplanTest.webApp.domain.Animal;
import com.aplanTest.webApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal,Long> {

    List<Animal> findByType(String type);

    List<Animal> findByOwner(User owner);

    Animal findByName(String name);

    List<Animal> findById(long id);

    void deleteById(long id);


}
