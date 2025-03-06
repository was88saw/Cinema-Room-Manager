import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private int numArray[] = new int[6];
    private ArrayList<Integer> numList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));

    public void fillArray() {
        for (int i = 0; i < 6; i++) {
            numArray[i] = i;
        }
    }

    public void manageList() {
        int total = numList.stream().reduce(1, (a, b) -> a / b);
    }

    public static void main(String args[]) {
        Main example = new Main();
        example.fillArray();
        example.manageList();
    }
}