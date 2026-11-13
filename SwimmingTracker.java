import java.util.Scanner;

public class SwimmingTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] times = new double[12];
        double sum = 0;

        // Input with validation (positive numbers only)
        for (int i = 0; i < times.length; i++) {
            double value;
            while (true) {
                System.out.print("Enter time in seconds for swimmer " + i + ": ");
                if (sc.hasNextDouble()) {
                    value = sc.nextDouble();
                    if (value > 0) {
                        break;
                    }
                    System.out.println("Time must be greater than 0. Try again.");
                } else {
                    System.out.println("Invalid input. Enter a number.");
                    sc.next(); // discard bad input
                }
            }
            times[i] = value;
            sum += value;
        }

        // Average
        double average = sum / times.length;

        // Fastest swimmer (smallest time)
        int fastest = 0;
        for (int i = 1; i < times.length; i++) {
            if (times[i] < times[fastest]) {
                fastest = i;
            }
        }

        // Count swimmers with 60 seconds or less
        int count = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i] <= 60) {
                count++;
            }
        }

        // Copy the array, then bubble sort the copy (ascending)
        double[] sorted = new double[times.length];
        for (int i = 0; i < times.length; i++) {
            sorted[i] = times[i];
        }
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted.length - 1 - i; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    double temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }

        // Output
        System.out.println();
        System.out.println("===== RESULTS =====");
        System.out.printf("Average time: %.2f seconds%n", average);
        System.out.printf("Fastest swimmer: Swimmer %d (%.2f seconds)%n", fastest, times[fastest]);
        System.out.println("Swimmers with 60 seconds or less: " + count);

        System.out.println("\nTimes in ascending order:");
        for (int i = 0; i < sorted.length; i++) {
            System.out.printf("Index %d: %.2f seconds%n", i, sorted[i]);
        }

        sc.close();
    }
}
