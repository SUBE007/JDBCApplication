import java.sql.*;
class Conntest 
{
	public static void main(String[] args) throws Exception
	{
		oracle.jdbc.driver.OracleDriver obj=new oracle.jdbc.driver.OracleDriver();
		 
		DriverManager.registerDriver(obj);
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		if(con==null)
		{
		System.out.println("connection is not established");
		}
		else
		{
          System.out.println("connection is   established");
		}

	}
}
