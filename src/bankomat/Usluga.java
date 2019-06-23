package bankomat;

import java.io.IOException;

public class Usluga {
	
	public static void kreacijaRacuna() throws IOException {
		
		System.out.println("Unesite broj racuna, vase ime i stanje na racunu:");
		int brojRacuna = UI.input.nextInt();
		String imeMusterije = UI.input.next();
		int stanjeRacuna = UI.input.nextInt();
		
		if (Provjera.provjeraUnosa(brojRacuna, stanjeRacuna)) {
			UI.racuni.add(new Racun(brojRacuna, imeMusterije, stanjeRacuna));
			System.out.println("Racun uspjesno kreiran.");
		}
		
		Menu.menu();
	}
	
	public static void transferNovca() throws IOException {
		
		System.out.println("Unesite broj slalaoca, broj primalaca kao i iznos transfera:");
		int brojSlalaoca = UI.input.nextInt();
		int brojPrimalaca = UI.input.nextInt();
		int iznosTransfera = UI.input.nextInt();
		
		if (Provjera.provjeraPriTransferu(brojSlalaoca, brojPrimalaca, iznosTransfera)) {
			Racun.getRacun(brojSlalaoca).setStanjeRacuna(Racun.getRacun(brojSlalaoca).getStanjeRacuna() - iznosTransfera);
			Racun.getRacun(brojPrimalaca).setStanjeRacuna(Racun.getRacun(brojPrimalaca).getStanjeRacuna() + iznosTransfera);
			System.out.println("Transfer je uspjesan.");
		}
		
		Menu.menu();
	}
	
	public static void ispisDetalja() throws IOException {
		
		System.out.println("Unesite broj racuna:");
		int unosKorisnika = UI.input.nextInt();
		
		if (Racun.getRacun(unosKorisnika) == null) 
			System.out.println("Uneseni racun ne postoji.");
		else
			System.out.println(Racun.getRacun(unosKorisnika).toString());		
		
		Menu.menu();
	}
}
