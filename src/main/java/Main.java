/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Service service = new Service();

        int wybor = 0;

        while (wybor != 3) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Dodaj studenta");
            System.out.println("2 - Wyświetl listę studentów");
            System.out.println("3 - Wyjście");
            System.out.print("Wybierz opcję: ");

            wybor = scanner.nextInt();
            scanner.nextLine(); // czyszczenie bufora

            switch (wybor) {
                case 1:
                    System.out.print("Podaj imię: ");
                    String imie = scanner.nextLine();

                    System.out.print("Podaj wiek: ");
                    int wiek = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        service.addStudent(new Student(imie, wiek));
                        System.out.println("Dodano studenta!");
                    } catch (IOException e) {
                        System.out.println("Błąd zapisu do pliku!");
                    }
                    break;

                case 2:
                    try {
                        Collection<Student> students = service.getStudents();
                        System.out.println("\n=== LISTA STUDENTÓW ===");
                        for (Student s : students) {
                            System.out.println(s.ToString());
                        }
                    } catch (IOException e) {
                        System.out.println("Błąd odczytu pliku!");
                    }
                    break;

                case 3:
                    System.out.println("Zakończono program.");
                    break;

                default:
                    System.out.println("Nie ma takiej opcji!");
            }
        }
    }
}
