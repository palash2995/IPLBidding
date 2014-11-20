package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Users {

	
	static Connection conn =null;
	
	
	static public boolean authenticate(String Id,String pass,String type)
	{
		try
		{
			
		ResultSet rs;
		Statement st = conn.createStatement();
		
		if(type.equals("player"))
		{
	        rs = st.executeQuery("SELECT * from players where userid ='" + Id +"' and password = '"  + pass + "'");	
		}
		
		else if(type.equals("team"))
		{
			rs = st.executeQuery("SELECT * from teams where userid ='" + Id +"' and password = '"  + pass + "'");
		}
		
		else
		{
			rs = st.executeQuery("SELECT * from admins where userid ='" + Id +"' and password = '"  + pass + "'");
		}

		if(!rs.next())
		{
			return false;
		}
		
		return true;
		
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;

	}
	

	
	
	
	
}
