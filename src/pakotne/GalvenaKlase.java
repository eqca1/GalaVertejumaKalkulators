package pakotne;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class GalvenaKlase {
	
	static ArrayList<String> audzek = new ArrayList<String>();
	static ArrayList<String> krit = new ArrayList<String>();
	static ArrayList<Integer> kritSv = new ArrayList<Integer>();
	static ArrayList<Double> semVert = new ArrayList<Double>();


	
	public static void main(String[] args) {
		int studSk, kritSk;
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.#");
		
		int GalvIzv;
		String GalvIz;
		do {
		GalvIz =JOptionPane.showInputDialog(null, "Izvēlies darbību~\n1. Pievienot audzēkņu!"
				+ "\n2. Ievadīt kritērijus!\n"
				+ "3. Ievadīt kritēriju svarus\n"
				+ "4. Ievadīt vērtējumus\n"
				+ "5. Labot..->\n"
				+ "6. Aprēķināt gala vērtējumu\n"
				+ "7. Saglabāt rezultātus failā\n"
				+ "8. Nolasīt rezultātus no faila\n"
				+ "0. Apturēt programmu!", "...");
		GalvIzv = Integer.parseInt(GalvIz);
			switch(GalvIzv) {
			
			case 0: JOptionPane.showMessageDialog(null, "Programma ir apturēta!"); GalvIzv = -1; break;
			case 1: PaligKlase.pievAudz(); break;
			case 2: PaligKlase.ievadKrit(); break;
			case 3: if( krit.size() == 0) { JOptionPane.showMessageDialog(null, "Nav ievadīti kritēriji!", "Kļūda", JOptionPane.ERROR_MESSAGE); break; }
				PaligKlase.ievadKritSv(); break;
			case 4: if( krit.size() == 0) { JOptionPane.showMessageDialog(null, "Nav ievadīti kritēriji!", "Kļūda", JOptionPane.ERROR_MESSAGE); break; }
				PaligKlase.ievadVert(); break;
			case 6: if( audzek.size() == 0) { JOptionPane.showMessageDialog(null, "Nav ievadīti audzēkņi!", "Kļūda", JOptionPane.ERROR_MESSAGE); break; }
				if( krit.size() == 0) { JOptionPane.showMessageDialog(null, "Nav ievadīti kritēriji!", "Kļūda", JOptionPane.ERROR_MESSAGE); break; } 
				PaligKlase.vertAprek(); break;
			case 5:
				int GalvIzvq;
				String GalvIzq;
				GalvIzq =JOptionPane.showInputDialog(null, "Izvēlies darbību~\n1. Labot kritēriju!"
						+ "\n2. Labot kritērija svaru!\n"
						+ "3. Labot iegūto vērtējumu\n"
						+ "0. Atgriezties!", "...");
				GalvIzvq = Integer.parseInt(GalvIzq);
					switch(GalvIzvq) { 
					case 0: break;
					case 1: PaligKlase.ievadKrit(); break;
					case 2: if( krit.size() == 0) { JOptionPane.showMessageDialog(null, "Nav ievadīti kritēriji!", "Kļūda", JOptionPane.ERROR_MESSAGE); break; }
					PaligKlase.ievadKritSv(); break;
					case 3: if( krit.size() == 0) { JOptionPane.showMessageDialog(null, "Nav ievadīti kritēriji!", "Kļūda", JOptionPane.ERROR_MESSAGE); break; }
					PaligKlase.ievadVert(); break;
					}
					break;
			}
		}while(GalvIzv > 0 || GalvIzv < 8);
		
		
		/*
		// Audzēkņu skaita ievade
		do {
			System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
			while(!scan.hasNextInt()) {
				System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
				scan.next();
			}
			studSk = scan.nextInt();
		}while(studSk<1);
		String[] studenti = new String[studSk];
		*/
		
		/*
		// Vērtēšanas kritēriju skaita ievade
		do {
			System.out.println("Kāds būs kritēriju skaits?");
			while(!scan.hasNextInt()) {
				System.out.println("Kāds būs kritēriju skaits?");
				scan.next();
			}
			kritSk = scan.nextInt();
		}while(kritSk<1);
		String[] kriteriji = new String[kritSk];
		int[] kriterijaSvars = new int[kritSk];
		int[][] kriterijaVertejums = new int[studSk][kritSk];
		double[] semestraVertejums = new double[studSk];
	
	
		scan.nextLine();
	*/
		
	/*	
		// Ievada audzēkņu vārdus, uzvārdus
		for(int i=0; i<studenti.length; i++) {
			do {
				System.out.println("Ievadi "+(i+1)+". studentu");
				studenti[i] = scan.nextLine().trim();
			} while(!studenti[i].matches("^[\\p{L} ]+$"));
		}
		*/
		// Definē kritērijus
		/*
		int maxSvars = 100, sk = 1;
		double atlSvars;
		for(int i=0; i<kriteriji.length; i++) {
			do {
				System.out.println("Ievadi "+(i+1)+". kritēriju");
				kriteriji[i] = scan.nextLine().trim();
			} while(!kriteriji[i].matches("^[\\p{L} ]+$"));
			
			// Norāda katra kritērija svaru
			do {
				System.out.println("Ievadi "+(i+1)+". kritērija svaru (max: "+maxSvars+")");
				while(!scan.hasNextInt()) {
					System.out.println("Ievadi "+(i+1)+". kritērija svaru");
					scan.next();
				}
				kriterijaSvars[i] = scan.nextInt();
				/* Minimālā KATRA ATLIKUŠĀ kritērija svars ir 5
				 * kopējai svaru vērtībai ir jābūt 100 (ne mazāk, ne vairāk)
				
				atlSvars = (maxSvars - kriterijaSvars[i]) / (double)(kriteriji.length - sk);
			} while(kriterijaSvars[i]>maxSvars || kriterijaSvars[i]<5 || 
				  (i != kriteriji.length-1 && kriterijaSvars[i] == maxSvars) ||
				  (i == kriteriji.length-1 && (maxSvars - kriterijaSvars[i])  > 0) 
				  || atlSvars < 5);
			maxSvars -= kriterijaSvars[i];
			sk++;
			scan.nextLine();
		}

		*/

		
		/*
		
		
		
		
		// Norāda vērtējumu kādu ieguvis katrs audzēknis par katru kritēriju
		for(int i=0; i<kriterijaVertejums.length; i++) {
			for(int j=0; j<kriterijaVertejums[i].length; j++) {
				do {
					System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
					while(!scan.hasNextInt()) {
						System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
						scan.next();
					}
					kriterijaVertejums[i][j] = scan.nextInt();
				}while(kriterijaVertejums[i][j]<0 || kriterijaVertejums[i][j]>10);
			}
		}
		
		// Gala vērtējuma aprēķināšana
		double rezultats;
		for(int i=0; i<studenti.length; i++) {
			rezultats=0;
			for(int j=0; j<kriteriji.length; j++) {
				rezultats += ((double) kriterijaSvars[j]/100)*kriterijaVertejums[i][j];
			}
			semestraVertejums[i] = rezultats;
		}
		
		// Gala vērtējumu izvadīšana
		for(int i=0; i<studenti.length; i++) {	
			for(int j=0; j<kriteriji.length; j++) {
				System.out.println("Studenta "+studenti[i]+" vērtējums par kritēriju "+kriteriji[j]+" ir "+kriterijaVertejums[i][j]+", kura svars ir "+kriterijaSvars[j]);
			}
			System.out.println("Semestra vērtējums ir "+df.format(semestraVertejums[i])+" balles"
					+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		}
		scan.close();
		
		
		
		*/
	}
}