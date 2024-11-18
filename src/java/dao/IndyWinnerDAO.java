package dao;

import model.IndyWinner;
import java.util.List;

/**
 * Defines data access methods for the IndyWinner entity.
 */
public interface IndyWinnerDAO {
    /**
     * Retrieves all IndyWinners from the database.
     * @return a list of all IndyWinner objects.
     */
    List<IndyWinner> getAllIndyWinners();

    /**
     * Retrieves an IndyWinner by its unique ID.
     * @param id the unique identifier of the IndyWinner.
     * @return an IndyWinner object if found, otherwise null.
     */
    IndyWinner getIndyWinnerById(int id);

    /**
     * Adds a new IndyWinner to the database.
     * @param winner the IndyWinner object to add.
     * @return true if the addition was successful, otherwise false.
     */
    boolean addIndyWinner(IndyWinner winner);

    /**
     * Updates an existing IndyWinner's details.
     * @param winner the IndyWinner object with updated details.
     * @return true if the update was successful, otherwise false.
     */
    boolean updateIndyWinner(IndyWinner winner);

    /**
     * Deletes an IndyWinner by its ID.
     * @param id the unique identifier of the IndyWinner to delete.
     * @return true if the deletion was successful, otherwise false.
     */
    boolean deleteIndyWinner(int id);
}
