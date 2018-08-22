<<<<<<< Updated upstream
package PACKAGE_NAME;

public class AnnotationConfigExample {
=======
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfigExample {

    @Bean
    public Client client(){
        return new Client();
    }
>>>>>>> Stashed changes
}
