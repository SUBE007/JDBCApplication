package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.SQLException;

class SelectTest6 
{
	public static void main(String[] args) 
	{
		Connection con=null;Statement st=null;ResultSet rs=null;  
          String query=null; boolean flag=false;
		  try{
			  //register the driver
			    Class.forName("oracle.jdbc.driver.OracleDriver");
                      
			      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger"); 

				  if(con!=null){
					  st=con.createStatement();}

                query="SELECT ENAME,EMPNO,SAL,JOB FROM EMP WHERE SAL=(SELECT MAX (SAL) FROM EMP) ";

                   System.out.println(query);
				if(st!=null){
					rs=st.executeQuery(query); }
					if(rs!=null){
              while(rs.next()!=false){

				  flag=true;
				System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getString(4)); }//while
					

				if(flag==false)
			  {
                   System.out.println("No record Found");
			  }//flag

			 }//if rs--

		  }//try

		  catch(SQLException se)
			  {
			  se.printStackTrace();
			  }

              ////////////
			   catch(ClassNotFoundException cnf)
			  {
			  cnf.printStackTrace();
			  }
              ////////////
			   catch(Exception e)
			  {
			    e.printStackTrace(); 
			  }
              ////////////
			  finally{
				  try{
                         if(rs!=null)
							 rs.close();
				  }
				  catch(SQLException se)
				  {
					  se.printStackTrace();
					  }

					   try{
                         if(st!=null)
							 st.close();
				         }
				  catch(SQLException se)
				    {
					  se.printStackTrace(); 
					  }

					   try{
                         if(con!=null)
							 con.close();
				       }
				  catch(SQLException se)
				  {
					  se.printStackTrace();
				}

			  }//finally


		
	}//main
}//class System.out.println("Hello World!");
