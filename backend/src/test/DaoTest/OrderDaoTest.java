package DaoTest;
import com.sun.tools.corba.se.idl.constExpr.Or;
import ssm.dao.IOrderDao;
import ssm.entity.Order;
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
public class OrderDaoTest {
    @Autowired
    private IOrderDao orderDao;

    @Test
    public void testSelect(){
        Order order = orderDao.getOrderById(1);
        assertEquals(order.getMemberID(), 1);
    }

    @Test
    public void testSelectAll(){
        List<Order> orders = orderDao.getAllOrders();
        for(Order item : orders){
            System.out.println(item.getSendAddress());
        }
    }

    @Test
    public void testAdd()
    {
        Order order = new Order();
        order.setId(100);
        order.setProductID(1);
        order.setMemberID(1);
        order.setOrderDate(new Date(1970-11-11));
        order.setUnitPrice(100);
        order.setAmount(1);
        order.setSendDate(new Date(2000-10-10));
        order.setSendAddress("Wuhan");
        orderDao.addOrder(order);
        Order newOrder = orderDao.getOrderById(100);
        assertEquals(newOrder.getSendAddress(), "Wuhan");
    }

}
