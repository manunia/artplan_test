package warming;

public class WarmingUp {

//    Написать метод, который разворачивает строку в обратном порядке и
//    замерить время работы этого метода на 1000, 10 000, 100 000 повторений.
//    оформить надо в виде stand alone java приложения с консольным вводом строки.
//    результатом работы должны быть строка, развернутая строка и 3 цифры (время работы).

    public static void main(String[] args) {

        String firstStr = "123456";
        String expandStr = expandString(firstStr);

        System.out.println("Исходная строка: " + firstStr);
        System.out.println("Перевернутая строка: " + expandStr);

        long currentTime1 = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            expandString(firstStr);
        }
        System.out.println("Время работы 1000 повторений: " + (System.currentTimeMillis() - currentTime1));

        long currentTime2 = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            expandString(firstStr);
        }
        System.out.println("Время работы 10 000 повторений: " + (System.currentTimeMillis() - currentTime2));

        long currentTime3 = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            expandString(firstStr);
        }
        System.out.println("Время работы 100 000 повторений: " + (System.currentTimeMillis() - currentTime3));

    }

    static String expandString(String str) {
        String expStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            expStr+= str.charAt(i);
        }
        return expStr;
    }
}
