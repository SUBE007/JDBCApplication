package com.nt.jdbc;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest4 
{
	public static void main(String[] args) 
	{
		Scanner sc=null; Connection con=null; Statement st=null;ResultSet rs=null;
		String desg1=null; String desg2=null;String desg3=null;
		boolean flag=false;

		try{

                    sc=new Scanner(System.in);
					if(sc!=null)
			     {
                       System.out.print("Enter Desg1:");
					   desg1=sc.next();

					    System.out.print("Enter Desg2:");
					   desg2=sc.next();

					    System.out.print("Enter Desg3:");
					   desg3=sc.next();
			      }//if
			String cond="('"+desg1+"','"+desg2+"','"+desg3+"')";
			System.out.println(cond);
			String query="SELECT ENAME,EMPNO,JOB,SAL FROM EMP WHERE JOB IN"+cond+"ORDER BY JOB";
              System.out.println(query);
			Class.forName("oracle.jdbc.driver.OracleDriver");
             con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			 if(con!=null)
			{
              st=con.createStatement();
		     
			}
			
			//con if
			if(st!=null)
				rs=st.executeQuery(query);
			if(rs!=null){
				while(rs.next()){
					flag=true;
                      System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
          
				}//while

				if(flag==false)
				{

                            System.out.println("No Record is Found::");
				}//if flag

			}//if rs



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


			try{
                    if(sc!=null)
						sc.close();
			     }
				 catch(Exception e)
			{
                e.printStackTrace();
			}


		}//finally
		
	}//main
}//class
