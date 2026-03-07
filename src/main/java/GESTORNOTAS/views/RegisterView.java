package views;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RegisterView extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtPassword, txtRepeatPassword;
    private JButton btnRegistrar, btnVolverLogin;
    private JLabel lblMensaje;

    public RegisterView() {
        setTitle("Registro de Usuario");
        setSize(350, 320); // Un poco más alta para el campo extra
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Componentes
        txtUsuario = new JTextField();
        txtPassword = new JPasswordField();
        txtRepeatPassword = new JPasswordField();
        btnRegistrar = new JButton("Crear Cuenta");
        btnVolverLogin = new JButton("¿Ya tienes cuenta? Inicia sesión");

        // Estilo
        btnRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolverLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolverLogin.setBorderPainted(false);
        btnVolverLogin.setContentAreaFilled(false);
        btnVolverLogin.setForeground(Color.BLUE);

        lblMensaje = new JLabel("Completa todos los campos");
        lblMensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblMensaje.setForeground(Color.GRAY);

        // Añadir al panel
        panel.add(new JLabel("Nuevo Usuario:"));
        panel.add(txtUsuario);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(new JLabel("Contraseña:"));
        panel.add(txtPassword);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(new JLabel("Repetir Contraseña:"));
        panel.add(txtRepeatPassword);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(btnRegistrar);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnVolverLogin);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblMensaje);

        add(panel);
    }

    // Getters para el controlador
    public String getUsuario() { return txtUsuario.getText(); }
    public String getPassword() { return new String(txtPassword.getPassword()); }
    public String getRepeatPassword() { return new String(txtRepeatPassword.getPassword()); }
    public JButton getBtnRegistrar() { return btnRegistrar; }
    public JButton getBtnVolverLogin() { return btnVolverLogin; }

    public void mostrarMensaje(String msj, Color color) {
        lblMensaje.setText(msj);
        lblMensaje.setForeground(color);
    }
}