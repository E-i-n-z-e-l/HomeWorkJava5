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
            System.out.println("Фамилия: " + key + "\t\t\t\t" + "Имя: " + values); // выводим в терминал HashMap для проверки введенных выше ключей и значений;
        }

        HashMap<String, Integer> countMap = new HashMap<>(); // Создаем новый HashMap чтобы поместить в него все значения из предыдущего HashMap чтобы узнать сколько раз кажждое значение повторяется;

        for (String value : arrayList.values()) { // заносим в новый HashMap кол-во повторений значений из предыдущего HashMap
            if (countMap.containsKey(value)) {
                countMap.put(value, countMap.get(value) + 1);
            }
            else {
                countMap.put(value, 1);
            }
        }
        
        countMap.entrySet().removeIf(entry -> entry.getValue() == 1); //  Метод entrySet() возвращает набор элементов коллекции countMap в виде множества объектов типа Map.Entry<K, V>, где K - тип ключа, а V - тип значения. 
                                                                      //  метод removeIf() применяется к этому множеству, и для каждого элемента выполняется проверка на условие - если значение равно 1, то элемент удаляется из коллекции
                                                                      //  Лямбда-выражение entry -> entry.getValue() == 1 является предикатом, который возвращает true для элементов, у которых значение равно 1;
        
        System.out.println("Количество повторяющихся значений: " + countMap); // выводим в терминал для проверки;

        List<Map.Entry<String, Integer>> sortedList = countMap.entrySet()
                .stream() // stream() создает поток данных для коллекции или массива, что позволяет последовательно обрабатывать элементы этой коллекции или массива с помощью различных операций;
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) // Метод comparingByValue() создает компаратор, который сравнивает значения элементов потока. Этот метод может быть использован в методе sorted() для сортировки элементов потока по значениям. Метод reversed() создает компаратор, который обращает порядок сортировки элементов. 
                .toList(); // Метод toList() преобразует элементы потока в список;

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
