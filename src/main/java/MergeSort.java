import java.util.Comparator;

public class MergeSort {

    public static <T> void sort(T[] arr, Comparator<T> comparator) {
        if (arr.length < 2)
            return;

        var mid = arr.length / 2;
        T[] left = generateArray(mid);
        T[] right = generateArray(arr.length - mid);
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length -mid);

        sort(left, comparator);
        sort(right, comparator);

        mergeHelper(arr,left,right,comparator);
    }

    private static <T> void mergeHelper(T[] source, T[] sortedLeft, T[] sortedRight, Comparator<T> comparator) {
        int l = 0, r = 0;
        while (l < sortedLeft.length && r < sortedRight.length) {
            if (comparator.compare(sortedLeft[l], sortedRight[r]) > 0)
                source[l + r] = sortedRight[r++];
            else
                source[l + r] = sortedLeft[l++];
        }

        if (l == sortedLeft.length) {
            System.arraycopy(sortedRight, r, source, l + r, source.length - (l + r));
        } else {
            System.arraycopy(sortedLeft, l, source, l + r, source.length - (l + r));
        }
    }

    private static <T> T[] generateArray(int size) {
        return (T[]) new Object[size];
    }
}
