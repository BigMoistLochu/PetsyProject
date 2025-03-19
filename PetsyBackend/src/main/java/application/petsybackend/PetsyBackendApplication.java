package application.petsybackend;

import application.petsybackend.entities.User;
import application.petsybackend.entities.UserRole;
import application.petsybackend.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetsyBackendApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    public PetsyBackendApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(PetsyBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {}
}
