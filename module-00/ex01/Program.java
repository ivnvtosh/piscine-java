import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		scanner.close();

		if (number <= 1) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }

		boolean isPrime = true;
		int i = 2;
		while (i * i < number) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}

			i += 1;
		}

		int numberOfIterations = i - 1;
		String description = isPrime + " " + numberOfIterations;
		System.out.println(description);
    }

}
