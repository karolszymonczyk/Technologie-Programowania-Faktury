package sourcecode;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Faktura {

  private String nazwa;
  public ArrayList<Element> elements;
  private String klient;
  private Date data;
  private double suma;

  public Faktura() {

    elements = new ArrayList<Element>();
  }

  /**
   * Method to add data to invoice.
   */
  public void dodajDane() {

    Scanner nazwa = new Scanner(System.in);
    System.out.print("Podaj nazwe faktury : ");
    this.nazwa = nazwa.nextLine();

    Scanner scanner = new Scanner(System.in);
    System.out.print("\nPodaj imie i nazwisko klienta : ");
    this.klient = scanner.nextLine();

    this.data = new Date();
  }

  /**
   * Method to add elements to invoice.
   * @throws Wyjatek when input is incorrect.
   */
  public void dodajElement() throws Wyjatek {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Wprowadz nazwe produktu : ");
    String nazwa = scanner.nextLine();
    int ilosc;
    double cena;
    try {
      System.out.print("Wprowadz ilsc produktu : ");
      ilosc = Integer.parseInt(scanner.nextLine());
      if (ilosc < 0) {
        throw new Wyjatek();
      }
      System.out.print("Wprowadz cene za sztuke : ");
      cena = Double.parseDouble(scanner.nextLine());
      if (cena < 0) {
        throw new Wyjatek();
      }
    } catch (NumberFormatException e) {

      System.out.println("Niepoprawny input!");
      return;
    }

    Element element = new Element(nazwa, ilosc, cena);
    elements.add(element);
    System.out.println("Produkt zostal dodany.\n");
    //suma += ilosc * cena;
    suma = obliczCeneFaktury();
  }

  /**
   * Method to calculate whole value of the invoice.
   * @return whole value of the invoice.
   */
  public double obliczCeneFaktury() {

    double cenaFaktury = 0;

    for (Element e : elements) {

      cenaFaktury += e.getIlosc() * e.getCena();
    }

    return cenaFaktury;
  }

  /**
   * Method to show elements of the invoice.
   */
  public void pokazElementy() {

    System.out.println();
    for (Element e : elements) {

      e.pokazElement();
    }
    System.out.println("\n                                                                "
            + "Suma : " + suma + "\n");
  }

  public String getNazwa() {

    return nazwa;
  }

  public String getKlient() {

    return klient;
  }

  public Date getData() {

    return data;
  }
}
