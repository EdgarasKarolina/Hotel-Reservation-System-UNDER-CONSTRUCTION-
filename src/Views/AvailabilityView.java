package Views;

import Model.DatabaseModel;
import Objects.Booking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 * Created by Edgaras on 17/08/2016.
 */
public class AvailabilityView {

    //this is for the left side of the view
    ComboBox typeOfRoomComboBox = new ComboBox();
    Button searchButton;
    Button addNewRoomButton;
    Button makeBookingButton;
    Button changeBookingInfoButton;
    Button decrementByOneButton;
    Button incrementByOneButton;
    Label weekLabel;
    HBox bottomHBox;
    HBox hBox1;

    TableView<Booking> bookingsTableView;

    Calendar cal;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    int weekOfYear;

    ArrayList<Label> labels = new ArrayList<>();
    static ArrayList<Button> buttons = new ArrayList<>();
   static ArrayList<Booking> bookings = new ArrayList<>();

    int[] weekDays = {2, 3, 4, 5, 6, 7, 1}; // because Sunday has number 1, we swap Monday(2) on that place - project requirements

    BorderPane borderPane = new BorderPane();
    //here we will put buttons for the 'calender'
    GridPane gridPane = new GridPane();
    GridPane gridPane1 = new GridPane();

    Scene availabilityViewScene;

    StartMenuView startMenuView;
    AddNewRoomView addNewRoomView;
    AddNewBookingView addNewBookingView;

    DatabaseModel databaseModel = new DatabaseModel();

