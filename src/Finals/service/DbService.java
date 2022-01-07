package Finals.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Finals.model.*;

public class DbService {

    private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu20";

    private String username = "cs3220stu20";
    private String password = "CeZuqkyts2Ym";

    private Connection connection;

    public DbService()
    {
        try
        {
            connection = DriverManager.getConnection( url, username, password );
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public void close()
    {
        if( connection != null )
        {
            try
            {
                connection.close();
            }
            catch( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }

    public List<Game> getGame()
    {
        List<Game> entries = new ArrayList<Game>();

        try
        {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from game order by id desc" );
            while( rs.next() )
            {
            	Game entry = new Game();
            	entry.setid(rs.getInt( "id" ));
                entry.setTitle( rs.getString( "title" ) );
                
                String sql = "select * from review where g_id = ?";
                PreparedStatement pstmt = connection.prepareStatement( sql );
                pstmt.setInt( 1, rs.getInt( "id" ) );
                ResultSet rs2 = pstmt.executeQuery();
                while( rs2.next() )
                {
                	Review entry2 = new Review();
                    entry2.setg_id( rs2.getInt( "g_id" ) );
                    entry2.setid(rs2.getInt("id"));
                    entry2.setauthor(rs2.getString("author"));
                    entry2.setrating(rs2.getInt("rating"));
                    entry2.setreview(rs2.getString("descript"));
                    System.out.print(rs2.getString("author"));
                    ArrayList<Review> temp = entry.getReviews();
                    temp.add(entry2);
                    entry.setReviews(temp);
                }
                pstmt.close();
                
                entries.add( entry );
                
                
                

                
            }
            stmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }

        return entries;
    }

    public Game getGame( int id )
    {
    	Game entry = new Game();
        try
        {
            String sql = "select * from game where id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setInt( 1, id );
            ResultSet rs = pstmt.executeQuery();
            if( rs.next() )
            {
            	entry.setid(rs.getInt( "id" ));
                entry.setTitle( rs.getString( "title" ) );
                
                String sql2 = "select * from review where g_id = ?";
                PreparedStatement pstmt2 = connection.prepareStatement( sql2 );
                pstmt2.setInt( 1, entry.getid() );
                ResultSet rs2 = pstmt2.executeQuery();
                while( rs2.next() )
                {
                	Review entry2 = new Review();
                    entry2.setg_id( rs2.getInt( "g_id" ) );
                    entry2.setid(rs2.getInt("id"));
                    entry2.setauthor(rs2.getString("author"));
                    entry2.setrating(rs2.getInt("rating"));
                    entry2.setreview(rs2.getString("descript"));
                    
                    ArrayList<Review> temp = entry.getReviews();
                    temp.add(entry2);
                    entry.setReviews(temp);
                }
                pstmt2.close();
                
            }
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return entry;
    }
    
    public Game getGame( String name )
    {
    	Game entry = new Game();
        try
        {
            String sql = "select * from game where title = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setString( 1, name );
            ResultSet rs = pstmt.executeQuery();
            if( rs.next() )
            {
            	entry.setid(rs.getInt( "id" ));
                entry.setTitle( rs.getString( "title" ) );
                
                String sql2 = "select * from review where g_id = ?";
                PreparedStatement pstmt2 = connection.prepareStatement( sql2 );
                pstmt2.setInt( 1, entry.getid() );
                ResultSet rs2 = pstmt2.executeQuery();
                while( rs2.next() )
                {
                	Review entry2 = new Review();
                    entry2.setg_id( rs2.getInt( "g_id" ) );
                    entry2.setid(rs2.getInt("id"));
                    entry2.setauthor(rs2.getString("author"));
                    entry2.setrating(rs2.getInt("rating"));
                    entry2.setreview(rs2.getString("descript"));
                    
                    ArrayList<Review> temp = entry.getReviews();
                    temp.add(entry2);
                    entry.setReviews(temp);
                }
                pstmt2.close();
                
            }
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return entry;
    }

    public int addGame(String name)
    {
        int id = 0;
        try
        {
            String sql = "insert into game (title) values (?)";
            PreparedStatement pstmt = connection.prepareStatement( sql,
                Statement.RETURN_GENERATED_KEYS );
            pstmt.setString( 1, name );
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if( rs.next() ) id = rs.getInt( 1 );
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return id;
    }
    
    public int addReview(int a, String b, int c, String d)
    {
        int id = 0;
        try
        {
            String sql = "insert into review (g_id, author, rating, descript) values (?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement( sql,
                Statement.RETURN_GENERATED_KEYS );
            pstmt.setInt( 1, a );
            pstmt.setString( 2, b );
            pstmt.setInt( 3, c );
            pstmt.setString( 4, d );
	        pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if( rs.next() ) id = rs.getInt( 1 );
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return id;
    }
    
}

