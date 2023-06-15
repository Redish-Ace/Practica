/*Mașinile sunt descrise prin date precum: producătorul, modelul, anul de fabricație, mărimea motorului, tipul
de combustibil, numărul de pasageri, numărul de înmatriculare, prețul de cumpărare, data cumpărării, prețul
de închiriere și detalii privind asigurarea mașinii.*/
import java.io.*;
import java.util.*;
public class Masina {
    private String producator, model, combustibil, dataCumparare, situatie, prCumpValuta, prInchValuta, filiala, compRepar;
    private int anulFabricat, numarPasageri, numarInmatriculare;
    private double marimeaMotorului, pretCumparare, pretInchiriere;

    public Masina(){}

    public Masina(String producator, String model, String combustibil, String dataCumparare, String situatie, int anulFabricat, int numarPasageri, int numarInmatriculare, double marimeaMotorului, double pretCumparare, String prCumpValuta, double pretInchiriere, String prInchValuta) {
        this.producator = producator;
        this.model = model;
        this.combustibil = combustibil;
        this.dataCumparare = dataCumparare;
        this.situatie = situatie;
        this.anulFabricat = anulFabricat;
        this.numarPasageri = numarPasageri;
        this.numarInmatriculare = numarInmatriculare;
        this.marimeaMotorului = marimeaMotorului;
        this.pretCumparare = pretCumparare;
        this.prCumpValuta = prCumpValuta;
        this.pretInchiriere = pretInchiriere;
        this.prInchValuta = prInchValuta;
    }

    public void menu(int index){
        switch(index){
            case 4 -> convertBuyCurrency();
            case 5 -> convertRentCurrency();
        }
    }

    public void setAuto(File file){
        Scanner scan = new Scanner(System.in);
        this.producator = scan.nextLine();
        this.model = scan.nextLine();
        this.combustibil = scan.nextLine();
        this.dataCumparare = scan.nextLine();
        this.situatie = scan.nextLine();
        this.anulFabricat = scan.nextInt();
        this.numarPasageri = scan.nextInt();
        this.numarInmatriculare = scan.nextInt();
        this.marimeaMotorului = scan.nextDouble();
        this.pretCumparare = scan.nextDouble();
        scan.nextLine();
        this.prCumpValuta = scan.nextLine();
        this.pretInchiriere = scan.nextDouble();
        scan.nextLine();
        this.prInchValuta = scan.nextLine();
        try{
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("m "+this.producator+" "+this.model+" "+this.combustibil+" "+this.dataCumparare
                    +" "+this.situatie+" "+this.anulFabricat+" "+this.numarPasageri+" "+this.numarInmatriculare
                    +" "+this.marimeaMotorului+" "+this.pretCumparare +" "+this.prCumpValuta+" "+this.pretInchiriere
                    +" "+this.prInchValuta+"\n");
            bufferedWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void convertBuyCurrency(){
        Scanner scan = new Scanner(System.in);
        System.out.printf(this.pretCumparare+" "+this.prCumpValuta+"\nIn ce doriti ca convertiti: ");
        String convCurrency = scan.nextLine();
        switch (convCurrency){
            case "MDL" -> convertMDL(this.pretCumparare, this.prCumpValuta);
            case "EUR" -> convertEUR(this.pretCumparare, this.prCumpValuta);
            case "USD" -> convertUSD(this.pretCumparare, this.prCumpValuta);
        }
    }

    public void convertRentCurrency(){
        Scanner scan = new Scanner(System.in);
        System.out.printf(this.pretInchiriere+" "+this.prInchValuta+"\nIn ce doriti ca convertiti: ");
        String convCurrency = scan.nextLine();
        switch (convCurrency){
            case "MDL" -> convertMDL(this.pretInchiriere, this.prInchValuta);
            case "EUR" -> convertEUR(this.pretInchiriere, this.prInchValuta);
            case "USD" -> convertUSD(this.pretInchiriere, this.prInchValuta);
        }
    }

    public void convertMDL(double sum, String currency){
        switch (currency){
            case "EUR" -> {
                sum *= 19.0;
                System.out.println(sum + " MDL");
            }
            case "USD" -> {
                sum *= 17.8;
                System.out.println(sum + " MDL");
            }
        }
    }

    public void convertEUR(double sum, String currency){
        switch (currency){
            case "MDL" -> {
                sum *= 19.00;
                System.out.println(sum + " EUR");
            }
            case "USD" -> {
                sum *= 1.07;
                System.out.println(sum + " EUR");
            }
        }
    }

    public void convertUSD(double sum, String currency){
        switch (currency){
            case "MDL" -> {
                sum *= 17.80;
                System.out.println(sum + " USD");
            }
            case "EUR" -> {
                sum *= 0.94;
                System.out.println(sum + " USD");
            }
        }
    }

    public String getSituatie() {
        return situatie;
    }

    public void setSituatie(String situatie) {
        this.situatie = situatie;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCombustibil() {
        return combustibil;
    }

    public void setCombustibil(String combustibil) {
        this.combustibil = combustibil;
    }

    public String getdataCumparare() {
        return dataCumparare;
    }

    public void setdataCumparare(String dataCumparare) {
        this.dataCumparare = dataCumparare;
    }

    public int getAnulFabricat() {
        return anulFabricat;
    }

    public void setAnulFabricat(int anulFabricat) {
        this.anulFabricat = anulFabricat;
    }

    public int getNumarPasageri() {
        return numarPasageri;
    }

    public void setNumarPasageri(int numarPasageri) {
        this.numarPasageri = numarPasageri;
    }

    public int getNumarInmatriculare() {
        return numarInmatriculare;
    }

    public void setNumarInmatriculare(int numarInmatriculare) {
        this.numarInmatriculare = numarInmatriculare;
    }

    public double getMarimeaMotorului() {
        return marimeaMotorului;
    }

    public void setMarimeaMotorului(double marimeaMotorului) {
        this.marimeaMotorului = marimeaMotorului;
    }

    public double getPretCumparare() {
        return pretCumparare;
    }

    public void setPretCumparare(double pretCumparare) {
        this.pretCumparare = pretCumparare;
    }

    public double getPretInchiriere() {
        return pretInchiriere;
    }

    public void setPretInchiriere(double pretInchiriere) {
        this.pretInchiriere = pretInchiriere;
    }

    public String getPrCumpValuta() {
        return prCumpValuta;
    }

    public void setPrCumpValuta(String prCumpValuta) {
        this.prCumpValuta = prCumpValuta;
    }

    public String getPrInchValuta() {
        return prInchValuta;
    }

    public void setPrInchValuta(String prInchValuta) {
        this.prInchValuta = prInchValuta;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "producator='" + producator + '\'' +
                ", model='" + model + '\'' +
                ", combustibil='" + combustibil + '\'' +
                ", dataCumparare='" + dataCumparare + '\'' +
                ", situatie='" + situatie + '\'' +
                ", prCumpValuta='" + prCumpValuta + '\'' +
                ", prInchValuta='" + prInchValuta + '\'' +
                ", anulFabricat=" + anulFabricat + '\'' +
                ", numarPasageri=" + numarPasageri + '\'' +
                ", numarInmatriculare=" + numarInmatriculare + '\'' +
                ", marimeaMotorului=" + marimeaMotorului + '\'' +
                ", pretCumparare=" + pretCumparare + '\'' +
                ", pretInchiriere=" + pretInchiriere + '\'' +
                '}';
    }
}
