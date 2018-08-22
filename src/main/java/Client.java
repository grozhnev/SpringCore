import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("client")
@Scope("singleton")
public class Client {
    @Value("Alexander Gradsky")
    String fullName;

    String id;
    String greeting;

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Client() {
        id = null;
        fullName = null;
    }

    public Client(String id, String name) {
        this.id = id;
        this.fullName = name;
    }

    String getId(){
        return id;
    }

    String getFullName(){
        return fullName;
    }
}
