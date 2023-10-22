package dev.jgranizo.inditex.launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(
        basePackages = {
                "dev.jgranizo.inditex.model",
                "dev.jgranizo.inditex.definition",
                "dev.jgranizo.inditex.controller"
        }
)
@EntityScan(basePackages = {
        "dev.jgranizo.inditex.model.entity"
})
@EnableJpaRepositories(basePackages = {
        "dev.jgranizo.inditex.model.repository"
})
public class InditexApplication {

    private static final Logger log = LogManager.getLogger(InditexApplication.class);

    public static void main(String[] args) throws Exception {

        System.setProperty("spring.config.location", System.getProperty("user.dir") + "/launcher/conf/application.yaml");

        try {
            SpringApplication.run(InditexApplication.class, args);
        } catch (Exception ex) {
            log.error("Error launching api process", ex);
            throw ex;
        }
    }
}