import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Service s = new Service();
        Scanner scanner = new Scanner(System.in);
        int wybor = -1;

        while (wybor != 0) {
            System.out.println("\n===== MENU APLIKACJI =====");
            System.out.println("1 - Dodaj  studenta");
            System.out.println("2 - Wyświetl  studentów");
            System.out.println("0 - Wyjście");
            System.out.print("Twój wybór: ");

            wybor = scanner.nextInt();
            scanner.nextLine(); // czyszczenie bufora

            switch (wybor) {

                case 1:
                    System.out.print("Podaj imię studenta: ");
                    String name = scanner.nextLine();

                    System.out.print("Podaj nazwisko studenta: ");
                    String surname = scanner.nextLine();

                    System.out.print("Podaj wiek studenta: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Podaj datę urodzenia studenta: ");  
                    String birthDate = scanner.nextLine();

                    try {
                        s.addStudent(new Student(name, surname, age, birthDate));
                        System.out.println("Student został dodany!");
                    } catch (IOException e) {
                        System.out.println("Błąd zapisu do pliku.");
                    }
                    break;

                case 2:
                    System.out.println("\n=== Lista studentów ===");
                    try {
                        var students = s.getStudents();
                        for (Student current : students) {
                            System.out.println(current.ToString());
                        }
                    } catch (IOException e) {
                        System.out.println("Błąd podczas odczytu pliku.");
                    }
                    break;

                case 0:
                    System.out.println("Zamykanie aplikacji...");
                    break;

                default:
                    System.out.println("Nieprawidłowy wybór!");
            }
        }
    }
}