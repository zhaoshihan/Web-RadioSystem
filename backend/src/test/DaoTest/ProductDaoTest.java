package DaoTest;

import ssm.dao.IProductDao;
import ssm.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
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

}
