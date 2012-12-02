package util;
 
/**
 * Copyright (C), 2001-2012, Aha
 * <br/>Date:2012-12-01 
 * @author  Aha tzl77258511@gmail.com
 * @version  1.0
 */
public class Counter{
	public static int count = 0;
	
	public static void reset(){
		count = 0;
	}
	
	public static void increaseOne(){
		count++;
	}
}