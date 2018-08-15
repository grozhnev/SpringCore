import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    Client client;
    ConsoleEventLogger logger;

    public App(Client client, ConsoleEventLogger logger) {
        this.client=client;
        this.logger=logger;
    }

    void logEvent(String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());
        System.out.println(msg);
        logger.logEvent(message);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        App app = (App) ctx.getBean("app");

        app.logEvent("One million dollars for 1");
    }
}
