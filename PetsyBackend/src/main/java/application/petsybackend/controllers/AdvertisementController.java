package application.petsybackend.controllers;

import application.petsybackend.dtos.AdvertisementRequest;
import application.petsybackend.entities.Advertisement;
import application.petsybackend.services.AdvertisementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/advertisement")
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping
    public ResponseEntity<List<Advertisement>> getAllAdvertisements(){
        List<Advertisement> allAdvertisements = advertisementService.getAllAdvertisements();
        return ResponseEntity.status(HttpStatus.OK).body(allAdvertisements);
    }

    @PostMapping
    public ResponseEntity<Advertisement> createAdvertisement(@RequestBody AdvertisementRequest request){
        Advertisement advertisement = advertisementService.createAdvertisement(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(advertisement);
    }


}
