/**
 * Ordenamiento tipo Merge Sort que divide recursivamente una lista desordenada en mitades,
 * ordena cada mitad y luego combina (merge) las mitades ordenadas para obtener la lista final ordenada.
 * Adaptada de: https://www.geeksforgeeks.org
 */
public class MergeSort {
    
    public static <T extends Comparable<T>> void merge(T[] arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        T[] L = (T[]) new Comparable[n1]; 
        T[] R = (T[]) new Comparable[n2]; 

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;

        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Método recursivo para ordenar el arreglo
    public static <T extends Comparable<T>> void sort(T[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
}
