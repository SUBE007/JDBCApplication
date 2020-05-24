import java.sql.*;
import java.io.*;

public class jdbcDemo
 {
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from emp");
		while(rs.next())
		{
            System.out.println(rs.getInt(4)+"..."+rs.getInt(1)+"..."+rs.getDate(5)+"..."+rs.getString(3)+"..."+rs.getString(2)+"..."+rs.getInt(8)+"..."+rs.getInt(7));
		}//while
		con.close();
	}
}
