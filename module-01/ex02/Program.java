public class Program {

	public static void main(String[] args) {
		User userOne = new User("UserOne", 50);
		User userTwo = new User("UserTwo", 0);

		UsersList userList = new UsersArrayList();

		userList.addUser(userOne);

		try {
			User user = userList.getUserByIndex(0);
			System.out.print(user);
		}
		catch(UserNotFoundException exception) {
			System.out.println("User not found!");
		}

		try {
			User user = userList.getUserByIndex(1);
			System.out.print(user);
		}
		catch(UserNotFoundException exception) {
			System.out.println("User not found!");
		}

		userList.addUser(userTwo);

		try {
			User user = userList.getUserByIndex(0);
			System.out.print(user);
		}
		catch(UserNotFoundException exception) {
			System.out.println("User not found!");
		}

		try {
			User user = userList.getUserByIndex(1);
			System.out.print(user);
		}
		catch(UserNotFoundException exception) {
			System.out.println("User not found!");
		}

		try {
			User user = userList.getUserByIndex(2);
			System.out.print(user);
		}
		catch(UserNotFoundException exception) {
			System.out.println("User not found!");
		}
	}

}
