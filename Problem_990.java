//Problem_990 Self-describing Sequence
import java.util.*;

class Main{
    static int N = 1000000;
    static int[] A = new int[N];
    static int max;
    
    public static void main(String[] args){

	// 問題用紙に記載されている値を格納
	A[1] = 1;
	A[2] = 3;
	A[3] = 5;
	A[4] = 8;

	int y = 5;
	int max_index = 8;
	int count = 3;
	int x = 3;
	while(y < N){
	    A[y] += max_index;
	    while(A[x] < y){
		x++;
	    }
	    A[y] += x;
	    max_index = A[y];
	    y++;
	}
	
	Scanner sc = new Scanner(System.in);
        while(true){
	    int n = sc.nextInt();
	    if(n == 0) System.exit(0);

	    int index = 1;
	    while(A[index] < n)
		index++;
	    System.out.println(index);
	}
    }
}
