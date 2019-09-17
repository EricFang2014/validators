package my.util.validators.bean;

import java.util.List;

/**
 * Created by eric on 5/27/19.
 */
public class Request {
    private Transaction transaction;
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
