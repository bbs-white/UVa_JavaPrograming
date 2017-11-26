//Problem_2621 Simple Equation
import java.util.*;

class Main{
    public static void main(String[] args){
	Scanner scan =  new Scanner(System.in);

	// 方程式の数を入力
	int N = scan.nextInt();
	boolean exist;

	for(int n = 0; n < N; n++){
	    exist = false;

	    // 各定数を入力
	    int A = scan.nextInt();
	    int B = scan.nextInt();
	    int C = scan.nextInt();
	    // 1 ≦ C ≦ 10000 && C ≧ 0であるからCの平方根によって探索範囲を決定
	    int rx = root(C);
	    for(int x = -rx; x <= rx; x++){
		for(int y = x; y <= (A-x); y++){
		    int z = A-x-y;
		    if(z >= y){
			int b = x*y*z;
			int c = x*x + y*y + z*z;
			if(b == B && c == C && exist == false){
			    if(x < y && y < z){
				System.out.println(x +" "+ y +" "+ z);
				exist = true;
				break;
			    }
			}
		    }
		    if(exist) break;
		}
	    }
	    if(exist == false) System.out.println("No solution.");
	}
    }

    public static int root(int C){
	int r = 1;
	while(true){
	    int r2 = r*r;
	    if(r2 <= C){
		r++;
	    }else{
		return (r-1);
	    }	
	}
    }
}
