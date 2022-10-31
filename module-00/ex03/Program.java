import java.util.Scanner;

public class Program {

	public static final Scanner scanner = new Scanner(System.in);

	public static final String END = "42";
	public static final int MAX_GRADE = 9;
	public static final int NUMBER_OF_TESTS_IN_WEEK = 5;

    public static void main(String[] args) {

		long grades = 0;
		int numberOfWeeks = 0;

		String string = scanner.nextLine();
		while (string.equals(END) == false) {
			numberOfWeeks += 1;

			if (string.equals("Week " + numberOfWeeks) == false) {
				System.err.println("IllegalArgument");
				System.exit(-1);
			}

			int grade = getMinGrade();
			grades = grades * 10 + grade;

			string = scanner.nextLine();
		}

		scanner.close();

		int week = 1;
		while (week <= numberOfWeeks) {
			int divider = getDivider(week, numberOfWeeks);
			int grade = (int) (grades / divider % 10);

			System.out.print("Week " + week + " ");

			int i = 0;
			while (i < grade) {
				System.out.print("=");
				i += 1;
			}

			System.out.println(">");

			week += 1;
		}
		
    }

    public static int getMinGrade() {
		int minGrade = MAX_GRADE;

		int i = 0;
		while (i < NUMBER_OF_TESTS_IN_WEEK) {
			int grade = scanner.nextInt();

			if (grade < minGrade) {
				minGrade = grade;
			}

			i += 1;
		}

		scanner.nextLine();
		return minGrade;
	}

    public static int getDivider(int week, int numberOfWeeks) {
		int divider = 1;

		int i = 0;
		while (i < numberOfWeeks - week) {
			divider *= 10;
			i += 1;
		}

		return divider;
	}

}
