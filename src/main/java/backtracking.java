/*
Алгоритм backtracking(поиск с возвратом).
 */
import java.util.ArrayList;
public class backtracking {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        backtrack(nums, new ArrayList<>());
    }
    private static void backtrack(int[] nums, ArrayList<Integer> tempList) {
        if (tempList.size() == nums.length) {
            System.out.println(tempList);
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // contains() используется для проверки наличия элемента в коллекции,
                tempList.add(nums[i]);                    // Он возвращает true, если элемент присутствует в коллекции, и false в противном случае.
                backtrack(nums, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }

    }
}
