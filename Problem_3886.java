//Problem_3886 Bars
import java.util.*;

class Main{
    static boolean s = false;
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);

	// Caseを入力
	int T = scan.nextInt();
	for(int t = 0; t < T; t++){
	    int N = scan.nextInt();
	    int P = scan.nextInt();
	    int[] x = new int[P];
	    for(int i = 0; i < P; i++)
		x[i] = scan.nextInt();

	    bubble_sort(x);
	    s = false;
	    dfs(x,0,0,N);			
            if(s) System.out.println("YES");
            else System.out.println("NO");
	}
    }

    public static void swap(int[] A, int i, int j){
	int tmp = A[i];
	A[i] = A[j];
	A[j] = tmp;
    }
    public static void bubble_sort(int[] A){
	int n = A.length;
	for(int i = 0; i < n; i++){
	    for(int j = n-1; j > i; j--){
		if(A[j-1] > A[j]) swap(A,j,j-1);
	    }
	}
    }
    public static void dfs(int[] A, int ci, int cl, int N){
	if(cl == N){
	    s = true;
	}else if(!s){
	    for(int i = ci; i < A.length; i++){
		if(cl + A[i] <= N){
		    dfs(A, i+1, cl+A[i], N);
		}
	    }
	}
    }
}
