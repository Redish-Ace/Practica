/*Sarcina 2: Scrieți un program Java care modelează următoarea activitate:
Creați un produs program pentru evidența activității unei companii de închiriere de mașini. Compania are
mai multe filiale în țară. Fiecare filială este caracterizată prin nume, adresă, telefon, persoană de contact, etc.
Produsul program gestionează activitatea a unei companii care oferă spre închiriere mașini de diferite tipuri.
Programul reține informații despre mașinile companiei, companiile cu care compania dată are contracte de
colaborare (de exemplu, garaje), mașinile închiriate, veniturile companiei și bineînțeles date despre clienții
companiei.
Mașinile sunt descrise prin date precum: producătorul, modelul, anul de fabricație, mărimea motorului, tipul
de combustibil, numărul de pasageri, numărul de înmatriculare, prețul de cumpărare, data cumpărării, prețul
de închiriere și detalii privind asigurarea mașinii.
Toate reparațiile importante asupra mașinilor companiei sunt făcute de companii cu care colaborează. Unele
companii solicită plata serviciilor de service imediat după ce reparația a fost făcută, altele acceptă plata în
rate a serviciilor.
Compania deține un portofoliu de clienți destul de stabil. Pentru clienții privilegiați oferă reduceri la
închirierea de mașini. Acești clienți au de asemenea posibilitatea de a rezerva o mașină din timp. O mașină
poate fi închiriată pentru o perioadă de timp de la o zi la un an. Plata pentru închirierea unei mașini se poate
face cash sau cu credit card. Se acceptă orice tip de card. Datele importante despre clienți sunt numele,
adresa, numărul de telefon, seria permisului de conducere, etc.
Produsul program trebuie să țină evidența clară a fiecărei mașini, a celor închiriate, a celor aflate în
reparații, etc. Se păstrează de asemenea evidența tuturor veniturilor și cheltuielilor firmei: cumpărarea de noi
mașini, închirierea de mașini, cheltuieli de reparații, vânzarea unor mașini mai vechi din parcul auto
(compania preferă să nu păstreze în parcul auto o mașină mai mult de un an), taxe de asigurare a mașinilor,
etc.

Cerințe față de sarcină: Implementați concepte ale POO
• Creați clase având ca metode (funcții) citirea și afișarea fiecărui câmp (set-teri și get- teri), precum și
o metodă care calculează o valoare nouă a unui sau a mai multor câmpuri (ca exemplu, de convertit
prețul din lei în EURO sau de calculat durata deplasării). Adăugați cel puțin trei tipuri de constructori
(unul trebuie să fie fără parametri, altul- cu toți parametrii indicați, iar al treilea- cu doar câțiva
parametri indicați, în dependență de temă, în ultimul caz unele câmpuri ar putea avea valori egale sau
careva valori standarde).
• Clase care moștenesc câmpurile și metodele clasei părinte vor avea proprietăți proprii, creând și
constructorii respectivi (care să corespundă constructorilor clasei de bază). Folosiți relațiile de asociere
și agregare între obiecte (acolo unde este cazul).
• Creați o clasă abstractă și o interfață, care are cel puțin o metodă abstractă, apoi le utilizează în procesul
de moștenire și o realizează pe deplin. Fiecare clasă trebuie să conțină constructori supraîncărcați,
metoda toString() supradefinită
• Prelucrați diferite tipuri de excepție (atunci când avem împărțire la zero, radical din număr negativ,
când încercăm să accesăm un element inexistent al unui tablou, atunci când în loc de număr utilizatorul
introduce litere, atunci când încercăm să apelăm o metodă a unui obiect care are referință nulă etc.) O
metodă care generează excepție proprie.
• Înscrieți obiectele într-o listă, minim 20 de înregistrări. Se va utiliza lista și la afișarea pe ecran.
• Programul să conțină un meniu minimalizat.
• Adăugați clase și / sau membri sau metode la clasele dacă se consideră necesar.*/

public class Main {
    public static void main(String[] args) {
        CompanieInchiriere compInchit = new CompanieInchiriere();
        //compInchit.menu();
        compInchit.createFrame();
    }
}