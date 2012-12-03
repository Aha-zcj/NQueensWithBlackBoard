package blackboard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

import knowledgesource.IKnowledgeSource;
import controller.Controller;
import datastruct.Data;

/**
 * Copyright (C), 2001-2012, Aha
 * <br/>Date:2012-12-01 
 * @author  Aha tzl77258511@gmail.com
 * @version  1.0
 */
public class BlackBoard {
	//single instance
	private static BlackBoard singleInstance;
	public static BlackBoard getSingleInstance(){
		if(singleInstance == null){
			singleInstance = new BlackBoard();
			return singleInstance;
		}
		else{
			singleInstance.getDataSource().clear();
			singleInstance.setController(null);
			return singleInstance;
		}
	}
	
	private Stack<Data> dataSource;
	private Controller controller;
	
	public BlackBoard(){
		this.dataSource = new Stack<Data>();
	}
	
	public boolean registKS(IKnowledgeSource ks){
		return controller.registKS(ks);
	}
	
	public boolean addData(Data d){
		dataSource.push(d);
		return true;
	}
	
	public boolean registController(Controller c){
		if(c != null){
			this.controller = c;
			c.setBb(this);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean start(){
		if(this.controller == null){
			System.out.println("Set the controller first.");
			return false;
		}
		else{
			while(!dataSource.isEmpty()){
				Data tmp = dataSource.pop();
				while(tmp.state != Data.FIN_STATE){
					controller.applyKS(tmp);
				}
			}
			return true;
		}
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public Stack<Data> getDataSource() {
		return dataSource;
	}

	public void setDataSource(Stack<Data> dataSource) {
		this.dataSource = dataSource;
	}
	
	
//	public void enableGen(){
//		controller.enableGen();
//	}
//	
//	public void disableGen(){
//		controller.disableGen();
//	}
//	
//	public boolean isEnableGen(){
//		return Controller.getState() == Controller.ENABLE_GEN;
//	}
}
