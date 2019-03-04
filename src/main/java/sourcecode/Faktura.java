package sourcecode;

import java.util.ArrayList;
import java.util.Date;

public class Faktura {

  private String nazwa;
  public ArrayList<Element> elements;
  private String klient;
  private Date data;
  private double suma;

  public Faktura(String nazwa, String klient, Date data) {

    this.nazwa = nazwa;
    this.klient = klient;
    this.data = data;
    elements = new ArrayList<Element>();
  }

  /**
   * Method to add elements to invoice.
   */
  public void dodajElement(String nazwaE, int ilosc, double cena){

    Element element = new Element(nazwaE, ilosc, cena);
    elements.add(element);

    suma = obliczCeneFaktury();
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
}
