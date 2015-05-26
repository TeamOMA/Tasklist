import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

import io.dropwizard.Configuration;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;


public class TaskListConfiguration extends Configuration
{
	
	
	
	
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultTask = "";

    @JsonProperty
    public String getTemplate()
    {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template)
    {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultTask()
    {
        return defaultTask;
    }

    @JsonProperty
    public void setDefaultTask(String task)
    {
        this.defaultTask = task;
    }

    @NotNull
    private Map<String, Map<String,String>> task = Collections.emptyMap();

    public Map<String, Map<String,String>> getTask()
    {
        // to implement

        return null;
    }

    @JsonProperty("task")
    public void setTask(Map<String, Map<String,String>> task)
    {
        //
        // code copied from:
        // http://www.dropwizard.io/getting-started.html
        //
        ImmutableMap.Builder<String, Map<String,String>> builder = ImmutableMap.builder();
        for(Map.Entry<String, Map<String,String>> entry : task.entrySet())
        {
            builder.put(entry.getKey(), ImmutableMap.copyOf(entry.getValue()));
        }
        this.task = builder.build();
    }
}
