package servlet;

import dao.IndyWinnerDAO;
import dao.IndyWinnerDAOImpl;
import model.IndyWinner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet for handling HTTP requests related to IndyWinners.
 */
@WebServlet("/winners")
public class IndyWinnerServlet extends HttpServlet {
    private IndyWinnerDAO indyWinnerDAO; // Data access object for IndyWinners

    @Override
    public void init() {
        indyWinnerDAO = new IndyWinnerDAOImpl(); // Initialize the DAO
    }

    /**
     * Handles HTTP GET requests to retrieve and display all IndyWinners.
     */
    /**
 * Handles HTTP GET requests to retrieve and display all IndyWinners.
 *
 * @param request  the HttpServletRequest object that contains the request the client has made of the servlet
 * @param response the HttpServletResponse object that contains the response the servlet sends to the client
 * @throws ServletException if an input or output error is detected when the servlet handles the GET request
 * @throws IOException if the request for the GET could not be handled
 */
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    List<IndyWinner> winners = indyWinnerDAO.getAllIndyWinners(); // Fetch all winners
    request.setAttribute("winners", winners); // Set winners as a request attribute
    RequestDispatcher dispatcher = request.getRequestDispatcher("winners.jsp");
    dispatcher.forward(request, response); // Forward the request to JSP for rendering
}

}
