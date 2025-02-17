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
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel con fondo degradado
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradiente = new GradientPaint(
                        0, 0, new Color(64, 158, 255), 
                        0, getHeight(), Color.WHITE);
                g2d.setPaint(gradiente);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panelFondo.setLayout(new GridBagLayout());
        setContentPane(panelFondo);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes

        // 📌 IMAGEN ENCIMA DEL NOMBRE DE LA APP
        ImageIcon icono = new ImageIcon("logo.png"); // Ruta de la imagen
        Image imagen = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Escalar imagen
        JLabel labelImagen = new JLabel(new ImageIcon(imagen));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panelFondo.add(labelImagen, gbc);


        // 📌 NOMBRE DE LA APP
        JLabel labelTitulo = new JLabel("LoginApp");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitulo.setForeground(Color.BLACK);
        gbc.gridy = 1;
        panelFondo.add(labelTitulo, gbc);

        // 📌 USUARIO
        JLabel labelUsuario = new JLabel("Usuario:");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelFondo.add(labelUsuario, gbc);

        textUsuario = new JTextField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelFondo.add(textUsuario, gbc);

        // 📌 CONTRASEÑA
        JLabel labelContrasena = new JLabel("Contraseña:");
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panelFondo.add(labelContrasena, gbc);

        textContrasena = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelFondo.add(textContrasena, gbc);

        // 📌 PANEL PARA LOS BOTONES
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panelBotones.setOpaque(false);

        // 📌 BOTÓN REGISTRARSE
        btnRegistro = new JButton("Registrarse");
        btnRegistro.setBackground(new Color(255, 87, 34));
        btnRegistro.setForeground(Color.WHITE);
        btnRegistro.setPreferredSize(new Dimension(120, 40));

        // 📌 BOTÓN ENTRAR
        btnEntrar = new JButton("Entrar");
        btnEntrar.setBackground(new Color(0, 150, 136));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setPreferredSize(new Dimension(120, 40));

        // Agregar los botones al panel
        panelBotones.add(btnRegistro);
        panelBotones.add(btnEntrar);

        // 📌 Agregar el panel de botones al layout
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelFondo.add(panelBotones, gbc);

        // 📌 ACCIONES DE LOS BOTONES
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textUsuario.getText();
                String contrasena = new String(textContrasena.getPassword());

                if (DatabaseHelper.verificarUsuario(usuario, contrasena)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. Bienvenido, " + usuario + " a LoginApp");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                }
            }
        });

        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroFrame().setVisible(true);
            }
        });

        // 📌 EFECTOS VISUALES AL PASAR EL RATÓN SOBRE LOS BOTONES
        btnEntrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnEntrar.setBackground(new Color(60, 179, 113)); // Verde oscuro
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnEntrar.setBackground(new Color(0, 150, 136)); // Verde original
            }
        });

        btnRegistro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnRegistro.setBackground(new Color(255, 122, 35)); // Naranja oscuro
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnRegistro.setBackground(new Color(255, 87, 34)); // Naranja original
            }
        });
    }
}






