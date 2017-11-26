// Problem_3053 Dominator
import java.util.*;
import java.io.*;
class Main{
    static int k = 100;
    static boolean[] r = new boolean[k];
    static boolean[] v = new boolean[k];
    static int[][] g = new int[k][k];
    static int[][] path = new int[k][k];
    static int delete = -1;
    
    public static void main(String[] args){
	BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	StringBuilder stringBuilder = new StringBuilder(25000);
	Scanner sc = new Scanner(System.in);
	try{
	    int T = sc.nextInt();
	    for(int t = 0; t < T; t++){
		int N = sc.nextInt();
	    
		// グラフの入力
		for(int i = 0; i < N; i++){
		    for(int j = 0; j < N; j++){
			g[i][j] = sc.nextInt();
		    }
		}

		// 各変数と配列の初期化
		delete = -1;
		for(int i = 0; i < N; i++){
		    r[i] = false;
		    v[i] = false;
		}
	    
		// 何も削除せず0をスタートして到達できる点を調査
		deapth_first_search(0,N);
		path[0][0] = 1;
		for(int i = 1; i < N; i++){
		    if(r[i]){
			path[0][i] = 1;
		    }else if(i>0){
			path[0][i] = 0;
		    }
		}

		// 1以降を削除した時の探索
		for(int i = 1; i < N; i++){
		    delete = i;
		    for(int x = 0; x < N; x++){
			r[x] = false;
			v[x] = false;
		    }

		    deapth_first_search(0,N);
		
		    for(int j = 1; j < N; j++){
			if(path[0][j] > 0 && !r[j])
			    path[i][j] = 1;
			else
			    path[i][j] = 0;
		    }
		}
	    
	    
		stringBuilder.append("Case " + (t+1) + ":\n");
		stringBuilder.append('+');
		for(int x = 0; x < 2 * N - 1; x++)
		    stringBuilder.append('-');
		stringBuilder.append("+\n");
	    
		for(int i = 0; i < N; i++){
		    for(int j = 0; j < N; j++){
			if(path[i][j] > 0)
			    stringBuilder.append("|Y");
			else
			    stringBuilder.append("|N");
		    }
		    stringBuilder.append("|\n");
		
		    stringBuilder.append('+');
		    for (int x = 0; x < 2 * N - 1; x++)
			stringBuilder.append('-');
		    stringBuilder.append("+\n");
		}
		if(stringBuilder.length() >= 10000){
		    output.write(stringBuilder.toString());
		    stringBuilder = new StringBuilder(25000);
		}
	    }
	    output.write(stringBuilder.toString());
	    output.flush();
	    output.close();
	}catch(IOException e){
	    System.out.println(e);
	}
    }
    

    
    
    // 深さ優先探索
    public static void deapth_first_search(int p, int N){
	for(int i = 0; i < N; i++){
	    if(i != delete && g[p][i] > 0){
		if(!v[i]){
		    r[i] = true;
		    v[i] = true;
		    deapth_first_search(i,N);
		}		
	    }
	}
    }
}
