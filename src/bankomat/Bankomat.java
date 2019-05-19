package bankomat;

import java.util.ArrayList;
import java.util.Scanner;

public class Bankomat {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<Racun> racuni = new ArrayList<>();

	public static void main(String[] args) {
		
		System.out.println(" ------------/////ATM\\\\\\\\\\------------");
		menu();

	}

	public static void menu() {
		
		System.out.println("Koju uslugu trebate?\n 1. Kreacija racuna\n 2. Transfer novca\n 3. Ispis detalja vec postojeceg racuna\n --------------------------------------");
		int unosKorinsika = input.nextInt();
		
		if (unosKorinsika > 3 || unosKorinsika < 0) 
			System.out.println("Greska. Negativan broj.");
		
		switch (unosKorinsika) {
		case 1 : kreacijaRacuna();
		break;
		case 2 : transferNovca();
		break;
		case 3 : ispisDetalja();
		break;
		}
	}
	
	public static void kreacijaRacuna() {
		
		System.out.println("Unesite broj racuna, vase ime i stanje na racunu:");
		int brojRacuna = input.nextInt();
		String imeMusterije = input.next();
		int stanjeRacuna = input.nextInt();
		
		if (provjeraUnosa(brojRacuna, stanjeRacuna)) {
			racuni.add(new Racun(brojRacuna, imeMusterije, stanjeRacuna));
			System.out.println("Racun uspjesno kreiran.");
		}
		
		menu();
	}
	
	public static boolean provjeraUnosa(int brojRacuna, int stanjeRacuna) {
		
		for (int i = 0; i < racuni.size(); i++) {
			if (racuni.get(i).getBrojRacuna() == brojRacuna) {
				System.out.println("Vec postoji racun sa unesenim brojem.");
				return false;
			}
		}
		
		if (stanjeRacuna < 0 || brojRacuna < 0) {
			System.out.println("Unos ne moze biti negativan broj.");
			return false;
		}
		
		return true;
	}
	
	public static void transferNovca() {
		
		System.out.println("Unesite broj slalaoca, broj primalaca kao i iznos transfera:");
		int brojSlalaoca = input.nextInt();
		int brojPrimalaca = input.nextInt();
		int iznosTransfera = input.nextInt();
		
		if (provjeraPriTransferu(brojSlalaoca, brojPrimalaca, iznosTransfera)) {
			getRacun(brojSlalaoca).setStanjeRacuna(getRacun(brojSlalaoca).getStanjeRacuna() - iznosTransfera);
			getRacun(brojPrimalaca).setStanjeRacuna(getRacun(brojPrimalaca).getStanjeRacuna() + iznosTransfera);
			System.out.println("Transfer je uspjesan.");
		}
		
		menu();
	}
	
	public static boolean provjeraPriTransferu(int brojSlalaoca, int brojPrimalaca, int iznosTransfera) { 
		
		Racun slaloc = getRacun(brojSlalaoca);
		Racun primalac = getRacun(brojPrimalaca);
		
		if (slaloc == null || primalac == null) {
			System.out.println("Uneseni profil ne postoji.");
			return false;
		}
		
		if (iznosTransfera < 0) {
			System.out.println("Negativan unos iznosa transfera.");
			return false;
		}
		
		if (slaloc.getStanjeRacuna() <= 0) {
			System.out.println("Nemate dovoljno novca za transfer.");
			return false;
		}
		
		return true;
	}
	
	public static void ispisDetalja() {
		
		System.out.println("Unesite broj racuna:");
		int unosKorisnika = input.nextInt();
		
		if (getRacun(unosKorisnika) == null) 
			System.out.println("Uneseni racun ne postoji.");
		else
			System.out.println(getRacun(unosKorisnika).toString());		
		
		menu();
	}
	
	public static Racun getRacun(int brojRacuna) {
		
		for (int i = 0; i < racuni.size(); i++) {
			if (racuni.get(i).getBrojRacuna() == brojRacuna)
				return racuni.get(i);
		}
		
		return null;
	}
}
