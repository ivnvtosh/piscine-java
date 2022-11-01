import java.util.Scanner;

public class Program {

	public static final Scanner scanner = new Scanner(System.in);

	public static final String END = "42";
	public static final int MAX_CHARACTER = 999;
	public static final int COLUMNS = 10;

    public static void main(String[] args) {

		char[] characters = new char[MAX_CHARACTER];
		int[] numberOfCharacters = new int[MAX_CHARACTER];

		String string = scanner.nextLine();
		scanner.close();

		char[] arrayOfCharacters = string.toCharArray();

		int i = 0;
		int numberOfIndividualCharacters = 0;
		while (i < string.length()) {
			int j = 0;
			while (j < numberOfIndividualCharacters && arrayOfCharacters[i] != characters[j]) {
				j += 1;
			}

			if (j == numberOfIndividualCharacters) {
				numberOfIndividualCharacters += 1;
				characters[j] = arrayOfCharacters[i];
				numberOfCharacters[j] = 0;
			}

			numberOfCharacters[j] += 1;

			i += 1;
		}

		sorted(characters, numberOfCharacters, numberOfIndividualCharacters);
		printTable(characters, numberOfCharacters, numberOfIndividualCharacters);
	}

	public static void sorted(char[] characters, int[] numberOfCharacters, int numberOfIndividualCharacters) {
		char[] newCharacters = new char[COLUMNS];
		int[] newNumberOfCharacters = new int[COLUMNS];

		int columns = numberOfIndividualCharacters < COLUMNS ? numberOfIndividualCharacters : COLUMNS;

		int maxIndex = 0;
		int previous = MAX_CHARACTER;
		char previousCharacter = 0;

		int i = 0;
		while (i < columns) {
			int j = 0;
			int max = 0;
			char prev = 0;
			while (j < numberOfIndividualCharacters) {

				int number = numberOfCharacters[j];
				if (number < previous) {
					if (number > max) {
						maxIndex = j;
						max = numberOfCharacters[maxIndex];
					} else if (number == max) {
						if (characters[j] < characters[maxIndex]) {
							maxIndex = j;
						}
					}
				} else if (number == previous && previousCharacter < characters[j] && prev == 0) {
					prev = characters[j];
					max = number;
					maxIndex = j;
				}

				j += 1;
			}

			previous = numberOfCharacters[maxIndex];
			previousCharacter = characters[maxIndex];
			newCharacters[i] = characters[maxIndex];
			newNumberOfCharacters[i] = numberOfCharacters[maxIndex];
			i += 1;
		}

		i = 0;
		while (i < columns) {
			characters[i] = newCharacters[i];
			numberOfCharacters[i] = newNumberOfCharacters[i];
			i += 1;
		}
	}

	public static void printTable(char[] characters, int[] numberOfCharacters, int numberOfIndividualCharacters) {
		float max = numberOfCharacters[0];
		float single = max / COLUMNS;

		int columns = numberOfIndividualCharacters < COLUMNS ? numberOfIndividualCharacters : COLUMNS;

		int j = COLUMNS;
		while (j > 0) {
			int i = 0;
			while (i < columns) {
				if (numberOfCharacters[i] > single * j) {
					System.out.print("  #");
				} else if (numberOfCharacters[i] > single * (j - 1)) {
					if (numberOfCharacters[i] >= 10) {
						System.out.print(" ");
					} else {
						System.out.print("  ");
					}
					System.out.print(numberOfCharacters[i]);
				}

				i += 1;
			}
			System.out.println();

			j -= 1;
		}

		int i = 0;
		while (i < columns) {
			System.out.print("  " + characters[i]);
			i += 1;
		}
		System.out.println();
    }

}
