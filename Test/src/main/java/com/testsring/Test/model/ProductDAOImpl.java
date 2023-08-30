package com.testsring.Test.model;

import com.testsring.Test.dao.IProductDAO;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
@Repository
// cette annotation est appliquée à la classe afin d'indiquer à Spring qu'il s'agit d'une classe qui gère les données,
// ce qui nous permettra de profiter de certaines fonctionnalités, comme les translations des erreurs.
public class ProductDAOImpl implements IProductDAO {
    public static List<Product> products = new ArrayList<>();

    static {
        try {
            products.add(new Product(1,"PC Hp",600,extractDate("20/08/1995") ,"FMGTS458"));
            products.add(new Product(2,"PC Dell",450,extractDate("20/08/1996"),"F59TS458"));
            products.add(new Product(3,"Apple Pc",950,extractDate("20/08/1997"),"FMGTS458"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date extractDate(String date) throws ParseException {
        SimpleDateFormat dateConvertor = new SimpleDateFormat("dd/MM/yyyy");
        return dateConvertor.parse(date);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findby(int id) {
        return null;
    }

    @Override
    public Product findById(int id) {
        for (Product product: products){
            if (product.getId(id) == id){
                return product;
            }
        }
        return null;
    }

    @Override
    //est utilisé pour définir une méthode qui est héritée de la classe parente. On ne l'utilise donc que dans le cas de l'héritage
    public Product save(Product product) {
        products.add(product);
        return product;
    }
    public Product editProduct(Product product, int id){
        Product productToUpdate = product.findById(id);
        if (productToUpdate != null){
            productToUpdate.setName(product.getName());
            productToUpdate.setReleaseDate(product.getReleaseDate());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setSerieNumber(product.getSerieNumber());
        }
        return product;
    }

    public Product delete(int id){
        return products.remove(id);



    }
}
