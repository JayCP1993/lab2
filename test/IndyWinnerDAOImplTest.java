import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.sql.*;
import java.util.*;

public class IndyWinnerDAOImplTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    private IndyWinnerDAOImpl indyWinnerDAO;

    @BeforeEach
    public void setUp() throws SQLException {
        // Initialize Mockito mocks
        MockitoAnnotations.openMocks(this);

        // Mocking the Connection and PreparedStatement
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        // Initialize the DAO instance with the mocked connection
        indyWinnerDAO = new IndyWinnerDAOImpl(mockConnection);
    }

    // Test for getAllIndyWinners method
    @Test
    public void testGetAllIndyWinners() throws SQLException {
        // Setup mock result set behavior
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("name")).thenReturn("Indy Winner");
        when(mockResultSet.getInt("year")).thenReturn(2022);

        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Call the method under test
        List<IndyWinner> winners = indyWinnerDAO.getAllIndyWinners();

        // Assertions
        assertNotNull(winners);
        assertEquals(1, winners.size());
        assertEquals("Indy Winner", winners.get(0).getName());
        assertEquals(2022, winners.get(0).getYear());
    }

    // Test for getIndyWinnerById method
    @Test
    public void testGetIndyWinnerById() throws SQLException {
        // Setup mock result set behavior
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("id")).thenReturn(1);
        when(mockResultSet.getString("name")).thenReturn("Indy Winner");
        when(mockResultSet.getInt("year")).thenReturn(2022);

        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Call the method under test
        IndyWinner winner = indyWinnerDAO.getIndyWinnerById(1);

        // Assertions
        assertNotNull(winner);
        assertEquals("Indy Winner", winner.getName());
        assertEquals(2022, winner.getYear());
    }

    // Test for addIndyWinner method
    @Test
    public void testAddIndyWinner() throws SQLException {
        IndyWinner newWinner = new IndyWinner(0, "New Winner", 2023); // Create with constructor

        // Setup mock insert behavior
        when(mockPreparedStatement.executeUpdate()).thenReturn(1); // Simulate successful insert

        // Call the method under test
        boolean isAdded = indyWinnerDAO.addIndyWinner(newWinner);

        // Assertions
        assertTrue(isAdded); // Check if the winner was added
    }

    // Test for updateIndyWinner method
    @Test
    public void testUpdateIndyWinner() throws SQLException {
        IndyWinner winnerToUpdate = new IndyWinner(1, "Updated Winner", 2024);

        // Setup mock update behavior
        when(mockPreparedStatement.executeUpdate()).thenReturn(1); // Simulate successful update

        // Call the method under test
        boolean isUpdated = indyWinnerDAO.updateIndyWinner(winnerToUpdate);

        // Assertions
        assertTrue(isUpdated); // Check if the winner was updated
    }

    // Test for deleteIndyWinner method
    @Test
    public void testDeleteIndyWinner() throws SQLException {
        // Setup mock delete behavior
        when(mockPreparedStatement.executeUpdate()).thenReturn(1); // Simulate successful deletion

        // Call the method under test
        boolean isDeleted = indyWinnerDAO.deleteIndyWinner(1);

        // Assertions
        assertTrue(isDeleted); // Check if the winner was deleted
    }
}
