package pakotne;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class PaligKlase {
	
	static void pievAudz() {
		String vards;
		do{
			vards = JOptionPane.showInputDialog(null, "Lūdzu ievadiet audzēkņa vārdu!", "Ievade");
		}while(vards == null || vards.isEmpty());
		
		GalvenaKlase.audzek.add(vards);
	}
	
}
