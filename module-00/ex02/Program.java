import java.util.Scanner;

public class Program {

	public static final int END = 42;

    public static void main(String[] args) {
		int countOfCoffeeRequest = 0;

		Scanner scanner = new Scanner(System.in);
		int sequenceOfNumbers = scanner.nextInt();
		while (sequenceOfNumbers != END) {
			int number = getSum(sequenceOfNumbers);
			if (isPrime(number) == true) {
				countOfCoffeeRequest += 1;
			}
			sequenceOfNumbers = scanner.nextInt();
		}

		scanner.close();

		String description = "Count of coffee-request - " + countOfCoffeeRequest;
		System.out.println(description);
    }

	public static int getSum(int sequenceOfNumbers) {
		int result = 0;

        while (sequenceOfNumbers != 0) {
			result += sequenceOfNumbers % 10;
			sequenceOfNumbers /= 10;
        }

		return result;
	}

	public static boolean isPrime(int number) {
		int i = 2;

		while (i * i < number) {
			if (number % i == 0) {
				return false;
			}

			i += 1;
		}

		return true;
    }

}
