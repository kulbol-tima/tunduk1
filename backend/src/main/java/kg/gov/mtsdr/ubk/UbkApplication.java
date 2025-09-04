package kg.gov.mtsdr.ubk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.retry.annotation.EnableRetry;

@EnableCaching
@EnableRetry
@SpringBootApplication
public class UbkApplication {

    public static void main(String[] args) {
        SpringApplication.run(UbkApplication.class, args);
    }

}
