import java.util.Arrays;
import java.util.Comparator;
import java.io.PrintWriter;

/**
 * Experiments with merge sort.
 *
 * @author YourName Here
 * @author Your NameHere
 * @author Samuel A. Rebelsky
 */
public class MergeSortExperiments {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run a bunch of experiments.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    experiment01(pen);
    experiment02(pen);
    experiment03(pen);
    experiment04(pen);
    experiment05(pen);
    experiment06(pen);
    experiment07(pen);
    experiment08(pen);
  } // main

  // +-------------+-------------------------------------------------
  // | Comparators |
  // +-------------+

  /**
   * Compare integers.
   */
  static Comparator<Integer> compareInts = (x,y) -> x == y ? 0 : x < y ? -1 : 1;

  /**
   * Compare strings.
   */
  static Comparator<String> compareStrings = Comparator.comparingInt(String::length);

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+

  /**
   * Sort a small array of integers.
   */
  static void experiment01(PrintWriter pen) {
    integerMergeSort(pen, new Integer[] { 3, 5, 1, 2, 4, 3 });
  } // experiment01(PrintWriter)

  /**
   * Sort a small array of strings.
   */
  static void experiment02(PrintWriter pen) {
    stringMergeSort(pen, new String[] { "foo", "bar", "baz", "qux", "fu" });
  } // experiment(02)


  static void experiment03(PrintWriter pen) {
    integerInsertionSort(pen, new Integer[] { 3, 5, 1, 4, 2, 4, 3 });
  } // experiment01(PrintWriter)

  /**
   * Sort a small array of strings.
   */
  static void experiment04(PrintWriter pen) {
    stringInsertionSort(pen, new String[] { "foo", "bar", "baz", "qux", "fu" });
  } // experiment(02)

  /**
   * Sort a small array of strings.
   */
  static void experiment07(PrintWriter pen) {
    integerQuickSort(pen, new Integer[] { 3, 5, 1, 2, 4, 3 });
  } // experiment(02)

  /**
   * Sort a small array of strings.
   */
  static void experiment08(PrintWriter pen) {
    stringQuickSort(pen, new String[] { "foo", "bar", "baz", "qux", "fu" });
  } // experiment(02)
  

  static void experiment05(PrintWriter pen) {
    integerNoahMendolaSort(pen, new Integer[] { 3, 5, 1, 2, 4, 3 });
  } // experiment01(PrintWriter)

  /**
   * Sort a small array of strings.
   */
  static void experiment06(PrintWriter pen) {
    stringNoahMendolaSort(pen, new String[] { "foo", "bar", "baz", "qux", "fu" });
  } // experiment(02)
  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

 /**
   * Sort an array of integers.
   */
  static void integerMergeSort(PrintWriter pen, Integer[] vals) {
    pen.print(Arrays.toString(vals));
    pen.print(" Merge -> ");
    MergeSorter.sort(vals, compareInts);
    pen.println(Arrays.toString(vals));
  } // integerSortExperiment(PrintWriter, Integer[])   

  /**
   * Sort an array of strings.
   */
  static void stringMergeSort(PrintWriter pen, String[] vals) {
    pen.print(Arrays.toString(vals));
    pen.print(" Merge -> ");
    MergeSorter.sort(vals, compareStrings);
    pen.println(Arrays.toString(vals));
  } // stringSortExperiment(PrintWriter, String[])   

 /**
   * Sort an array of integers.
   */
  static void integerInsertionSort(PrintWriter pen, Integer[] vals) {
    pen.print(Arrays.toString(vals));
    pen.print(" Insertion -> ");
    InsertionSorter.insertionSort(vals, compareInts);
    pen.println(Arrays.toString(vals));
  } // integerSortExperiment(Print[Writer, Integer[])   

  /**
   * Sort an array of strings.
   */
  static void stringInsertionSort(PrintWriter pen, String[] vals) {
    pen.print(Arrays.toString(vals));
    pen.print(" Insertion -> ");
    InsertionSorter.insertionSort(vals, compareStrings);
    pen.println(Arrays.toString(vals));
  } // stringSortExperiment(PrintWriter, String[])   

  static void integerQuickSort(PrintWriter pen, Integer[] vals) {
    pen.print(Arrays.toString(vals));
    pen.print(" Quick -> ");
    QuickSort.quickSort(vals, compareInts, 0, vals.length - 1);
    pen.println(Arrays.toString(vals));
  } // integerSortExperiment(Print[Writer, Integer[])   

  /**
   * Sort an array of strings.
   */
  static void stringQuickSort(PrintWriter pen, String[] vals) {
    pen.print(Arrays.toString(vals));
    pen.print(" Quick -> ");
    QuickSort.quickSort(vals, compareStrings, 0, vals.length - 1);
    pen.println(Arrays.toString(vals));
  }

  /**
   * Sort an array of integers.
   */
  static void integerNoahMendolaSort(PrintWriter pen, Integer[] vals) {
    pen.print(Arrays.toString(vals));
    pen.print(" Noah -> ");
    NoahMendolaSort.introsort(vals, compareInts);
    pen.println(Arrays.toString(vals));
  } // integerSortExperiment(PrintWriter, Integer[])   

  /**
   * Sort an array of strings.
   */
  static void stringNoahMendolaSort(PrintWriter pen, String[] vals) {
    pen.print(Arrays.toString(vals));
    pen.print(" Noah -> ");
    NoahMendolaSort.introsort(vals, compareStrings);
    pen.println(Arrays.toString(vals));
  }  

} // class MergeSortExperiments
