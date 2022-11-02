import java.util.UUID;

public class Program {

	public static void main(String[] args) {
		User userOne = new User("UserOne", 50);
		User userTwo = new User("UserTwo", 0);

		System.out.print(userOne);
		System.out.print(userTwo);

		Transaction transaction = new Transaction(
			userTwo,
			userOne,
			Transaction.Category.debits,
			45
		);

		System.out.print(transaction);

		System.out.println("---");

		System.out.print(userOne);
		System.out.print(userTwo);
		
		System.out.println("---");
		System.out.println("---");
		System.out.println("---");

        TransactionsList transactionsList = new TransactionsLinkedList();

		transactionsList.add(transaction);

		System.out.println(transactionsList.toArray()[0]);
		
	}

}
