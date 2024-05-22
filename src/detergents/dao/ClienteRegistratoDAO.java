package detergents.dao;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import detergents.entity.ClienteRegistrato;

public class ClienteRegistratoDAO implements Interface<ClienteRegistrato> {
    
    private Manager manager;

    private List<ClienteRegistrato> clienti;

    private ResultSet query(String queryStatement) throws SQLException {
        Connection conn = manager.getConnection();

        PreparedStatement preparedStatement = conn.prepareStatement(queryStatement); 
        ResultSet result = preparedStatement.executeQuery();

        return result;
    }

    public List<ClienteRegistrato> fetchAll() {

        if (clienti.size() != 0) { return clienti; }

        try(ResultSet result = query("select * from ClienteRegistrato");) {

            while(result.next()) {
                clienti.add(
                    new ClienteRegistrato(
                        result.getString("nomeUtente"),
                        result.getString("password"),
                        result.getString("nrTelefono"),
                        result.getString("cartaCredito")
                    )
                );
            }

        } catch(SQLException error) {
            System.err.println(error.getLocalizedMessage());
        }

        return clienti;
    }

    public ClienteRegistratoDAO() {
        manager = Manager.getInstance();
        clienti = new ArrayList<>();
    }
}
