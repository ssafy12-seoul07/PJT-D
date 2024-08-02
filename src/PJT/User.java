package PJT;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String user;
    private List<Review> reviews;

    public User(String user) {
        this.user = user;
        this.reviews = new ArrayList<>();
    }

    public void writeReview(Review review) {
        reviews.add(review);
    }

    public void deleteReview(Review review) {
        reviews.remove(review);
    }

    // Getter와 Setter 추가 가능
}
