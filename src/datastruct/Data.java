package datastruct;

/**
 * Copyright (C), 2001-2012, Aha
 * <br/>Date:2012-12-01 
 * @author  Aha tzl77258511@gmail.com
 * @version  1.0
 */
public class Data {
	public final static int RAW_STATE = 0x00;
	public final static int OF_STATE = 0x01;
	//public final static int GEN_STATE = 0x02;
	public final static int FIN_STATE = 0x03;
	
	public long row;
	public long copyRow;
	public long ld;
	public long rd;
	public int state;
}
