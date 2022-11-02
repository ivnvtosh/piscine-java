import java.util.UUID;

public class Transaction {

	private UUID identifier;
	private User recipient;
	private User sender;
	private Category transferCategory;
	private Integer transferAmount;

	public enum Category {
        debits,
        credits
    }

	public Transaction(
	    User recipient,
		User sender,
		Category transferCategory,
		Integer transferAmount
	) {
        this.identifier = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        this.transferCategory = transferCategory;
		this.transferAmount = transferAmount;

		if (sender.getBalance() < 0 || sender.getBalance() < transferAmount)
			System.err.println("Transaction failed!");
		else {
			sender.setBalance(sender.getBalance() - transferAmount);
			recipient.setBalance(recipient.getBalance() + transferAmount);
		}
    }

	public UUID getIdentifier() {
		return this.identifier;
	}

	public User getRecipient() {
		return this.recipient;
	}

	public User getSender() {
		return this.sender;
	}

	public Category getTransferCategory() {
		return this.transferCategory;
	}

	public Integer getTransferAmount() {
		return this.transferAmount;
	}

	public void setIdentifier(UUID identifier) {
		this.identifier = identifier;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public void setTransferCategory(Category transferCategory) {
		this.transferCategory = transferCategory;
	}

	public void setTransferAmount(Integer transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String toString() {
		return "identifier       : " + this.identifier       + "\n" +
			   "----------------"                         + "\n" +
			   "| recipient    |"                         + "\n" +
			   "----------------"                         + "\n" +
			   this.recipient        +
			   "----------------"                         + "\n" +
			   "| sender       |"                         + "\n" +
			   "----------------"                         + "\n" +
			   this.sender           +
			   "----------------"                         + "\n" +
			   "transferCategory : " + this.transferCategory + "\n" +
			   "transferAmount   : " + this.transferAmount   + "\n";
	}

}
