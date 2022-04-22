import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MensajesDAO {
    public static void crearMensajeDB(Mensajes mensaje){
        ConnectionDB connection = new ConnectionDB();
        if(connection==null) return;
        PreparedStatement ps = null;
        String query = "INSERT INTO mensajes " +
                "(mensaje, autor_mensaje) " +
                "VALUES " +
                "(?, ?)";
        try {
            ps = connection.getConnection().prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAuthorMensaje());
            ps.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public static ArrayList<Mensajes> leerMensajesDB(){
        ConnectionDB connection = new ConnectionDB();
        ArrayList<Mensajes> mensajes = new ArrayList<Mensajes>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM mensajes";
        try {
            ps = connection.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                mensajes.add(new Mensajes(
                    rs.getInt("id_mensaje"),
                    rs.getString("mensaje"),
                    rs.getString("autor_mensaje"),
                    rs.getString("fecha_mensaje"))
                );
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return mensajes;
    }

    public static void borrarMensaje(int id){
        ConnectionDB connection = new ConnectionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
        try{
            ps = connection.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
            System.out.println("No se pudo borrar el mensaje");
        }
    }

    public static void editarMensajeDB(Mensajes mensaje){
        ConnectionDB connection = new ConnectionDB();
        PreparedStatement ps = null;
        String query = "UPDATE mensajes SET " +
                "mensaje = ? ," +
                "fecha_mensaje = NOW() " +
                "WHERE id_mensaje = ?";
        try {
            ps = connection.getConnection().prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setInt(2, mensaje.getIdMensaje());
            ps.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
            System.out.println("No se pudo actualizar el mensaje");
        }
    }
}
