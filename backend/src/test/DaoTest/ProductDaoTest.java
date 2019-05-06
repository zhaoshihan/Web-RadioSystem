package DaoTest;

import ssm.dao.IProductDao;
import ssm.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
@Transactional
public class ProductDaoTest {
    @Autowired
    private IProductDao productDao;

    @Test
    public void testSelect()
    {
        Product product = productDao.getProductById(1);
        assertEquals(product.getName(), "The Foggy Drew");
    }

    @Test
    public void testSelectAll()
    {
        List<Product> products = productDao.getAllProducts();
        for (Product item : products){
            System.out.println(item.getName());
        }
    }

    @Test
    public void testAdd()
    {
        Product product = new Product();
        product.setId(100);
        product.setType("light");
        product.setName("music");
        product.setPrice(500);
        product.setDiscount(300);
        product.setHabitat("China");
        product.setDirector("me");
        product.setSuperStar("me");
        product.setDate(new Date(1970-11-11));
        product.setDescription("hhh");
        productDao.addProduct(product);
        Product newProduct = productDao.getProductById(100);
        assertEquals(newProduct.getDescription(), "hhh");
    }

    @Test
    public void testUpdate()
    {
        Product product = productDao.getProductById(1);
        product.setHabitat("Britain");
        productDao.updateProduct(product);
        Product newProduct = productDao.getProductById(1);
        assertEquals(newProduct.getHabitat(), "Britain");
    }

    @Test
    public void testDelete()
    {
        Product product = productDao.getProductById(1);
        productDao.deleteProduct(product);
    }

}
