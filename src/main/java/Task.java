import com.fasterxml.jackson.annotation.JsonProperty;


public class Task 
{
	private int id;
	private String taskDescription;
	@JsonProperty
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonProperty
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
}
