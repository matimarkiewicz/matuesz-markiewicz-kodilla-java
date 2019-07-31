package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {

        Invoice invoice = new Invoice("001/07/2019");

        Product position1 = new Product("gwoŸdzie");
        Product position2 = new Product("œruby");
        Product position3 = new Product("nakrêtki");

        Item itemPosition1 = new Item(position1, new BigDecimal(2), 20);
        Item itemPosition2 = new Item(position2, new BigDecimal(4), 91);
        Item itemPosition3 = new Item(position3, new BigDecimal(5), 41);

        itemPosition1.setInvoice(invoice);
        itemPosition2.setInvoice(invoice);
        itemPosition3.setInvoice(invoice);

        List<Item> items = new ArrayList<>();
        items.add(itemPosition1);
        items.add(itemPosition2);
        items.add(itemPosition3);

        invoice.setItems(items);

        invoiceDao.save(invoice);
        long invoiceId = invoice.getId();
        long itemSize = invoice.getItems().size();

        Invoice invoiceReadDB = invoiceDao.findById(invoiceId);

        Assert.assertEquals(invoiceId, invoiceReadDB.getId());
        Assert.assertNotEquals(3, itemSize);
        Assert.assertEquals(itemSize, invoiceReadDB.getItems().size());

        invoiceDao.delete(invoice);
    }
}
