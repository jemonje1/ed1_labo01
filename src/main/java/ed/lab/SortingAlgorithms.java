package ed.lab;

import java.util.Random;

public class SortingAlgorithms <T> {
    private static <T extends Comparable<T>> int partitionHigh(T[] array, int lo, int hi) {
        T pivot = array[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[hi];
        array[hi] = temp;
        return i + 1;
    }

    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array, int lo, int hi) {
        if (lo < hi) {
            int p = partitionHigh(array, lo, hi);
            highPivotQuickSort(array, lo, p - 1);
            highPivotQuickSort(array, p + 1, hi);
        }
    };

    private static <T extends Comparable<T>> int partitionLow(T[] array, int lo, int hi) {
        T pivot = array[lo];
        int i = lo;

        for (int j = lo + 1; j <= hi; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i];
        array[i] = array[lo];
        array[lo] = temp;
        return i;
    }

    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array, int lo, int hi) {
        if (lo < hi) {
            int p = partitionLow(array, lo, hi);
            lowPivotQuickSort(array, lo, p - 1);
            lowPivotQuickSort(array, p + 1, hi);
        }
    }

    public static <T extends Comparable<T>> int partitionRandom(T[] array, int lo, int hi) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(hi - lo + 1) + lo;
        T temp = array[randomIndex];
        array[randomIndex] = array[hi];
        array[hi] = temp;
        T pivot = array[hi];
        int i = lo - 1;
        for (int j = lo; j <= hi; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                T swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }
        T swapTemp = array[i + 1];
        array[i + 1] = array[hi];
        array[hi] = swapTemp;
        return i + 1;
    }

    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array, int lo, int hi) {
        if (lo < hi) {
            int p = partitionRandom(array, lo, hi);
            randomPivotQuickSort(array, lo, p - 1);
            randomPivotQuickSort(array, p + 1, hi);
        }
    }
}

