package controllers;

import models.Usuario;
import repository.FilePersistence;
import views.LoginView;
import views.RegisterView;
import views.MainView;
import utils.Validator;
import utils.PasswordHasher;
import java.awt.Color;
import java.util.List;

public class AuthController {
    private LoginView loginView;
    private RegisterView registerView;
    private List<Usuario> usuarios;
    private FilePersistence persistence;

    public AuthController(LoginView loginView, RegisterView registerView, List<Usuario> usuarios, FilePersistence persistence) {
        this.loginView = loginView;
        this.registerView = registerView;
        this.usuarios = usuarios;
        this.persistence = persistence;
        initEventHandlers();
    }

    private void initEventHandlers() {
        loginView.getBtnLogin().addActionListener(e -> handleLogin());
        loginView.getBtnIrRegistro().addActionListener(e -> {
            loginView.setVisible(false);
            registerView.setVisible(true);
        });
        registerView.getBtnRegistrar().addActionListener(e -> handleRegister());
        registerView.getBtnVolverLogin().addActionListener(e -> {
            registerView.setVisible(false);
            loginView.setVisible(true);
        });
    }

    private void handleLogin() {
        String user = loginView.getUsuario();
        String pass = loginView.getPassword();

        if (Validator.isStringEmpty(user) || Validator.isStringEmpty(pass)) {
            loginView.mostrarError("Campos obligatorios vacíos");
            return;
        }

        Usuario usuarioEncontrado = null;
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equals(user) && PasswordHasher.verifyPassword(pass, u.getPasswordHash())) {
                usuarioEncontrado = u;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            abrirAppPrincipal(usuarioEncontrado);
        } else {
            loginView.mostrarError("Credenciales incorrectas");
        }
    }

    private void handleRegister() {
        String user = registerView.getUsuario();
        String pass = registerView.getPassword();
        String passRep = registerView.getRepeatPassword();

        if (!Validator.validateRegistration(user, pass, passRep)) {
            registerView.mostrarMensaje("Error: Datos inválidos", Color.RED);
            return;
        }

        Usuario nuevo = new Usuario(user, PasswordHasher.hashPassword(pass));
        usuarios.add(nuevo);
        persistence.guardarDatos(usuarios);
        registerView.mostrarMensaje("¡Usuario registrado!", Color.GREEN);
    }

    private void abrirAppPrincipal(Usuario usuarioLogueado) {
        loginView.dispose();
        if (registerView != null) registerView.dispose();
        MainView mainView = new MainView();
        new NotaController(mainView, usuarioLogueado, usuarios, persistence);
        mainView.setVisible(true);
    }
}