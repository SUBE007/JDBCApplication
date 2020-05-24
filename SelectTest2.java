import java.sql.*;
import  java.util.Scanner;
class SelectTest2 
{
	public static void main(String[] args)  throws Exception
	{

		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Department Name:");

		String dept=sc.nextLine();
		dept="'"+dept+"'";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");

		Statement st=con.createStatement();

		ResultSet rs=st.executeQuery("SELECT * FROM DEPT WHERE DNAME="+dept);

		boolean flag=false;
while(rs.next()!=false)
		{
	     flag=true;
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		}

		if(flag==false)
		{
              System.out.println("No record is found Please try Again");
		}
		rs.close();
		st.close();
		con.close();
	}
}
