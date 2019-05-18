package bankomat;

import java.util.ArrayList;

public class Racun {
	
	// stanja objekta
	int brojRacuna;
	String imeMusterije;
	int stanjeRacuna = 0;
	static ArrayList<Racun> racuni = new ArrayList<>();
	
	// konsturkosti
	Racun() {
		
	}
	
	Racun(int brojRacuna, String imeMusterije, int stanjeRacuna) {
		if (provjeraUnosa(brojRacuna, stanjeRacuna)) {
			this.brojRacuna = brojRacuna;
			this.imeMusterije = imeMusterije;
			this.stanjeRacuna = stanjeRacuna;
			racuni.add(this);
		}
	}
	
	// ponasanje objekta
	public boolean provjeraUnosa(int brojRacuna, int stanjeRacuna) {
		
		for (int i = 0; i < racuni.size(); i++) {
			if (racuni.get(i).brojRacuna == brojRacuna) {
				System.out.println("Vec postoji racun sa unesenim brojem.");
				return false;
			}
		}
		
		if (stanjeRacuna < 0 || brojRacuna < 0) {
			System.out.println("Unos ne moze biti negativan broj.");
			return false;
		}
		
		System.out.println("Racun je uspjesno kreiran.");
		return true;
	}
	
	public static boolean provjeraPriTransferu(int brojSlalaoca, int brojPrimalaca, int iznosTransfera) { 
		
		Racun slaloc = Racun.getRacun(brojSlalaoca);
		Racun primalac = Racun.getRacun(brojPrimalaca);
		
		if (slaloc == null || primalac == null) {
			System.out.println("Uneseni profil ne postoji.");
			return false;
		}
		
		if (iznosTransfera < 0) {
			System.out.println("Negativan unos iznosa transfera.");
			return false;
		}
		
		if (slaloc.stanjeRacuna <= 0) {
			System.out.println("Nemate dovoljno novca za transfer.");
			return false;
		}
		
		return true;
	}
	
	public static Racun getRacun(int brojRacuna) {
		
		for (int i = 0; i < racuni.size(); i++) {
			if (racuni.get(i).brojRacuna == brojRacuna)
				return racuni.get(i);
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return "BrojRacuna = " + brojRacuna + ", ime musterije = " + imeMusterije + ", stanje racuna = " + stanjeRacuna;
	}

}
