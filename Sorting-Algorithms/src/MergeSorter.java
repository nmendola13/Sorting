import java.util.Arrays;
import java.util.Comparator;

/**
 * A simple way to sort arrays using merge sort.
 *
 * @author Reed
 * @author Noah
 * @author Samuel A. Rebelsky
 */
public class MergeSorter {

  // +------------------+--------------------------------------------
  // | Exported methods |
  // +------------------+

  /**
   * Sort an array using the merge sort algorithm.
   */
  public static <T> void sort(T[] vals, Comparator<? super T> comparator) {
    sort(0, vals.length, vals, comparator);
  } // sort

  /**
   * Recursive helper for the sort method.
   */
  public static <T> void sort(int i, int size, T[] vals, Comparator<? super T> comparator) {

    // Base case
    if (size <= 1)
      return;

    // Recursively sort first and second halves
    int mid = size / 2;
    sort(i, mid, vals, comparator);
    sort(i + mid, size - mid, vals, comparator);

    // Merge sorted halves
    merge(vals, i, i + mid, i + size, comparator);
  }

  // Implementation of merge remains same

  // sort

  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int start, int mid, int end, Comparator<? super T> comparator) {
    int leftSize = mid - start;
    int rightSize = end - mid;

    T[] L = Arrays.copyOfRange(vals, start, mid);
    T[] R = Arrays.copyOfRange(vals, mid, end);

    int i = 0, j = 0;

    // Initial index of merged subarray array
    int k = start;
    while (i < leftSize && j < rightSize) {
      if (comparator.compare(L[i], R[j]) <= 0) {
        vals[k] = L[i];
        i++;
      } else {
        vals[k] = R[j];
        j++;
      }
      k++;
    }

    // Copy remaining elements of L[] if any
    while (i < leftSize) {
      vals[k] = L[i];
      i++;
      k++;
    }

    // Copy remaining elements of R[] if any
    while (j < rightSize) {
      vals[k] = R[j];
      j++;
      k++;
    }
  }
}// class MergeSorter
