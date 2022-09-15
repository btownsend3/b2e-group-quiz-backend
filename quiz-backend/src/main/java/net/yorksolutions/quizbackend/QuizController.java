package net.yorksolutions.quizbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(@NonNull QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/test")
    public String hello() {
        return "Testing";
    }

    @PostMapping("/create")
    public void createQuiz(@RequestParam UUID token, @RequestBody Quiz quiz) {
//        if (!this.quizService.checkAuth(token, "admin")) {
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You are not authorized to create quizzes");
//        } else {
//        }
            this.quizService.createQuiz(quiz);
    }

    @PostMapping("/edit")
    public void editQuizList(@RequestParam UUID token, @RequestBody Quiz quiz) {
//        if (this.quizService.checkAuth(token, "admin")) {
//        } else throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "only admin can edit quizzes");
            this.quizService.editQuiz(quiz);

    }

    @GetMapping("/delete")
    public void delete(@RequestParam Long id) {
        this.quizService.delete(id);
    }

    @GetMapping("/get-quizzes")
    public Iterable<Quiz> get() {
        return this.quizService.getQuizList();
    }


}
