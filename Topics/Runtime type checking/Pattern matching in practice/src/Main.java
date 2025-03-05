import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Object msg = scanner.nextLine();    

        // Write your code here
        if(msg instanceof String string){
            String tmp = string;
            if(tmp.length() > 0){
                System.out.println("The variable is not empty, the length is " + tmp.length());
            }
        }


    }
}
