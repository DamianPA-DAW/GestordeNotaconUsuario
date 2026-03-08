package controllers;

import models.Nota;
import models.Usuario;
import views.MainView;
import repository.FilePersistence;
import utils.Validator;
import java.util.List;
import javax.swing.JOptionPane;

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
        view.getBtnEditar().addActionListener(e -> editarNota());
        view.getBtnEliminar().addActionListener(e -> eliminarNota());
        view.getBtnBorrarTodo().addActionListener(e -> borrarTodo());
        view.getBtnLimpiar().addActionListener(e -> view.limpiarCampos());
        view.getListaNotas().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) cargarNotaSeleccionada();
        });
    }

    private void crearNota() {
        String titulo = view.getTitulo();
        String contenido = view.getContenido();
        if (Validator.isStringEmpty(titulo)) {
            view.setStatus("Error: El título es obligatorio");
            return;
        }
        usuarioActual.getNotas().add(new Nota(titulo, contenido));
        actualizarYGuardar("Nota creada con éxito");
    }

    private void editarNota() {
        int index = view.getListaNotas().getSelectedIndex();
        if (index == -1) {
            view.setStatus("Error: Selecciona una nota primero");
            return;
        }
        Nota n = usuarioActual.getNotas().get(index);
        n.setTitulo(view.getTitulo());
        n.setContenido(view.getContenido());
        actualizarYGuardar("Nota actualizada");
    }

    private void eliminarNota() {
        int index = view.getListaNotas().getSelectedIndex();
        if (index != -1) {
            usuarioActual.getNotas().remove(index);
            actualizarYGuardar("Nota eliminada");
        }
    }

    private void borrarTodo() {
        int confirm = JOptionPane.showConfirmDialog(view, "¿Borrar TODAS las notas?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            usuarioActual.getNotas().clear();
            actualizarYGuardar("Listado vaciado");
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
            view.setStatus("Editando: " + n.getTitulo());
        }
    }

    private void actualizarYGuardar(String mensaje) {
        cargarNotasEnLista();
        persistence.guardarDatos(todosLosUsuarios);
        view.limpiarCampos();
        view.setStatus(mensaje);
    }
}