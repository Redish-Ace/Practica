#pragma once
#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

fstream file("Comoara.in");
ofstream out("Comoara.out");
ofstream grout("Verde.txt");

struct Paralelipiped {
	string cod, culoare, material;
	double x{}, y{}, z{}, volum{}, arie{};
} p[1000];

vector<string> colours{ "albastru", "rosu", "verde", "galben", "violet", "portocaliu", "cafeniu", "sur", "gri", "negru", "alb", "roz", "auriu", "argintiu", "cupru"};
vector<string> materials{"lemn", "carton", "metal", "plastic", "ghips"};

int n;

void menu();
void continueMessage();
void avgVolume();

void readFile() {
	file >> n;
	for (int index = 0; index < n; index++) {
		file >> p[index].cod >> p[index].x >> p[index].y >> p[index].z >> p[index].culoare >> p[index].material;
	}
	avgVolume();
}

bool checkColour(string colour) {
	bool check = false;
	if (find(colours.begin(), colours.end(), colour) != colours.end()) check = true;
	return check;
}

bool checkMaterial(string material) {
	bool check = false;
	if (find(materials.begin(), materials.end(), material) != materials.end()) check = true;
	return check;
}

bool checkCode(string cod) {
	bool check = false;
	for (int index = 0; index < n; index++) {
		if (p[index].cod == cod){
			check = true;
			break;
		}
	}

	return check;
}

//1) Înregistrează un nou paralelipiped;
void insert() {
	readFile();
	ofstream fileOut("Comoara.in", ios::trunc);
	int add;
	cout << "Numarul de Introduceri: "; cin >> add;
	for (int index = n; index < n + add; index++) {
		do {
			if (!p[index].cod.empty()) if (checkCode(p[index].cod)) cout << "Codul deja existent" << endl;

			cout << "Codul Paralelipipedului " << index << ": ";
			cin >> p[index].cod;
		} while (checkCode(p[index].cod));

		int i = 0;
		do {
			if(i != 0) if (p[index].x <= 0) cout << "Latimea nu poate fi 0 sau negativa" << endl;

			cout << "Latimea Paralelipipedului " << index << ": ";
			cin >> p[index].x;
			i++;
		} while (p[index].x <= 0);
		i = 0;

		do {
			if (i != 0) if (p[index].y <= 0) cout << "Inaltimea nu poate fi 0 sau negativa" << endl;

			cout << "Inaltimea Paralelipipedului " << index << ": ";
			cin >> p[index].y;
			i++;
		} while (p[index].y <= 0);
		
		i = 0;
		do {
			if (i != 0) if (p[index].z <= 0) cout << "Lungimea nu poate fi 0 sau negativa" << endl;

			cout << "Lungimea a Paralelipipedului " << index << ": ";
			cin >> p[index].z;
			i++;
		} while (p[index].z <= 0);

		do {
			if (!p[index].culoare.empty()) if (!checkMaterial(p[index].culoare)) cout << "Nu este o Culaore" << endl;

			cout << "Culoarea Paralelipipedului " << index << ": ";
			cin >> p[index].culoare;
		} while (!checkColour(p[index].culoare));

		do {
			if (!p[index].material.empty()) if (!checkMaterial(p[index].material)) cout << "Nu este un Material" << endl;

			cout << "Materialul din care este Confectionat Paralelipipedului " << index << ": ";
			cin >> p[index].material;
		} while (!checkMaterial(p[index].material));
	}

	n += add;
	fileOut << n << endl;

	for (int index = 0; index < n; index++) {
		fileOut << p[index].cod << " " << p[index].x << " " << p[index].y << " " << p[index].z << " " << p[index].culoare << " " << p[index].material << endl;
	}
	
	continueMessage();
}

//2) Exclude din fişierul Comoara.in linia ce corespunde codului figurii, introdus de la tastatură;
void deleteInfo() {
	readFile();
	ofstream fileOut("Comoara.in", ios::trunc);
	string cod;
	cout << "Codul Ales de Sters: "; cin >> cod;

	int foundIndex=0;
	for (int index = 0; index < n; index++) {
		if (p[index].cod == cod) {
			foundIndex = index;
			break;
		}
	}

	if (foundIndex == 0) cout << "Codul nu a fost gsit";
	else {
		if (foundIndex == n - 1) n--;
		else {
			for (int index = foundIndex; index < n - 1; index++) {
				p[index].cod = p[index + 1].cod;
				p[index].x = p[index + 1].x;
				p[index].y = p[index + 1].y;
				p[index].z = p[index + 1].z;
				p[index].culoare = p[index + 1].culoare;
				p[index].material = p[index + 1].material;
				p[index].volum = p[index + 1].volum;
			}
			n--;
		}

		fileOut << n << endl;

		for (int index = 0; index < n; index++) {
			fileOut << p[index].cod << " " << p[index].x << " " << p[index].y << " " << p[index].z << " " << p[index].culoare << " " << p[index].material << endl;
		}
	}
	continueMessage();
}

