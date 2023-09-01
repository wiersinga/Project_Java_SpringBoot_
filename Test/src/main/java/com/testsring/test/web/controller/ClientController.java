package com.testsring.test.web.controller;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.testsring.test.dao.IClientDAO;
import com.testsring.test.exceptions.LicenseDrivingException;
import com.testsring.test.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


//il indique que cette classe va pouvoir traiter les requêtes que nous allons definir.
// Il indique aussi que chaque méthode va renvoyer directement la réponse JSON à l utilisateur, donc pas de vue dans le circuit.
@RestController
@RequestMapping("/customers")
public class ClientController {
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private IClientDAO clientDAO;


    @GetMapping
    public Object listAllClients() {
        Iterable<Customer> clients = clientDAO.findAll();
        //return clients;
        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("lastName");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue clientsFiltres = new MappingJacksonValue(clients);

        clientsFiltres.setFilters(listDeNosFiltres);

        return clientsFiltres;
    }
@GetMapping("/{id}")
    public Customer listOneClient(@PathVariable int id){
        return clientDAO.findById(id);
    }
@PostMapping
    public Customer addAClient(@RequestBody Customer customer){
    if (!isDrivinglicenseValid(customer.getLicenseId())){
            throw new LicenseDrivingException();
       }
        return clientDAO.save(customer);
    }

@PutMapping
    public Customer editAclient(@RequestBody Customer customer){
        if (!isDrivinglicenseValid(customer.getLicenseId())){
            throw new LicenseDrivingException();
        }
        return clientDAO.save(customer);
    }

    @DeleteMapping("/{id}")
    public Customer deleteProduct(@PathVariable int id){
        return clientDAO.deleteById(id);
    }

       public Boolean isDrivinglicenseValid(String licenceDrivingNum) {
        return restTemplate.getForObject("http://localhost:8081/licenses/" + licenceDrivingNum,Boolean.class);
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

//public Customer afficheUnProduit(@PathVariable int id) throws ParseException {
//    Customer product = new Customer(id, "Aspirateur", 100, extractDate("20/08/1996"),"F2C5914DP");
//    return product;
//}

