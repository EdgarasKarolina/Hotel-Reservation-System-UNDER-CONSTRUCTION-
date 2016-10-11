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
 * Created by Edgaras on 18/08/2016.
 */
public class AddNewRoomView {

   // Label nameOfAppartmentLabel;
    Label appartmentNameLabel;
    Label numberOfRoomsLabel;
    Label numberOfPeopleLabel;
    Label whichFloorLabel;
    Label sizeLabel;
    Label roomInfoLabel;

 //   TextField nameOfAppartmentTextField;
    TextField appartmentNameTextField;
    TextField numberOfRoomsTextField;
    TextField numberOfPeopleTextField;
    TextField whichFloorTextField;
    TextField sizeTextField;
    TextField roomInfoTextField;

    Button addNewRoomButton;
    Button goBackButton;

    VBox vBox, vBox2, vBox3;
    HBox hBox1, hBox2;

    Scene addNewRoomScene;

    DatabaseModel databaseModel = new DatabaseModel();
    StartMenuView startMenuView = new StartMenuView();
    AvailabilityView availabilityView = new AvailabilityView();

    public Scene getAddNewRoomScene()
    {
      //  nameOfAppartmentLabel = new Label("Name of appartment");
        appartmentNameLabel = new Label("Appartment name");
        appartmentNameLabel.setMinSize(130, 40);
        appartmentNameLabel.setFont(Font.font ("Serif", 20));
        appartmentNameLabel.setPadding(new Insets(10, 10, 10, 37));

        numberOfRoomsLabel = new Label("Number of rooms");
        numberOfRoomsLabel.setMinSize(130, 40);
        numberOfRoomsLabel.setFont(Font.font ("Serif", 20));
        numberOfRoomsLabel.setPadding(new Insets(10, 10, 10, 37));

        numberOfPeopleLabel = new Label("Max number of people");
        numberOfPeopleLabel.setMinSize(130, 40);
        numberOfPeopleLabel.setFont(Font.font ("Serif", 20));
        numberOfPeopleLabel.setPadding(new Insets(10, 10, 10, 37));

        whichFloorLabel = new Label("Which floor");
        whichFloorLabel.setMinSize(130, 40);
        whichFloorLabel.setFont(Font.font ("Serif", 20));
        whichFloorLabel.setPadding(new Insets(10, 10, 10, 37));

        sizeLabel = new Label("Size");
        sizeLabel.setMinSize(130, 40);
        sizeLabel.setFont(Font.font ("Serif", 20));
        sizeLabel.setPadding(new Insets(10, 10, 10, 37));

        roomInfoLabel = new Label("Room info");
        roomInfoLabel.setMinSize(130, 40);
        roomInfoLabel.setFont(Font.font ("Serif", 20));
        roomInfoLabel.setPadding(new Insets(10, 10, 10, 37));

        //nameOfAppartmentTextField = new TextField();
        appartmentNameTextField = new TextField();
        appartmentNameTextField.setMinSize(200, 40);
        appartmentNameTextField.setMaxSize(200, 40);
        appartmentNameTextField.setFont(Font.font ("Serif", 20));

        numberOfRoomsTextField = new TextField();
        numberOfRoomsTextField.setMinSize(200, 40);
        numberOfRoomsTextField.setMaxSize(200, 40);
        numberOfRoomsTextField.setFont(Font.font ("Serif", 20));

        numberOfPeopleTextField = new TextField();
        numberOfPeopleTextField.setMinSize(200, 40);
        numberOfPeopleTextField.setMaxSize(200, 40);
        numberOfPeopleTextField.setFont(Font.font ("Serif", 20));

        whichFloorTextField = new TextField();
        whichFloorTextField.setMinSize(200, 40);
        whichFloorTextField.setMaxSize(200, 40);
        whichFloorTextField.setFont(Font.font ("Serif", 20));

        sizeTextField = new TextField();
        sizeTextField.setMinSize(200, 40);
        sizeTextField.setMaxSize(200, 40);
        sizeTextField.setFont(Font.font ("Serif", 20));

        roomInfoTextField = new TextField();
        roomInfoTextField.setMinSize(200, 40);
        roomInfoTextField.setMaxSize(200, 40);
        roomInfoTextField.setFont(Font.font ("Serif", 20));

        addNewRoomButton = new Button("Add room");
        addNewRoomButton.setMinSize(200, 50);
        addNewRoomButton.setFont(Font.font ("Serif", 30));
        addNewRoomButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        addNewRoomButton.setOnAction(event -> {
            String appartmentName = appartmentNameTextField.getText();
            int numberOfRooms = Integer.parseInt(numberOfRoomsTextField.getText());
            int maxNumberOfPeople = Integer.parseInt(numberOfPeopleTextField.getText());
            int whichFloor = Integer.parseInt(whichFloorTextField.getText());
            int size = Integer.parseInt(sizeTextField.getText());
            String roomInfo = roomInfoTextField.getText();

            databaseModel.addNewAppartment(appartmentName, numberOfRooms, maxNumberOfPeople, whichFloor,
                    size, roomInfo);

        });
        goBackButton = new Button("Go Back");
        goBackButton.setMinSize(200, 50);
        goBackButton.setFont(Font.font ("Serif", 30));
        goBackButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        goBackButton.setOnAction(event -> {
            startMenuView.setSceneToMainStage(availabilityView.getAvailabilityViewScene());
        });

        vBox2 = new VBox();
        vBox2.getChildren().addAll(appartmentNameLabel, numberOfRoomsLabel, numberOfPeopleLabel,
                whichFloorLabel, sizeLabel, roomInfoLabel);
        vBox3 = new VBox();
        vBox3.getChildren().addAll(appartmentNameTextField, numberOfRoomsTextField, numberOfPeopleTextField,
                whichFloorTextField, sizeTextField, roomInfoTextField);
        hBox1 = new HBox();
        hBox1.getChildren().addAll(vBox2, vBox3);
        hBox2 = new HBox();
        hBox2.getChildren().addAll(addNewRoomButton, goBackButton);

        vBox = new VBox();
        vBox.getChildren().addAll(hBox1, hBox2);
        vBox.setStyle("-fx-background-color: yellowgreen");

        addNewRoomScene = new Scene(vBox, 450, 300);

        return addNewRoomScene;



    }
}
