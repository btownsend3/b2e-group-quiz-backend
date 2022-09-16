package net.yorksolutions.quizbackend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResponseRepo extends CrudRepository<Response, Long> {
    Optional<Response> findById(Long id);
}
