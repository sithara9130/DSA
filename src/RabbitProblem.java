
import java.util.Scanner;

public class RabbitProblem {

    // Calculate rabbit pairs using Fibonacci sequence
    public static int calculateRabbits(int months) {

        if (months <= 0) {
            return 0;
        }

        if (months == 1 || months == 2) {
            return 1;
        }

        int previous = 1;
        int current = 1;

        for (int i = 3; i <= months; i++) {

            int next = previous + current;

            previous = current;
            current = next;
        }

        return current;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of months: ");

        int months = input.nextInt();

        if (months < 1) {
            System.out.println("Please enter a positive number.");
        } else {
            int rabbits = calculateRabbits(months);

            System.out.println(
                    "Number of rabbit pairs after "
                    + months + " months: " + rabbits);
        }

        input.close();
    }
}
