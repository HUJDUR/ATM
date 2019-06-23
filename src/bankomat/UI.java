package bankomat;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class UI implements Serializable{
	
	private static final long serialVersionUID = 1L;
	static Scanner input = new Scanner(System.in);
	static ArrayList<Racun> racuni = new ArrayList<>();
	
	public static boolean doesFileExist() throws IOException {
		
		try {
			FileInputStream test = new FileInputStream("racuni.txt");
			test.close();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}
	
	public static boolean load() throws IOException, ClassNotFoundException {
		
		if (doesFileExist()) {
			
			FileInputStream in = new FileInputStream("racuni.txt");
			ObjectInputStream oin = new ObjectInputStream(in);
			
			try {
			
				while(true)
				loadRacun((Racun)oin.readObject());
			
			} catch(EOFException ex) {}
				
			in.close();
			oin.close();
			
			return true;
		} else {
			
			@SuppressWarnings("unused")
			File file = new File("racuni.txt");
			return false;
		}		
	}
	
	public static boolean save() throws IOException {

		FileOutputStream in = new FileOutputStream("racuni.txt");
		ObjectOutputStream oin = new ObjectOutputStream(in);

		for (int i = 0; i < racuni.size(); i++) 
			oin.writeObject(Racun.getRacun(i));
		
		in.close();
		oin.close();
		
		return true;
	}
	
	public static void loadRacun(Racun racun) {
		racuni.add(racun);
	}
}
