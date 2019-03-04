package sourcecode;

public class Element {

  private String artykul;
  private int ilosc;
  private double cena;

  /**
   * Constructor.
   * @param artykul name of the product.
   * @param ilosc amount of the product.
   * @param cena price of the product.
   */
  public Element(String artykul, int ilosc, double cena) {

    this.artykul = artykul;
    this.ilosc = ilosc;
    this.cena = cena;
  }

  /**
   * Method to show information about element.
   */
  public void pokazElement() {

    System.out.println("Produkt : " + artykul + "          "
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
