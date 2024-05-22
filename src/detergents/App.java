package detergents;

import java.sql.Connection;
import java.sql.SQLException;

import detergents.dao.Manager;

public class App {

    public static void main(String[] args) {
        Manager manager = Manager.getInstance();

        System.out.println("Acquired shared manager");

        try (Connection conn = manager.getConnection();) {
            System.out.println("Connected");
        } catch(SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
