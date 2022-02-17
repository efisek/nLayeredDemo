package com.nLayeredDemo.business.concretes;

import com.nLayeredDemo.business.abstracts.ProductService;
import com.nLayeredDemo.core.LoggerService;
import com.nLayeredDemo.dataAccess.abstracts.ProductDao;
import com.nLayeredDemo.dataAccess.concretes.HibernateProductDao;
import com.nLayeredDemo.entities.concretes.Product;


import java.util.List;

public class ProductManager implements ProductService {

    private ProductDao productDao;//dependency Injection
    private LoggerService loggerService;


    public ProductManager(ProductDao productDao,LoggerService loggerService) {
        this.productDao = productDao;
        this.loggerService=loggerService;
    }

    @Override
    public void add(Product product) {
        if(product.getCategoryId()==1){
            System.out.println("Product is not accepted in this category");
            return;
        }

        /*HibernateProductDao dao=new HibernateProductDao();
        dao.add(product);*/
        //bu sekilde yaparsak sistem bagimli olur
        // Dependency Injection yapmamiz gerek

        this.productDao.add(product); //hibernate ile bagimlilik yok
        this.loggerService.logToSystem(product.getName() + " logged");


    }


    @Override
    public List<Product> getAll() {
        return null;
    }
}
