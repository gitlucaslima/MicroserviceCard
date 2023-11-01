package io.github.gitlucaslima.mscartoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MscartoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscartoesApplication.class, args);
    }

}
