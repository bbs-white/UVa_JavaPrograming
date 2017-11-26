//Problem_3873 Forwarding Emails
import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args){
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	StringBuilder stringBuilder = new StringBuilder(25000);
	Scanner sc = new Scanner(System.in);
	try{
	    int T = sc.nextInt();
	    for(int t = 1; t <= T; t++){
		int N = sc.nextInt();
		int[] mail = new int[N];
		for(int n = 0; n < N; n++){
		    int sender = sc.nextInt()-1;
		    mail[sender] = sc.nextInt()-1;
		}
		int min = must_send(mail, N);
		min++;
		stringBuilder.append("Case " + t + ": " + min + "\n");

		if(stringBuilder.length() >= 10000){
                    output.write(stringBuilder.toString());
                    stringBuilder = new StringBuilder(25000);
		}
	       
	    }
	    output.write(stringBuilder.toString());
	    output.flush();
	    output.close();
	    
	}catch(IOException e){
	    System.out.println(e);
	}
    }

    public static int must_send(int[] m, int N){
	boolean[] send = new boolean[N];
	for(int i = 0; i < N; i++)
	    send[i] = false;
	int start = -1;
	int count;
	while(start < N){
	    start++;
	    count = 0;
	    int s = start;
	    outer:
	    while(count < N){
		count++;
		send[s] = true;
		int next_send = m[s];
		if(send[next_send]) break outer;
		s = next_send;
	    }
	    boolean f = true;
	    for(int i = 0; i < N; i++){
		if(!send[i]){
		    f = false;
		    break;
		}
	    }
	    if(f)
		return start;
	    
	}
	return -1;
    }
}
