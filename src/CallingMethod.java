

public class CallingMethod {
	public static void main(String[] args)
	{
		System.out.println("Hi 'Yamini' how r u?");         //print yamini from this statement
	String data2=getData();
	System.out.print(data2);
	}

	public static String getData()
	{
		String data="Hi 'Yamini' how r u?";
		String[] data1=data.split("'");
		//index[0]=Hi
		//index[1]=Yamini' how r u?
		String data2=data1[1].split("'")[0];             //index[0]=Yamini   //index[1]=how r u?
		return data2;                                        
	
	}
	
}
