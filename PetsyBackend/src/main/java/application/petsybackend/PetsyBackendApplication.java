package application.petsybackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetsyBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PetsyBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Zmienne srodowiskowe: " + System.getenv());
    }
}
