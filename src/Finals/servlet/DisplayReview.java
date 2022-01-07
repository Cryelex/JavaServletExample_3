package Finals.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Finals.service.DbService;

/**
 * Servlet implementation class DisplayReview
 */
@WebServlet("/DisplayReview")
public class DisplayReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
    		int g_id = Integer.parseInt(request.getParameter("id"));
        	DbService dbService = new DbService();
            request.setAttribute( "game", dbService.getGame(g_id) );
            dbService.close();
            request.getRequestDispatcher( "/WEB-INF/DisplayReview.jsp" )
                .forward( request, response );
        }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
