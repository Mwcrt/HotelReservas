package database;

import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/HotelReservas";
    private static final String USER = "root";
    private static final String PASS = "Olaxdlolh1#@";

    public static void crearCuenta(String nombre, String apellido, long numero, String correo, String pais, String ciudad, String usuario, String contraseña) {
        // Conexión a la base de datos y código para insertar los datos en la tabla correspondiente
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establecer la conexión a la base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelReservas", "root", "Olaxdlolh1#@");

            // Preparar la consulta SQL
            String query = "INSERT INTO usuarios (nombre, apellido, numero, correo, pais, ciudad, usuario, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);

            // Establecer los valores de los parámetros en la consulta preparada
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setLong(3, numero);
            statement.setString(4, correo);
            statement.setString(5, pais);
            statement.setString(6, ciudad);
            statement.setString(7, usuario);
            statement.setString(8, contraseña);

            // Ejecutar la consulta
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión y el statement
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean iniciarSesion(String usuario, String contraseña) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario);
            pstmt.setString(2, contraseña);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

