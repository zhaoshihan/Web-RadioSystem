package ssm.service;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.stereotype.Service;
import ssm.entity.Order;
import ssm.dao.IOrderDao;

import javax.annotation.Resource;
import java.util.List;

@Service("OrderService")
public class OrderService implements IOrderService{
    @Resource
    private IOrderDao orderDao;

    @Override
    public Order getOrderById(int id){
        return orderDao.getOrderById(id);
    }

    @Override
    public List<Order> getAllOrders(){
        return orderDao.getAllOrders();
    }

    @Override
    public List<Order> getOrderByMemberId(int memberId){
        return orderDao.getOrderByMemberId(memberId);
    }

    @Override
    public boolean addOrder(Order order){
        return orderDao.addOrder(order) > 0;
    }

    @Override
    public boolean updateOrder(Order order){
        return orderDao.updateOrder(order) > 0;
    }

    @Override
    public boolean deleteOrder(Order order){
        return orderDao.deleteOrder(order) > 0;
    }
}
