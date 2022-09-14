package net.yorksolutions.quizbackend;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
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

}
