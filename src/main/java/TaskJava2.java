/*
Пусть дан список сотрудников:

Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов

А) Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.

Б) Отсортировать по убыванию популярности.
 */


import java.util.*;
import java.util.stream.Collectors;

public class TaskJava2 {
    public static void main(String[] args) {
        HashMap<String, String> arrayList = new HashMap<>();
        arrayList.put("Иванов", "Иван");
        arrayList.put("Петрова", "Светлана");
        arrayList.put("Белова", "Кристина");
        arrayList.put("Мусина", "Анна");
        arrayList.put("Крутова", "Анна");
        arrayList.put("Юрин", "Иван");
        arrayList.put("Лыков", "Петр");
        arrayList.put("Чернов", "Павел");
        arrayList.put("Чернышов", "Петр");
        arrayList.put("Федорова", "Мария");
        arrayList.put("Светлова", "Марина");
        arrayList.put("Савина", "Мария");
        arrayList.put("Рыкова", "Мария");
        arrayList.put("Лугова", "Марина");
        arrayList.put("Владимирова", "Анна");
        arrayList.put("Мечников", "Иван");
        arrayList.put("Петин", "Петр");
        arrayList.put("Ежов", "Иван");

        for (String key : arrayList.keySet()) {
            List<String> values = Collections.singletonList(arrayList.get(key));
            System.out.println("Фамилия: " + key + "\t\t\t\t" + "Имя: " + values);
        }

        HashMap<String, Integer> countMap = new HashMap<>();

        for (String value : arrayList.values()) {
            if (countMap.containsKey(value)) {
                countMap.put(value, countMap.get(value) + 1);
            }
            else {
                countMap.put(value, 1);
            }
        }
        countMap.entrySet().removeIf(entry -> entry.getValue() == 1); // удаляем все ключ-значение значение которых равно 1;
        System.out.println("Количество повторяющихся значений: " + countMap);

        List<Map.Entry<String, Integer>> sortedList = countMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .toList();

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
