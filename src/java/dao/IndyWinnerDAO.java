package dao;

import model.IndyWinner;
import java.util.List;

/**
 * Interface for data access methods related to IndyWinners.
 */
public interface IndyWinnerDAO {
    // Retrieves all IndyWinners from the database
    List<IndyWinner> getAllIndyWinners();

    // Retrieves a specific IndyWinner by their ID
    IndyWinner getIndyWinnerById(int id);

    // Adds a new IndyWinner record to the database
    boolean addIndyWinner(IndyWinner winner);

    // Updates an existing IndyWinner record in the database
    boolean updateIndyWinner(IndyWinner winner);

    // Deletes an IndyWinner record by their ID
    boolean deleteIndyWinner(int id);
}
