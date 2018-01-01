package net.tekpartner.learn.many2many;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Chandrashekar R. Gaajula
 */
@SpringBootApplication
@EnableJpaRepositories("net.tekpartner.learn.many2many.repositories.jpa")
public class Many2manyApplication {

    public static void main(String[] args) {
        SpringApplication.run(Many2manyApplication.class, args);
    }
}
