package dev.jgranizo.inditex.launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
        basePackages = {
                "dev.jgranizo.inditex.model",
        }
)
public class InditexApplication {

    private static final Logger log = LogManager.getLogger(InditexApplication.class);

    static {
        System.setProperty("spring.config.location", System.getProperty("user.dir") + "/launcher/conf/application.yaml");
    }

    public static void main(String[] args) throws Exception {
        try {
            SpringApplication.run(InditexApplication.class, args);
        } catch (Exception ex) {
            log.error("Error launching api process", ex);
            throw ex;
        }
    }
}