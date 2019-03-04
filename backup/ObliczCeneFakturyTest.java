import sourcecode.Element;
import sourcecode.Faktura;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ObliczCeneFakturyTest {

  @Test
  public void ObliczCeneFatkuryTest() {

    Faktura faktura = new Faktura();

    ArrayList<Element> elements = new ArrayList<Element>();

    Element element1 = new Element("Marchew", 20, 0.50);
    Element element2 = new Element("Rzodkiew", 12, 0.65);
    Element element3 = new Element("Pomidor", 6, 1.40);
    Element element4 = new Element("Chleb", 3, 4.99);
    Element element5 = new Element("Ser", 1, 7);

    elements.add(element1);
    elements.add(element2);
    elements.add(element3);
    elements.add(element4);
    elements.add(element5);

    faktura.elements = elements;

    double wynik = faktura.obliczCeneFaktury();

    Assert.assertEquals(48.17, wynik, 0.00);
  }
}
