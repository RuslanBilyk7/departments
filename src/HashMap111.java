import java.util.HashMap;
import java.util.Map;

/**
 * Created by RUSLAN77 on  30.01.2018 in Ukraine
 */

public class HashMap111 {
    public static void main(String[] args) {
//        Map<String, Integer> hashMap = new HashMap<>();
//
//        hashMap.put("Васька", 0);
//        hashMap.put("Закваска", 5);
//        hashMap.put("Аська", 10);
//        hashMap.put("Рыжик", 10);
//
//
//        for (String k : hashMap.keySet()) {
//            System.out.println("Key: " + k);
//        }
//
//        for (Integer v : hashMap.values()) {
//            System.out.println("Values: " + v);
//        }
//
//        // Добавляем значение
//
////        hashMap.put("Рыжик",  3);
//        // Добавляем значение
////        int value = hashMap.get("Рыжик");
//        hashMap.put("Рыжик", hashMap.get("Рыжик") + 3);
//        System.out.println("У Рыжика стало " + hashMap.get("Рыжик"));
//
//
//        for (Map.Entry entry : hashMap.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + " Value: "
//                    + entry.getValue());


//        Random random = new Random(36);
//        Map<Integer, Integer> hashMap = new HashMap<>();
//
//        for (int i = 0; i < 100; i++) {
//            // Создадим число от 0 до 10
//            int number = random.nextInt(10);
//            Integer frequency = hashMap.get(number);
//            hashMap.put(number, frequency == null ? 1 : frequency + 1);
//        }
//


        Map<String, Pet> hashMap = new HashMap<>();

        hashMap.put("Кот", new Cat("Мурзик"));
        hashMap.put("Собака", new Dog("Бобик"));
        hashMap.put("Попугай", new Parrot("Кеша"));
        System.out.println(hashMap);
        Pet cat = hashMap.get("Кот");
        System.out.println(cat);
        System.out.println(hashMap.containsKey("Кот"));
        System.out.println(hashMap.containsValue(cat));
    }

    private static class Cat extends Pet {
        public Cat(String мурзик) {
            super();
        }
    }

    private static class Dog extends Pet {
        public Dog(String бобик) {
            super();
        }
    }

    private static class Parrot extends Pet {
        public Parrot(String кеша) {
            super();
        }
    }
}
