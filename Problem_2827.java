// Problem_2827 Cost Cutting

import java.io.*;

class Main{
    
    static int num_emp = 3;
    static int min = 1000;
    static int max = 10000;


    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            
            // Caseの数を決定
            String line = reader.readLine();
            int t = Integer.parseInt(line);
            int[][] table = new int[t][num_emp];
            String[] l = new String[t];
            String[][] l2 = new String[t][3];

            // Caseの数だけ入力
            for(int i = 0; i < t; i++){
                l[i] = reader.readLine();

                // 入力されたものを数値に変換して格納
                l2[i] = l[i].split(" ",0);
                for(int j = 0; j < num_emp; j++){
                    table[i][j] = Integer.parseInt(l2[i][j]);
                }
            }

            // 格納された数値が適切かどうかを調査
            for(int a = 0; a < t; a++){
                for(int b = 0; b < num_emp; b++){
                    if(table[a][b] < 1000 || table[a][b] > 10000) System.exit(1);
                }
            }

            // 格納された数値に同じCase中に同じ数字があるかどうかを調査
            for(int a = 0; a < t; a++){
                if(table[a][0] == table[a][1] || table[a][0] == table[a][2] || table[a][1] == table[a][2]) System.exit(1);
            }

            // table内をソート
            for(int x = 0; x < t; x++){
                int tmp;
                for(int i = 1; i < num_emp; i++){
                    tmp = table[x][i];
                    int j = i-1;
                    while(j >= 0 && tmp < table[x][j]){
                        table[x][j+1] = table[x][j];
                        j--;
                    }
                    table[x][j+1] = tmp;
                }
            }

            // 中央の値を表示
            for(int i = 0; i < t; i++){
                System.out.println("Case "+ (i+1) +": "+ table[i][1]);
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static void swap(int a, int b){
        int tmp = a;
        a = b;
        b = tmp;
    }
}
