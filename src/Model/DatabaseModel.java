package Model;

import Objects.Appartment;
import Objects.User;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by Edgaras on 16/08/2016.
 */
public class DatabaseModel {

    private java.sql.Connection conn = null;

    public DatabaseModel() {

        String DB_URL = "jdbc:mysql://localhost/hotelreservation";
        String USER = "root";
        String PASS = "root";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewUser(String userName, String password, String name, String surname) {
        String sql = "INSERT INTO users VALUES(null, ?, ?, ?, ? )";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, surname);


            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User retrieveUserIfAllowedToLogIn(String userName, String password) {
        String sql = "SELECT * FROM users WHERE userName = ? AND password= ?";
        User user = null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt(1);
                String name = resultSet.getString(4);
                String surname = resultSet.getString(5);


                user = new User(userId, userName, password, name, surname);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addNewAppartment(String appartmentName, int numberOfRooms, int maxNumberOfGuests, int whichFloor, int size, String roomInfo) {
        String sql = "INSERT INTO rooms VALUES(null, ?, ?, ?, ?, ?, ? )";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, appartmentName);
            preparedStatement.setInt(2, numberOfRooms);
            preparedStatement.setInt(3, maxNumberOfGuests);
            preparedStatement.setInt(4, whichFloor);
            preparedStatement.setInt(5, size);
            preparedStatement.setString(6, roomInfo);

            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Appartment> getListOfAppartments(int numberOfRooms) {
        ArrayList<Appartment> listOfAppartments = new ArrayList<>();

        try {

            String sql = "SELECT * FROM rooms WHERE nrofrooms = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, numberOfRooms);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Appartment appartment = new Appartment(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4),
                        resultSet.getInt(5), resultSet.getInt(6), resultSet.getString(7));
                listOfAppartments.add(appartment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfAppartments;
    }

    public boolean ifAvailable(Date dates, int appartmentId) {
        boolean out = true;

        String sql = "SELECT appartment2id FROM bookings2 WHERE date = ?  AND appartment2id = ? ";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setDate(1, dates);
            preparedStatement.setInt(2, appartmentId);
            //preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();


            if(resultSet.next() == false) {
                out = false;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace(); // if employee is working - then the record is not null, its present.
        }

        return out;
    }

    public ArrayList<Appartment> getListOfAllAppartments(int numberOfRooms) {
        ArrayList<Appartment> listOfAppartments = new ArrayList<>();

        try {

            String sql = "SELECT * FROM rooms WHERE nrofrooms = ? ";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, numberOfRooms);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Appartment appartment = new Appartment(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4),
                        resultSet.getInt(5), resultSet.getInt(6), resultSet.getString(7));
                listOfAppartments.add(appartment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfAppartments;
    }



    public Set<Integer> getListOfNumberOfRooms()
    {
        Set<Integer> listOfNumberOfRooms = new HashSet<>();
        String sql = "SELECT nrofrooms FROM rooms";
       try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //preparedStatement.setInt(1, childId);

            ResultSet resultSet = preparedStatement.executeQuery();

           while (resultSet.next())
           {
               listOfNumberOfRooms.add(resultSet.getInt(1));
           }
        } catch (SQLException e)
       {
           e.printStackTrace();
       }
        return listOfNumberOfRooms;
    }

    public void addBooking(String clientsName, String clientsSurname,
                           String clientsPhoneNumber, String clientsEmail,
                           Date bookingDate, int appartmentId)
    {
        String sql = "INSERT INTO bookings2 VALUES (null, ?,?,?, ?,? ,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, clientsName);
            preparedStatement.setString(2, clientsSurname);
            preparedStatement.setString(3, clientsPhoneNumber);
            preparedStatement.setString(4, clientsEmail);
            preparedStatement.setDate(5, bookingDate);
            preparedStatement.setInt(6, appartmentId);

            preparedStatement.executeUpdate();
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


}
