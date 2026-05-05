import java.util.*;

public class Main2 {

    public static long minOperations(int[] arr, int k) {
        int n = arr.length;

        // Step 1: Check if transformation is possible
        int remainder = arr[0] % k;
        for (int num : arr) {
            if (num % k != remainder) {
                return -1;
            }
        }

        // Step 2: Sort array
        Arrays.sort(arr);

        // Step 3: Choose median
        int median = arr[n / 2];

        // Step 4: Calculate operations
        long operations = 0;
        for (int num : arr) {
            operations += Math.abs(num - median) / k;
        }

        return operations;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Safe input handling
        if (!sc.hasNextInt()) {
            System.out.println("Please enter valid input.");
            return;
        }

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(minOperations(arr, k));
    }
}
