package Java.HWork5;

/*Пусть дан список сотрудников. Написать программу, 
которая найдет и выведет повторяющиеся имена с количеством повторений. 
Отсортировать по убыванию популярности. */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class task2 {

    public static void findCopyAndSort(String[] array) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i].split(" ")[0].equals(array[j].split(" ")[0])) {
                    count++;
                }
            }
            map.putIfAbsent(array[i].split(" ")[0], count);
            count = 0;
        }
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        String[] array = new String[] {
                "Иван Иванов", "Светлана Петрова",
                "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов",
                "Петр Чернышов", "Мария Федорова",
                "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова",
                "Анна Владимирова", "Иван Мечников",
                "Петр Петин", "Иван Ежов" };

        findCopyAndSort(array);
    }
}