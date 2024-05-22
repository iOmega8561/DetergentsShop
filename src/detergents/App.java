package detergents;

import java.util.List;

import detergents.dao.ClienteRegistratoDAO;
import detergents.entity.ClienteRegistrato;;

public class App {

    public static void main(String[] args) {

        System.out.println("APPLICATION ==> Started Detergents Shop");

        ClienteRegistratoDAO crDao = new ClienteRegistratoDAO();

        

        List<ClienteRegistrato> clienti = crDao.fetchAll();

        for (ClienteRegistrato cliente : clienti) {
            System.out.println(cliente.getNomeUtente());
        }
    }
}