    public Scene getAvailabilityViewScene() {

        bookingsTableView = new TableView();

        TableColumn appartmentNameCol = new TableColumn("Appartment name");
        appartmentNameCol.setCellValueFactory(new PropertyValueFactory<Booking, String>("appartmentName"));
        appartmentNameCol.setMinWidth(150);
        appartmentNameCol.setMaxWidth(150);


        TableColumn dateCol = new TableColumn("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<Booking, Date>("date"));
        dateCol.setMinWidth(80);
        dateCol.setMaxWidth(80);


        bookingsTableView.getColumns().setAll(appartmentNameCol, dateCol);

        //tableView.setPrefWidth(300);
        bookingsTableView.setMaxWidth(550);


        bookingsTableView.setPrefHeight(300);

        bookingsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);





        cal = Calendar.getInstance();  // getting the current date
        cal.setFirstDayOfWeek(Calendar.MONDAY); // setting the Monday to be the first day of the week instead of Sunday
        weekOfYear = cal.get(Calendar.WEEK_OF_YEAR); // getting the current week number

        hBox1 = new HBox();
        decrementByOneButton = new Button("<");
        decrementByOneButton.setMinSize(130, 40);
        decrementByOneButton.setFont(Font.font ("Serif", 20));
        decrementByOneButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        decrementByOneButton.setOnAction(event -> {
            Integer o = (Integer) typeOfRoomComboBox.getSelectionModel().getSelectedItem();
            int birtday = o.intValue();
            if (weekOfYear < 52) {  // checking if the week is smaller than 52
                weekOfYear = weekOfYear - 1;// incrementing the week of the year
                updateDateLabels(labels); // updating the date labels
                updateButtons(birtday);// updating the button information
            }
        });
        incrementByOneButton = new Button(">");
        incrementByOneButton.setMinSize(130, 40);
        incrementByOneButton.setFont(Font.font ("Serif", 20));
        incrementByOneButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        incrementByOneButton.setOnAction(event -> {
            Integer o = (Integer) typeOfRoomComboBox.getSelectionModel().getSelectedItem();
            int birtday = o.intValue();
            if (weekOfYear < 52) {  // checking if the week is smaller than 52
                weekOfYear = weekOfYear + 1;// incrementing the week of the year
                updateDateLabels(labels); // updating the date labels
                updateButtons(birtday);// updating the button information
                System.out.println( " what is selected " + getWhatIsSelectedFromCombobox());
            }
        });

        weekLabel = new Label("WEEK: " + weekOfYear);
        weekLabel.setMinSize(130, 40);
        weekLabel.setFont(Font.font ("Serif", 20));
        weekLabel.setPadding(new Insets(0, 10, 0, 17));

        hBox1.getChildren().addAll(decrementByOneButton, weekLabel, incrementByOneButton);
       // gridPane1.setConstraints(hBox1, 3, 1, 3, 2, HPos.CENTER, VPos.CENTER);

        gridPane1.getChildren().add(hBox1);
        gridPane1.setAlignment(Pos.TOP_CENTER);

        //this is for the left side of the view
        //populating combobox with the list of how many rooms do the appartments have
        ObservableList<Integer> listOfNumberOfRooms = FXCollections.observableArrayList();
        listOfNumberOfRooms.addAll(databaseModel.getListOfNumberOfRooms());
        typeOfRoomComboBox.setItems(listOfNumberOfRooms);
        typeOfRoomComboBox.setMinSize(180, 50);
        typeOfRoomComboBox.setMaxSize(180, 50);
        typeOfRoomComboBox.setStyle("-fx-font-size: 100px");
        typeOfRoomComboBox.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        typeOfRoomComboBox.getSelectionModel().selectFirst();
        typeOfRoomComboBox.setOnAction(event -> {

            Integer o = (Integer) typeOfRoomComboBox.getSelectionModel().getSelectedItem();
            int birtday = o.intValue();
            buttons.clear();
            gridPane.getChildren().clear();
            labels.clear();
            createLabels();
            createButtons(birtday);
           // createNamesOfAllAppartments(o);
            System.out.println(buttons.size());

        });

        searchButton = new Button("Search");
        searchButton.setMinSize(180, 50);
        searchButton.setMaxSize(180, 50);
        searchButton.setFont(Font.font ("Serif", 20));
        searchButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");

        addNewRoomButton = new Button("Add new Room");
        addNewRoomButton.setMinSize(180, 50);
        addNewRoomButton.setMaxSize(180, 50);
        addNewRoomButton.setFont(Font.font ("Serif", 20));
        addNewRoomButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        addNewRoomButton.setOnAction(event -> {
            startMenuView = new StartMenuView();
            addNewRoomView = new AddNewRoomView();
            startMenuView.setSceneToMainStage(addNewRoomView.getAddNewRoomScene());
        });

        makeBookingButton = new Button("Make a booking");
        makeBookingButton.setMinSize(180, 50);
        makeBookingButton.setMaxSize(180, 50);
        makeBookingButton.setFont(Font.font ("Serif", 20));
        makeBookingButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        makeBookingButton.setOnAction(event -> {
        //    for (int i = 0; i < bookings.size(); i++) {
          //      databaseModel.addBooking(bookings.get(i).getDate(), 0, bookings.get(i).getAppartmentId());
          //  }
            getWhatIsSelectedFromCombobox();
            addNewBookingView = new AddNewBookingView();
            addNewBookingView.getAddNewBookingScene();

        });

        changeBookingInfoButton = new Button("Change booking");
        changeBookingInfoButton.setMinSize(180, 50);
        changeBookingInfoButton.setMaxSize(180, 50);
        changeBookingInfoButton.setFont(Font.font ("Serif", 20));
        changeBookingInfoButton.setStyle("-fx-effect: dropshadow(one-pass-box, black, 15 , 0.0 , 2 , 0)");
        changeBookingInfoButton.setOnAction(event -> {
            System.out.println(databaseModel.getListOfNumberOfRooms());
        });
        bottomHBox = new HBox();
        bottomHBox.getChildren().addAll(typeOfRoomComboBox, searchButton, addNewRoomButton, makeBookingButton,
                changeBookingInfoButton);
        bottomHBox.setPadding(new Insets(0, 0, 0, 0));

      //  leftSideVBox = new VBox();
      //  leftSideVBox.getChildren().addAll(typeOfRoomComboBox, searchButton, addNewRoomButton, makeBookingButton, changeBookingInfoButton);
      //  leftSideVBox.setPadding(new Insets(20, 0, 0, 0));

        //  addAppartmentNames();
        createLabels();  // CREATING LABELS AND SETTING THEM TO GRID AT ROW 1 POSITIONS 1-7
        createButtons(1);
       // createNamesOfAllAppartments(1);

        //  borderPane = new BorderPane();
      //  borderPane.setLeft(leftSideVBox);
        borderPane.setTop(gridPane1);
        borderPane.setBottom(bottomHBox);
        borderPane.setRight(bookingsTableView);

        availabilityViewScene = new Scene(borderPane, 1300, 500);

        return availabilityViewScene;
    }


