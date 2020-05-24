package com.nt.jdbc;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
public class SelectTest8
{
	public static void main(String[] args) 
	{ 
		Connection con=null; Statement st=null; ResultSet rs=null;
		String query=null; boolean flag=false; int count=0;

		try{
			
				  Class.forName("oracle.jdbc.driver.OracleDriver");
			     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger"); 
			
              if(con!=null)
				  st=con.createStatement();
                          query="SELECT COUNT(*) FROM BANK";
                 System.out.println(query);

				 if(st!=null)
					 rs=st.executeQuery(query);
				 
				 if(rs!=null)
			{
					 while(rs.next()!=false)
				{
						  flag=true;
						 count=rs.getInt("count(*)");
                   }//if while

			}//if rs
			System.out.println("no. of record is="+count);
						
                   
			if(flag==false)
			{ 
                     System.out.println("Sorry,No row selected::");

			}//flag
       }//try
	   catch(SQLException se)
		{
		   se.printStackTrace();
		}

	  catch(ClassNotFoundException cnf)
		{
		   cnf.printStackTrace();
		}


		  catch(Exception e)
		{
		   e.printStackTrace();
		}
		
		finally{
			try
			{
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se)
		{
		   se.printStackTrace();
		}

		try
			{
				if(st!=null)
					st.close();
			}
			catch(SQLException se)
		{
		   se.printStackTrace();
		}

		try
			{
				if(con!=null)
					con.close();
			}
			catch(SQLException se)
		{
		   se.printStackTrace();
		}


		}//finally

				

		
		
	}//System.out.println("Hello World!"); main()
}// class
