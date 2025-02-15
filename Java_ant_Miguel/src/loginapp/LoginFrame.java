/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginapp;


/**
 *
 * @author miguivg
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame {
    private JTextField textUsuario;
    private JPasswordField textContrasena;
    private JButton btnEntrar, btnRegistro;

    public LoginFrame() {
        setTitle("LoginApp");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        // Configurar etiqueta y campo Usuario
        JLabel labelUsuario = new JLabel("Usuario:");
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST; // Alinear a la derecha
        add(labelUsuario, gbc);

        textUsuario = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        add(textUsuario, gbc);

        // Configurar etiqueta y campo Contraseña
        JLabel labelContrasena = new JLabel("Contraseña:");
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(labelContrasena, gbc);

        textContrasena = new JPasswordField(20);
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(textContrasena, gbc);

        // Crear un panel sin márgenes extra para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0)); // Separación de 20px entre los botones
        panelBotones.setOpaque(false);  // Hacer que el panel sea transparente para que no agregue ningún espacio adicional

        // Configurar botón Registrarse
        btnRegistro = new JButton("Registrarse");
        btnRegistro.setBackground(new Color(255, 87, 34)); // Color naranja
        btnRegistro.setForeground(Color.WHITE);
        btnRegistro.setPreferredSize(new Dimension(120, 40));  // Ajustar tamaño del botón
        

        // Configurar botón Entrar
        btnEntrar = new JButton("Entrar");
        btnEntrar.setBackground(new Color(0, 150, 136)); // Color verde
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setPreferredSize(new Dimension(120, 40));  // Ajustar tamaño del botón
        
        
        // Agregar los botones al panel
        panelBotones.add(btnRegistro);
        panelBotones.add(btnEntrar);

        // Establecer el panel de botones en el layout principal
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Alinear el panel en toda la fila
        add(panelBotones, gbc);

        // Acción del botón Entrar
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textUsuario.getText();
                String contrasena = new String(textContrasena.getPassword());

                if (DatabaseHelper.verificarUsuario(usuario, contrasena)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });

        // Acción del botón Registrarse
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroFrame().setVisible(true);
            }
        });

        // MouseListener para cambiar color sin aumentar tamaño en el botón Entrar
        btnEntrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnEntrar.setBackground(new Color(60, 179, 113)); // Un verde más oscuro
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnEntrar.setBackground(new Color(0, 150, 136)); // Color original
            }
        });

        // MouseListener para cambiar color sin aumentar tamaño en el botón Registrarse
        btnRegistro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnRegistro.setBackground(new Color(255, 122, 35)); // Un naranja más oscuro
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnRegistro.setBackground(new Color(255, 87, 34)); // Color original
            }
        });
    }
}





