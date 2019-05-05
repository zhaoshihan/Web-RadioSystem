package ssm.service;
import ssm.entity.Order;

import java.util.List;

public interface IOrderService {

    public Order getOrderById(int id);
    public List<Order> getAllOrders();
    public boolean addOrder(Order order);
    public List<Order> getOrderByMemberId(int memberId);
}
