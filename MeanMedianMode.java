//PINKACHU
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MeanMedianMode {

    public static void main(String[] args) {
        int[][] lists = {
            {4, 9, 1, 0, 4},
            {1, 7, 3, 9, 1, 2, 7},
            {9, 2, 2, 4, 6, 6, 8, 8},
            {3, 3, 2, 2, 1, 1, 6, 6},
            {3, 3, 3, 3, 3, 3},
            {1, 8, 0, 7, 1, 2, 11},
            {2, 5, 1, 5, 7, 2, 1, 3}
        };

        for (int[] list : lists) {
            calculateStatistics(list);
        }
    }

    public static void calculateStatistics(int[] numbers) {
        Arrays.sort(numbers);
        
        double mean = calculateMean(numbers);
        
        double median = calculateMedian(numbers);
        
        String mode = calculateMode(numbers);
        
        int range = calculateRange(numbers);
        
        System.out.printf("List: %s\n", Arrays.toString(numbers));
        System.out.printf("Mean: %.1f, Median: %.1f, Mode: %s, Range: %d\n\n",
                mean, median, mode, range);
    }

    private static double calculateMean(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.length;
    }

    private static double calculateMedian(int[] numbers) {
        int length = numbers.length;
        if (length % 2 == 0) {
            return (numbers[length / 2 - 1] + numbers[length / 2]) / 2.0;
        } else {
            return numbers[length / 2];
        }
    }

    private static String calculateMode(int[] numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        int maxFrequency = 0;
        StringBuilder modes = new StringBuilder();
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                modes.setLength(0);
                modes.append(entry.getKey());
            } else if (entry.getValue() == maxFrequency) {
                modes.append(", ").append(entry.getKey());
            }
        }

        return modes.toString();
    }

    private static int calculateRange(int[] numbers) {
        return numbers[numbers.length - 1] - numbers[0];
    }
}
