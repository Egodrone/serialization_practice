package se.lexicon.modelCarRegister;



import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;



public class Owner implements Serializable {

    private UUID ownerId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate birthdate;



    public Owner() {
    }



    public Owner(String name, LocalDate birthdate) {
        this.ownerId = UUID.randomUUID();
        this.name = name;
        this.birthdate = birthdate;
    }



}
