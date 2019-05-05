package ssm.dao;
import com.sun.tools.corba.se.idl.constExpr.Or;
import ssm.entity.Order;

import java.util.List;

public interface IOrderDao {
    public Order getOrderById(int id);
    public List<Order> getAllOrders();
    public int addOrder(Order order);
    public List<Order> getOrderByMemberId(int memberId);
}
