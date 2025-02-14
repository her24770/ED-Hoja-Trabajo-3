import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Pruebas unitarias para el Radix Sort
 */
public class RadixSortTest {
    
    /**
     * Prueba con lista desordenada
     */
    @Test 
    public void shouldBeAbleToRadixSortUnsortedList(){
        Integer[] unsortedList = {5, 11, 400, 2, 7,9,65,32,99,21};
        RadixSort.radixSort(unsortedList);
        Integer[] expected = {2,5,7,9,11,21,32,65,99,400};
        assertArrayEquals(unsortedList,expected);
    }

     /**
     * Prueba con lista ordenada
     */
    @Test 
    public void shouldBeAbleToRadixSortSortedList(){
        Integer[] sortedList = {2,5,6,11,45,95,101,102,103,104};
        RadixSort.radixSort(sortedList);
        Integer[] expected = {2,5,6,11,45,95,101,102,103,104};
        assertArrayEquals(sortedList,expected);
    }

     /**
     * Prueba con lista con datos repetidos
     */
    @Test
    public void shouldBeAbleToRadixSortRepeatedValuesList(){
        Integer[] repeatedValuesList = {5,5,10,1,5,8,12,50,21,1};
        RadixSort.radixSort(repeatedValuesList);
        Integer[] expected = {1,1,5,5,5,8,10,12,21,50};
        assertArrayEquals(repeatedValuesList,expected);
    }

    /**
     * Prueba con lista null
     */
    @Test
    public void shouldNotCrashWithNullList(){
        Integer[] nullList = null;
        RadixSort.radixSort(nullList);
        assertArrayEquals(nullList, null);
    }

    /**
     * Prueba con lista vacia
     */
    @Test
    public void shouldNotCrashWithEmptyList(){
        Integer[] emptyList = {};
        RadixSort.radixSort(emptyList);
        Integer[] expected = {};
        assertArrayEquals(emptyList, expected);
    }
}
