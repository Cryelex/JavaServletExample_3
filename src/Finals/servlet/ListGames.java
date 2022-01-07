package Finals.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Finals.service.DbService;


@WebServlet(urlPatterns = "/ListGames", loadOnStartup = 1)
public class ListGames extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ListGames()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	
    	DbService dbService = new DbService();
        request.setAttribute( "games", dbService.getGame() );
        dbService.close();
        
        request.getRequestDispatcher( "/WEB-INF/ListGames.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        doGet( request, response );
    }

}