package demo;

public class Product {
    private String title;
    private String imageUrl;
    private int reviews;

    public Product(String title, String imageUrl, int reviews) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.reviews = reviews;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getReviews() {
        return reviews;
    }
}