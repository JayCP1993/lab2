package dao;

import model.IndyWinner;
import util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the IndyWinnerDAO interface using JDBC.
 */
public class IndyWinnerDAOImpl implements IndyWinnerDAO {
    private Connection conn; // Connection to the database

    // Constructor to initialize the database connection
    public IndyWinnerDAOImpl() {
        conn = DBConnectionUtil.getConnection();
    }

    @Override
    public List<IndyWinner> getAllIndyWinners() {
        List<IndyWinner> winners = new ArrayList<>();
        String sql = "SELECT * FROM indywinners"; // SQL query to retrieve all IndyWinner records

        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Create and populate an IndyWinner object
                IndyWinner winner = new IndyWinner();
                winner.setId(rs.getInt("id"));
                winner.setName(rs.getString("name"));
                winner.setYear(rs.getInt("year"));
                winners.add(winner); // Add the winner to the list
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return winners; // Return the list of winners
    }

    @Override
    public IndyWinner getIndyWinnerById(int id) {
        IndyWinner winner = null;
        String sql = "SELECT * FROM indywinners WHERE id = ?"; // SQL query to retrieve a record by ID

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id); // Set the ID parameter in the query
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Create and populate an IndyWinner object
                winner = new IndyWinner();
                winner.setId(rs.getInt("id"));
                winner.setName(rs.getString("name"));
                winner.setYear(rs.getInt("year"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return winner; // Return the found winner or null if no match is found
    }

    @Override
    public boolean addIndyWinner(IndyWinner winner) {
        boolean rowInserted = false;
        String sql = "INSERT INTO indywinners (name, year) VALUES (?, ?)"; // SQL query to insert a new record

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, winner.getName());
            stmt.setInt(2, winner.getYear());
            rowInserted = stmt.executeUpdate() > 0; // Execute the update and check if a row was inserted
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return rowInserted; // Return true if a row was inserted, false otherwise
    }

    @Override
    public boolean updateIndyWinner(IndyWinner winner) {
        boolean rowUpdated = false;
        String sql = "UPDATE indywinners SET name = ?, year = ? WHERE id = ?"; // SQL query to update a record

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, winner.getName());
            stmt.setInt(2, winner.getYear());
            stmt.setInt(3, winner.getId());
            rowUpdated = stmt.executeUpdate() > 0; // Execute the update and check if a row was updated
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return rowUpdated; // Return true if a row was updated, false otherwise
    }

    @Override
    public boolean deleteIndyWinner(int id) {
        boolean rowDeleted = false;
        String sql = "DELETE FROM indywinners WHERE id = ?"; // SQL query to delete a record

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id); // Set the ID parameter in the query
            rowDeleted = stmt.executeUpdate() > 0; // Execute the update and check if a row was deleted
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
        return rowDeleted; // Return true if a row was deleted, false otherwise
    }
}
