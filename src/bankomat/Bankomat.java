package bankomat;

import java.io.IOException;
import java.io.Serializable;

public class Bankomat implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		System.out.println(" ------------/////ATM\\\\\\\\\\------------");
		UI.load();
		Menu.menu();

	}
}
