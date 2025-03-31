package application.petsybackend.repositories;


import application.petsybackend.entities.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {

    @Query("SELECT A FROM Advertisement A JOIN FETCH A.user")
    List<Advertisement> getAllAdvertisements();

}
