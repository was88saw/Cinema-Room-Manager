import java.util.Scanner;

public class Main{

    public static void printPattern(int n) {
        // You should declare a two-dimensional array here.
        char[][] result= new char[n][n];

        // You should write a nested for loop to iterate over element in the array.
        // In the for loop you can identify the positions that should hold '#' and ' '.
        for (int i = 0; i < result.length; i ++){
            for (int j = 0; j < result[i].length; j++) {
                if( i == j || i + j == n - 1){
                    result[i][j] = '#';
                }else result[i][j] = ' ';
            }
        }

        // You should print out the elements of each row of the array. Use 'System.out.print' 
        // to avoid automatic newline after every element and 'System.out.println' 
        // at the end of every row to print a newline.
        for (int i = 0; i < result.length; i ++){
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }System.out.println();
        }

    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        printPattern(n);
    }
}