package bankomat;

import java.io.IOException;

public class Menu {
	
	public static void menu() throws IOException {
		
		System.out.println("Koju uslugu trebate?\n 1. Kreacija racuna\n 2. Transfer novca\n 3. Ispis detalja vec postojeceg racuna\n 4. Zavrsavate rad sa bankomatom\n --------------------------------------");
		int unosKorinsika = UI.input.nextInt();
		
		if (unosKorinsika > 4 || unosKorinsika < 0) 
			System.out.println("Greska. Negativan broj.");
		
		switch (unosKorinsika) {
		case 1 : Usluga.kreacijaRacuna();
		break;
		case 2 : Usluga.transferNovca();
		break;
		case 3 : Usluga.ispisDetalja();
		break;
		case 4 : UI.save();
		break;
		}
	}	
}
