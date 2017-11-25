// Problem_36 The 3n+1 problem

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
	while(scan.hasNext()){

	    int max_count;
	    int count;
	    int min = 1;
	    int max = 9999;
	    // 最大計算回数をリセット
	    max_count = 0;
	    
	    int l = scan.nextInt();
	    int r = scan.nextInt();

	    // 計算する最初と最後の整数を格納する変数を宣言
	    // 同時に2個の整数の大小を整理
	    int min_num = Math.min(l,r);
	    int max_num = Math.max(l,r);
            if(min_num > 0 && max_num > 0){
		for(int i = min_num; i <= max_num; i++){
		    int key = i;
		    count = 1;
		    while(key != 1) {
			key = func(key);
			count++;
		    }
		    if(count > max_count) max_count = count;
		}
	    
		// 結果を出力
		System.out.println(l +" "+ r +" "+ max_count);
	    }
	}
    }
    
    public static int func(int n){
        if(n%2 == 0) return n/2;
        else return 3*n + 1;
    }
}
