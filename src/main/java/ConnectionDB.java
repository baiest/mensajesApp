import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private final String HOST = "localhost";
    private final int  PORT = 3306;
    private final String NAME_DB = "mensajes_app";
    private final String  USER = System.getenv("USER_DB");
    private final String  PASS = System.getenv("USER_PASS");

    public Connection getConnection(){
        Connection connection = null;
        String url = String.format("jdbc:mysql://%s:%s/%s", HOST, PORT, NAME_DB);
        try {
            connection = DriverManager.getConnection(url, USER, PASS);
//            if(connection != null){
//                System.out.println("Conexión exitosa");
//            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return connection;
    }
}
