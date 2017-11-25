//Problem_2595 Event Planning

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	while(scan.hasNext()){
	    int N = scan.nextInt(); // 参加者 [1, 200]
	    if(N < 1 || N > 200) System.exit(1);
	
	    int B = scan.nextInt(); // 予算 [1, 500000]
	    if(B < 1 || B > 500000) System.exit(1);
	
	    int H = scan.nextInt(); // ホテル箇所 [1, 18]
	    if(H < 1 || H > 18) System.exit(1);
	
	    int W = scan.nextInt(); // 滞在週間 [1, 13]
	    if(W < 1 || W > 13) System.exit(1);

	    int[] p = new int[H];
	    int[][] a = new int[H][W];
	    for(int i = 0; i < H; i++){
		p[i] = scan.nextInt(); // 一人当たりの料金
		if(p[i] < 1 || p[i] > 10000) System.exit(1);
		for(int j = 0; j < W; j++){
		    a[i][j] = scan.nextInt(); // 可能なベッドの数
		    if(a[i][j] < 0 || a[i][j] > 1000) System.exit(1);
		}
	    }
	
	    int cost_min = B+1;
	    for(int i = 0; i < H; i++){
		boolean found = false; // 可能な週があるかどうかを格納する変数
		int cost_all = N*p[i];
		if(cost_all <= B){
		    for(int j = 0; j < W; j++)
			if(a[i][j] > N) found = true;
		}
		if(found == true && cost_min > cost_all) cost_min = cost_all;
	    }
	    if(cost_min > B) System.out.println("stay home");
	    else System.out.println(cost_min);
	}
    }
}
