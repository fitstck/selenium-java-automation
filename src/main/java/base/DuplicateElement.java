package base;

import java.util.HashSet;

public class DuplicateElement {
    public static void main(String[] arg) {
        int[] arr = {1, 2, 3, 2, 5};
        HashSet<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) {
                System.out.println("There is duplicate: " + num);
            }
        }
    }
}
