//Problem_499 Wormholes
import java.io.*;
import java.util.*;

class Main{
    public static boolean hasNegativeCycle;
    public static int Inf = Integer.MAX_VALUE;
    public static int N, M;
    public static void main(String[] args){

	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	for(int t = 0; t < T; t++){
	    
	    // 惑星の数 N とワームホールの数 M を入力
	    N = sc.nextInt();
	    M = sc.nextInt();

	    // ワームホールの経過年数を入力
	    int[][] edges = new int[M][3];
	    for(int m = 0; m < M; m++){
		edges[m][0] = sc.nextInt();
		edges[m][1] = sc.nextInt();
		edges[m][2] = sc.nextInt();
	    }

	    // 負の閉ループが存在しないと仮定
	    hasNegativeCycle = false;

	    BF(edges);
	    
	    if(hasNegativeCycle)
		System.out.println("possible");
	    else
		System.out.println("not possible");
	}
    }

    public static void BF(int[][] edg){
	int[] dis = new int[N];
	dis[0] = 0;
	for(int i = 1; i < N; i++)
	    dis[i] = Inf;

	for(int n = 0; n < N; n++){
	    for(int m = 0; m < M; m++){
		if(dis[edg[m][1]] > dis[edg[m][0]] + edg[m][2]){
		    dis[edg[m][1]] = dis[edg[m][0]] + edg[m][2];
		    if(n == N-1){
			hasNegativeCycle = true;
			break;
		    }
		}
	    }
	}
    }
}
