import java.util.Scanner;
public class BinarySearchWithMagic 
{

	public static void main(String[] args)  
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number :");
	     int N=sc.nextInt();
	     sc.close();
	  while(true)
	  {
	     if(N%2==1)
	   {
		 System.out.println("Number should be divisible by 2 for magic");
		 N=sc.nextInt();
	   }
	   else
		    break;
	   }
	  System.out.println("think a number between 1 and "+N);
	  
	  BinarySearchWithMagic.binarySearchWithMagic(1,N);
		  
	}
//************
	public static int binarySearchWithMagic(int l, int h)
	{
		Scanner sc=new Scanner(System.in);
		 if(l<h)
		 {
			 int mid=(l+h)/2;
			
				 System.out.println("if your imagined number present b/w is:"+(mid+1)+"and "+h+"pres y");
			  char ch=sc.next().charAt(0);
			  if(ch=='y'||ch=='Y')
				  return binarySearchWithMagic( mid+1,  h);
			  else
				  return binarySearchWithMagic( l,  mid);
				 
		 }
		 System.out.println("your number is "+h);
		 return h;
	}
//***************
}