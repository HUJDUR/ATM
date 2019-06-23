package bankomat;

public class Provjera {
	
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
		
		if (slaloc.getStanjeRacuna() <= 0) {
			System.out.println("Nemate dovoljno novca za transfer.");
			return false;
		}
		
		return true;
	}
}
