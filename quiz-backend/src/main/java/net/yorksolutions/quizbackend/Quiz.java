package net.yorksolutions.quizbackend;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty
    Long id;
    @JsonProperty
    String title;
    @JsonProperty
    String description;
    @JsonProperty
    @ElementCollection
    List<HashMap> questions;
    @JsonProperty
    @OneToMany(cascade = CascadeType.ALL)
    List<Response> responses;

}
