import java.util.Comparator;

public class QuickSort {
  /**
   * Select a pivot and partition the subarray from [lb .. ub) into the following
   * form.
   *
   * <pre>
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   * 
   * @author Alma Ordaz and Noah Mendola
   * @return pivotLoc.
   */
  private static <T> void swap(T[] arr, int a, int b) {
    T temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  static <T> int partition(T[] arr, Comparator<? super T> compare, int lb, int ub) {

    int mid = lb + (ub - lb) / 2;
    swap(arr, mid, lb);
  
    int pivot = lb;
    int small = lb + 1;
    int large = ub;
  
    while (small <= large) {
      if (compare.compare(arr[small], arr[pivot]) < 0) {
        small++; 
      } else if (compare.compare(arr[large], arr[pivot]) > 0) {
        large--;
      } else {
        swap(arr, small, large);
        small++;
        large--;
      }
    }
    
    swap(arr, pivot, large);
    return large;
  }// partition

  static <T> void quickSort(T[] values, Comparator<? super T> compare, int small, int large) {
    // Slargearrays of one element or fewer are sorted.
    if (small >= large) {
      return;
    } else {
      int mid = partition(values, compare, small, large);
      quickSort(values, compare, small, mid);
      quickSort(values, compare, mid + 1, large);
    } // if/else
  } // quickSort(T[], Comparator, int, int)
}
