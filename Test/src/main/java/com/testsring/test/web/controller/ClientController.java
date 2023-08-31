package com.testsring.test.web.controller;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.testsring.test.dao.IClientDAO;
import com.testsring.test.exceptions.LicenseDrivingException;
import com.testsring.test.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


//il indique que cette classe va pouvoir traiter les requêtes que nous allons définir.
// Il indique aussi que chaque méthode va renvoyer directement la réponse JSON à l'utilisateur, donc pas de vue dans le circuit.
@RestController
@RequestMapping("/clients")
public class ClientController {
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private IClientDAO clientDAO;


    @GetMapping
    public Object listAllClients() {
        Iterable<Client> clients = clientDAO.findAll();
        //return clients;
        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("lastName");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue clientsFiltres = new MappingJacksonValue(clients);

        clientsFiltres.setFilters(listDeNosFiltres);

        return clientsFiltres;
    }
@GetMapping("/{id}")
    public Client listOneClient(@PathVariable int id){
        return clientDAO.findById(id);
    }
@PostMapping
    public Client addAClient(@RequestBody Client client){
    if (!isDrivinglicenseValid(client.getDrivinglicenseNumber())){
            throw new LicenseDrivingException();
       }
        return clientDAO.save(client);
    }

@PutMapping
    public Client editAclient(@RequestBody Client client){
        if (!isDrivinglicenseValid(client.getDrivinglicenseNumber())){
            throw new LicenseDrivingException();
        }
        return clientDAO.save(client);
    }

    @DeleteMapping("/{id}")
    public Client deleteProduct(@PathVariable int id){
        return clientDAO.deleteById(id);
    }

       public Boolean isDrivinglicenseValid(String licenceDrivingNum) {
        return restTemplate.getForObject("http://localhost:8081/licenses/" + licenceDrivingNum,Boolean.class);
   }
}













//
//////The @RequestBody annotation indicates that Spring should deserialize a request body into an object.
////// This object is passed as a handler method parameter.
//    @PutMapping("/Products/{id}")
//    public Client updateProduct(@RequestBody Client client, @PathVariable int id) throws LicenseDrivingException {
//        if (!isDrivinglicenseValid(client.getDrivinglicenseNumber())){
//            throw new LicenseDrivingException();
//        }
//        return clientDAO.editClient(client,id);
//    }
//
////    public Date extractDate1(String date) throws ParseException {
////        SimpleDateFormat dateConvertor = new SimpleDateFormat("dd/MM/yyyy");
////        return dateConvertor.parse(date);
////    }








    // Partie Itération 1::
//    @GetMapping("/Produits")
//    //@RequestMapping(value = "/Produits", method = RequestMethod.GET)
//    public String listeProduits (){
//
//    return "test nom de produit";
//}


//@RequestMapping(value="/Produits/{id}", method= RequestMethod.GET)
//@GetMapping("/Produits/{id}")

//public Client afficheUnProduit(@PathVariable int id) throws ParseException {
//    Client product = new Client(id, "Aspirateur", 100, extractDate("20/08/1996"),"F2C5914DP");
//    return product;
//}

