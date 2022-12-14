package net.yorksolutions.quizbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
public class QuizService {
    private final QuizRepo repo;
    private final ResponseRepo responseRepo;
    private final RestTemplate restTemplate;

    @Autowired
    public QuizService(@NonNull QuizRepo repo, @NonNull ResponseRepo responseRepo) {
        this.repo = repo;
        this.responseRepo = responseRepo;
        this.restTemplate = new RestTemplate();
    }

    public Boolean checkAuth(UUID token, String role) {
        try {
            ResponseEntity<Boolean> response = this.restTemplate.getForEntity("http://localhost:8080/checkAuth/" + token + "?role=" + role, Boolean.class);
            return response.getBody();
        } catch (RestClientException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public void createQuiz(@RequestBody Quiz quiz) {
        if (repo.existsByTitle(quiz.title)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Quiz with title " + quiz.title + " already exists");
        } else {
            repo.save(quiz);
        }
    }

    public Iterable getQuizList() {
        return repo.findAll();
    }

    public void editQuiz(Quiz quiz) {
        this.repo.save(quiz);
    }

    public void delete(Long id) {
        Optional<Quiz> quiz = this.repo.findById(id);
        if (quiz.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.GONE);
        } else {
            this.repo.deleteById(id);
        }
    }

    public void addResponse(Long id, Response response) {
        Optional<Quiz> quiz = this.repo.findById(id);
        if (quiz.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.GONE);
        } else {
            quiz.get().responses.add(response);
            repo.save(quiz.get());
        }
    }

    public void grade(Long id, Float grade) {
        Optional<Response> res = this.responseRepo.findById(id);
        if (res.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            res.get().grade = grade;
            this.responseRepo.save(res.get());
        }
    }
}
