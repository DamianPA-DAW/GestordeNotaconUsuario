package main;

import controllers.AuthController;
import views.LoginView;
import views.RegisterView;
import repository.FilePersistence;
import models.Usuario;
import java.util.List;

public class main {
    public static void main(String[] args) {
        FilePersistence persistence = new FilePersistence();
        List<Usuario> usuarios = persistence.cargarDatos();
        
        LoginView loginView = new LoginView();
        RegisterView registerView = new RegisterView();
        
        // Inyectamos usuarios y persistencia al controlador de autenticación
        new AuthController(loginView, registerView, usuarios, persistence);
        
        loginView.setVisible(true);
    }
}