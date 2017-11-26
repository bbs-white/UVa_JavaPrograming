// Problem_979 Jolly Jumpers

import java.util.*;

class Main{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	while(scan.hasNext()){
	    int t = scan.nextInt();

	    int[] A = new int[t];
	    for(int i = 0; i < t; i++)
		A[i] = scan.nextInt();

	    boolean[] s = new boolean[t];
	    for(int i = 0; i < t-1; i++)
		s[i] = false;

	    for(int i = 0; i < t-1; i++){
		int d = direction(A[i],A[i+1]);
		for(int j = 0; j < t-1; j++){
		    if(d == (j+1)) s[j] = true;
		}
	    }

	    boolean jump = true;
	    for(int i = 0; i < t-1; i++){
		if(s[i] == false) jump = false;
	    }
	    if(jump) System.out.println("Jolly");
	    else System.out.println("Not jolly");
	}
    }

    public static int direction(int a, int b){
	if(a > b) return a-b;
	else return b-a; 
    }
}
