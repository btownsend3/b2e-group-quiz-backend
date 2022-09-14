package net.yorksolutions.quizbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuizService {
    private final QuizRepo repo;
    private final RestTemplate restTemplate;

    @Autowired
    public QuizService(@NonNull QuizRepo repo) {
        this.repo = repo;
        this.restTemplate = new RestTemplate();
    }
    public void create(){

    }
    public Iterable getQuizList(){
        return repo.findAll();
    }
    public void editQuiz(){

    }
    public void deleteQuiz(){

    }
}
