package PJT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewManager implements IReviewManager {
    private Map<Integer, List<Review>> reviews;

    public ReviewManager() {
        this.reviews = new HashMap<>();
    }

    public void addReview(int videoNo, Review review) {
        if (!reviews.containsKey(videoNo)) {
            reviews.put(videoNo, new ArrayList<>());
        }
        reviews.get(videoNo).add(review);
    }

    public void deleteReview(int videoNo, Review review) {
        if (reviews.containsKey(videoNo)) {
            reviews.get(videoNo).remove(review);
        }
    }

    public List<String> listReviews(int videoNo) {
        List<String> reviewInfos = new ArrayList<>();
        if (reviews.containsKey(videoNo)) {
            for (Review review : reviews.get(videoNo)) {
                reviewInfos.add(review.display());
            }
        }
        return reviewInfos;
    }
}