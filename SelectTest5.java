package com.nt.jdbc;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest5 
{
	public static void main(String[] args) 
	{
		Scanner sc=null; Connection con=null; Statement st=null;ResultSet rs=null;
		int deptno=0;
		boolean flag=false;
             try{
                        sc=new Scanner(System.in);

			   if(sc!=null)
				 {
                    System.out.print("Enter the Employee Number:");
                   deptno=sc.nextInt();
					 

				 }//if
              String query="SELECT ENAME,EMPNO,JOB,SAL FROM EMP WHERE DEPTNO="+deptno;
                            System.out.println(query);
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");

			  if(con!=null){
				  st=con.createStatement();
                        
			  }//if --con

			  if(st!=null)
				 {
                       rs=st.executeQuery(query);
				 }//if --st

				 if(rs!=null){
					 while(rs.next())
					 {
						 flag=true;
						System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getInt(4));
                        
					 }//while
				 }//if--rs
				 if(flag==false)
				 {
                       System.out.println("No Record  Found try Again");
				 }

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

							  }//finally
				   
 
	}
}//System.out.println(" ");

			   

				 

			
