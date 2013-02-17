package ru.kreedz.xogame;

import java.util.Scanner;
 
class XOGame {
	public static void printGame(int m[]) {
		for (int i = 0; i < 3; ++i) {
			int t = i + 9 + i * 2;
			System.out.println(m[t] + " " + m[t + 1] + " " + m[t + 2]);
			System.out.println();
		}
	}
	
	public static int getWin(int m[]) {
		for (int i = 0; i < 3; ++i) {
			int t = i + 9 + i * 2;
			
			//horizontal
			if (m[t] == m[t + 1] && m[t] == m[t + 2]) return m[t];
			
			//vertical
			if (m[i + 9] == m[i + 12] && m[i + 9] == m[i + 15]) return m[t];
		}
		
		//diagonal
		if (m[9] == m[13] && m[9] == m[17]) return m[9];
		if (m[11] == m[13] && m[11] == m[15]) return m[11];
		
		return 0;
	}
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
    
		int i = 0, flag = 0;
		//0 -> clear, -1 -> X, 1 -> O;
		int[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		while (i < 9) {
			int j = in.nextInt();
			if (j > 0 && j < 10 && 0 == m[j + 8]) {
				++i;
				m[j + 8] = flag == 1 ? (flag = -1) : (flag = 1);
				printGame(m);
				int winner = getWin(m);
				if (winner != 0) { 
					System.out.println(winner + " win this game!");
					break;
				}
			}
		}
	}
}