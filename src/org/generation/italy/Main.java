package org.generation.italy;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[][] matrice = new String[3][3];
		int[][] controllo = new int[3][3];
		int x, y, i, j, contatore = 0, k=1;
		boolean occupata, vittoria1 = false, vittoria2 = false;

		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				matrice[i][j] = "   ";
			}
		}

		do { // ciclo della partità, termina solo se uno dei due giocatori vince o la matrice
				// si riempie
			if(k%2==1) { //la variabile k conta i vari turni, se è un turno dispari fa la mossa il Giovatore 1
				// TURNO GIOCATORE 1
				do { // ciclo di controllo che non inserisca la X in una casella già occupata
					System.out.print("Giocatore 1 inserire la coordinata x: ");
					x = sc.nextInt();
					System.out.println();
					System.out.print("Adesso inserire la coordinata y: ");
					y = sc.nextInt();
	
					if (matrice[x - 1][y - 1].equals("   ")) { // controllo che la casella sia vuota
						matrice[x - 1][y - 1] = " X ";
						controllo[x - 1][y - 1] = 1;
						contatore++;
						for (i = 0; i < 3; i++) { // mostro la tabella
							for (j = 0; j < 3; j++) {
								System.out.print(matrice[i][j]);
							}
							System.out.println();
						}
						occupata = false;
					} else {
						System.out.println("Casella già occupata!");
						occupata = true;
					}
				} while (occupata);
			}else { //se è un turno pari fa la mossa il Giocatore 2
				// TURNO GIOCATORE 2
				do { // ciclo di controllo che il giocatore non inserisca il O in una casella già
						// occupato
					System.out.print("Giocatore 2 inserire la coordinata x: ");
					x = sc.nextInt();
					System.out.println();
					System.out.print("Adesso inserire la coordinata y: ");
					y = sc.nextInt();
	
					if (matrice[x - 1][y - 1].equals("   ")) { // controllo che la casella sia vuota
						matrice[x - 1][y - 1] = " O ";
						controllo[x - 1][y - 1] = 2;
						contatore++;
						for (i = 0; i < 3; i++) { // mostro la tabella
							for (j = 0; j < 3; j++) {
								System.out.print(matrice[i][j]);
							}
							System.out.println();
						}
						occupata = false;
					} else {
						System.out.println("Casella già occupata!");
						occupata = true;
					}
				} while (occupata);
			}
			k++;
			// CONTROLLO CHE UNO DEI DUE GIOCATORI ABBIA VINTO
			for (i = 0; i < 3; i++) { // controllo le righe
				if ((controllo[i][0] == controllo[i][1]) && (controllo[i][1] == controllo[i][2])) {
					if (controllo[i][1] == 1) {
						vittoria1 = true;
					} else if (controllo[i][1] == 2) {
						vittoria2 = true;
					}
				}
			}
			for (j = 0; j < 3; j++) { // controllo le colonne
				if ((controllo[0][j] == controllo[1][j]) && (controllo[1][j] == controllo[2][j])) {
					if (controllo[1][j] == 1) {
						vittoria1 = true;
					} else if (controllo[1][j] == 2) {
						vittoria2 = true;
					}
				}
			}
			// controllo la prima diagonale
			if ((controllo[0][0] == controllo[1][1]) && (controllo[1][1] == controllo[2][2])) {
				if (controllo[1][1] == 1) {
					vittoria1 = true;
				} else if (controllo[1][1] == 2) {
					vittoria2 = true;
				}
			}
			// controllo la seconda diagonale
			if ((controllo[0][2] == controllo[1][1]) && (controllo[1][1] == controllo[2][0])) {
				if (controllo[1][1] == 1) {
					vittoria1 = true;
				} else if (controllo[1][1] == 2) {
					vittoria2 = true;
				}
			}

		} while ((contatore < 9) && !(vittoria1) && !(vittoria2));
		
		if (vittoria1) {
			System.out.println("Complimenti ha vinto il giocatore 1!");
		}else if (vittoria2) {
			System.out.println("Complimenti ha vinto il giocatore 2!");
		}else {
			System.out.println("Non ha vinto nessuno, pareggio...");
		}

		sc.close();
	}

}
