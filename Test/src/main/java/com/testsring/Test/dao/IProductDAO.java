package com.testsring.Test.dao;

import com.testsring.Test.model.Product;

import java.util.List;


public interface IProductDAO {
    //findAll : renvoie la liste complète de tous les produits ;
    //findById : renvoie un produit par son Id ;
    //save : ajoute un produit.
    List<Product> findAll();
    Product findby(int id);

    Product findById(int id);

    Product save(Product product);
}
