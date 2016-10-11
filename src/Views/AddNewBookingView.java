package Views;

import Model.DatabaseModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.Date;

import static Views.AvailabilityView.bookings;

/**
 * Created by Edgaras on 23/08/2016.
 */
public class AddNewBookingView {

    Label clientsNameLabel;
    Label clientsSurnameLabel;
    Label clientsPhoneNumberLabel;
    Label clientsEmailLabel;

    TextField clientsNameTextField;
    TextField clientsSurnameTextField;
    TextField clientsPhoneNumberTextField;
    TextField clientsEmailTextField;

    Button addButton;
    Button backButton;

    HBox hBox1, hBox2, hBox3, hBox4, hBox5;
    VBox vBox1;


    Scene addNewBookingScene;
    Stage addNewBookingStage;



    AvailabilityView availabilityView = new AvailabilityView() ;
    DatabaseModel databaseModel = new DatabaseModel();



    public Stage getAddNewBookingScene()
    {
        clientsNameLabel = new Label("Client's name");
        clientsNameLabel.setMinSize(130, 40);
        clientsNameLabel.setFont(Font.font ("Serif", 20));
        clientsNameLabel.setPadding(new Insets(10, 10, 10, 37));

        clientsSurnameLabel = new Label("Clients surname");
        clientsSurnameLabel.setMinSize(130, 40);
        clientsSurnameLabel.setFont(Font.font ("Serif", 20));
        clientsSurnameLabel.setPadding(new Insets(10, 10, 10, 37));

        clientsPhoneNumberLabel = new Label("Phone number");
        clientsPhoneNumberLabel.setMinSize(130, 40);
        clientsPhoneNumberLabel.setFont(Font.font ("Serif", 20));
        clientsPhoneNumberLabel.setPadding(new Insets(10, 10, 10, 37));

        clientsEmailLabel = new Label("Emails");
        clientsEmailLabel.setMinSize(130, 40);
        clientsEmailLabel.setFont(Font.font ("Serif", 20));
        clientsEmailLabel.setPadding(new Insets(10, 10, 10, 37));

        clientsNameTextField = new TextField();
        clientsNameTextField.setMinSize(200, 40);
        clientsNameTextField.setMaxSize(200, 40);
        clientsNameTextField.setFont(Font.font ("Serif", 20));

        clientsSurnameTextField = new TextField();
        clientsSurnameTextField.setMinSize(200, 40);
        clientsSurnameTextField.setMaxSize(200, 40);
        clientsSurnameTextField.setFont(Font.font ("Serif", 20));

        clientsPhoneNumberTextField = new TextField();
        clientsPhoneNumberTextField.setMinSize(200, 40);
        clientsPhoneNumberTextField.setMaxSize(200, 40);
        clientsPhoneNumberTextField.setFont(Font.font ("Serif", 20));

        clientsEmailTextField = new TextField();
        clientsEmailTextField.setMinSize(200, 40);
        clientsEmailTextField.setMaxSize(200, 40);
        clientsEmailTextField.setFont(Font.font ("Serif", 20));

        addButton = new Button("Add booking");
        addButton.setMinSize(200, 50);
        addButton.setFont(Font.font ("Serif", 30));
        addButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        addButton.setOnAction(event -> {
            String clientsName = clientsNameTextField.getText();
            String clientsSurname = clientsSurnameTextField.getText();
            String phoneNumber = clientsPhoneNumberTextField.getText();
            String email = clientsEmailTextField.getText();
            Integer bet = new Integer(availabilityView.getWhatIsSelectedFromCombobox());
            int bet2 = bet.intValue();

           // availabilityView = new AvailabilityView();
            System.out.println(bookings.size());
            for (int i = 0; i < bookings.size(); i++) {
                databaseModel.addBooking(clientsName, clientsSurname, phoneNumber, email,
                        bookings.get(i).getDate(),  bookings.get(i).getAppartmentId());
            }


            // availabilityView.updateButtons(whatIsSelected);
            System.out.println("what is selected " + bet2);
           // addNewBookingStage.close();

        });
        backButton = new Button("Back");
        backButton.setMinSize(200, 50);
        backButton.setFont(Font.font ("Serif", 30));
        backButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");

        hBox1 = new HBox();
        hBox1.getChildren().addAll(clientsNameLabel, clientsNameTextField);
        hBox2 = new HBox();
        hBox2.getChildren().addAll(clientsPhoneNumberLabel, clientsPhoneNumberTextField);
        hBox3 = new HBox();
        hBox3.getChildren().addAll(clientsEmailLabel, clientsEmailTextField);
        hBox4 = new HBox();
        hBox4.getChildren().addAll(addButton, backButton);
        hBox5 = new HBox();
        hBox5.getChildren().addAll(clientsSurnameLabel, clientsSurnameTextField);

        vBox1 = new VBox();
        vBox1.getChildren().addAll(hBox1, hBox5, hBox2, hBox3, hBox4);



        addNewBookingScene = new Scene(vBox1, 400, 300);
        addNewBookingStage = new Stage();
        addNewBookingStage.setScene(addNewBookingScene);
        addNewBookingStage.show();

        return addNewBookingStage;

    }

  /*  public int getNumber()
    {
        int number = availabilityView.getWhatIsSelectedFromCombobox();
        return number;

    } */

}
