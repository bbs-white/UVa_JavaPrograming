// Problem_2899 Horror Dash

import java.util.*;

class Main{
    public static void main(String[] args){
	int num_max = 100;
	String er = "適切な数値を入力してください";
	Scanner s = new Scanner(System.in);

	while(s.hasNext()){
	    int T = s.nextInt(); // Case数
	    if(T < 1 || T > 50){
		System.out.println(er);
		System.exit(1);
	    }

	    int[] N = new int[T]; // 怪獣の生徒数
	    
	    int[][] c = new int[T][num_max]; // 全てのCaseの怪獣の生徒の秒速
	    for(int i = 0; i < T; i++){
		// 最初の数値 怪獣の生徒数を入力
		N[i] = s.nextInt();
		if(N[i] < 1){
		    System.out.println(er);
		    System.exit(1);
		}

		// 怪獣の生徒の速度をそれぞれ入力
		for(int j = 0; j < N[i]; j++){
		    c[i][j] = s.nextInt();
		    if(c[i][j] < 1 || c[i][j] > 10000){
			System.out.println(er);
			System.exit(1);
		    }
		}
	    }

	    int s_max; // それぞれのCaseにおける必要速度

	    for(int i = 0; i < T; i++){
		s_max = 0;
		for(int j = 0; j < N[i]; j++)
		    if(s_max < c[i][j]) s_max = c[i][j];

		System.out.println("Case "+ (i+1) +": "+ s_max);
	    }
	}
    }
}
