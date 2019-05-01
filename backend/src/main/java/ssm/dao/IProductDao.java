package ssm.dao;
import ssm.entity.Product;

import java.util.List;

public interface IProductDao {
    public Product getProductById(int id);
    public List<Product> getAllProducts();
}