//3 ) Determină volumul mediu al paralelipipedelor în studiu;
void avgVolume() {
	for (int index = 0; index < n; index++) {
		p[index].volum = p[index].x * p[index].y * p[index].z;
	}
}

void writeAvg() {
	avgVolume();
	for (int index = 0; index < n; index++) {
		cout << p[index].cod << " " << p[index].x << " " << p[index].y << " " << p[index].z << " " << p[index].culoare << " " << p[index].material << " " << p[index].volum << endl;
	}
	continueMessage();
}

void bubbleSort() {
	avgVolume();

	double aux;
	string auxs;

	for (int index = 0; index < n-1; index++) {
		for (int jindex = 0; jindex < n-1; jindex++) {
			if (p[jindex].volum > p[jindex + 1].volum) {

				auxs = p[jindex + 1].cod;
				p[jindex + 1].cod = p[jindex].cod;
				p[jindex].cod = auxs;

				aux = p[jindex + 1].x;
				p[jindex + 1].x = p[jindex].x;
				p[jindex].x = aux;

				aux = p[jindex + 1].y;
				p[jindex + 1].y = p[jindex].y;
				p[jindex].y = aux;

				aux = p[jindex + 1].z;
				p[jindex + 1].z = p[jindex].z;
				p[jindex].z = aux;

				auxs = p[jindex + 1].culoare;
				p[jindex + 1].culoare = p[jindex].culoare;
				p[jindex].culoare = auxs;

				auxs = p[jindex + 1].material;
				p[jindex + 1].material = p[jindex].material;
				p[jindex].material = auxs;

				aux = p[jindex + 1].volum;
				p[jindex + 1].volum = p[jindex].volum;
				p[jindex].volum = aux;
			}
		}
	}
}

//4) Afişează pe ecran atributele figurilor, de culoarea indicată de la tastatură, în ordinea crescătoare a
//volumelor acestora; sortarea datelor se va realiza prin metoda bulelor;
void writeByColour() {
	bubbleSort();
	string colour;
	do {
		if(!colour.empty()) if(!checkColour(colour)) cout << "Nu este o Culaore" << endl;

		cout << "Introduceti Culoarea Cautata: "; cin >> colour;
	} while (!checkColour(colour));
	for (int index = 0; index < n; index++) {
		if (p[index].culoare == colour) {
			cout << p[index].cod << " " << p[index].x << " " << p[index].y << " " << p[index].z << " " << p[index].culoare << " " << p[index].material << " " << p[index].volum << endl;
		}
	}
	continueMessage();
}

double getMin(string material) {
	double min = 999999;
	for (int index = 0; index < n; index++) {
		if (p[index].material == material) {
			if (min > p[index].volum) min = p[index].volum;
		}
	}
	return min;
}

double getMax(string material) {
	double max = 0;
	for (int index = 0; index < n; index++) {
		if (p[index].material == material) {
			if (max < p[index].volum) max = p[index].volum;
		}
	}
	return max;
}

//5) Determină figura de volum minim şi, respectiv, cea de volum maxim, confecţionate din materialul cu
//denumirea introdusă de la tastatură;
void minVolume() {
	avgVolume();
	string material;
	cout << "Intodu Materialul Cautat: "; cin >> material;
	double min = getMin(material);
	for (int index = 0; index < n; index++) {
		if (p[index].material == material && p[index].volum == min) {
			cout << p[index].cod << " " << p[index].x << " " << p[index].y << " " << p[index].z << " " << p[index].culoare << " " << p[index].material << " " << p[index].volum << endl;
		}
	}
	continueMessage();
}

void maxVolume() {
	avgVolume();
	string material;
	do {
		if (!material.empty()) if (!checkMaterial(material)) cout << "Nu este un Material" << endl;

		cout << "Intodu Materialul Cautat: "; cin >> material;
	} while (!checkMaterial(material));
	double max = getMax(material);
	for (int index = 0; index < n; index++) {
		if (p[index].material == material && p[index].volum == max) {
			cout << p[index].cod << " " << p[index].x << " " << p[index].y << " " << p[index].z << " " << p[index].culoare << " " << p[index].material << " " << p[index].volum << endl;
		}
	}
	continueMessage();
}

