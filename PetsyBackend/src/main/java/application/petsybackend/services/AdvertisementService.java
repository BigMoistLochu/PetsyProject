package application.petsybackend.services;


import application.petsybackend.dtos.AdvertisementRequest;
import application.petsybackend.entities.Advertisement;
import application.petsybackend.entities.user.User;
import application.petsybackend.repositories.AdvertisementRepository;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final UserService userService;

    public AdvertisementService(AdvertisementRepository advertisementRepository, UserService userService) {
        this.advertisementRepository = advertisementRepository;
        this.userService = userService;
    }

    public Advertisement createAdvertisement(AdvertisementRequest advertisementRequest){
        User user = userService.getUserById(advertisementRequest.getUserId());
        Advertisement advertisement = new Advertisement(user,advertisementRequest.getTitle(), advertisementRequest.getDescription(), advertisementRequest.getImgPath());

        return advertisementRepository.save(advertisement);
    }


}
