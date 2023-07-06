package proyectoparqueadero;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;

/**
 * Clase para establecer una conexión con una base de datos MySQL.
 */
public class connectar {
    Connection con;
    
    /**
     * Establece una conexión con la base de datos.
     * @return La conexión establecida.
     */
    public Connection conexion() {
        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establecer la conexión utilizando la URL de la base de datos, nombre de usuario y contraseña
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdparqueadero", "root", "");
        } catch(Exception e) {
            // Mostrar un mensaje de error en caso de excepción
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e);
        }
        
        return con;
    }
}
