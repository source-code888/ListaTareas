package main.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class Consult {

    protected File file;
    protected ObjectOutputStream objectOutputStream;
    protected ObjectInputStream objectInputStream;
    protected String fileName;

    public Consult(String fileName) {
        this.fileName = fileName;
    }

    public void insert(List<Object> objects) {
        try {
            openOutputStream();
            for (Object object : objects) {
                objectOutputStream.writeObject(object);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeOutputStream();
        }
    }

    public Consult() {

    }

    protected abstract void createFile(String name);

    protected abstract void addDefault();

    protected void openOutputStream() {
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected void openInputStream() {
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    protected void closeOutputStream() {
        if (objectOutputStream != null) {
            try {
                objectOutputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    protected void closeInputStream() {
        if (objectInputStream != null) {
            try {
                objectInputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    public List<Object> getListObjects() {
        List<Object> objects = new ArrayList<>();
        Object object;
        try {
            openInputStream();
            while (objectInputStream != null) {
                object = objectInputStream.readObject();
                if (object != null) {
                    objects.add(object);
                }
            }
        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } finally {
            closeInputStream();
        }
        return objects;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        createFile(fileName);
        this.fileName = fileName;
    }
}
