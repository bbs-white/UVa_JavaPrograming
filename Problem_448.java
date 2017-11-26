//Problem_448 Jill Rides Again
import java.util.*;

class Main{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	int B = scan.nextInt();
	for(int r = 1; r <= B; r++){
	    int S = scan.nextInt();
	    if(S<2 || S>20000){
		System.out.println("Route "+ r +" has no nice parts");
		continue;
	    }
	    int nice_sum = 0;
	    int i = 1;
	    int start = i;
	    int goal = start+1;
	    int max = 0;
	    for(int s = 2; s <= S; s++){
		nice_sum += scan.nextInt();
		int d = goal-start;
		int f = s-i;
		if(nice_sum > max || (nice_sum == max && d < f)){
		    max = nice_sum;
		    start = i;
		    goal = s;
		}
		if(nice_sum < 0){
		    i = s;
		    nice_sum = 0;
		}
	    }

	    if(max > 0){
		System.out.println("The nicest part of route "+ r +" is between stops "+ start +" and "+ goal);
	    }else{
		System.out.println("Route "+ r +" has no nice parts");
	    }
	}
    }
}
