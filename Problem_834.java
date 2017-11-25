// Problem_834 Y3k Problem

import java.util.*;

class Main{
    public static void main(String[] args){

	Scanner scan = new Scanner(System.in);
	while(scan.hasNext()){
	    int days1 = scan.nextInt();
	    int days2 = scan.nextInt();
	    int months = scan.nextInt();
	    int years = scan.nextInt();
	    int[] days_tmp = {31,28,31,30,31,30,31,31,30,31,30,31};

	    int count = 0;
	    int m = months;
	    int d = days2 + days1;

	    if(m != 0){
		while(d > days_tmp[m-1]){
		    if(m == 2){
			if(years%4 == 0){
			    if(years%100 == 0 && years%400 != 0) d++;
			    if(d == 29) break;
			    d--;
			}
		    }
		    d = d - days_tmp[m-1];

		    m++;
		    if(m == 13){
			m = 1;
			years++;
		    }
		}
		System.out.println(d +" "+ m +" "+ years);
	    }			
	}
    }
}
