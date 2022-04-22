import java.sql.Timestamp;
import java.util.Scanner;

public class MensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe tu mensaje: ");
        String textoMensaje = sc.nextLine();
        System.out.print("Tu nombre: ");
        String autor = sc.nextLine();
        Mensajes mensaje = new Mensajes();
        mensaje.setMensaje(textoMensaje);
        mensaje.setAuthorMensaje(autor);
        MensajesDAO.crearMensajeDB(mensaje);
    }

    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB().forEach(mensaje -> System.out.println(mensaje.String()));
    }

    public static Mensajes listarMensajeById(int id){
        for (Mensajes mensaje : MensajesDAO.leerMensajesDB()){
            if(mensaje.getIdMensaje() == id){
                return mensaje;
            }
        }
        return null;
    }

    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Que mensaje quieres borrar?: ");
        int idMensaje = sc.nextInt();
        MensajesDAO.borrarMensaje(idMensaje);
    }

    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Escriba el nuevo texto: ");
        String textMensaje = sc.nextLine();
        System.out.print("Que mensaje quieres actualizar?: ");
        int idMensaje = sc.nextInt();
        Mensajes mensaje = listarMensajeById(idMensaje);
        mensaje.setMensaje(textMensaje);
        if(mensaje != null) MensajesDAO.editarMensajeDB(mensaje);
        else System.out.println("Mensaje no encontrado");
    }
}
