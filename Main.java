import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createFile();
        List<Integer> numeros = readFile();

        

        scanner.close();
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
    public static List<Integer> readFile() {
        List<Integer> numeros = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("data.txt"))) {
            while (scanner.hasNextInt()) {
                numeros.add(scanner.nextInt()); // Lee los números y los agrega a la lista
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return numeros;
    }
}