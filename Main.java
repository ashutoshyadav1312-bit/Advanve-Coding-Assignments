import java.util.*;

public class Main{

    public static int maxCyclicSubstringSum(String s) {
        int n = s.length();
        String doubled = s + s;

        int maxSum = 0;
        int left = 0, sum = 0;

        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < doubled.length(); right++) {
            char c = doubled.charAt(right);

            // Maintain unique characters and window size <= n
            while (set.contains(c) || (right - left + 1) > n) {
                char remove = doubled.charAt(left);
                set.remove(remove);
                sum -= (remove - 'a' + 1);
                left++;
            }

            set.add(c);
            sum += (c - 'a' + 1);

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Safe input handling
        if (!sc.hasNext()) {
            System.out.println("Please enter a string input.");
            return;
        }

        String s = sc.next(); // works better than nextLine in VS Code
        System.out.println(maxCyclicSubstringSum(s));
    }
}
