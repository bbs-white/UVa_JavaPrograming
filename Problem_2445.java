//Problem_2445 Wedding shopping
import java.util.*;

class Main{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);

	// Caseを入力
	int N = scan.nextInt();
	for(int n = 0; n < N; n++){

	    // 予算を入力
	    int M = scan.nextInt();
	    // 商品の分類数を入力
	    int C = scan.nextInt();
	    int[][] state = new int[M+1][C+1];

	    // 現在の残り予算と所持している商品の分類数を格納する.
	    // 初期状態の予算は M, 所持している分類数は 0.
	    state[M][0] = 1;
	    
	    for(int c = 1; c <= C; c++){

		// ある分類の商品数を入力
		int K = scan.nextInt();
		for(int k = 0; k < K; k++){

		    // 商品の値段を入力
		    int m = scan.nextInt();
		    for(int i = 0; i <= M; i++){

			// 次の分類の商品を買った時の残りの予算を格納
			if(state[i][c-1] == 1 && i >= m){
			    state[i-m][c] = 1;
			}
		    }
		}
	    }

	    // 残り予算が少ない順に全ての商品を買った場合の値段を決定
	    for(int i = 0; i <= M; i++){
		if(state[i][C] == 1){
		    System.out.println(M-i);
		    break;
		}else if(i == M){
		    System.out.println("no solution");
		}
	    }
	}
    }
}
	
