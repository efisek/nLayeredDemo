package com.nLayeredDemo;

import com.nLayeredDemo.business.abstracts.ProductService;
import com.nLayeredDemo.business.concretes.ProductManager;
import com.nLayeredDemo.core.JLoggerManagerAdapter;
import com.nLayeredDemo.dataAccess.concretes.AbcProductDao;
import com.nLayeredDemo.dataAccess.concretes.HibernateProductDao;
import com.nLayeredDemo.entities.concretes.Product;
import com.nLayeredDemo.jLogger.JLoggerManager;

public class Main {

    public static void main(String[] args) {

        //ToDo: Spring IoC ile cozulecek
        ProductService productService=new ProductManager(new AbcProductDao(), new JLoggerManagerAdapter());

        Product product = new Product(1,2,"Headphone",12,50);
        productService.add(product);



    }
}
