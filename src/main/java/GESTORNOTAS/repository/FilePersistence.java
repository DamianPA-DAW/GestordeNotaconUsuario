package repository;

import models.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilePersistence {
    private final String RUTA_ARCHIVO = "usuarios.dat";

    public void guardarDatos(List<Usuario> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> cargarDatos() {
        File file = new File(RUTA_ARCHIVO);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO))) {
            return (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}