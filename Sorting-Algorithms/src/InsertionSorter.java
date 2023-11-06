import java.util.Arrays;
import java.util.Comparator;

public class InsertionSorter {

    public static <T> void insertionSort(T[] arr, Comparator<? super T> compare) {
        for (int pos = 1; pos < arr.length; pos++) {
            T temp = arr[pos];
            int index = pos;
            while (index > 0 && compare.compare(arr[index - 1], temp) > 0) {
                arr[index] = arr[index - 1];
                index--;
            }
            arr[index] = temp;
        }
    }
}
