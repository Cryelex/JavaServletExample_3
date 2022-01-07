package Finals.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Finals.model.*;
import Finals.service.DbService;

/**
 * Servlet implementation class CreateReview
 */
@WebServlet("/CreateReview")
public class CreateReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReview() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
    		int g_id = Integer.parseInt(request.getParameter("id"));
        	DbService dbService = new DbService();
            request.setAttribute( "game", dbService.getGame(g_id) );
            request.setAttribute( "cur_game_id", g_id );
            dbService.close();
            request.getRequestDispatcher( "/WEB-INF/CreateReview.jsp" )
                .forward( request, response );
        }

        protected void doPost( HttpServletRequest request,
            HttpServletResponse response ) throws ServletException, IOException
        {
            String gameName = request.getParameter( "gameName" );
            String review =  request.getParameter( "review" );
            String name =  request.getParameter( "name" );
            int rating = Integer.parseInt(request.getParameter("rating"));
            int g_id = Integer.parseInt(request.getParameter("g_id"));

            DbService dbService = new DbService();
            Game temp = dbService.getGame(gameName);
            dbService.addReview(g_id,name,rating,review);
            dbService.close();

            response.sendRedirect( "ListGames" );
        }

}
