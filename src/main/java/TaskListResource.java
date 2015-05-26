import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;

import java.util.concurrent.atomic.AtomicLong;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
public class TaskListResource
{
    private final String template;
    private final String defaultTask;
    private final AtomicLong idCounter;

    public TaskListResource(String template, String defaultTask)
    {
        this.template = template;
        this.defaultTask = defaultTask;
        this.idCounter = new AtomicLong();
    }

    @GET
    @Timed
    public ArrayList<Task> sayTask(@QueryParam("tasks") String task)
    {
    	
    	ArrayList<Task> taskList= new ArrayList<Task>(); 
    	Task t= new Task();
    	t.setId(1);
    	t.setTaskDescription("wake up");
    	taskList.add(t);
    	t = new Task();
    	t.setId(2);
    	t.setTaskDescription("wake the fuck up");
    	taskList.add(t);
    	//final String value = String.format(template, task);
        //return new Saying(idCounter.incrementAndGet(), value);
    	return taskList;
    }
    
    /*
    @POST
    public void SaveTasks (ArrayList<Task> tasks)
    {
    	
    }
    */
}
