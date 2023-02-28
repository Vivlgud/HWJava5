package Java.HWork5;

/* Реализуйте структуру телефонной книги с помощью HashMap, 
учитывая, что 1 человек может иметь несколько телефонов.*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task1 {

    public static void addContact(String name, Integer number, Map<String, ArrayList<Integer>> phoneBook) {
        if (!phoneBook.containsKey(name)) {
            ArrayList<Integer> numbers = new ArrayList<>();
            numbers.add(number);
            phoneBook.put(name, numbers);
        } else {
            var numbers = phoneBook.get(name);
            numbers.add(number);
            phoneBook.put(name, numbers);
        }
    }

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String flag;

        while (true) {
            System.out.print("Введите имя: ");
            String name = scanner.next();
            System.out.print("Введите номер: ");
            int number = scanner.nextInt();
            addContact(name, number, phoneBook);
            System.out.print("Нажмите 'q' для выхода или любой символ для продолжения: ");
            flag = scanner.next();
            if (flag.equals("q")) {
                break;
            }

        }
        scanner.close();

        System.out.println("Справочник: ");
        for (var i : phoneBook.entrySet()) {
            System.out.printf("%s %s\n", i.getKey(), i.getValue().toString());
        }

    }
}