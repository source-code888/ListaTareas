package main.model;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

    private int id;
    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;
    private String email;
    private String numberPhone;

    public UsuarioDTO(int id, String userName, String password, String email, String numberPhone) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.numberPhone = numberPhone;
    }

    public UsuarioDTO(String userName, String password, String email, String numberPhone) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.numberPhone = numberPhone;
    }

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id, String email, String numberPhone) {
        this.id = id;
        this.email = email;
        this.numberPhone = numberPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + ", numberPhone=" + numberPhone + '}';
    }

}
