package BibliotecaComJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection getDatabase(){
        String url = "jdbc:mysql://127.0.0.1:3306/library";
        String user = "root";
        String password = "admin";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: "+ e);
        }
    }
}
