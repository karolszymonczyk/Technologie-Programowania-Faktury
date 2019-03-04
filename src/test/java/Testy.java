import sourcecode.Faktura;
import org.junit.Assert;
import org.junit.Test;
import sourcecode.ObslugaFaktury;

import java.util.Date;

public class Testy {

  @Test
  public void ObliczCeneFakturyTest() {

    Date data = new Date();
    Faktura faktura = new Faktura("Faktura", "Jan Kowalski", data);

    faktura.dodajElement("Marchew", 20, 0.50);
    faktura.dodajElement("Rzodkiew", 12, 0.65);
    faktura.dodajElement("Pomidor", 6, 1.40);
    faktura.dodajElement("Chleb", 3, 4.99);
    faktura.dodajElement("Ser", 1, 7);

    double wynik = faktura.obliczCeneFaktury();

    Assert.assertEquals(48.17, wynik, 0.00);
  }

  @Test
  public void DodajElementTest1() {

    ObslugaFaktury of = new ObslugaFaktury();
    Date data = new Date();
    Faktura faktura = new Faktura("Faktura", "Jan Kowalski", data);
    boolean test;
    test = of.dodajElementFaktury("Test", 10, 2.5);

    Assert.assertTrue(test);
  }

  @Test
  public void DodajElementTest2() {

    ObslugaFaktury of = new ObslugaFaktury();
    boolean test;
    test = of.dodajElementFaktury("Test", -5, 2.5);

    Assert.assertFalse(test);
  }

  @Test
  public void DodajElementTest3() {

    ObslugaFaktury of = new ObslugaFaktury();
    boolean test;
    test = of.dodajElementFaktury("Test", 10, -3);

    Assert.assertFalse(test);
  }

}
