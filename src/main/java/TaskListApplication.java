import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


public class TaskListApplication extends Application<TaskListConfiguration>
{
    public static void main(String[] args) throws Exception
    {
        new TaskListApplication().run(args);
    }

    //@Override
    public String getTask()//getName()
    {
        return "Add new task";
    }

    @Override
    public void initialize(Bootstrap<TaskListConfiguration> bootstrap)
    {

    }

    @Override
    public void run(TaskListConfiguration configuration, Environment environment) throws Exception
    {
        final TaskListResource resource = new TaskListResource(
          configuration.getTemplate(),
          configuration.getDefaultTask()
        );

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
