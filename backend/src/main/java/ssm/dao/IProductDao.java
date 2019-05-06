package ssm.dao;
import ssm.entity.Product;

import java.util.List;

public interface IProductDao {
    public Product getProductById(int id);
    public List<Product> getAllProducts();
    public int addProduct(Product product);
    public int updateProduct(Product product);
    public int deleteProduct(Product product);
}
