package util;
 

public class Counter{
	public static int count = 0;
	
	public static void reset(){
		count = 0;
	}
	
	public static void increaseOne(){
		count++;
	}
}