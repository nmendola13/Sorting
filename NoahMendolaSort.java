import java.util.Comparator;
import java.util.Arrays;
import java.lang.Math;

public class NoahMendolaSort {
  
  public static <T> void introsort(T[] values, Comparator<? super T> compare) {
    introsort(values, compare, 0, values.length - 1, 0);
  }

  private static <T> void introsort(T[] values, Comparator<? super T> compare, 
                                    int start, int end, int depth) {
    int maxDepth = 2 * (int) Math.log(values.length);                                  
    if (end - start <= 1) {
      return;
    }
    
    if (depth == maxDepth) {
        HeapSort.heapSort(values, compare);
      return;
    }
    
    int pivot = QuickSort.partition(values, compare, start, end);
    
    introsort(values, compare, start, pivot, depth+1);
    introsort(values, compare, pivot+1, end, depth+1);
  }

}
   