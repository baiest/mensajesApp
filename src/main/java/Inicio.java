import java.util.Scanner;
import java.util.function.Function;

public class Inicio {
    public static void main(String[] args) {
        ConnectionDB connection = new ConnectionDB();
        connection.getConnection();
        if(connection == null) return;

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        String textMenu = "-------- Menu ---------\n" +
                "1. Crear mensaje\n" +
                "2. Listar mensajes\n" +
                "3. Borrar mensaje\n" +
                "4. Editar mensaje\n" +
                "5. Salir\n";
        do{
            System.out.println(textMenu);
            System.out.print("Esciba su opción: ");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.borrarMensaje();
                    break;
                case 4:
                    MensajesService.editarMensaje();
                    break;
                default:
                    break;
            }
        }while (opcion != 5);
    }

//    private menu(int opcion) {
//
//    }
}
