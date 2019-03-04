package sourcecode;

public class Element {

  private String nazwa;
  private int ilosc;
  private double cena;

  /**
   * Constructor.
   * @param nazwa name of the product.
   * @param ilosc amount of the product.
   * @param cena price of the product.
   */
  public Element(String nazwa, int ilosc, double cena) {

    this.nazwa = nazwa;
    this.ilosc = ilosc;
    this.cena = cena;
  }

  /**
   * Method to show information about element.
   */
  public void pokazElement() {

    System.out.println("Produkt : " + nazwa + "          "
            + "Iloscc : " + ilosc + "szt.          "
            + "Cena za szt. : " + cena);
  }

  public double getCena() {

    return cena;
  }

  public int getIlosc() {

    return ilosc;
  }
}
