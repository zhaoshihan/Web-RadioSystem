package ssm.service;
import com.sun.tools.corba.se.idl.constExpr.Or;
import ssm.entity.Order;

import java.util.List;

public interface IOrderService {
    public Order getOrderById(int id);
    public List<Order> getAllOrders();
    public List<Order> getOrderByMemberId(int memberId);
    public boolean addOrder(Order order);
    public boolean updateOrder(Order order);
    public boolean deleteOrder(Order order);
}
