package ssm.dao;
import com.sun.tools.corba.se.idl.constExpr.Or;
import ssm.entity.Order;

import java.util.List;

public interface IOrderDao {
    public Order getOrderById(int id);
    public List<Order> getAllOrders();
    public List<Order> getOrderByMemberId(int memberId);
    public int addOrder(Order order);
    public int updateOrder(Order order);
    public int deleteOrder(Order order);
}
