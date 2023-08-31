//package com.testsring.test.dao;
//
//import com.testsring.test.model.Client;
//import org.springframework.stereotype.Repository;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//@Repository
//// cette annotation est appliquée à la classe afin d'indiquer à Spring qu'il s'agit d'une classe qui gère les données,
//// ce qui nous permettra de profiter de certaines fonctionnalités, comme les translations des erreurs.
//public class ClientDAOImpl implements IClientDAO {
//    public static List<Client> clients = new ArrayList<>();
//
//    static {
//        try {
//            clients.add(new Client(1,"olfi","ihci",extractDate("20/08/1995") ,"FMGTS4158"));
//            clients.add(new Client(2,"hichamus","hji",extractDate("20/08/1996"),"F59TS4658"));
//            clients.add(new Client(3,"polm","hui",extractDate("20/08/1997"),"FMGTS45P8"));
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static Date extractDate(String date) throws ParseException {
//        SimpleDateFormat dateConvertor = new SimpleDateFormat("dd/MM/yyyy");
//        return dateConvertor.parse(date);
//    }
//
//    @Override
//    public List<Client> findAll() {
//        return clients;
//    }
//
//
//
//    @Override
//    public Client findById(int id) {
//        for (Client client : clients){
//            if (client.getId(id) == id){
//                return client;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    //est utilisé pour définir une méthode qui est héritée de la classe parente. On ne l'utilise donc que dans le cas de l'héritage
//    public Client save(Client client) {
//        client.setName(client.getName());
//        client.setId(client.getId());
//        client.setBirthDate(client.getBirthDate());
//        client.setLastName(client.getLastName());
//        client.setDrivinglicenseNumber(client.getDrivinglicenseNumber());
//
//        return client;
//    }
//    @Override
//    public Client editClient(Client client, int id){
//        Client clientToUpdate = client.findById(id);
//        if (clientToUpdate != null){
//            clientToUpdate.setName(client.getName());
//            clientToUpdate.setBirthDate(client.getBirthDate());
//            clientToUpdate.setLastName(client.getLastName());
//            clientToUpdate.setDrivinglicenseNumber(client.getDrivinglicenseNumber());
//        }
//        return client;
//    }
//
//    public Client delete(int id){
//        return clients.remove(id);
//    }
//}
