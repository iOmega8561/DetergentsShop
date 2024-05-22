package detergents.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Manager {

    // Singleton
    private static Manager INSTANCE;

    public static Manager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Manager();
        }
        return INSTANCE;
    }

    // Init
    private Manager() {}

    // Properties
    private String url = "jdbc:mysql://localhost:3306/detergents?serverTimezone=UTC";

    private Connection connection;

    public Connection getConnection() throws SQLException {
        
        if (connection == null) {
            connection = DriverManager.getConnection(url, "detergents", "detergents");
            System.out.println("DAO MANAGER ==> Connected to localhost");
        }

        return connection;
    }

}