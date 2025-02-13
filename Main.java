import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        createFile();

        List<Integer> numeros = readFile();

        System.out.println("Números leídos del archivo:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }


    // funcion para crear archivo con numeros aleatorios
    public static void createFile() {
        try (FileWriter writer = new FileWriter("data.txt")) {
            for (int i = 0; i < 3000; i++) {
                writer.write((int) (Math.random() * 5000) + " ");
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