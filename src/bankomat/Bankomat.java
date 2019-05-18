package bankomat;

import java.util.Scanner;

public class Bankomat {
	
	static Scanner input = new Scanner(System.in);

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
		
		if (new Racun(brojRacuna, imeMusterije, stanjeRacuna).provjeraUnosa(brojRacuna, stanjeRacuna)) {
			Racun.getRacuni().add(new Racun(brojRacuna, imeMusterije, stanjeRacuna));
			System.out.println("Racun uspjesno kreiran.");
		}
		
		menu();
	}
	
	public static void transferNovca() {
		
		System.out.println("Unesite broj slalaoca, broj primalaca kao i iznos transfera:");
		int brojSlalaoca = input.nextInt();
		int brojPrimalaca = input.nextInt();
		int iznosTransfera = input.nextInt();
		
		if (Racun.provjeraPriTransferu(brojSlalaoca, brojPrimalaca, iznosTransfera)) {
			Racun.getRacun(brojSlalaoca).setStanjeRacuna(Racun.getRacun(brojSlalaoca).getStanjeRacuna() - iznosTransfera);
			Racun.getRacun(brojPrimalaca).setStanjeRacuna(Racun.getRacun(brojPrimalaca).getStanjeRacuna() + iznosTransfera);
			System.out.println("Transfer je uspjesan.");
		}
		
		menu();
	}
	
	public static void ispisDetalja() {
		
		System.out.println("Unesite broj racuna:");
		int unosKorisnika = input.nextInt();
		
		if (Racun.getRacun(unosKorisnika) == null) 
			System.out.println("Uneseni racun ne postoji.");
		else
			System.out.println(Racun.getRacun(unosKorisnika).toString());		
		
		menu();
	}
}
