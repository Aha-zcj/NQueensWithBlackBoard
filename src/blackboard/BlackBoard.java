package blackboard;

import java.util.ArrayList;
import java.util.Collection;

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
			singleInstance.getBufferDataSource().clear();
			singleInstance.getBufferRemoveData().clear();
			singleInstance.setController(null);
			return singleInstance;
		}
	}
	
	private ArrayList<Data> dataSource;
	private ArrayList<Data> bufferDataSource;
	private ArrayList<Data> bufferRemoveData;
	private Controller controller;
	
	public BlackBoard(){
		this.dataSource = new ArrayList<Data>();
		this.bufferDataSource = new ArrayList<Data>();
		this.bufferRemoveData = new ArrayList<Data>();
	}
	
	public boolean registKS(IKnowledgeSource ks){
		return controller.registKS(ks);
	}
	
	public boolean addData(Data d){
		return dataSource.add(d);
	}
	
	public boolean removeData(Data d){
		return dataSource.remove(d);
	}
	
	public boolean addBufferData(Data d){
		return bufferDataSource.add(d);
	}
	
	public boolean addRemoveBufferData(Data d){
		return bufferRemoveData.add(d);
	}
	
	public void flushBufferIntoDataSource(){
		dataSource.addAll(bufferDataSource);
		bufferDataSource.clear();
	}
	
	public void removeDataInRemoveBuffer(){
		dataSource.removeAll(bufferRemoveData);
		bufferRemoveData.clear();
	}
	
	public boolean init(Data d){
		return dataSource.add(d);
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
				for(Data tmp:dataSource){
					controller.applyKS(tmp);
				}
				removeDataInRemoveBuffer();
				flushBufferIntoDataSource();
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

	public ArrayList<Data> getDataSource() {
		return dataSource;
	}

	public void setDataSource(ArrayList<Data> dataSource) {
		this.dataSource = dataSource;
	}

	public ArrayList<Data> getBufferDataSource() {
		return bufferDataSource;
	}

	public void setBufferDataSource(ArrayList<Data> bufferDataSource) {
		this.bufferDataSource = bufferDataSource;
	}

	public ArrayList<Data> getBufferRemoveData() {
		return bufferRemoveData;
	}

	public void setBufferRemoveData(ArrayList<Data> bufferRemoveData) {
		this.bufferRemoveData = bufferRemoveData;
	}
	
}
