/*Compania deține un portofoliu de clienți destul de stabil. Pentru clienții privilegiați oferă reduceri la
închirierea de mașini. Acești clienți au de asemenea posibilitatea de a rezerva o mașină din timp. O mașină
poate fi închiriată pentru o perioadă de timp de la o zi la un an. Plata pentru închirierea unei mașini se poate
face cash sau cu credit card. Se acceptă orice tip de card. Datele importante despre clienți sunt numele,
adresa, numărul de telefon, seria permisului de conducere, etc.*/
import java.io.*;
import java.util.Scanner;

public class Client {
    private String nume, prenume, adresa, privilegiu, perioadaInchirierii, plata;
    private int telefon, permisConducere;

    public Client(){}

    public Client(String nume, String prenume, String adresa, int telefon, int permisConducere) {
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.privilegiu = "fara";
        this.perioadaInchirierii = "0";
        this.plata = "cash";
        this.telefon = telefon;
        this.permisConducere = permisConducere;
    }

    public Client(String nume, String prenume, String adresa, String privilegiu, String perioadaInchirierii, String plata, int telefon, int permisConducere) {
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.privilegiu = privilegiu;
        this.perioadaInchirierii = perioadaInchirierii;
        this.plata = plata;
        this.telefon = telefon;
        this.permisConducere = permisConducere;
    }

    public void setClient(File file){
        Scanner scan = new Scanner(System.in);
        this.nume = scan.nextLine();
        this.prenume = scan.nextLine();
        this.adresa = scan.nextLine();
        this.privilegiu = scan.nextLine();
        this.perioadaInchirierii = scan.nextLine();
        this.plata = scan.nextLine();
        this.telefon = scan.nextInt();
        this.permisConducere = scan.nextInt();
        try{
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("c "+this.nume+" "+this.prenume+" "+this.adresa+" "+this.privilegiu
                    +" "+this.perioadaInchirierii+" "+this.plata+" "+this.telefon+" "+this.permisConducere+"\n");
            bufferedWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPrivilegiu() {
        return privilegiu;
    }

    public void setPrivilegiu(String privilegiu) {
        this.privilegiu = privilegiu;
    }

    public String getPlata() {
        return plata;
    }

    public void setPlata(String plata) {
        this.plata = plata;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getPermisConducere() {
        return permisConducere;
    }

    public void setPermisConducere(int permisConducere) {
        this.permisConducere = permisConducere;
    }

    public String getPerioadaInchirierii() {
        return perioadaInchirierii;
    }

    public void setPerioadaInchirierii(String perioadaInchirierii) {
        this.perioadaInchirierii = perioadaInchirierii;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", privilegiu='" + privilegiu + '\'' +
                ", perioadaInchirierii='" + perioadaInchirierii + '\'' +
                ", plata='" + plata + '\'' +
                ", telefon=" + telefon +
                ", permisConducere=" + permisConducere +
                '}';
    }
}
