package pakotne;
import java.util.ArrayList;
import java.text.DecimalFormat;

import javax.sql.rowset.serial.SerialJavaObject;
import javax.swing.JOptionPane;
public class PaligKlase {
	
	static DecimalFormat df = new DecimalFormat("0.#");

	static int[][] kriterijaVertejums = new int[GalvenaKlase.audzek.size()][GalvenaKlase.krit.size()];
	
	static void pievAudz() {
		String vards;
		do{
			vards = JOptionPane.showInputDialog(null, "Lūdzu ievadiet audzēkņa vārdu!", "...", JOptionPane.PLAIN_MESSAGE);
		}while(vards == null || vards.isEmpty());
		
		GalvenaKlase.audzek.add(vards);
	}
	
	static void ievadKrit() {
		
		int kritSk;
		kritSk = Integer.parseInt(JOptionPane.showInputDialog(null, "Kāds būs kritēriju skaits?", "...", JOptionPane.PLAIN_MESSAGE));
		

		for(int i=0; i<kritSk; i++) {
			
			
				GalvenaKlase.krit.add(JOptionPane.showInputDialog(null, "Ievadi "+(i+1)+". kritēriju", "...").trim());
				
		}
	}
	
	static void ievadKritSv() {
		/*
		int maxSvars = 100, sk = 0;
		double atlSvars;
		
	for(int i=0; i<GalvenaKlase.krit.size(); i++) {
		
			do {
				
				GalvenaKlase.kritSv.add(Integer.parseInt(JOptionPane.showInputDialog(null, "Ievadi "+(sk+1)+". kritērija svaru (max: "+maxSvars+")")));
				maxSvars -= GalvenaKlase.kritSv.get(i);
				sk++;
				
			} while(maxSvars != 0);
		}
		*/
	// Definē kritērijus
			String[] kriteriji = new String[GalvenaKlase.krit.size()];
			int[] kriterijaSvars = new int[GalvenaKlase.krit.size()];
			
			int maxSvars = 100, sk = 1;
			double atlSvars;
			for(int i=0; i<kriteriji.length; i++) {
				
				kriteriji[i] = GalvenaKlase.krit.get(i);
				
				// Norāda katra kritērija svaru
				do {
					
					kriterijaSvars[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ievadi "+(i+1)+". kritērija svaru (max: "+maxSvars+")"));
					/* Minimālā KATRA ATLIKUŠĀ kritērija svars ir 5
					 * kopējai svaru vērtībai ir jābūt 100 (ne mazāk, ne vairāk)
					*/
					atlSvars = (maxSvars - kriterijaSvars[i]) / (double)(kriteriji.length - sk);
				} while(kriterijaSvars[i]>maxSvars || kriterijaSvars[i]<5 || 
					  (i != kriteriji.length-1 && kriterijaSvars[i] == maxSvars) ||
					  (i == kriteriji.length-1 && (maxSvars - kriterijaSvars[i])  > 0) 
					  || atlSvars < 5);
				maxSvars -= kriterijaSvars[i];
				sk++;
				GalvenaKlase.kritSv.add(kriterijaSvars[i]);
			}
	}
	static void ievadVert() {
		
		

		
		for(int i=0; i<kriterijaVertejums.length; i++) {
			for(int j=0; j<kriterijaVertejums[i].length; j++) {
				do {
					kriterijaVertejums[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Ievadi "+GalvenaKlase.audzek.get(i)+" vērtējumu par kritēriju "+GalvenaKlase.krit.get(i)));
				}while(kriterijaVertejums[i][j]<0 || kriterijaVertejums[i][j]>10);
			}
		}
	}
	static void vertAprek() {
		
		// Gala vērtējuma aprēķināšana
				double rezultats;
				for(int i=0; i<GalvenaKlase.audzek.size(); i++) {
					rezultats=0;
					for(int j=0; j<GalvenaKlase.krit.size(); j++) {
						rezultats += ((double) GalvenaKlase.kritSv.get(j)/100)*kriterijaVertejums[i][j];
					}
					GalvenaKlase.semVert.add(rezultats);
				}
				
				// Gala vērtējumu izvadīšana
				for(int i=0; i<GalvenaKlase.audzek.size(); i++) {	
					for(int j=0; j<GalvenaKlase.krit.size(); j++) {
						JOptionPane.showMessageDialog(null, "Studenta "+GalvenaKlase.audzek.get(i)+" vērtējums par kritēriju "+GalvenaKlase.krit.get(j)+" ir "+kriterijaVertejums[i][j]+", kura svars ir "+GalvenaKlase.kritSv.get(j));
					}
					JOptionPane.showMessageDialog(null, "Semestra vērtējums ir "+df.format(GalvenaKlase.semVert.get(i))+" balles"
							+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
				}
		
	}
		
	
}
