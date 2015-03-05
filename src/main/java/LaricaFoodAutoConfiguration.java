import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.laricafood")
public class LaricaFoodAutoConfiguration {

    public static void main(String[] args) {

        SpringApplication.run(LaricaFoodAutoConfiguration.class, args);
    }
}
