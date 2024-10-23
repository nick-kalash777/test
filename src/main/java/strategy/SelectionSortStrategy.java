package strategy;

//example usage:
//SelectionSortStrategy<T> sorter = new SelectionSortStrategy<>();
//sorter.sort(array)

public class SelectionSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {
    public void sort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            //swap elements if minIndex changed
            if (minIndex != i) {
                T temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}

