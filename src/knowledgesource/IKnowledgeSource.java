package knowledgesource;


public interface IKnowledgeSource {
	public boolean isNeeded(Object o);
	public boolean operation(Object o);
	public boolean regist(Object o);
}
