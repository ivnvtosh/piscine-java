public class User {

	private Integer identifier;
	private String name;
	private Integer balance;

	public User(String name, Integer balance) {
        this.identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;
		this.balance = balance > 0 ? balance : 0;
    }

	public Integer getIdentifier() {
		return this.identifier;
	}

	public String getName() {
		return this.name;
	}

	public Integer getBalance() {
		return this.balance;
	}

    public void setBalance(Integer balance) {
		this.balance = balance > 0 ? balance : 0;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String toString() {
		return "identifier : " + this.identifier + "\n" +
			   "name       : " + this.name       + "\n" +
			   "balance    : " + this.balance    + "\n";
	}

}
