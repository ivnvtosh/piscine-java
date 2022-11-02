import java.util.UUID;

public class Program {

	public static void main(String[] args) {
		User userOne = new User(0, "UserOne", 50);
		User userTwo = new User(1, "UserTwo", 0);

		System.out.print(userOne);
		System.out.print(userTwo);

		Transaction transaction = new Transaction(
			UUID.randomUUID(),
			userTwo,
			userOne,
			Transaction.Category.debits,
			45
		);

		System.out.print(transaction);

		System.out.println("---");

		System.out.print(userOne);
		System.out.print(userTwo);
	}

}
