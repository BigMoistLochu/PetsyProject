package application.petsybackend.dtos;

public class AdvertisementRequest {

    private Long userId;
    private String title;
    private String description;
    private String imgPath;


    public AdvertisementRequest(Long userId, String title, String description, String imgPath) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.imgPath = imgPath;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
