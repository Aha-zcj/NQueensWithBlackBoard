package datastruct;

public class Data {
	public final static int RAW_STATE = 0x00;
	public final static int OF_STATE = 0x01;
	//public final static int FINISH_STATE = 0x02;
	public long row;
	public long copyRow;
	public long ld;
	public long rd;
	public int state;
}