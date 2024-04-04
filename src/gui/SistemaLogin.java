package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import database.DatabaseManager;

public class SistemaLogin {
    private JFrame frame;
    private JPanel panel;
    private JLabel usuarioLabel, contraseñaLabel, preguntaCrearCuenta;
    private JTextField usuarioField, nombreField, apellidoField, numeroField, correoField, paisField, ciudadField;
    private JPasswordField contraseñaField;
    private JButton iniciarSesionBoton, crearCuentaBoton;

    public SistemaLogin() {
        frame = new JFrame("Inicio de Sesión");
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        usuarioLabel = new JLabel("Usuario:");
        contraseñaLabel = new JLabel("Contraseña:");
        usuarioField = new JTextField(20);
        contraseñaField = new JPasswordField(20);
        iniciarSesionBoton = new JButton("Iniciar Sesión");
        crearCuentaBoton = new JButton("Crear Cuenta");
        preguntaCrearCuenta = new JLabel("¿Aún no tienes cuenta?");
        nombreField = new JTextField(20);
        apellidoField = new JTextField(20);
        numeroField = new JTextField(20);
        correoField = new JTextField(20);
        paisField = new JTextField(20);
        ciudadField = new JTextField(20);

        // Establecer colores y fuentes
        panel.setBackground(new Color(64, 64, 64)); 
        usuarioLabel.setForeground(Color.WHITE); 
        contraseñaLabel.setForeground(Color.WHITE); 
        preguntaCrearCuenta.setForeground(Color.WHITE); 
        iniciarSesionBoton.setBackground(new Color(255, 153, 0)); 
        crearCuentaBoton.setBackground(new Color(255, 153, 0));
        iniciarSesionBoton.setForeground(Color.WHITE); 
        crearCuentaBoton.setForeground(Color.WHITE); 

        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(usuarioLabel, constraints);

        constraints.gridy = 1;
        panel.add(usuarioField, constraints);

        
        constraints.gridy = 2;
        panel.add(contraseñaLabel, constraints);

        constraints.gridy = 3;
        panel.add(contraseñaField, constraints);

        
        constraints.gridy = 4;
        panel.add(iniciarSesionBoton, constraints);

       
        constraints.gridy = 5;
        panel.add(preguntaCrearCuenta, constraints);

       
        constraints.gridy = 6;
        panel.add(crearCuentaBoton, constraints);

        // Acción del botón Iniciar Sesión
        iniciarSesionBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String usuario = usuarioField.getText();
                String contraseña = new String(contraseñaField.getPassword());

                
                boolean inicioSesionExitoso = DatabaseManager.iniciarSesion(usuario, contraseña);
                if (inicioSesionExitoso) {
                    
                    new VentanaPrincipal();
                    
                    frame.dispose();
                } else {
                    
                    JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        // Acción del botón Crear Cuenta
        crearCuentaBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame nuevaVentana = new JFrame("Detalles de la Cuenta");
                JPanel nuevoPanel = new JPanel(new GridBagLayout());
                GridBagConstraints nuevoConstraints = new GridBagConstraints();
                nuevoConstraints.insets = new Insets(10, 10, 10, 10);

                JLabel nombreLabel = new JLabel("Nombre:");
                JLabel apellidoLabel = new JLabel("Apellido:");
                JLabel numeroLabel = new JLabel("Número:");
                JLabel correoLabel = new JLabel("Correo:");
                JLabel paisLabel = new JLabel("País:");
                JLabel ciudadLabel = new JLabel("Ciudad:");
                JLabel usuarioLabel = new JLabel("Nombre de Usuario:");
                JLabel contraseñaLabel = new JLabel("Contraseña:");
                JTextField usuarioField = new JTextField(20);
                JPasswordField contraseñaField = new JPasswordField(20);

                nuevoConstraints.gridx = 0;
                nuevoConstraints.gridy = 0;
                nuevoPanel.add(nombreLabel, nuevoConstraints);

                nuevoConstraints.gridy = 1;
                nuevoPanel.add(nombreField, nuevoConstraints);

                nuevoConstraints.gridy = 2;
                nuevoPanel.add(apellidoLabel, nuevoConstraints);

                nuevoConstraints.gridy = 3;
                nuevoPanel.add(apellidoField, nuevoConstraints);

                nuevoConstraints.gridy = 4;
                nuevoPanel.add(numeroLabel, nuevoConstraints);

                nuevoConstraints.gridy = 5;
                nuevoPanel.add(numeroField, nuevoConstraints);

                nuevoConstraints.gridy = 6;
                nuevoPanel.add(correoLabel, nuevoConstraints);

                nuevoConstraints.gridy = 7;
                nuevoPanel.add(correoField, nuevoConstraints);

                nuevoConstraints.gridy = 8;
                nuevoPanel.add(paisLabel, nuevoConstraints);

                nuevoConstraints.gridy = 9;
                nuevoPanel.add(paisField, nuevoConstraints);

                nuevoConstraints.gridy = 10;
                nuevoPanel.add(ciudadLabel, nuevoConstraints);

                nuevoConstraints.gridy = 11;
                nuevoPanel.add(ciudadField, nuevoConstraints);

                
                nuevoConstraints.gridy = 12;
                nuevoPanel.add(usuarioLabel, nuevoConstraints);

                nuevoConstraints.gridy = 13;
                nuevoPanel.add(usuarioField, nuevoConstraints);

               
                nuevoConstraints.gridy = 14;
                nuevoPanel.add(contraseñaLabel, nuevoConstraints);

                nuevoConstraints.gridy = 15;
                nuevoPanel.add(contraseñaField, nuevoConstraints);

                JButton confirmarBoton = new JButton("Confirmar");
                nuevoConstraints.gridy = 16;
                nuevoPanel.add(confirmarBoton, nuevoConstraints);

                // Establecer colores y fuentes para la nueva ventana
                nuevoPanel.setBackground(new Color(64, 64, 64)); 
                nombreLabel.setForeground(Color.WHITE); 
                apellidoLabel.setForeground(Color.WHITE); 
                numeroLabel.setForeground(Color.WHITE); 
                correoLabel.setForeground(Color.WHITE); 
                paisLabel.setForeground(Color.WHITE); 
                ciudadLabel.setForeground(Color.WHITE); 
                usuarioLabel.setForeground(Color.WHITE); 
                contraseñaLabel.setForeground(Color.WHITE); 
                confirmarBoton.setBackground(new Color(255, 153, 0)); 
                confirmarBoton.setForeground(Color.WHITE); 

                nuevaVentana.add(nuevoPanel);
                nuevaVentana.setSize(600, 800);
                nuevaVentana.setLocationRelativeTo(null);
                nuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                nuevaVentana.setVisible(true);
                
                // Acción del botón Confirmar en la ventana de creación de cuenta
                confirmarBoton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                       
                        String nombre = nombreField.getText();
                        String apellido = apellidoField.getText();
                        long numero = Long.parseLong(numeroField.getText());
                        String correo = correoField.getText();
                        String pais = paisField.getText();
                        String ciudad = ciudadField.getText();
                        String usuario = usuarioField.getText(); 
                        String contraseña = new String(contraseñaField.getPassword());

                        // Llama al método crearCuenta de DatabaseManager para guardar los datos en la base de datos
                        DatabaseManager.crearCuenta(nombre, apellido, numero, correo, pais, ciudad, usuario, contraseña);

                        
                        JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.");
                        
                        
                        nuevaVentana.dispose();
                    }
                });
            }
        });

        frame.add(panel);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void abrirVentanaPrincipal() {
        
        JFrame ventanaPrincipal = new JFrame("Ventana Principal");
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLocationRelativeTo(null);
        
        ventanaPrincipal.setVisible(true);
    }

    public static void main(String[] args) {
        new SistemaLogin();
    }
}

