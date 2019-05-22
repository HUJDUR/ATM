package bankomat;

import java.io.IOException;

public class Bankomat {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		System.out.println(" ------------/////ATM\\\\\\\\\\------------");
		UI.load();
		menu();

	}

	public static void menu() throws IOException {
		
		System.out.println("Koju uslugu trebate?\n 1. Kreacija racuna\n 2. Transfer novca\n 3. Ispis detalja vec postojeceg racuna\n 4. Zavrsavate rad sa bankomatom\n --------------------------------------");
		int unosKorinsika = UI.input.nextInt();
		
		if (unosKorinsika > 4 || unosKorinsika < 0) 
			System.out.println("Greska. Negativan broj.");
		
		switch (unosKorinsika) {
		case 1 : kreacijaRacuna();
		break;
		case 2 : transferNovca();
		break;
		case 3 : ispisDetalja();
		break;
		case 4 : UI.save();
		break;
		}
	}
	
	public static void kreacijaRacuna() throws IOException {
		
		System.out.println("Unesite broj racuna, vase ime i stanje na racunu:");
		int brojRacuna = UI.input.nextInt();
		String imeMusterije = UI.input.next();
		int stanjeRacuna = UI.input.nextInt();
		
		if (provjeraUnosa(brojRacuna, stanjeRacuna)) {
			UI.racuni.add(new Racun(brojRacuna, imeMusterije, stanjeRacuna));
			System.out.println("Racun uspjesno kreiran.");
		}
		
		menu();
	}
	
	public static boolean provjeraUnosa(int brojRacuna, int stanjeRacuna) {
		
		for (int i = 0; i < UI.racuni.size(); i++) {
			if (UI.racuni.get(i).getBrojRacuna() == brojRacuna) {
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
	
	public static void transferNovca() throws IOException {
		
		System.out.println("Unesite broj slalaoca, broj primalaca kao i iznos transfera:");
		int brojSlalaoca = UI.input.nextInt();
		int brojPrimalaca = UI.input.nextInt();
		int iznosTransfera = UI.input.nextInt();
		
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
	
	public static void ispisDetalja() throws IOException {
		
		System.out.println("Unesite broj racuna:");
		int unosKorisnika = UI.input.nextInt();
		
		if (getRacun(unosKorisnika) == null) 
			System.out.println("Uneseni racun ne postoji.");
		else
			System.out.println(getRacun(unosKorisnika).toString());		
		
		menu();
	}
	
	public static Racun getRacun(int brojRacuna) {
		
		for (int i = 0; i < UI.racuni.size(); i++) {
			if (UI.racuni.get(i).getBrojRacuna() == brojRacuna)
				return UI.racuni.get(i);
		}
		
		return null;
	}
}
