package test;

import com.sun.javafx.scene.traversal.Direction;
import java.util.Scanner;

/**
 * @author Isen
 * @date 2019/3/6 21:42
 * @since 1.0
 */
public class P2 {
    public static void find(char[][] array, char[] str){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                if(array[i][j] == str[0]){
                    find(array, i, j, str, 0, 0);
                }
            }
        }
    }

    public static void find(char[][] array, int x, int y, char[] str, int k, int direction){
        if(k == str.length - 1){
            System.out.println("Find");
            return;
        }

        if(direction > 3){
            return;
        }

        if(array[x][y] != str[k]){

        }

        switch (direction){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        char[][] array = new char[n][m];

        for(int i = 0; i < n; i++){
            String tmp = in.nextLine();
            for(int j = 0; j < m; j++){
                array[i][j] = tmp.charAt(j);
            }
        }

        int q = in.nextInt();
        for(int i = 0; i < q; i++){
            String tmp = in.nextLine();
            find(array, tmp.toCharArray());
        }
    }
}
