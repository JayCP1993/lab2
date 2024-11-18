package dao;

import model.IndyWinner;
import util.DBConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of IndyWinnerDAO interface for database operations.
 */
public class IndyWinnerDAOImpl implements IndyWinnerDAO {
    private final Connection conn; // Connection to the database

    // Constructor to establish a database connection
    public IndyWinnerDAOImpl() {
        conn = DBConnectionUtil.getConnection(); // Initialize the connection from DBConnectionUtil
    }

    // Constructor for testing with mocked Connection (dependency injection)
    public IndyWinnerDAOImpl(Connection conn) {
        this.conn = conn; // This constructor is for testing purposes
    }

    @Override
    public List<IndyWinner> getAllIndyWinners() {
        List<IndyWinner> winners = new ArrayList<>();
        String query = "SELECT * FROM IndyWinners"; // SQL query to retrieve all records
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) { // Iterate over each record
                // Create an IndyWinner object and add it to the list
                winners.add(new IndyWinner(rs.getInt("id"), rs.getString("name"), rs.getInt("year")));
            }
        } catch (SQLException e) {
            System.err.println("Database error occurred while fetching Indy winners: " + e.getMessage());
        }
        return winners;
    }

    @Override
    public IndyWinner getIndyWinnerById(int id) {
        String query = "SELECT * FROM IndyWinners WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new IndyWinner(rs.getInt("id"), rs.getString("name"), rs.getInt("year"));
            }
        } catch (SQLException e) {
            System.err.println("Database error occurred while fetching Indy winners: " + e.getMessage());
        }
        return null; // Return null if no record is found
    }

    @Override
    public boolean addIndyWinner(IndyWinner winner) {
        String query = "INSERT INTO IndyWinners (name, year) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, winner.getName());
            stmt.setInt(2, winner.getYear());
            int rowsAffected = stmt.executeUpdate(); // Execute the update
            return rowsAffected > 0; // Return true if insertion was successful
        } catch (SQLException e) {
            System.err.println("Database error occurred while fetching Indy winners: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateIndyWinner(IndyWinner winner) {
        String query = "UPDATE IndyWinners SET name = ?, year = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, winner.getName());
            stmt.setInt(2, winner.getYear());
            stmt.setInt(3, winner.getId());
            int rowsAffected = stmt.executeUpdate(); // Execute the update
            return rowsAffected > 0; // Return true if update was successful
        } catch (SQLException e) {
            System.err.println("Database error occurred while fetching Indy winners: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteIndyWinner(int id) {
        String query = "DELETE FROM IndyWinners WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate(); // Execute the deletion
            return rowsAffected > 0; // Return true if deletion was successful
        } catch (SQLException e) {
            System.err.println("Database error occurred while fetching Indy winners: " + e.getMessage());
        }
        return false;
    }
}
