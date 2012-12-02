package controller;

import knowledgesource.*;
import blackboard.*;
import java.util.ArrayList;


public class Controller {
	//single instance
	private static Controller singleInstance;
	public static Controller getSingleInstance(){
		if(singleInstance == null){
			singleInstance = new Controller();
			return singleInstance;
		}
		else{
			singleInstance.getKnowledgeSources().clear();
			singleInstance.setBb(null);
			return singleInstance;
		}
	}
	
	
	private ArrayList<IKnowledgeSource> knowledgeSources;
	private BlackBoard bb;
	
	public Controller(){
		this.knowledgeSources = new ArrayList<IKnowledgeSource>();
	}
	
	public boolean registKS(IKnowledgeSource ks){
		if(bb != null){
			return knowledgeSources.add(ks) && ks.regist(bb);
		}
		else{
			return false;
		}
	}
	
	public boolean applyKS(Object o){
		for(IKnowledgeSource i:knowledgeSources){
			if(i.isNeeded(o)){
				return i.operation(o);
			}
		}
		return false;
	}

	public BlackBoard getBb() {
		return bb;
	}

	public void setBb(BlackBoard bb) {
		this.bb = bb;
	}

	public ArrayList<IKnowledgeSource> getKnowledgeSources() {
		return knowledgeSources;
	}

	public void setKnowledgeSources(ArrayList<IKnowledgeSource> knowledgeSources) {
		this.knowledgeSources = knowledgeSources;
	}
}
