import java.util.Arrays;

/**
 * que recorre una lista de números desordenada y los agrupa progresivamente según sus dígitos, 
 * desde la menor hasta la mayor posición decimal.
 * Adaptada de: https://www.geeksforgeeks.org
 */
public class RadixSort {
    
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

    static <T extends Number & Comparable<T>> void countSort(T arr[], int exp){
        int i;
        if(arr != null && arr.length != 0){
            int size = arr.length;
            T output[] = Arrays.copyOf(arr, arr.length);
            int count[] = new int[10]; //digitos de 0 a 9
            Arrays.fill(count,0);
    
            for (i=0; i < size; i++){
                count[(arr[i].intValue() / exp) % 10]++;
            }
    
            for (i=1; i<10; i++){
                count[i] += count[i-1];
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

    static <T extends Number & Comparable<T>> void radixSort(T[] arr){
        
        if(arr != null && arr.length != 0){
            T max = getMax(arr);

            for (int exp = 1; max.intValue() / exp > 0 ; exp *= 10){
                countSort(arr, exp);
            }
        }
    }
}
