package net.yorksolutions.quizbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(@NonNull QuizService quizService){
        this.quizService = quizService;
    }
@GetMapping("/test")
    public String hello(){
        return "Testing";
}

}
