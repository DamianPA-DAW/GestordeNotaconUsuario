package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainView extends JFrame {
    private JList<String> listaNotas;
    private DefaultListModel<String> modeloLista;
    private JTextField txtTitulo;
    private JTextArea txtContenido;
    private JButton btnCrear, btnEditar, btnEliminar, btnLimpiar, btnBorrarTodo;
    private JLabel lblStatus;

    public MainView() {
        setTitle("GESTOR DE NOTAS - Nivel 2");
        setSize(900, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- INICIALIZACIÓN DE COMPONENTES ---
        modeloLista = new DefaultListModel<>();
        listaNotas = new JList<>(modeloLista);
        txtTitulo = new JTextField();
        txtContenido = new JTextArea();
        txtContenido.setLineWrap(true);
        txtContenido.setWrapStyleWord(true);

        btnCrear = new JButton("Crear Nota");
        btnEditar = new JButton("Guardar Cambios");
        btnEliminar = new JButton("Eliminar Nota");
        btnLimpiar = new JButton("Limpiar Campos");
        btnBorrarTodo = new JButton("Borrar Todo");
        btnBorrarTodo.setForeground(Color.RED);
        
        lblStatus = new JLabel(" Bienvenido al Gestor de Notas");
        lblStatus.setBorder(BorderFactory.createEtchedBorder());

        // --- DISEÑO: PANEL IZQUIERDO (LISTADO) ---
        JPanel panelIzquierdo = new JPanel(new BorderLayout());
        panelIzquierdo.setBorder(new EmptyBorder(10, 10, 10, 0));
        JScrollPane scrollLista = new JScrollPane(listaNotas);
        scrollLista.setPreferredSize(new Dimension(200, 0));
        panelIzquierdo.add(new JLabel("Mis Notas:"), BorderLayout.NORTH);
        panelIzquierdo.add(scrollLista, BorderLayout.CENTER);

        // --- DISEÑO: PANEL CENTRAL (EDITOR DE TEXTO) ---
        JPanel panelEditor = new JPanel(new BorderLayout(5, 5));
        panelEditor.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Sub-panel para el título
        JPanel panelTitulo = new JPanel(new BorderLayout(5, 5));
        panelTitulo.add(new JLabel("Título:"), BorderLayout.NORTH);
        panelTitulo.add(txtTitulo, BorderLayout.CENTER);

        panelEditor.add(panelTitulo, BorderLayout.NORTH);
        panelEditor.add(new JScrollPane(txtContenido), BorderLayout.CENTER);

        // --- DISEÑO: PANEL DERECHO (BOTONERA) ---
        JPanel panelBotones = new JPanel(new GridLayout(6, 1, 5, 5));
        panelBotones.setBorder(new EmptyBorder(10, 0, 10, 10));
        
        panelBotones.add(btnCrear);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(new JSeparator());
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnBorrarTodo);

        // --- MONTAJE FINAL ---
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelEditor, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.EAST);
        add(lblStatus, BorderLayout.SOUTH);
    }

    // --- GETTERS PARA EL CONTROLADOR ---
    public JButton getBtnCrear() { return btnCrear; }
    public JButton getBtnEditar() { return btnEditar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnLimpiar() { return btnLimpiar; }
    public JButton getBtnBorrarTodo() { return btnBorrarTodo; }
    
    public JTextField getTxtTitulo() { return txtTitulo; }
    public JTextArea getTxtContenido() { return txtContenido; }
    public JList<String> getListaNotas() { return listaNotas; }
    public DefaultListModel<String> getModeloLista() { return modeloLista; }

    // --- MÉTODOS DE UTILIDAD ---
    public String getTitulo() { return txtTitulo.getText(); }
    public String getContenido() { return txtContenido.getText(); }
    
    public void setStatus(String mensaje) {
        lblStatus.setText(" " + mensaje);
    }

    public void limpiarCampos() {
        txtTitulo.setText("");
        txtContenido.setText("");
        listaNotas.clearSelection();
    }
}