/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 *
 * @author miguivg
 */


public class RegistroFrame extends JFrame {
    private JTextField textNombre, textCorreo, textUsuario;
    private JPasswordField textContrasena;
    private JButton btnRegistrar;

    public RegistroFrame() {
        setTitle("Registro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Crear un gradiente de color para el fondo (de azul a blanco)
        GradientPaint gradiente = new GradientPaint(0, 0, new Color(64, 158, 255), 0, getHeight(), Color.WHITE);
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(gradiente);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelFondo.setLayout(new GridBagLayout());
        setContentPane(panelFondo);

        // Cambiar el color de fondo de la ventana a un gradiente
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes

        // Configurar etiqueta y campo Nombre
        JLabel labelNombre = new JLabel("Nombre:");
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST; // Alinear a la derecha
        add(labelNombre, gbc);

        textNombre = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        add(textNombre, gbc);

        // Configurar etiqueta y campo Correo
        JLabel labelCorreo = new JLabel("Correo:");
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(labelCorreo, gbc);

        textCorreo = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(textCorreo, gbc);

        // Configurar etiqueta y campo Usuario
        JLabel labelUsuario = new JLabel("Usuario:");
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(labelUsuario, gbc);

        textUsuario = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(textUsuario, gbc);

        // Configurar etiqueta y campo Contraseña
        JLabel labelContrasena = new JLabel("Contraseña:");
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(labelContrasena, gbc);

        textContrasena = new JPasswordField(20);
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(textContrasena, gbc);

        // Configurar botón Registrar
        btnRegistrar = new JButton("Registrar");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Alinear el botón en toda la fila
        add(btnRegistrar, gbc);

        // Acción del botón Registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textNombre.getText();
                String correo = textCorreo.getText();
                String usuario = textUsuario.getText();
                String contrasena = new String(textContrasena.getPassword());

                if (DatabaseHelper.registrarUsuario(nombre, correo, usuario, contrasena)) {
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    dispose(); // Cerrar ventana de registro
                } else {
                    JOptionPane.showMessageDialog(null, "Error en el registro");
                }
            }
        });

        // MouseListener para cambiar color sin aumentar tamaño
        btnRegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiar color de fondo al pasar el ratón
                btnRegistrar.setBackground(new Color(60, 179, 113)); // Un verde más oscuro
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Volver al color original
                btnRegistrar.setBackground(new Color(0, 150, 136)); // Color original
            }
        });

        // Establecer un color inicial para el botón
        btnRegistrar.setBackground(new Color(0, 150, 136)); // Color inicial
        btnRegistrar.setForeground(Color.WHITE);
    }
}



