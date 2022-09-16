package net.yorksolutions.quizbackend;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty
    Long id;
    @JsonProperty
    String username; //user: applicant
    @JsonProperty
    @ElementCollection
    List<HashMap> answers;
    @JsonProperty
    Float grade;

    public Response(String username, Float grade) {
        this.username = username;
        this.answers = new ArrayList<>();
        this.grade = grade;
    }

    public Response() {}
}
