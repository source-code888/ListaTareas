package main.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import main.model.UsuarioDAO;
import main.model.UsuarioDTO;
import main.view.Login;
import main.view.Principal;

public class LoginController implements ActionListener, KeyListener, FocusListener {

    private Login login;
    private JTextField txtNombre;
    private JPasswordField pwdPassword;
    private List<JLabel> labels;
    private UsuarioDAO usuarioDAO;

    public LoginController(Login login, JTextField txtNombre, JPasswordField pwdPassword, List<JLabel> labels) {
        this.login = login;
        this.txtNombre = txtNombre;
        this.pwdPassword = pwdPassword;
        this.labels = labels;
        usuarioDAO = new UsuarioDAO("usuarios.ser");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JButton) {
            JButton btn = (JButton) obj;
            if (btn.getText().equals("Aceptar")) {
                if (txtNombre.getText().isBlank() && String.valueOf(pwdPassword.getPassword()).isBlank()) {
                    labels.get(0).setText("Ingresa un usuario valido");
                    labels.get(1).setText("Ingresa una contraseña valida");
                    labels.get(1).setForeground(Color.red);
                    labels.get(0).setForeground(Color.red);
                } else if (txtNombre.getText().isBlank()) {
                    labels.get(0).setText("Ingresa un usuario valido");
                    labels.get(0).setForeground(Color.red);
                } else if (String.valueOf(pwdPassword.getPassword()).isBlank()) {
                    labels.get(1).setText("Ingresa una contraseña valida");
                    labels.get(1).setForeground(Color.red);
                } else {
                    List<UsuarioDTO> usuarios = usuarioDAO.getList();
                    String userName = txtNombre.getText();
                    String password = String.valueOf(pwdPassword.getPassword());
                    int count = usuarios.stream().
                            filter(usuario -> usuario.getUserName().equals(userName) && usuario.getPassword().equals(password)).
                            collect(Collectors.toList()).size();
                    if (count == 1) {
                        txtNombre.setText("");
                        pwdPassword.setText("");
                        Principal principal = new Principal();
                        principal.setTitle("Vista principal");
                        principal.setLocationRelativeTo(principal);
                        principal.setResizable(false);
                        principal.setVisible(true);
                        this.login.dispose();
                    } else {

                    }
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JPasswordField) {
            JPasswordField pwd = (JPasswordField) obj;
            if (pwd.equals(pwdPassword)) {
                if (String.valueOf(pwdPassword.getPassword()).length() > 8) {
                    e.consume();
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTextField) {
            JTextField txt = (JTextField) obj;
            if (txt.equals(txtNombre)) {
                if (!txtNombre.getText().isBlank()) {
                    labels.get(0).setText("Usuario");
                    labels.get(0).setForeground(Color.black);
                } else {
                    labels.get(0).setText("Ingresa tu nombre de usuario");
                    labels.get(0).setForeground(Color.red);
                }

            }
        }
        if (obj instanceof JPasswordField) {
            JPasswordField pwd = (JPasswordField) obj;
            if (pwd.equals(pwdPassword)) {
                if (!String.valueOf(pwdPassword.getPassword()).isBlank()) {
                    labels.get(1).setText("Contraseña");
                    labels.get(1).setForeground(Color.black);
                } else {
                    labels.get(1).setText("Ingresa tu ncontraseña");
                    labels.get(1).setForeground(Color.red);
                }
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTextField) {
            JTextField txt = (JTextField) obj;
            if (txt.equals(txtNombre)) {
                if (txtNombre.getText().isBlank()) {
                    labels.get(0).setText("Ingresa tu nombre de usuario");
                    labels.get(0).setForeground(Color.red);
                }
            }
        }
        if (obj instanceof JPasswordField) {
            JPasswordField pwd = (JPasswordField) obj;
            if (pwd.equals(pwdPassword)) {
                if (String.valueOf(pwdPassword.getPassword()).isBlank()) {
                    labels.get(1).setText("Ingresa tu ncontraseña");
                    labels.get(1).setForeground(Color.red);
                }
            }
        }
    }
}
