package com.testsring.Test.web.controller;


import com.testsring.Test.exceptions.LicenseDrivingException;
import com.testsring.Test.model.Product;
import com.testsring.Test.model.ProductDAOImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
//il indique que cette classe va pouvoir traiter les requêtes que nous allons définir.
// Il indique aussi que chaque méthode va renvoyer directement la réponse JSON à l'utilisateur, donc pas de vue dans le circuit.
//@ResponseBody
public class ProductController {
    RestTemplate restTemplate = new RestTemplate();

    private final ProductDAOImpl productDAO;

    public ProductController(ProductDAOImpl productDAO) {

        this.productDAO = productDAO;
    }

    @GetMapping("/Products")
    public List<Product> listAllProduct() {

        return productDAO.findAll();
    }
    @GetMapping("Products/{id}")
    public Product listProductWithId(@PathVariable int id){
        return productDAO.findById(id);

    }
    @PostMapping("/Products")
    public Product addProduct(String licenseNum) throws ParseException, LicenseDrivingException {
        if (isDivinglicenseValid(licenseNum)){
            throw new LicenseDrivingException("the driving license is not valid !");
        }
        return productDAO.save(new Product(1,"PC Hp",600,extractDate1("20/08/1995") ,"FMGTS458"));

    }

    @DeleteMapping("/Products/{id}")
    public Product deleteProduct(@PathVariable int id){
        return productDAO.delete(id);

    }
//The @RequestBody annotation indicates that Spring should deserialize a request body into an object.
// This object is passed as a handler method parameter.
    @PutMapping("/Products/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id, String licenseNum) throws LicenseDrivingException {
        if (!isDivinglicenseValid(licenseNum)){
            throw new LicenseDrivingException("the driving license is not valid !");
        }
        return productDAO.editProduct(product,id);

    }

    public Date extractDate1(String date) throws ParseException {
        SimpleDateFormat dateConvertor = new SimpleDateFormat("dd/MM/yyyy");
        return dateConvertor.parse(date);
    }
    public Boolean isDivinglicenseValid(String licenceDrivingNum) {
        return restTemplate.getForObject("http://localhost:8081/licenses" + licenceDrivingNum,Boolean.class);
    }


}




    // Partie Itération 1::
//    @GetMapping("/Produits")
//    //@RequestMapping(value = "/Produits", method = RequestMethod.GET)
//    public String listeProduits (){
//
//    return "test nom de produit";
//}


//@RequestMapping(value="/Produits/{id}", method= RequestMethod.GET)
//@GetMapping("/Produits/{id}")

//public Product afficheUnProduit(@PathVariable int id) throws ParseException {
//    Product product = new Product(id, "Aspirateur", 100, extractDate("20/08/1996"),"F2C5914DP");
//    return product;
//}

