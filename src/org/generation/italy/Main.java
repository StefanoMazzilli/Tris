package org.generation.italy;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String[][] matrice= new String [3][3];
		int x, y, i, j, contatore=0;
		
		for (i=0; i<3; i++) {
			for (j=0; j<3; j++) {
				matrice [i][j]=" ";
				System.out.print(matrice[i][j]);
			}
			System.out.println();
		}
		
		do {
			System.out.print("Inserire la coordinata x: ");
			x=sc.nextInt();
			System.out.println();
			System.out.print("Inserire la coordinata y: ");
			y=sc.nextInt();
			
			if (matrice[x-1][y-1].equals(" ")) {
				matrice[x-1][y-1]="X";
				contatore++;
				for (i=0; i<3; i++) {
					for (j=0; j<3; j++) {
						System.out.print(matrice[i][j]);
					}
					System.out.println();
				}
			} else {
				System.out.println("Casella già occupata!");
			}
		}while(contatore<9);
		sc.close();
	}

}
