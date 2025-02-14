/**
 * Ordenamiento tipo Cycle que reorganiza una lista moviendo los elementos directamente
 * a su posición correcta. Se basa en detectar ciclos de intercambio y rotar los elementos dentro de dichos ciclos.
 * Adaptado de: https://www.geeksforgeeks.org
 */
public class CycleSort {
    public static <T extends Comparable<T>> void cycleSort(T[] arr, int n) {
        // count number of memory writes
        int writes = 0;

        // traverse array elements and put them in the right place
        for (int cycle_start = 0; cycle_start <= n - 2; cycle_start++) {
            // initialize item as starting point
            T item = arr[cycle_start];

            // Find position where we put the item. We basically
            // count all smaller elements on the right side of the item.
            int pos = cycle_start;
            for (int i = cycle_start + 1; i < n; i++) {
                if (arr[i].compareTo(item) < 0) {
                    pos++;
                }
            }

            // If item is already in correct position
            if (pos == cycle_start) {
                continue;
            }

            // Ignore all duplicate elements
            while (item.equals(arr[pos])) {
                pos += 1;
            }

            // Put the item in its correct position
            if (pos != cycle_start) {
                T temp = item;
                item = arr[pos];
                arr[pos] = temp;
                writes++;
            }

            // Rotate the rest of the cycle
            while (pos != cycle_start) {
                pos = cycle_start;

                // Find position where we put the element
                for (int i = cycle_start + 1; i < n; i++) {
                    if (arr[i].compareTo(item) < 0) {
                        pos++;
                    }
                }

                // Ignore all duplicate elements
                while (item.equals(arr[pos])) {
                    pos += 1;
                }

                // Put the item in its correct position
                if (!item.equals(arr[pos])) {
                    T temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                    writes++;
                }
            }
        }
    }
}
