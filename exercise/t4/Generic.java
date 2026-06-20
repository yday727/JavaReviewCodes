package exercise.t4;

public class Generic {
    public static <T extends Comparable<T>> T findMax (T[] array) {
        T maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(maxValue) > 0) {
                maxValue = array[i];
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Double[] arr = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9};
        System.out.println(findMax(arr));
    }
}
