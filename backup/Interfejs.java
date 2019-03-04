package sourcecode;

import java.util.Scanner;

public class Interfejs {

  int wybor;

  Scanner scannerW;
  Scanner scanner;

  /**
   * Interface to communicate with user.
   */
  public Interfejs() {

    Baza baza = new Baza();

    wybor = -1;

    scannerW = new Scanner(System.in);
    scanner = new Scanner(System.in);

    while (wybor != 0) {

      System.out.println("Wybierz opcje :\n");
      System.out.println("0. Wyjscie");
      System.out.println("1. Dodaj fakture");
      System.out.println("2. Wyswietl faktury\n");
      System.out.print("Wybor: ");

      try {
        wybor = Integer.parseInt(scannerW.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Niepoprawny input!");
      }

      if (wybor == 1) {

        Faktura faktura = new Faktura();
        faktura.dodajDane();

        int dodaj = -1;

        while (dodaj != 0) {

          try {
            faktura.dodajElement();
          } catch (Wyjatek w) {

            System.out.println("Niepoprawne dane!\n");
            continue;
          }
          do {
            System.out.println("Czy chcesz dodac nastepny produkt?\n");
            System.out.println("0. Nie");
            System.out.println("1. Tak");
            dodaj = scanner.nextInt();
          } while (dodaj != 1 && dodaj != 0);

        }
        baza.dodajDoBazy(faktura);
      } else if (wybor == 2) {

        baza.pokazFaktury();
      } else if (wybor != 0) {

        System.out.println("Nie wybrano zadnej opcji\n");
        continue;
      }
    }
  }

}
