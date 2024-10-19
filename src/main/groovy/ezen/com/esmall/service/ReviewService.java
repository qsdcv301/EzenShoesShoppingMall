package ezen.com.esmall.service;

import ezen.com.esmall.entity.Review;
import ezen.com.esmall.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review findById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    public Review update(Long id, Review reviewDetails) {
        Review review = findById(id);
        if (review != null) {
            review.update(reviewDetails.getComment(), reviewDetails.getTitle(), reviewDetails.getStarRate());
            return reviewRepository.save(review);
        }
        return null;
    }

    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    public List<Review> findAllByProductId(Long productId) {
        return reviewRepository.findAllByProductId(productId);
    }

    public int countAllByProductId(Long productId) {
        return reviewRepository.countAllByProductId(productId);
    }
}
