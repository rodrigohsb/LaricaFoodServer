import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
@Configuration
@ComponentScan(basePackages = "com.laricafood")
@EnableAutoConfiguration(exclude = {JpaBaseConfiguration.class, HibernateJpaAutoConfiguration.class, SolrAutoConfiguration.class})
public class LaricaFoodAutoConfiguration {

    public static void main(String[] args) {

        SpringApplication.run(LaricaFoodAutoConfiguration.class, args);
    }
}