//6) Enumără figurile confecţionate din metal, volumul căror nu depăşeşte valoarea introdusă de la
//tastatură;
void writeLessVolume() {
	avgVolume();
	double volum;
	cout << "Intodu Volumul Cautat: "; cin >> volum;
	for (int index = 0; index < n; index++) {
		if (p[index].material == "metal") {
			if (p[index].volum <= volum) {
				cout << p[index].cod << " " << p[index].x << " " << p[index].y << " " << p[index].z << " " << p[index].culoare << " " << p[index].material << " " << p[index].volum << endl;
			}
		}
	}
	continueMessage();
}

//7) Creează fişierul textual Verde.txt în care se vor copia acele linii ale fişierului de intrare, care
//corespund figurilor de culoare verde;
void outGreen(string colour, int index) {
	grout << p[index].cod << " " << p[index].x << " " << p[index].y << " " << p[index].z << " " << p[index].culoare << " " << p[index].material << " " << p[index].volum << endl;
}

void writeGreen() {
	for (int index = 0; index < n; index++) {
		if (p[index].culoare == "verde") {
			cout << p[index].cod << " " << p[index].x << " " << p[index].y << " " << p[index].z << " " << p[index].culoare << " " << p[index].material << " " << p[index].volum << endl;
			outGreen(p[index].culoare, index);
		}
	}
	continueMessage();
}

/*8) Rezolvă problema. Vânătorii de comori au descoperit în una din încăperile închise ale unui castel
medieval n lingouri de aur de dimensiuni distincte. Fiecare lingou i ( 1 ≤ i ≤ n ) reprezintă un paralelipiped
dreptunghiular cu dimensiunile xi , yi , zi. Pentru a scoate lingourile la lumina zilei, vânătorii de comori
trebuie să perforeze într-un zid de piatră unul sau mai multe orificii dreptunghiulare, care nu au puncte de
tangenţă. Un lingou poate fi scos printr-un orificiu dreptunghiular doar atunci când lăţimea şi înălţimea
orificiului sunt egale sau mai mari ca lăţimea şi înălţimea uneia din feţele dreptunghiulare ale
paralelipipedului. Evident, lingoul poate fi rotit in orice fel.
Pentru a-şi uşura munca, vânătorii de comori doresc ca suma ariilor orificiilor ce trebuie perforate să fie cât
mai mică.

Sarcină. Elaboraţi un subprogram care, cunoscând dimensiunile lingourilor de aur, calculează valoarea
minimă S a sumei ariilor orificiilor de perforat, ce vor fi suficiente pentru a scoate toate lingourile.

Date de intrare. Fişierul text Comoara.in.

Date de ieşire. Fişierul text Comoara.out va conţine pe o singură linie numărul întreg S − valoarea
minimă a sumei ariilor orificiilor de perforat.*/

double sumaMin(int index) {
	if (index < 0) return 0;

	p[index].arie = p[index].x * p[index].y;
	if (p[index].x * p[index].z < p[index].arie) p[index].arie = p[index].x * p[index].z;
	if (p[index].y * p[index].z < p[index].arie) p[index].arie = p[index].y * p[index].z;

	return p[index].arie + sumaMin(index - 1);
}

void problem() {
	readFile();

	double suma;
	suma =  sumaMin(n-1);
	cout << "Suma ariilor minima: " << suma << endl;
	out << suma;

	continueMessage();
}

void menu() {
	readFile();
	int index;
	cout << "1.Introduceti Informatie" << endl;
	cout << "2.Stergeti Informatie" << endl;
	cout << "3.Volumul mediu" << endl;
	cout << "4.Afisare dupa coluare" << endl;
	cout << "5.Afisare dupa volum minim si produs" << endl;
	cout << "6.Afisare dupa volum maxim si produs" << endl;
	cout << "7.Enumerare din metal si volum" << endl;
	cout << "8.Afisare dupa culoarea verde" << endl;
	cout << "9.Afisare Suma Ariilor Minima" << endl;
	cout << "Alegeti optiunea: ";
	cin >> index;
	cout << endl;
	switch (index) {
	case 1: insert();
		break;
	case 2: deleteInfo();
		break;
	case 3: writeAvg();
		break;
	case 4: writeByColour();
		break;
	case 5: minVolume();
		break;
	case 6: maxVolume();
		break;
	case 7: writeLessVolume();
		break;
	case 8: writeGreen();
		break;
	case 9: problem();
		break;
	default: "Optiunea nu exista";
		break;
	}
}

void continueMessage() {
	int index;
	cout << endl << "1.Continuati" << endl;
	cout << "2.Terminati" << endl;
	cin >> index;
	cout<<endl;
	switch (index) {
	case 1: menu();
		break;
	default: cout << "";
		break;
	}
}