package knowledgesource;

/**
 * Copyright (C), 2001-2012, Aha
 * <br/>Date:2012-12-01 
 * @author  Aha tzl77258511@gmail.com
 * @version  1.0
 */
public interface IKnowledgeSource {
	public boolean isNeeded(Object o);
	public boolean operation(Object o);
	public boolean regist(Object o);
}
