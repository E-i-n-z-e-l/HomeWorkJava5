/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TaskJava1 {
    public static void main(String[] args) {

        HashMap<String, List<String>> telephoneDirectory = new HashMap<>(); // Создаем HashMap;
        List<String> telephoneNumber = new ArrayList<>(); // Создаем список прямо в HashMap;
        telephoneNumber.add("123");
        telephoneNumber.add("456");
        telephoneNumber.add("789");
        telephoneDirectory.put("Иванов", telephoneNumber); // метод put() позволяет добавить в HashMap ключ и значение(-я)

        for (String key : telephoneDirectory.keySet()) {      // Проходимся по ключам с помощью keySet();
            telephoneNumber = telephoneDirectory.get(key);
            System.out.println("Фамилия: " + key);
            System.out.println("Телефонные номера: " + telephoneNumber);
        }

    }
}

/*
Структура реализована - в HashMap лежит список, который принимает несколько значений.
 */
