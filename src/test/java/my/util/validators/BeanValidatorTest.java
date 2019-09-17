package my.util.validators;

import my.util.validators.bean.Item;
import my.util.validators.bean.Request;
import my.util.validators.bean.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eric on 5/27/19.
 */
public class BeanValidatorTest {

    private BeanValidator validator;
    private Transaction good;
    private Transaction bad;
    private Item badItem;
    private Item goodItem;
    private Request goodRequest;
    private Request badRequest;

    @Before
    public void init(){
        validator = new BeanValidator();

        good = new Transaction();
        good.setTransId("456");
        good.setAgentAssociateId("abc");
        bad = new Transaction();
        bad.setAgentAssociateId("no transId");

        List<Item> goodItems = new ArrayList<>(2);
        badItem = new Item();
        badItem.setActionFlag("BB");
        badItem.setFirstName("");
        badItem.setLastName("Fang");

        goodItem = new Item();
        goodItem.setActionFlag("A");
        goodItem.setFirstName("Eric");
        goodItem.setLastName("Fang");

        goodItems.add(goodItem);
        goodItems.add(goodItem);

        List<Item> unknowItems = new ArrayList<>(2);
        unknowItems.add(badItem);
        unknowItems.add(goodItem);

        goodRequest = new Request();
        goodRequest.setTransaction(good);
        goodRequest.setItems(goodItems);
        badRequest = new Request();
        badRequest.setTransaction(bad);
        badRequest.setItems(unknowItems);

    }

    @Test
    public void testValidate(){
        BeanValidatedResult result = validator.validate(goodRequest);
        Assert.assertTrue(result.isPassed());

        result = validator.validate(badRequest);
        Assert.assertTrue(result.isPassed());

        result = validator.validate(bad);
        Assert.assertTrue(result.getMessages().size() > 0);

        result = validator.validate(badItem);
        Assert.assertTrue(result.getMessages().size() > 0);

        result = validator.validate(good);
        Assert.assertTrue(result.getMessages().size() == 0);

        result = validator.validate(goodItem);
        Assert.assertTrue(result.getMessages().size() == 0);



    }


}
