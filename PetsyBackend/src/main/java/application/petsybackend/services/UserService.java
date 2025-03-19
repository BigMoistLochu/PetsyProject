package application.petsybackend.services;


import application.petsybackend.entities.User;
import application.petsybackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUserByUsername(String username){
        return userRepository.findByUsername(username).orElse(null);
    }

}
