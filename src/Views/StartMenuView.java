package Views;

import Model.DatabaseModel;
import Objects.User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by Edgaras on 16/08/2016.
 */
public class StartMenuView extends Application {

    static Stage mainStage;
    Scene startMenuViewScene;

    Label hotelReservationLabel;
    Label userNameLabel;
    Label passwordLabel;

    TextField userNameTextField;
    TextField passwordTextField;

    Button signInButton;
    Button addNewUserButton;
    Button exitButton;

    VBox vBox1, vBox2, vBox3;

    HBox hBox1;
    HBox hBox2;
    HBox hBox3;




    AddNewUserView addNewUserView = new AddNewUserView();
    AvailabilityView availabilityView = new AvailabilityView();
    public static User user;
    DatabaseModel databaseModel;



    @Override
    public void start(Stage primaryStage) throws Exception {

        mainStage = new Stage();
        mainStage.setScene(getStartMenuViewScene());
        mainStage.show();

    }

    public Scene getStartMenuViewScene()
    {
        //labels
        hotelReservationLabel = new Label("Room Reservation");
        hotelReservationLabel.setMinSize(200, 110);
        hotelReservationLabel.setFont(Font.font ("Dialog", 40));
        hotelReservationLabel.setPadding(new Insets(10, 10, 10, 37));

        userNameLabel = new Label("User Name");
        userNameLabel.setMinSize(130, 40);
        userNameLabel.setFont(Font.font ("Serif", 20));
        userNameLabel.setPadding(new Insets(10, 10, 10, 57));

        passwordLabel = new Label("Password");
        passwordLabel.setMinSize(130, 40);
        passwordLabel.setFont(Font.font ("Serif", 20));
        passwordLabel.setPadding(new Insets(10, 10, 10, 57));

        //text fields
        userNameTextField = new TextField();
        userNameTextField.setMinSize(130, 40);
        userNameTextField.setMaxSize(130, 40);
        userNameTextField.setFont(Font.font ("Serif", 20));

        passwordTextField = new TextField();
        passwordTextField.setMinSize(130, 40);
        passwordTextField.setMaxSize(130, 40);
        passwordTextField.setFont(Font.font ("Serif", 20));

        //buttons
        signInButton = new Button("Sign in");
        signInButton.setMinSize(130, 40);
        signInButton.setFont(Font.font ("Serif", 20));
        signInButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        signInButton.setOnAction(event -> {
            databaseModel = new DatabaseModel();
            String userName = userNameTextField.getText();
            String password = passwordTextField.getText();

            user = databaseModel.retrieveUserIfAllowedToLogIn(userName, password);

            if (user == null)
            {
                System.out.println("sorry");

            }

            else {

               mainStage.setScene(availabilityView.getAvailabilityViewScene());

            }
        });
        addNewUserButton = new Button("Add new user");
        addNewUserButton.setMinSize(130, 40);
        addNewUserButton.setFont(Font.font ("Serif", 20));
        addNewUserButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        addNewUserButton.setOnAction(event -> {
        mainStage.setScene(addNewUserView.getAddNewUserViewScene());
        });

        exitButton = new Button("Exit");
        exitButton.setMinSize(130, 40);
        exitButton.setFont(Font.font ("Serif", 20));
        exitButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        exitButton.setOnAction(event -> System.exit(1));

        //hbox
        hBox1 = new HBox();
        hBox1.getChildren().addAll(hotelReservationLabel);
        vBox2 = new VBox();
        vBox2.getChildren().addAll(userNameLabel, passwordLabel);
        vBox3 = new VBox();
        vBox3.getChildren().addAll(userNameTextField, passwordTextField);
        hBox2 = new HBox();
        hBox2.getChildren().addAll(vBox2, vBox3);
        hBox3 = new HBox();
        hBox3.getChildren().addAll(signInButton, addNewUserButton, exitButton);

        //vbox
        vBox1 = new VBox();
        vBox1.getChildren().addAll(hBox1, hBox2, hBox3);
        vBox1.setStyle("-fx-background-color: yellowgreen");


        //scene
        startMenuViewScene = new Scene(vBox1, 404, 400);

        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(20);

        return startMenuViewScene;

    }

    public void setStartMenuViewToMainStage()
    {
        mainStage.setScene(getStartMenuViewScene());
    }

    public void setSceneToMainStage(Scene scene)
    {
        mainStage.setScene(scene);
    }
}
