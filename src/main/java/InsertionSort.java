import java.util.Comparator;

public class InsertionSort {

    public static <T> void sort(T[] arr, Comparator<T> comparator) {
        if (arr.length <= 1)
            return;

        for (int i = 1; i < arr.length; i++) {
            var successStep = -1;
            var j = i - 1;
            while (j >= 0 && comparator.compare(arr[i], arr[j]) < 0) {
                successStep = j--;
            }
            if (successStep != -1) {
                var temp = arr[i];
                System.arraycopy(arr, successStep, arr, successStep + 1, i - successStep);
                arr[successStep] = temp;
            }
        }
    }
}
