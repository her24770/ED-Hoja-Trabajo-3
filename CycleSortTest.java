import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Pruebas unitarias para el Insertion Sort
 */
public class CycleSortTest {

    /**
     * Prueba con lista desordenada
     */
    @Test
    public void shouldInsertionSortUnsortedList(){
        Integer[] unsortedList = {5, 11, 400, 2, 7,9,65,32,99,21};
        CycleSort.cycleSort(unsortedList, unsortedList.length);
        Integer[] expected = {2,5,7,9,11,21,32,65,99,400};
        assertArrayEquals(unsortedList, expected);
    }

    /**
     * Prueba con lista ordenada
     */
    @Test 
    public void shouldInsertionSortSortedList(){
        Integer[] sortedList = {2,5,6,11,45,95,101,102,103,104};
        CycleSort.cycleSort(sortedList, sortedList.length);
        Integer[] expected = {2,5,6,11,45,95,101,102,103,104};
        assertArrayEquals(sortedList,expected);
    }

    /**
     * Prueba con lista con datos repetidos
     */
    @Test
    public void shouldInsertionSortRepeatedValuesList(){
        Integer[] repeatedValuesList = {5,5,10,1,5,8,12,50,21,1};
        CycleSort.cycleSort(repeatedValuesList, repeatedValuesList.length);
        Integer[] expected = {1,1,5,5,5,8,10,12,21,50};
        assertArrayEquals(repeatedValuesList,expected);
    }

    /**
     * Prueba con lista null
     */
    @Test
    public void shouldNotCrashWithNullList(){
        Integer[] nullList = null;
        CycleSort.cycleSort(nullList, 0);
        assertArrayEquals(nullList, null);
    }

    /**
     * Prueba con lista vacia
     */
    @Test
    public void shouldNotCrashWithEmptyList(){
        Integer[] emptyList = {};
        CycleSort.cycleSort(emptyList, emptyList.length);
        Integer[] expected = {};
        assertArrayEquals(emptyList, expected);
    }
}
