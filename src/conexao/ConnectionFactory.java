package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String url = "jdbc:mysql://localhost:3306/db_projeto";
    private static final String user = "root";
    private static final String password = "Rafa136501";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar: ", e);
        }
    }
}
