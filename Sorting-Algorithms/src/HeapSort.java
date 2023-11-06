import java.util.Arrays;
import java.util.Comparator;

public class HeapSort {

  public static <T> void heapSort(T[] arr, Comparator<? super T> c) {
    
    int n = arr.length;

    // Build max heap
    for (int  i = n/2 - 1; i >= 0; i--) {
      heapify(arr, n, i, c);
    }

    // Extract elements
    for (int i = n-1; i > 0; i--) {
      swap(arr, 0, i);
      heapify(arr, i, 0, c);
    }
  }

  private static <T> void heapify(T[] arr, int n, int i, Comparator<? super T> c) {
    int largest = i;
    int left = 2*i + 1; 
    int right = 2*i + 2;

    if (left < n && c.compare(arr[left], arr[largest]) > 0) {
      largest = left;
    }

    if (right < n && c.compare(arr[right], arr[largest]) > 0) {
      largest = right;
    }

    if (largest != i) {
      swap(arr, i, largest);
      heapify(arr, n, largest, c);
    }
  }

  private static <T> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
    public static void main(String[] args) {
      
      String[] words = {"apple", "banana", "kiwi", "mango", "peach"};
      
      // Comparator to compare string lengths 
      Comparator<String> byLength = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
          return s1.length() - s2.length(); 
        }
      };
      
      // Print original array
      System.out.println("Original Array: " + Arrays.toString(words));
      
      // Heap sort the array 
      HeapSort.heapSort(words, byLength);
      
      // Print sorted array
      System.out.println("Sorted Array: " + Arrays.toString(words));
    }
  
  }
