/*Toate reparațiile importante asupra mașinilor companiei sunt făcute de companii cu care colaborează. Unele
companii solicită plata serviciilor de service imediat după ce reparația a fost făcută,
altele acceptă plata în rate a serviciilor.*/
import java.io.*;
import java.util.Scanner;

public class CompanieReparati {
    private String denumire, plataServiciilor;

    public CompanieReparati(){}

    public CompanieReparati(String denumire) {
        this.denumire = denumire;
        this.plataServiciilor = "imediata";
    }

    public CompanieReparati(String denumire, String plataServiciilor) {
        this.denumire = denumire;
        this.plataServiciilor = plataServiciilor;
    }

    public void setCompRep(File file){
        Scanner scan = new Scanner(System.in);
        this.denumire = scan.nextLine();
        this.plataServiciilor = scan.nextLine();
        try{
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("cr "+this.denumire+" "+this.plataServiciilor+"\n");
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

    public String getPlataServiciilor() {
        return plataServiciilor;
    }

    public void setPlataServiciilor(String plataServiciilor) {
        this.plataServiciilor = plataServiciilor;
    }

    @Override
    public String toString() {
        return "CompanieReparati{" +
                "denumire='" + denumire + '\'' +
                ", plataServiciilor='" + plataServiciilor + '\'' +
                '}';
    }
}
