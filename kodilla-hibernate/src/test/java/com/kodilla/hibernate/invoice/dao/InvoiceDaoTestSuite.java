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
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ProductDao productDao;

    @Test
    public void testInvoiceDaoSave() {

        Invoice invoice = new Invoice("001/07/2019");

        Product product1 = new Product("gwoŸdzie");
        Product product2 = new Product("œruby");
        Product product3 = new Product("nakrêtki");

        productDao.save(product1);
        productDao.save(product2);
        productDao.save(product3);

        Item itemProduct1 = new Item(product1, new BigDecimal(2), 20);
        Item itemProduct2 = new Item(product2, new BigDecimal(4), 91);
        Item itemProduct3 = new Item(product3, new BigDecimal(5), 41);

        itemProduct1.setInvoice(invoice);
        itemProduct2.setInvoice(invoice);
        itemProduct3.setInvoice(invoice);

        List<Item> items = new ArrayList<>();
        items.add(itemProduct1);
        items.add(itemProduct2);
        items.add(itemProduct3);

        invoice.setItems(items);

        invoiceDao.save(invoice);
        long invoiceId = invoice.getId();
        long itemSize = invoice.getItems().size();

        Invoice invoiceReadDB = invoiceDao.findById(invoiceId);

        Assert.assertEquals(invoiceId, invoiceReadDB.getId());
        Assert.assertEquals(3, itemSize);
        Assert.assertEquals(itemSize, invoiceReadDB.getItems().size());

        invoiceDao.delete(invoice);
    }
}
