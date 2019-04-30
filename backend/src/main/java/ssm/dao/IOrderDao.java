package ssm.dao;
import ssm.entity.Order;

public interface IOrderDao {
    public Order getOrderById(int id);
}
