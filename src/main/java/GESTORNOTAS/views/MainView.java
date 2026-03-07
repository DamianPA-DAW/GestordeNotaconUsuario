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
        setTitle("GESTOR DE NOTAS - Nivel 1");
        setSize(900, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // --- PANEL IZQUIERDO ---
        JPanel panelIzquierdo = new JPanel(new BorderLayout());
        panelIzquierdo.setBorder(new EmptyBorder(10, 10, 10, 0));

        modeloLista = new DefaultListModel<>();
        listaNotas = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(listaNotas);
        scrollLista.setPreferredSize(new Dimension(200, 0));
        
        panelIzquierdo.add(new JLabel("Mis Notas:"), BorderLayout.NORTH);
        panelIzquierdo.add(scrollLista, BorderLayout.CENTER);

        // --- PANEL CENTRAL ---
        JPanel panelEditor = new JPanel(new BorderLayout(5, 5));
        panelEditor.setBorder(new EmptyBorder(10, 10, 10, 10));

        txtTitulo = new JTextField();
        txtContenido = new JTextArea();
        txtContenido.setLineWrap(true);
        txtContenido.setWrapStyleWord(true);

        JPanel panelCampos = new JPanel(new GridLayout(2, 1, 5, 5));
        panelCampos.add(new JLabel("Título:"));
        panelCampos.add(txtTitulo);
        
        panelEditor.add(panelCampos, BorderLayout.NORTH);
        panelEditor.add(new JScrollPane(txtContenido), BorderLayout.CENTER);

        // --- PANEL DERECHO ---
        JPanel panelBotones = new JPanel(new GridLayout(6, 1, 5, 5));
        panelBotones.setBorder(new EmptyBorder(10, 0, 10, 10));

        btnCrear = new JButton("Crear Nota");
        btnEditar = new JButton("Guardar Cambios");
        btnEliminar = new JButton("Eliminar Nota");
        btnLimpiar = new JButton("Limpiar Campos");
        btnBorrarTodo = new JButton("Borrar Todo");
        btnBorrarTodo.setForeground(Color.RED);

        panelBotones.add(btnCrear);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(new JSeparator());
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnBorrarTodo);

        // --- PANEL INFERIOR ---
        lblStatus = new JLabel(" Bienvenido al Gestor de Notas");
        lblStatus.setBorder(BorderFactory.createEtchedBorder());
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelEditor, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.EAST);
        add(lblStatus, BorderLayout.SOUTH);
    }

    // --- GETTERS QUE LE FALTABAN PARA EL CONTROLLER ---
    
    public JButton getBtnCrear() { return btnCrear; }
    
    public JButton getBtnEliminar() { return btnEliminar; }
    
    public JButton getBtnLimpiar() { return btnLimpiar; }

    public JTextField getTxtTitulo() { return txtTitulo; }

    public JTextArea getTxtContenido() { return txtContenido; }

    // --- GETTERS Y MÉTODOS 

    public DefaultListModel<String> getModeloLista() { return modeloLista; }
    
    public JList<String> getListaNotas() { return listaNotas; }
    
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