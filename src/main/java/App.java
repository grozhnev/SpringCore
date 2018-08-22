import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("app")
@Scope("singleton")
public class App {

    @Autowired
    @Qualifier("client")
    Client client;

    @Autowired
    @Qualifier("consoleLogger")
    EventLogger logger;

    @Autowired(required = false)
    Map<EventType, EventLogger> loggersMap;

    public App(Client client, EventLogger logger) {
        this.client=client;
        this.logger=logger;
    }

    public App(Client client, Map<EventType, EventLogger> map) {
        this.client=client;
        this.loggersMap = map;
    }

    void logEvent(String msg, EventType eventType){
        if (eventType == null){
            logger = new CacheFileEventLogger("12");
        } else if (eventType == EventType.INFO){
            logger=new ConsoleEventLogger();
        } else if (eventType==EventType.ERROR){
            logger = new FileEventLogger("somefile.txt");
        }

        String message = msg.replaceAll(client.getId(), client.getFullName());
        System.out.println(msg);
        logger.logEvent(new Event(message));
    }

    public static void main(String[] args) {
//        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
//        App app = (App) ctx.getBean("app");
//
//        app.logEvent("One million dollars for 1", EventType.INFO);
//        app.logEvent("One million dollars for 1", EventType.ERROR);
//
//        ctx.close();


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfigExample.class);
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.register(AnnotationConfigExample.class);
//        applicationContext.refresh();

//        context.scan("/");
//        context.refresh();


    }
}
