// Problem_2315 Newspaper

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	while(scan.hasNext()){
	    scan.reset();
	    // Caseの数を入力
	    int N = scan.nextInt();
	    if(N <= 0 || N > 5) System.exit(1);
	    // それぞれのCaseで実行
	    for(int n = 0; n < N; n++){
		scan.reset();

		// 文字と価値を入力
		int K = scan.nextInt();
		if(K <= 0 || K > 100) System.exit(1);
		char[] ch = new char[K];
		int[] p = new int[K];
		for(int k = 0; k < K; k++){
		    ch[k] = scan.next().charAt(0);
		    p[k] = scan.nextInt();
		}

		// 計算する文の行を入力
		int lines = scan.nextInt();
		if(lines <= 0 || lines > 150000) System.exit(1);
		scan.useDelimiter("\n");
		int sum = 0;
		for(int i = 0; i < lines; i++){
		    // 1行ずつ文を入力
		    String l = scan.next();
		    for(int a = 0; a < l.length(); a++){
			for(int k = 0; k < K; k++){
			    if(ch[k] == l.charAt(a)){
				sum += p[k];
				break;
			    }
			}
		    }	
		}

		// 結果を出力

		int tm = sum%100;
		sum /= 100;
		if(tm < 10) System.out.println(sum +".0"+ tm +"$");
		if(tm >= 10) System.out.println(sum +"."+ tm +"$");
	    }
	}
    }
}
