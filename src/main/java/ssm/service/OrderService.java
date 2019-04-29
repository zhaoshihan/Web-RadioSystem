package ssm.service;
import org.springframework.stereotype.Service;
import ssm.entity.Order;
import ssm.dao.IOrderDao;

import javax.annotation.Resource;

@Service("OrderService")
public class OrderService implements IOrderService{
    @Resource
    private IOrderDao orderDao;

    public Order getOrderById(int id){
        return orderDao.getOrderById(id);
    }
}
