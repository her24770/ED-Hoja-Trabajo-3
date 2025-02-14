import java.util.Arrays;

/**
 * que recorre una lista de números desordenada y los agrupa progresivamente según sus dígitos, 
 * desde la menor hasta la mayor posición decimal.
 * Adaptada de: https://www.geeksforgeeks.org
 */
public class RadixSort {
    /**
     * Regresa el objeto de mayor valor del arreglo
     * @param <T> Tipo de dato numérico que implementa Comparable.
     * @param arr arreglo a ordenar
     * @return el objeto de mayor valor
     */
    static <T extends Comparable<T>> T getMax(T[] arr){
        T max = arr[0];
        if(arr != null && arr.length != 0){
            int size = arr.length;
            for (int i = 1; i<size; i++){
                if(arr[i].compareTo(max)>0){
                    max = arr[i];
                }
            }  
        }return max;

    }
    /**
     * Ordena los elementos según su valor en la posición decimal dada por 'exp'.
     * @param <T> Tipo de dato numérico que implementa Comparable.
     * @param arr arreglo a ordenar 
     * @param exp El valor de la posición decimal actual (1, 10, 100, etc.) sobre la que se ordenará
     */
    static <T extends Number & Comparable<T>> void countSort(T arr[], int exp){
        int i;
        if(arr != null && arr.length != 0){
            int size = arr.length;
            T output[] = Arrays.copyOf(arr, arr.length);
            int count[] = new int[10]; //digitos de 0 a 9
            Arrays.fill(count,0);
    
            for (i=0; i < size; i++){
                count[(arr[i].intValue() / exp) % 10]++; //Cuenta cuántos números tienen cada dígito en la posición actual (exp)
            }
    
            for (i=1; i<10; i++){ 
                count[i] += count[i-1]; //Ajusta count[i] para que almacene la posición donde irá cada número
            }
    
            for (i=size-1; i>=0; i--){
                output[count[(arr[i].intValue()/exp)%10]-1] = arr[i];
                count[(arr[i].intValue()/exp)%10]--;
            }
    
            for (i=0; i < size; i++){
                arr[i] = output[i];
            }
        }
        
    }

    /**
     * Ordena los elementos analizando sus dígitos de menor a mayor posición decimal
     * @param <T> Tipo de dato numérico que implementa Comparable.
     * @param arr arreglo a ordenar
     */
    static <T extends Number & Comparable<T>> void radixSort(T[] arr){
        
        if(arr != null && arr.length != 0){
            T max = getMax(arr);

            for (int exp = 1; max.intValue() / exp > 0 ; exp *= 10){
                countSort(arr, exp);
            }
        }
    }
}
