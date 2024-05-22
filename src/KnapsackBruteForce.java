import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KnapsackBruteForce {

    private int capacity;

    private int quantity;

    private Item[] items;
    private void getDataSet(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String line = bufferedReader.readLine();
        String[] parts = line.split(" ");
        capacity = Integer.parseInt(parts[0]);
        quantity = Integer.parseInt(parts[1]);

        items = new Item[quantity];

        line = bufferedReader.readLine();
        String[] valueStr = line.split(",");
        int[] values = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            values[i] = Integer.parseInt(valueStr[i]);
        }

        line = bufferedReader.readLine();
        String[] weightStr = line.split(",");
        int[] weights = new int[quantity];
        for (int i = 0; i < quantity; i++) {
            weights[i] = Integer.parseInt(weightStr[i]);
        }

        for (int i = 0; i < quantity; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        bufferedReader.close();
    }


    public int[] calculateCombination() throws IOException {
        int maxValue = 0;
        int [] combination = new int[items.length];
        int totalCombinations = (int) Math.pow(2, quantity);

        for (int i = 0; i < totalCombinations ; i++) {
            int currentWeight = 0;
            int currentValue = 0;
            int[] currentCombination = new int[quantity];

            for (int j = 0; j < quantity; j++) {
                if ((i & (1 << j)) != 0) {
                    currentCombination[j] = 1;
                    currentWeight += items[j].getWeight();
                    currentValue += items[j].getValue();
                }
            }

            if (currentWeight <= capacity && currentValue > maxValue) {
                maxValue = currentValue;
                combination = currentCombination.clone();
            }

            if (i % 100000 == 0) {
                System.out.println("-Iteration: " + i + ", Best value: " + maxValue);
                System.out.print("-The best vector found: ");
                for (int element : combination){
                    System.out.print(element);
                }
                System.out.println();
            }

        }
        System.out.println("Best value: " + maxValue);
        return combination;

    }

    public void findCombination() throws IOException {
        getDataSet("plecak.txt");
        int[] bestCombination = calculateCombination();
        System.out.print("Best combination: ");
        for (int tmp : bestCombination) {
            System.out.print(tmp);
        }
        System.out.println();
    }












}
