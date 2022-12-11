package main.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends Consult {

    @Override
    protected void addDefault() {
        openOutputStream();
        UsuarioDTO usuario = new UsuarioDTO(0, "Admin", "12345678", "ju301202@gmail.com", "989199291");
        try {
            objectOutputStream.writeObject(usuario);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeOutputStream();
        }
    }

    @Override
    protected void createFile(String name) {
        file = new File(name);
        if (!file.exists()) {
            try {
                file.createNewFile();
                addDefault();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    public UsuarioDAO(String fileName) {
        super(fileName);
        createFile(fileName);
    }

    public List<UsuarioDTO> getList() {
        List<UsuarioDTO> usuarios = new ArrayList<>();
        for (Object o : getListObjects()) {
            if (o instanceof UsuarioDTO usuario) {
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

}