    public void createButtons(int numberOfRooms) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> listOfRoomNames = new ArrayList<>();

        list = getIdOfAllAppartments(numberOfRooms);
        listOfRoomNames = getNamesOfAllAppartments(numberOfRooms);


        System.out.println(listOfRoomNames);

        for (int j = 0; j < list.size(); j++) {
            String appartmentName = listOfRoomNames.get(j);
                // System.out.println(databaseModel.getListOfAppartments(1).get(j).getAppartmentName());
                for (int i = 0; i < 7; i++) {
                    String dates = labels.get(i).getText();
                    String id = dates; // creating buttons Id
                    Button button = new Button();

                   // button.setMaxWidth(Double.MAX_VALUE);
                  //  button.setMaxHeight(Double.MAX_VALUE);
                    button.setMinSize(130, 40);
                    button.setMaxSize(130, 40);
                    button.setId(id);
                    button.setText(appartmentName);
                    Date sqlDate = Date.valueOf(dates); // asigning a date of sql type Date


                    boolean booked = databaseModel.ifAvailable(sqlDate, list.get(j));
                    int number;
                    number = list.get(j);

                    //  boolean booked2 =

                    if (booked == true) {

                        button.setStyle("-fx-base: #00b300"); // green
                    }

                    buttons.add(button);
                    button.setOnAction(event -> {

                        button.setStyle("-fx-base: #FFFF00");
                        String name = button.getText();
                        System.out.println(name);
                        Booking booking = new Booking(name, sqlDate, number);
                        bookings.add(booking);

                        ObservableList<Booking> data = FXCollections.observableList(bookings);
                        bookingsTableView.setItems(data);



                    });
                    gridPane.getChildren().add(button);
                    gridPane.setConstraints(button, i + 10, j + 4);
                    borderPane.setCenter(gridPane);
                    gridPane.setPadding(new Insets(30,30,30,30));
                }

            }
        }



    public void createLabels() {


        for (int i = 0; i < 7; i++) {    // 7 times we create a label, from Monday label to Sunday label

            cal.set(Calendar.WEEK_OF_YEAR, cal.get(Calendar.WEEK_OF_YEAR)); // setting a calendar to a desired week
            cal.set(Calendar.DAY_OF_WEEK, weekDays[i]);

            String date = simpleDateFormat.format(cal.getTime());// labels Id format (date)
            Label label = new Label(); // creating a label for a date
            label.setText(date);// setting date to label
            label.setStyle("-fx-font-size: 8px");// setting size of the label
            labels.add(label);// adding labels to array list of labels

            gridPane.getChildren().add(label); // put label to grid
            gridPane.setConstraints(label, i + 10, 3); // position label at column 1...7, row 3
        }

    }

    public ArrayList<Integer> getIdOfAllAppartments(int numberOfRooms) {
        ArrayList<Integer> idOfAllAppartments = new ArrayList<>();

        for (int i = 0; i < databaseModel.getListOfAllAppartments(numberOfRooms).size(); i++) {
            idOfAllAppartments.add(databaseModel.getListOfAllAppartments(numberOfRooms).get(i).getAppartmentId());
        }

        return idOfAllAppartments;

    }

    public void createNamesOfAllAppartments(int numberOfRooms) {
        ArrayList<String> namesOfAllAppartments = new ArrayList<>();

        for (int i = 0; i < databaseModel.getListOfAllAppartments(numberOfRooms).size(); i++) {
            namesOfAllAppartments.add(databaseModel.getListOfAllAppartments(numberOfRooms).get(i).getAppartmentName());
        }

        for (int a = 0; a < namesOfAllAppartments.size(); a ++)
        {
            String nameOfAppartment = namesOfAllAppartments.get(a);
            Label label = new Label(nameOfAppartment);
            gridPane.getChildren().add(label);
            gridPane.setConstraints(label, 1, 1 + a);

        }
    }

    public ArrayList<String> getNamesOfAllAppartments(int numberOfRooms) {
        ArrayList<String> namesOfAllAppartments = new ArrayList<>();

        for (int i = 0; i < databaseModel.getListOfAllAppartments(numberOfRooms).size(); i++) {
            namesOfAllAppartments.add(databaseModel.getListOfAllAppartments(numberOfRooms).get(i).getAppartmentName());
        }

        return namesOfAllAppartments;

    }

    public void updateDateLabels (ArrayList<Label> labels) {
        weekLabel.setText("WEEK: " + weekOfYear);  // setting the week label to a week of interest
        cal = Calendar.getInstance(); // getting the current date
        cal.setFirstDayOfWeek(Calendar.MONDAY);// setting the Monday to be the first day of the week instead of Sunday


        for (int i = 0; i < labels.size(); i++) {
            System.out.println("Size of labels " + labels.size());
            cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);
            cal.set(Calendar.DAY_OF_WEEK, weekDays[i]);
            String date = simpleDateFormat.format(cal.getTime()); // setting a string for a desired date
            labels.get(i).setText(date); // setting the name of the label to desired date
        }
    }

    public void updateButtons(int numberOfRooms) {
        ArrayList<Integer> list = new ArrayList<>();
        int indexButton = 0;

        list = getIdOfAllAppartments(numberOfRooms);

        for (int j = 0; j < list.size(); j++) {
            // System.out.println(databaseModel.getListOfAppartments(1).get(j).getAppartmentName());
            for (int i = 0; i < 7; i++) {

                String id = labels.get(i).getText();
                Button button = buttons.get(indexButton);


                String date = id.substring(0, 10);
              //  String shiftType = id.substring(10, 11);
                Date sqlDate = Date.valueOf(date);
                boolean booked = databaseModel.ifAvailable(sqlDate, list.get(j));
                int number;
                number = list.get(j);

                if (booked == true) {

                    button.setStyle("-fx-base: #00b300"); // green


                } else {
                    button.setStyle("-fx-base: #e3e3e3"); // gray
                }

                button.setId(id);
                for (int g = 0; g < bookings.size(); g++)
                {
                    if (bookings.get(g).getAppartmentName() == button.getText()) {
                        button.setStyle("-fx-base: #FFFF00");
                    }
                }
                button.setOnAction(event -> {


                    String name = button.getText();
                    System.out.println(name);
                    Booking booking = new Booking(name, sqlDate, number);
                        bookings.add(booking);
                    ObservableList<Booking> data = FXCollections.observableList(bookings);
                    bookingsTableView.setItems(data);
                    System.out.println("Size of bookings " + bookings.size());

                });
                indexButton++;
            }
        }
    }

    public ArrayList<Booking> getBookings()
    {
        return bookings;
    }

    public int getWhatIsSelectedFromCombobox()
    {
        Integer o = (Integer) typeOfRoomComboBox.getSelectionModel().getSelectedItem();
        int birtday = o.intValue();
        return birtday;
    }





}
