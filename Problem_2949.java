// Problem_2949 CD
import java.util.*;

class Main{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	int t = 0;
	int max_case = 100;
	int million = 1000000;
	int billion = 1000000000;
	int[] N = new int[max_case];
	int[] M = new int[max_case];
	int[][] c1 = new int[max_case][million];
	int[][] c2 = new int[max_case][million];

	while(scan.hasNext()){
	    while(true){
		N[t] = scan.nextInt();
		M[t] = scan.nextInt();
		if(N[t] > million || M[t] > million) System.exit(1);
		if(N[t] == 0 || M[t] == 0) break;

		// CD カタログを昇順で入力
		for(int i = 0; i < N[t]; i++){
		    c1[t][i] = scan.nextInt();
		}
		for(int i = 0; i < M[t]; i++){
		    c2[t][i] = scan.nextInt();
		}

		t++;
	    }

	    int[] common = new int[t];
	    int _t = 0;

	    // CDが昇順になっているので比較する必要のない部分以外を比較
	    while(_t < t){
		int i = 0;
		int j = 0;
		while(i < N[_t] && j < M[_t]){
		    if(c1[_t][i] == c2[_t][j]){
			common[_t]++;
			i++;
			j++;
		    }else if(c1[_t][i] < c2[_t][j]){
			i++;
		    }else{
			j++;
		    }
		}
		// 結果を出力
		System.out.println(common[_t]);
		_t++;
	    }
	}
    }
}
