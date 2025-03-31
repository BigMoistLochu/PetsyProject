package application.petsybackend.services;


import application.petsybackend.dtos.user.UserDTO;
import application.petsybackend.dtos.user.UserRequest;
import application.petsybackend.entities.user.User;
import application.petsybackend.entities.user.UserRole;
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

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserDTO createUser(UserRequest userRequest){
        User user = new User(userRequest.getUsername(),userRequest.getEmail(),userRequest.getPassword(), UserRole.USER,"default/path");
        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser.getUsername(),savedUser.getEmail());
    }


    //weryfikacja emaila uzytkownika (wyslanie mu maila)

}
