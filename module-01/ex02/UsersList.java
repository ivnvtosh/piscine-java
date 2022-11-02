public interface UsersList {

	void addUser(User user);
    User getUserByIdentifier(int id) throws UserNotFoundException;
    User getUserByIndex(int index) throws UserNotFoundException;
    int getCount();

}
