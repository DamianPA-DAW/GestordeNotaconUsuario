package controllers;

import models.Nota;
import models.Usuario;
import views.MainView;
import repository.FilePersistence;
import utils.Validator;
import java.util.List;
import javax.swing.JButton;

public class NotaController {
    private MainView view;
    private Usuario usuarioActual;
    private FilePersistence persistence;
    private List<Usuario> todosLosUsuarios;

    public NotaController(MainView view, Usuario usuario, List<Usuario> todosLosUsuarios, FilePersistence persistence) {
        this.view = view;
        this.usuarioActual = usuario;
        this.todosLosUsuarios = todosLosUsuarios;
        this.persistence = persistence;
        
        cargarNotasEnLista();
        initEventHandlers();
    }

    private void initEventHandlers() {
        view.getBtnCrear().addActionListener(e -> crearNota());
        
        view.getBtnLimpiar().addActionListener(e -> view.limpiarCampos());

        view.getBtnEliminar().addActionListener(e -> eliminarNota());
        
        view.getListaNotas().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) cargarNotaSeleccionada();
        });
    }

    private void crearNota() {
        String titulo = view.getTitulo();
        String contenido = view.getContenido();

        if (!Validator.validateNote(titulo)) {
            view.setStatus("Error: El título no puede estar vacío");
            return;
        }

        Nota nuevaNota = new Nota(titulo, contenido);
        usuarioActual.getNotas().add(nuevaNota);
        
        actualizarYGuardar("Nota '" + titulo + "' creada correctamente");
    }

    private void eliminarNota() {
        int index = view.getListaNotas().getSelectedIndex();
        if (index != -1) {
            usuarioActual.getNotas().remove(index);
            actualizarYGuardar("Nota eliminada");
        } else {
            view.setStatus("Selecciona una nota para eliminar");
        }
    }

    private void cargarNotasEnLista() {
        view.getModeloLista().clear();
        for (Nota n : usuarioActual.getNotas()) {
            view.getModeloLista().addElement(n.getTitulo());
        }
    }

    private void cargarNotaSeleccionada() {
        int index = view.getListaNotas().getSelectedIndex();
        if (index != -1) {
            Nota n = usuarioActual.getNotas().get(index);
            view.getTxtTitulo().setText(n.getTitulo());
            view.getTxtContenido().setText(n.getContenido());
            view.setStatus("Viendo: " + n.getTitulo());
        }
    }

    private void actualizarYGuardar(String mensaje) {
        cargarNotasEnLista();
        persistence.guardarDatos(todosLosUsuarios);
        view.limpiarCampos();
        view.setStatus(mensaje);
    }
}