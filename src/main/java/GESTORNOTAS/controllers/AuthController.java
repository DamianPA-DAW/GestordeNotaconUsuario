package controllers;

import views.LoginView;
import views.RegisterView;
import views.MainView;
import utils.Validator;
import utils.PasswordHasher;
import java.awt.Color;

public class AuthController {
    private LoginView loginView;
    private RegisterView registerView;

    public AuthController(LoginView loginView, RegisterView registerView) {
        this.loginView = loginView;
        this.registerView = registerView;
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
        System.out.println("Login intentado para: " + user);
        abrirAppPrincipal();
    }

    private void handleRegister() {
        String user = registerView.getUsuario();
        String pass = registerView.getPassword();
        String passRep = registerView.getRepeatPassword();

        if (!Validator.validateRegistration(user, pass, passRep)) {
            registerView.mostrarMensaje("Error: Datos inválidos o contraseñas no coinciden", Color.RED);
            return;
        }
        String hashed = PasswordHasher.hashPassword(pass);
        System.out.println("Registrando usuario con hash: " + hashed);
        registerView.mostrarMensaje("¡Registro con éxito!", Color.GREEN);
    }

    private void abrirAppPrincipal() {
        loginView.dispose();
        if (registerView != null)
            registerView.dispose();

        MainView mainView = new MainView();
        mainView.setVisible(true);
    }
}