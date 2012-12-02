package knowledgesource;
import util.Counter;
import datastruct.Data;
import blackboard.BlackBoard;


public class JudgeEndKnowledgeSource implements IKnowledgeSource{
	//single instance
	private static JudgeEndKnowledgeSource singleInstance = null;
	public static JudgeEndKnowledgeSource getInstance(long ul){
		if(singleInstance == null){
			singleInstance = new JudgeEndKnowledgeSource(ul);
			return singleInstance;
		}
		else{
			singleInstance.setUpperlim(ul);
			singleInstance.setBb(null);
			return singleInstance;
		}
	}
	
	private BlackBoard bb = null;
	private long upperlim;
	
	public JudgeEndKnowledgeSource(long ul){
		this.upperlim = ul;
	}

	@Override
	public boolean isNeeded(Object o) {
		// TODO Auto-generated method stub
		Data d = (Data)o;
		if(d.state == Data.RAW_STATE && d.row == upperlim){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean operation(Object o) {
		// TODO Auto-generated method stub
		Counter.increaseOne();
		bb.addRemoveBufferData((Data)o);
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
