import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        KnapsackBruteForce knapsackBruteForce = new KnapsackBruteForce();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Execute the BruteForce algorithm: [y/n]");
            String ans = bufferedReader.readLine().toLowerCase();
            switch (ans){
                case "y":
                    knapsackBruteForce.findCombination();
                case "n":
                    System.exit(0);
                default:
                    System.out.println("Something went wrong... ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}