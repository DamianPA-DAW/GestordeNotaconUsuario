package repository;

import models.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NotaRepository{
    private final String FILE_PATH = "usuarios.dat";

    public void guardarUsuario(List<Usuario> usuarios){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
            oos.writeObject(usuarios);
        } catch (IOException e){
            System.out.println("Error al guardar los usuarios: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public List<Usuario> cargarUsuarios(){
        File file = new File(FILE_PATH);
        if(!file.exists()){
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))){
            return (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Error al cargar los usuarios: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}