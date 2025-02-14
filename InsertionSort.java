public class InsertionSort {
    public static <T extends Comparable<T>> void insertionSort(T[] arr){
        if(arr != null){
            int size = arr.length;
            for (int i=1; i<size; i++){
                T value = arr[i];
                int prevIndex = i-1;
    
            while (prevIndex>=0 && arr[prevIndex].compareTo(value)>0){
                arr[prevIndex + 1] = arr[prevIndex];
                prevIndex = prevIndex-1;
                }
                arr[prevIndex + 1] = value;
                }
        }   
    } 
}
