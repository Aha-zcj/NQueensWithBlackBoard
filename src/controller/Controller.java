package controller;

import knowledgesource.*;
import blackboard.*;
import java.util.ArrayList;

/**
 * Copyright (C), 2001-2012, Aha
 * <br/>Date:2012-12-01 
 * @author  Aha tzl77258511@gmail.com
 * @version  1.0
 */
public class Controller {
//	public final static int ENABLE_GEN = 0x00;
//	public final static int DISABLE_GEN = 0x01;
//	private static int state = DISABLE_GEN;
	
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
	
//	public void enableGen(){
//		setState(ENABLE_GEN);
//	}
//	
//	public void disableGen(){
//		setState(DISABLE_GEN);
//	}
//
//	public static int getState() {
//		return state;
//	}
//
//	public static void setState(int state) {
//		Controller.state = state;
//	}

	
}
