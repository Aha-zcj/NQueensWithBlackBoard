package knowledgesource;
import datastruct.Data;
import blackboard.BlackBoard;



public class ObliqueLineEliminateKnowledgeSource implements IKnowledgeSource{
	
	//single instance
	private static ObliqueLineEliminateKnowledgeSource singleInstance = null;
	public static ObliqueLineEliminateKnowledgeSource getInstance(long ul){
		if(singleInstance == null){
			singleInstance = new ObliqueLineEliminateKnowledgeSource(ul);
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
	
	public ObliqueLineEliminateKnowledgeSource(long ul){
		this.upperlim = ul;
	}

	@Override
	public boolean isNeeded(Object o) {
		// TODO Auto-generated method stub
		Data d = (Data)o;
		if(d.state == Data.RAW_STATE && d.row != upperlim){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean operation(Object o) {
		// TODO Auto-generated method stub
		Data data = (Data)o;
		data.ld = data.ld << 1;
		data.rd = data.rd >> 1;
		data.state = Data.OF_STATE;
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
