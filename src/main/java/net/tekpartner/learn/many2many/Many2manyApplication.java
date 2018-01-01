package net.tekpartner.learn.many2many;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Chandrashekar R. Gaajula
 */
@SpringBootApplication
@ComponentScan("net.tekpartner.learn.many2many")
public class Many2manyApplication {

    public static void main(String[] args) {
        SpringApplication.run(Many2manyApplication.class, args);
    }
}
