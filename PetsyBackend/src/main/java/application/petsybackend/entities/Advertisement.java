package application.petsybackend.entities;


import application.petsybackend.entities.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "advertisement")
@Setter
@Getter
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private String title;

    private String description;

    private String imgPath;

    public Advertisement(){}

    public Advertisement(User user, String title, String description, String imgPath) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.imgPath = imgPath;
    }
}
