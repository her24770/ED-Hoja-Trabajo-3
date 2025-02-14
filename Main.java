/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Sección: 30
 * Hoja de Trabajo 3
 * @Author: Josue Hernández 24770 y Gabriel Hidalgo 24939
 * Fecha de creación: 13/02/2025
 * Última modificación: 13/02/2025
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        createFile();
        Integer[] numerosFile = readFile();
    
        System.out.println("Ingrese el número de números a analizar del 1 al 3000 \n0 para salir");
        boolean loop = true;
    
        while (loop) {
            System.out.print("Número a analizar: ");
            String numberEvalue = sc.nextLine();
    
            try {
                int number = Integer.parseInt(numberEvalue); 
    
                if (number == 0) {
                    loop = false; 
                } else if (number > 0 && number <= 3000) {
                    Integer[] numeros = new Integer[number];
    
            
                    for (int i = 0; i < number; i++) {
                        numeros[i] = numerosFile[i];
                    }
                    String[] typeSorts = {"InsertionSort","MergeSort","QuickSort","RadixSort","CycleSort"};

                    //Calculos con la lista desordenada
                    System.out.println("Calculos con la lista desordenada");
                    for(int i=0; i<5; i++){
                        long startTime = System.nanoTime(); 
                        Integer[] listTemporal = numeros.clone();
                        switch (typeSorts[i]) {
                            case "InsertionSort":
                                InsertionSort.insertionSort(listTemporal); 
                                break;
                            case "MergeSort":
                                MergeSort.sort(listTemporal, 0, listTemporal.length - 1);
                                break;
                            case "QuickSort":
                                QuickSort.quickSort(listTemporal, 0, listTemporal.length - 1);
                                break;
                            case "RadixSort":
                                RadixSort.countSort(listTemporal, listTemporal.length);
                                break;
                            case "CycleSort":
                                CycleSort.cycleSort(listTemporal, listTemporal.length);
                                break;
                            default:
                                break;
                        }
                        long endTime = System.nanoTime();
                        long duration = endTime - startTime;

                        System.out.println("Tiempo de ejecución de "+typeSorts[i]+": "+duration+" nanosegundos");
                    }

                    //calculos con la lista ordenada

                    System.out.println("Calculos con la lista ordenada");
                    InsertionSort.insertionSort(numeros);
                    for(int i=0; i<5; i++){
                        long startTime = System.nanoTime(); // Tiempo inicial
                        Integer[] listTemporal = numeros.clone();
                        switch (typeSorts[i]) {
                            case "InsertionSort":
                                InsertionSort.insertionSort(listTemporal); 
                                break;
                            case "MergeSort":
                                MergeSort.sort(listTemporal, 0, listTemporal.length - 1);
                                break;
                            case "QuickSort":
                                QuickSort.quickSort(listTemporal, 0, listTemporal.length - 1);
                                break;
                            case "RadixSort":
                                RadixSort.countSort(listTemporal, listTemporal.length);
                                break;
                            case "CycleSort":
                                CycleSort.cycleSort(listTemporal, listTemporal.length);
                                break;
                            default:
                                break;
                        }
                        long endTime = System.nanoTime();
                        long duration = endTime - startTime;

                        System.out.println("Tiempo de ejecución de "+typeSorts[i]+": "+duration+" nanosegundos");
                    }
                    

                   
    
                    //Imprimir lista ordenada
                    System.out.println("Lista ordenada: ");
                    for (int i = 0; i < number; i++) {
                        System.out.print(numeros[i] + " ");
                    }
                    System.out.println();
                    
                    
                } else {
                    System.out.println("Ingrese un número entre 1 y 3000.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido."); 
            }
        }
    
        sc.close();
    }


    // funcion para crear archivo con numeros aleatorios
    public static void createFile() {
        try (FileWriter escribirtxt = new FileWriter("data.txt")) {
            for (int i = 0; i < 3000; i++) {
                escribirtxt.write((int) (Math.random() * 5000) + " ");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Función para leer data de archivo
    public static Integer[] readFile() {
        List<Integer> numeros = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("data.txt"))) {
            while (scanner.hasNextInt()) {
                numeros.add(scanner.nextInt());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        Integer[] numerosArray = new Integer[numeros.size()];
        numeros.toArray(numerosArray);
        return numerosArray;
    }
}