//showing table by jdbc connectvity...

import java.sql.*;
//import java.io.*;
public class SelectTest 
{
	public static void main(String[] args) throws Exception
{
    Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");

	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("SELECT * FROM BANK");

	while(rs.next()!=false)
	{
          System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4));
	}
	rs.close();
	st.close();
	con.close();

	
	}//main()
}//	System.out.println("Hello World!");
