package Views;

import Model.DatabaseModel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Created by Edgaras on 16/08/2016.
 */
public class AddNewUserView {

    Label newUserInformationLabel;
    Label nameLabel;
    Label surnameLabel;
    Label userNameLabel;
    Label passwordLabel;
    Label repeatPasswordLabel;

    TextField nameTextField;
    TextField surnameTextField;
    TextField userNameTextField;
    TextField passwordTextField;
    TextField repeatPasswordTextField;

    Button addButton;
    Button goBackButton;

    Scene addNewUserViewScene;

    HBox hBox1,hBox2,hBox3, hBox4, hBox5, hBox6, hBox7;
    VBox vBox1,vBox2, vBox3;


    DatabaseModel databaseModel = new DatabaseModel();
    StartMenuView startMenuView;



    public Scene getAddNewUserViewScene()
    {
        //labels
        newUserInformationLabel = new Label("New user information");
        newUserInformationLabel.setMinSize(180, 110);
        newUserInformationLabel.setFont(Font.font ("Dialog", 40));
        newUserInformationLabel.setPadding(new Insets(10, 10, 10, 37));

        nameLabel = new Label("Name");
        nameLabel.setMinSize(130, 40);
        nameLabel.setFont(Font.font ("Serif", 20));
        nameLabel.setPadding(new Insets(10, 10, 10, 37));

        surnameLabel = new Label("Surname");
        surnameLabel.setMinSize(130, 40);
        surnameLabel.setFont(Font.font ("Serif", 20));
        surnameLabel.setPadding(new Insets(10, 10, 10, 37));

        userNameLabel = new Label("User Name");
        userNameLabel.setMinSize(130, 40);
        userNameLabel.setFont(Font.font ("Serif", 20));
        userNameLabel.setPadding(new Insets(10, 10, 10, 37));

        passwordLabel = new Label("Password");
        passwordLabel.setMinSize(130, 40);
        passwordLabel.setFont(Font.font ("Serif", 20));
        passwordLabel.setPadding(new Insets(10, 10, 10, 37));

        repeatPasswordLabel = new Label("Repeat password");
        repeatPasswordLabel.setMinSize(130, 40);
        repeatPasswordLabel.setFont(Font.font ("Serif", 20));
        repeatPasswordLabel.setPadding(new Insets(10, 10, 10, 37));

        //text fields
        nameTextField = new TextField();
        nameTextField.setMinSize(200, 40);
        nameTextField.setMaxSize(200, 40);
        nameTextField.setFont(Font.font ("Serif", 20));

        surnameTextField = new TextField();
        surnameTextField.setMinSize(200, 40);
        surnameTextField.setMaxSize(200, 40);
        surnameTextField.setFont(Font.font ("Serif", 20));

        userNameTextField = new TextField();
        userNameTextField.setMinSize(200, 40);
        userNameTextField.setMaxSize(200, 40);
        userNameTextField.setFont(Font.font ("Serif", 20));

        passwordTextField = new TextField();
        passwordTextField.setMinSize(200, 40);
        passwordTextField.setMaxSize(200, 40);
        passwordTextField.setFont(Font.font ("Serif", 20));

        repeatPasswordTextField = new TextField();
        repeatPasswordTextField.setMinSize(200, 40);
        repeatPasswordTextField.setMaxSize(200, 40);
        repeatPasswordTextField.setFont(Font.font ("Serif", 20));

        //buttons
        addButton = new Button("Add");
        addButton.setMinSize(200, 50);
        addButton.setFont(Font.font ("Serif", 30));
        addButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        addButton.setOnAction(event -> {
            String name = nameTextField.getText();
            String surname = surnameTextField.getText();
            String userName = userNameTextField.getText();
            String password = passwordTextField.getText();

            databaseModel.addNewUser(userName, password, name, surname);
            startMenuView = new StartMenuView();
            startMenuView.setStartMenuViewToMainStage();

        });
        goBackButton = new Button("Go Back");
        goBackButton.setMinSize(200, 50);
        goBackButton.setFont(Font.font ("Serif", 30));
        goBackButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        goBackButton.setOnAction(event -> {
            startMenuView = new StartMenuView();
            startMenuView.setStartMenuViewToMainStage();
        });

        hBox1 = new HBox();
        hBox1.getChildren().addAll(newUserInformationLabel);
        vBox2 = new VBox();
        vBox2.getChildren().addAll(nameLabel, surnameLabel, userNameLabel, passwordLabel, repeatPasswordLabel);
        vBox3 = new VBox();
        vBox3.getChildren().addAll(nameTextField, surnameTextField, userNameTextField, passwordTextField, repeatPasswordTextField);
        hBox2 = new HBox();
        hBox2.getChildren().addAll(vBox2, vBox3);

        hBox7 = new HBox();
        hBox7.getChildren().addAll(addButton, goBackButton);

        vBox1 = new VBox();
        vBox1.getChildren().addAll(hBox1, hBox2, hBox7);
        vBox1.setStyle("-fx-background-color: yellowgreen");

        addNewUserViewScene = new Scene(vBox1, 410, 500);

        return addNewUserViewScene;
    }
}
