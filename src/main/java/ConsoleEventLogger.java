import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("consoleLogger")
@Scope("prototype")
public class ConsoleEventLogger implements EventLogger{
    public void logEvent(Event event){
        System.out.println(event.toString());
    }
}
