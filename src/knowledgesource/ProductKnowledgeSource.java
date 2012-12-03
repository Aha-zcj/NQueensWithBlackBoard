package knowledgesource;
import controller.Controller;
import datastruct.Data;
import blackboard.BlackBoard;



/**
 * Copyright (C), 2001-2012, Aha
 * <br/>Date:2012-12-01 
 * @author  Aha tzl77258511@gmail.com
 * @version  1.0
 */
public class ProductKnowledgeSource implements IKnowledgeSource{

	//single instance
	private static ProductKnowledgeSource singleInstance = null;
	public static ProductKnowledgeSource getSingleInstance(long ul){
		if(singleInstance == null){
			singleInstance = new ProductKnowledgeSource(ul);
			return singleInstance;
		}
		else{
			singleInstance.setUpperlim(ul);
			singleInstance.setBb(null);
			return singleInstance;
		}
	}
	
	
	private BlackBoard bb;
	private long upperlim;
	
	public ProductKnowledgeSource(long ul){
		this.upperlim = ul;
	}
	
	@Override
	public boolean isNeeded(Object o) {
		// TODO Auto-generated method stub
		Data d = (Data)o;
//		switch(d.state){
//		case Data.OF_STATE:
//			return true;
//		case Data.GEN_STATE:
//			if(bb.isEnableGen()){
//				return true;
//			}
//			else{
//				return false;
//			}
//		}
//		return false;
		if(d.state == Data.OF_STATE){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean operation(Object o) {
		// TODO Auto-generated method stub
		// row，ld，rd进行“或”运算，求得所有可以放置皇后的列,对应位为0，  
        // 然后再取反后“与”上全1的数，来求得当前所有可以放置皇后的位置，对应列改为1  
        // 也就是求取当前哪些列可以放置皇后  
		Data data = (Data)o;
        long pos = upperlim & ~(data.copyRow | data.ld | data.rd); 
        if (pos != 0)    // 0 -- 皇后没有地方可放，回溯
        {  
            // 拷贝pos最右边为1的bit，其余bit置0  
            // 也就是取得可以放皇后的最右边的列  
            long p = pos & -pos;                                                
  
            
            
            Data newData = new Data();
            newData.row = data.row;
            newData.ld = data.ld;
            newData.rd = data.rd;
            newData.copyRow = data.copyRow + p;
            newData.state = Data.OF_STATE;
            
            data.row += p;
            data.ld += p;
            data.rd += p;
            data.copyRow = data.row;
            data.state = Data.RAW_STATE;
            
            return bb.addData(newData);
        }
        else{
        	data.state = Data.FIN_STATE;
        }
        return true;
	}

	@Override
	public boolean regist(Object o) {
		// TODO Auto-generated method stub
		if(o == null){
			return false;
		}
		this.bb = (BlackBoard)o;
		return true;
	}

	public long getUpperlim() {
		return upperlim;
	}

	public void setUpperlim(long upperlim) {
		this.upperlim = upperlim;
	}

	public BlackBoard getBb() {
		return bb;
	}

	public void setBb(BlackBoard bb) {
		this.bb = bb;
	}

}
