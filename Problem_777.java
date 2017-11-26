//Problem_777 Largest Submatrix
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args){
	BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
	try{
	    String l = re.readLine();
	    int T = Integer.parseInt(l);
	    
	    for(int t = 0; t < T; t++){
		int N = 0;
		for(int i = 0; i < 2; i++){
		    l = re.readLine();
		    N = l.length();
		}
		
		int[][] M = new int[N][N];
		String[] l2 = new String[N];
		l2 = l.split("",0);
		for(int i = 0; i < N; i++){
		    M[0][i] = Integer.parseInt(l2[i]);
		}
		
		for(int i = 1; i < N; i++){
		    l = re.readLine();
		    l2 = l.split("",0);
		    for(int j = 0; j < N; j++){
			M[i][j] = Integer.parseInt(l2[j]);
		    }
		}

		// 最大面積を格納する変数 max
		int max = 0;

     		// 探索開始
		// まず始点をP(i,j)として、Pを左上の点とする
		for(int i = 0; i < N; i++){
		    for(int j = 0; j < N; j++){
			// 残りの四角形の面積が max より小さければ探索終了
			if((N-i)*(N-j) < max) break;

			// 現在の値が0のとき次の点へと移動
			if(M[i][j] == 0) continue;
			
			// 右下の点をP'(gi,gj)とする
			for(int gi = i; gi < N; gi++){
			    outer:
			    for(int gj = j; gj < N; gj++){
				if(M[gi][gj] == 0) break outer;
				// 単純な四角形の面積
				int s = (1+gi-i)*(1+gj-j);
				if(max > s) continue;

				// 実際の四角形の面積
				int key = sumRec(M,i,j,gi,gj);
				
				if(key == s && key > max) max = key;
			    }
			}
		    }
		}
		if(t != 0) System.out.println();
		System.out.println(max);
	    }
	}catch(IOException e){
	    System.out.println(e);
	}
    }
    
    public static int sumRec(int[][] M, int si, int sj, int gi, int gj){
	int sum = 0;
	for(int i = si; i <= gi; i++){
	    for(int j = sj; j <= gj; j++){
		sum += M[i][j];
	    }
	}
	return sum;
    }
}
