package ssm.service;
import org.springframework.stereotype.Service;
import ssm.entity.Product;
import ssm.dao.IProductDao;

import javax.annotation.Resource;

@Service("ProductService")
public class ProductService implements IProductService{
    @Resource
    private IProductDao productDao;

    public Product getProductById(int id){
        return productDao.getProductById(id);
    }
}
