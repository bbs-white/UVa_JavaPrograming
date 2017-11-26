//Problem_1018 The Stern-Brocot Number
import java.util.*;

class Main{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	while(scan.hasNext()){
	    int m = scan.nextInt();
	    int n = scan.nextInt();
	    // 1が2回入力されたら終了
	    if(m == 1 && n == 1) System.exit(0);

	    String l = "";

	    // 探索対象を分数に変更
	    double target = (double)m/(double)n;

	    // 比較対象の隣接する分数の分子と分母を格納する変数を宣言
	    double key,t1,l1,r1,t2,l2,r2;
	    l1 = 0;
	    r1 = 1;
	    l2 = 1;
	    r2 = 0;
	    t1 = l1 + r1;
	    t2 = l2 + r2;
	    key = 1;

	    // 比較
	    while(true){
		key = t1/t2;
		if(target == key){
		    break;
		}else if(target < key){
		    l = l+"L";
		    r1 = t1;
		    r2 = t2;
		    t1 = l1 + t1;
		    t2 = l2 + t2;
		}else{
		    l = l+"R";
		    l1 = t1;
		    l2 = t2;
		    t1 = r1 + t1;
		    t2 = r2 + t2;
		}
	    }
	    System.out.println(l);
	}
    }	  
}
