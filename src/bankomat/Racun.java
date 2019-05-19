package bankomat;

public class Racun {
	
	// stanja objekta
	private int brojRacuna;
	private String imeMusterije;
	private int stanjeRacuna = 0;
	
	// konsturkosti
	Racun() {
		
	}
	
	Racun(int brojRacuna, String imeMusterije, int stanjeRacuna) {
			this.brojRacuna = brojRacuna;
			this.imeMusterije = imeMusterije;
			this.stanjeRacuna = stanjeRacuna;
	}
	
	// getteri, setteri
	@Override
	public String toString() {
		return "BrojRacuna = " + brojRacuna + ", ime musterije = " + imeMusterije + ", stanje racuna = " + stanjeRacuna;
	}

	public int getStanjeRacuna() {
		return stanjeRacuna;
	}

	public void setStanjeRacuna(int stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}

	public int getBrojRacuna() {
		return brojRacuna;
	}
}
