package com.example.test1b;

import com.example.test1b.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label nameLabel;

    @FXML
    private Label validationLabel;

    private final Model model = new Model();

    @FXML
    private void initialize() {
        nameLabel.setText("Aditi Thapa");
    }

    @FXML
    private void handleLoginButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            validationLabel.setTextFill(Color.RED);
            validationLabel.setText("Please Provide Username or Password.");
        } else {
            if (model.isAccountLocked()) {
                validationLabel.setTextFill(Color.RED);
                validationLabel.setText("Sorry, Your Account is Locked!!!");
            } else if (model.validate(username, password)) {
                validationLabel.setTextFill(Color.GREEN);
                validationLabel.setText("Logged in successfully");
            } else {
                validationLabel.setTextFill(Color.RED);
                validationLabel.setText("Sorry, Invalid Username or Password. Attempt " + model.getInvalidAttempts() + " of " + Model.getMaxAttempts());
            }
        }
    }





}