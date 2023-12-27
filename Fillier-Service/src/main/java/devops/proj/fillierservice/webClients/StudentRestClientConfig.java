package devops.proj.fillierservice.webClients;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentRestClientConfig {
    @Bean
    public StudentRestClient studentRestClient() {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .encoder(new GsonEncoder())
                .target(StudentRestClient.class, "http://localhost:8085");
    }
}
