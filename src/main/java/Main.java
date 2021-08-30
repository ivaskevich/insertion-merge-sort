import com.google.common.base.Stopwatch;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*
        * Merge sort takes more memory space comparing to insertion sort
        * Merge sort takes much less time than insertion sort, especially on big data
        * Merge sort takes approximately the same time either on not sorted array and partially sorted one
        * */


        int length = 100000;
        Integer[] arr = new Random().ints(length)
                .boxed().toArray(Integer[]::new);
//        Arrays.sort(arr,length/4,length/2 + length/4); //partially sorted
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();

        Stopwatch timer = Stopwatch.createStarted();
        MergeSort.sort(arr, Integer::compare);
//        InsertionSort.sort(arr, Integer::compare);

        System.out.println("Time using : " + timer.stop());
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory using: " + (usedMemoryAfter-usedMemoryBefore) + " bytes");
    }
}
