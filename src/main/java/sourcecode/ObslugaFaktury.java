package sourcecode;

import java.util.Date;
import java.util.Scanner;

public class ObslugaFaktury {

  Baza baza;
  Faktura faktura;

  public ObslugaFaktury() {

    baza = new Baza();
  }

  /**
   * Method to add data to invoice.
   */
  public void skanujDaneFaktury() {

    Scanner nazwaS = new Scanner(System.in);
    System.out.print("Podaj nazwe faktury : ");
    String nazwa = nazwaS.nextLine();

    Scanner scanner = new Scanner(System.in);
    System.out.print("\nPodaj imie i nazwisko klienta : ");
    String klient = scanner.nextLine();

    Date data = new Date();

    dodajDane(nazwa, klient, data);
  }

  public void dodajDane(String nazwaF, String klientF, Date dataF) {

    faktura = new Faktura(nazwaF, klientF, dataF);
  }


  public void dodajFaktureDoBazy() {

    baza.dodajDoBazy(faktura);
  }

  public void zaladujFaktury() {

    baza.pokazFaktury();

  }

  /**
   * Method to skan elements to invoice.
   */
  public boolean skanujElementFkatury(){

    Scanner scanner = new Scanner(System.in);
    System.out.print("Wprowadz nazwe produktu : ");
    String nazwaE = scanner.nextLine();
    int ilosc;
    double cena;
    try {
      System.out.print("Wprowadz ilosc produktu : ");
      ilosc = Integer.parseInt(scanner.nextLine());

      System.out.print("Wprowadz cene za sztuke : ");
      cena = Double.parseDouble(scanner.nextLine());
    } catch (NumberFormatException e) {

      System.out.println("Niepoprawny input!");
      return false;
    }
    return dodajElementFaktury(nazwaE, ilosc, cena);
  }

  /**
   * Method to add elements to invoice.
   */
  public boolean dodajElementFaktury(String nazwaE, int iloscE, double cenaE) {

      if (iloscE < 0) {
        return false;
      }
      if (cenaE < 0) {
        return false;
      }

    faktura.dodajElement(nazwaE, iloscE, cenaE);
    System.out.println("Produkt zostal dodany.\n");
    return true;
  }
}
