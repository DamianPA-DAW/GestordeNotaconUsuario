package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginView extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnIrRegistro;
    private JLabel lblMensaje;

    public LoginView() {
        setTitle("Acceso - Gestor de Notas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Componentes
        txtUsuario = new JTextField();
        txtPassword = new JPasswordField();
        btnLogin = new JButton("Iniciar Sesión");
        btnIrRegistro = new JButton("¿No tienes cuenta? Regístrate");

        // Estilo de botones
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIrRegistro.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIrRegistro.setBorderPainted(false);
        btnIrRegistro.setContentAreaFilled(false);
        btnIrRegistro.setForeground(Color.BLUE);

        lblMensaje = new JLabel("Introduce tus credenciales");
        lblMensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblMensaje.setForeground(Color.GRAY);

        // Añadir al panel
        panel.add(new JLabel("Usuario:"));
        panel.add(txtUsuario);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(new JLabel("Contraseña:"));
        panel.add(txtPassword);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(btnLogin);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(btnIrRegistro);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblMensaje);

        add(panel);
    }

    // Getters y Setters
    public String getUsuario() {
        return txtUsuario.getText();
    }

    public String getPassword() {
        return new String(txtPassword.getPassword());
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnIrRegistro() {
        return btnIrRegistro;
    }

    public void mostrarError(String msj) {
        lblMensaje.setText(msj);
        lblMensaje.setForeground(Color.RED);
    }
}