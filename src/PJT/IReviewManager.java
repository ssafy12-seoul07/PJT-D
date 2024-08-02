package PJT;

import java.util.List;

public interface IReviewManager {
    void addReview(int videoNo, Review review);
    void deleteReview(int videoNo, Review review);
    List<String> listReviews(int videoNo);
}
