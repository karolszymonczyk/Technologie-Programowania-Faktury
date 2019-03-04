package sourcecode;

import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Baza {

  ArrayList<Faktura> faktury;
  Scanner scanner;
  final String path = "C:/Users/karol/Desktop/SZQL/Semestr II/TP/Lista2/Faktury/";

  /**
   * Constructor.
   */
  public Baza() {

    faktury = new ArrayList<Faktura>();
    scanner = new Scanner(System.in);
  }

  /**
   * Method to save invoices in JSON files.
   * @param faktura invoice which we want to save.
   */
  public void dodajDoBazy(Faktura faktura) {

    String json = new Gson().toJson(faktura);

    try {
      File files = new File(path + faktura.getKlient());
      files.mkdir();
      FileWriter file = new FileWriter(path + faktura.getKlient() + "/"
              + faktura.getNazwa() + ".json");
      file.write(json);
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Faktura została dodana\n");
  }

  /**
   * Method to read invoices from JSON files.
   */
  public void pokazFaktury() {

    System.out.print("Podaj imie i nazwisko klienta : ");
    String klient = scanner.nextLine();

    Gson gson;

    File dir = new File(path + klient);
    File[] directoryListing = dir.listFiles();
    if (directoryListing != null) {
      for (File child : directoryListing) {

        gson = new Gson();
        try {
          Reader reader = new FileReader(child);

          Faktura fakturaIn = gson.fromJson(reader, Faktura.class);

          System.out.println("\n" + fakturaIn.getNazwa() + "          "
                  + fakturaIn.getKlient() + "                     " + fakturaIn.getData());
          fakturaIn.pokazElementy();

        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } else {
      System.out.println("\nBrak faktur dla : " + klient + "\n");
    }
  }
}
