package main;

import main.view.Login;

public class Aplicacion {

    public static void main(String[] args) {
        Login login = new Login();
        login.setTitle("Iniciar sesion");
        login.setLocationRelativeTo(login);
        login.setResizable(false);
        login.setVisible(true);
    }
}
