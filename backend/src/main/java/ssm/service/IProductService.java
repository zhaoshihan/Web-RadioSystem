package ssm.service;
import ssm.entity.Product;

import java.util.List;

public interface IProductService {
    public Product getProductById(int id);
    public List<Product> getAllProducts();
    public boolean addProduct(Product product);
    public boolean updateProduct(Product product);
    public boolean deleteProduct(Product product);
}
