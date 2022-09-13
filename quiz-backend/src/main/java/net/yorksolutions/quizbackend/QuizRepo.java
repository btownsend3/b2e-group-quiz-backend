package net.yorksolutions.quizbackend;

import org.springframework.data.repository.CrudRepository;

public interface QuizRepo extends CrudRepository <Quiz, Long> {
    Boolean existsByTitle(String title);
}
