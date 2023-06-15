/*Compania are mai multe filiale în țară.
Fiecare filială este caracterizată prin nume, adresă, telefon, persoană de contact, etc.*/
import java.io.*;
import java.util.Scanner;

public class Filiala {
    private String denumire, adresa, numePersContact, prenumePersContact;
    private int telefon;

    public Filiala(){}

    public Filiala(String denumire, String adresa, String numePersContact, String prenumePersContact, int telefon) {
        this.denumire = denumire;
        this.adresa = adresa;
        this.numePersContact = numePersContact;
        this.prenumePersContact = prenumePersContact;
        this.telefon = telefon;
    }

    public void setFiliala(File file){
        Scanner scan = new Scanner(System.in);
        this.denumire = scan.nextLine();
        this.adresa = scan.nextLine();
        this.numePersContact = scan.nextLine();
        this.prenumePersContact = scan.nextLine();
        this.telefon = scan.nextInt();
        try{
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("f "+this.denumire+" "+this.adresa+" "+this.numePersContact+" "+this.prenumePersContact+" "+this.telefon+"\n");
            bufferedWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNumePersContact() {
        return numePersContact;
    }

    public void setNumePersContact(String numePersContact) {
        this.numePersContact = numePersContact;
    }

    public String getPrenumePersContact() {
        return prenumePersContact;
    }

    public void setPrenumePersContact(String prenumePersContact) {
        this.prenumePersContact = prenumePersContact;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Filiala{" +
                "denumire='" + denumire + '\'' +
                ", adresa='" + adresa + '\'' +
                ", numePersContact='" + numePersContact + '\'' +
                ", prenumePersContact='" + prenumePersContact + '\'' +
                ", telefon=" + telefon +
                '}';
    }
}
