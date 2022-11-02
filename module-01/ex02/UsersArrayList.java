public class UsersArrayList implements UsersList {

    private int currentSize = 10;
    private Integer numberOfUsers = 0;
    private User[] users = new User[currentSize];
	
    public void addUser(User user) {
        if (this.numberOfUsers != this.currentSize) {
			this.users[numberOfUsers] = user;
			this.numberOfUsers += 1;
			return;
        }

		User[] newUsers = new User[this.currentSize * 2];

		int i = 0;
		while (i < this.numberOfUsers) {
			newUsers[i] = this.users[i];
			i += 1;
		}

		this.currentSize *= 2;
		this.users = newUsers;
		this.users[numberOfUsers] = user;
		numberOfUsers += 1;
    }

    public User getUserByIdentifier(int id) throws UserNotFoundException {
		int i = 0;
		while (i < numberOfUsers) {
			if (this.users[i].getIdentifier().equals(id)) {
				return this.users[i];
			}

			i += 1;
		}

        throw new UserNotFoundException();
    }

    public User getUserByIndex(int index) throws UserNotFoundException {
        if (index < 0 || index >= this.numberOfUsers) {
            throw new UserNotFoundException();
        }

        return this.users[index];
    }

    public int getCount() {
        return this.numberOfUsers;
    }

}
