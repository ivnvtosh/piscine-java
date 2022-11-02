import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private Node first = null;
    private Node last = null;
    private int size = 0;

    private static class Node {
        Transaction transaction;
        Node previous;
        Node next;

        Node(Transaction transaction, Node previous, Node next) {
            this.transaction = transaction;
            this.previous = previous;
            this.next = next;
        }
    }

    public void add(Transaction transaction) {
        Node newNode = new Node(transaction, last, null);
        
        if (this.first == null) {
            this.first = newNode;

        } else if (this.last == null) {
            this.first.next = newNode;
            this.last = newNode;

        } else {
            this.last.next = newNode;
            this.last = newNode;
        }

        size += 1;
    }

    public void remove(UUID uuid) throws TransactionNotFoundException {

        Node node = first;
        int i = 0;
        while (i < size) {
            if (uuid.equals(node.transaction.getIdentifier()) == true) {
                Node previous = node.previous;
                Node next = node.next;
        
                if (previous == null) {
                    this.first = next;
                } else {
                    previous.next = next;
                    node.previous = null;
                }

                if (next == null) {
                    this.last = previous;
                } else {
                    next.previous = previous;
                    node.next = null;
                }

                size -= 1;
                return;
            }
    
            i += 1;
        }

        throw new TransactionNotFoundException();
    }

    public Transaction[] toArray() {
        if (this.size == 0) {
            return null;
        }

        Transaction[] result = new Transaction[this.size];

        Node node = first;
        int i = 0;
        while (i < this.size) {
            result[i] = node.transaction;
            node = node.next;
            i += 1;
        }

        return result;
    }

}
