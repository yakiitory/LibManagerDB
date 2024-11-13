/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yakiitory.libmanagerdb.manager;

/**
 *
 * @author steven the yakiitory
 */
import yakiitory.libmanagerdb.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookManager {
    // Create a method to... create a book with the parameters of title, author, and year
    public boolean createBook(String title, String author, int year, int quantity) {
    String sqlQuery = "INSERT INTO Books (Title, Author, PublishedYear, Quantity) VALUES (?, ?, ?, ?)"; // SQL Query as a string
    try (Connection connection = DatabaseConnection.connectToDatabase();
         PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

        statement.setString(1, title); // Set the title for the ?
        statement.setString(2, author); // Set the author for the ?
        statement.setInt(3, year); // Set the year for the ?
        statement.setInt(4, quantity); // Set a quantity for the ?

        int rowsInserted = statement.executeUpdate();
        // Returns true
        return rowsInserted > 0;
    } catch (SQLException e) {
        System.out.println("Failed to create book.");
        return false;
    }
}

    public void readBooks() {
    String sqlQuery = "SELECT * FROM Books";
    try (Connection connection = DatabaseConnection.connectToDatabase();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(sqlQuery)) {

        while (resultSet.next()) {
            String title = resultSet.getString("Title");
            String author = resultSet.getString("Author");
            int year = resultSet.getInt("PublishedYear");
            int quantity = resultSet.getInt("Quantity");

            System.out.println("Title: " + title + ", Author: " + author + ", Year: " + year + ", Quantity: " + quantity);
        }
    } catch (SQLException e) {
        System.out.println("Failed to read books.");
    }
}

    public boolean updateBookQuantity(String title, String author, int year, int newQuantity) {
    String sqlQuery = "UPDATE Books SET Quantity = ? WHERE Title = ? AND Author = ? AND PublishedYear = ?";
    try (Connection connection = DatabaseConnection.connectToDatabase();
         PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

        statement.setInt(1, newQuantity);
        statement.setString(2, title);
        statement.setString(3, author);
        statement.setInt(4, year);

        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    } catch (SQLException e) {
        System.out.println("Failed to update book quantity.");
        return false;
    }
}

   public boolean removeBookQuantity(String title, String author, int year, int quantityToRemove) {
    String sqlQuery = "UPDATE Books SET Quantity = Quantity - ? WHERE Title = ? AND Author = ? AND PublishedYear = ?";
    try (Connection connection = DatabaseConnection.connectToDatabase();
         PreparedStatement statement = connection.prepareStatement(sqlQuery)) {

        statement.setInt(1, quantityToRemove);
        statement.setString(2, title);
        statement.setString(3, author);
        statement.setInt(4, year);

        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    } catch (SQLException e) {
        System.out.println("Failed to remove book quantity.");
        return false;
    }
}



}