//Problem_1700 Dice throwing
import java.util.*;

class Main{
    
    static long max;
    static int dice_max = 30+1;
    static int score_max = (dice_max-1) * 6 + 1;
    static long[][] result = new long[dice_max][score_max];
    
    public static void main(String[] args){

	// 初期値を-1とする
	for(int i = 0; i < 25; i++){
	    for(int j = 0; j < 145; j++){
		result[i][j] = -1;
	    }
	}
	
	Scanner sc = new Scanner(System.in);
	while(sc.hasNext()){
	    // サイコロ数 n, 最小値 m を入力
	    int n = sc.nextInt();
	    int m = sc.nextInt();

	    // (n,m) = (0,0)のとき終了
	    if(n == 0 && m == 0)
		System.exit(0);

	    // 出る目の最大値を格納
	    max = 6*n;
	    if(m > max){
		result[n][m] = 0;
		System.out.println(0);
		continue;
	    }
	    if(m == n){
		System.out.println(1);
		continue;
	    }
	    
	    
	    long c = 0;
	    int m_ = m;
	    while(m_ <= max){
		c += count(n,m_);
		m_++;
	    }
	    long d = power(6,n);

	    // 約分
	    // 6の素因数である2と3で約分を繰り返す
	    while(c%2 == 0 && d%2 == 0){
		c /= 2;
		d /= 2;
	    }
	    while(c%3 == 0 && d%3 == 0){
		c /= 3;
		d /= 3;
	    }
	    if(c/d == 1){
		System.out.println(1);
		continue;
	    }
	    System.out.println(c +"/"+ d);
	}
    }

    public static long power(int x, int n){
	long t = 1;
	for(int i = 0; i < n; i++)
	    t *= x;
	return t;
    }
    
    public static long count(int dice_left, int score_left){
	/*
	if(dice_left * 6 < score_left)
	    return 0;
	*/
	if(score_left < dice_left)
	    return 0;
	else if(score_left == dice_left)
	    return 1;
	
	if(score_left < 1) return 1;
	if(dice_left == 0) return 0;
	
	if(result[dice_left][score_left] != -1)
	    return result[dice_left][score_left];
	
	long sum = 0;

	for(int i = 0; i < 6; i++)
	    sum += count(dice_left-1, score_left-(i+1));

	result[dice_left][score_left] = sum;
	return sum;
    }
}
