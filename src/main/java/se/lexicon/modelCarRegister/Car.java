package se.lexicon.modelCarRegister;



import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;



public class Car implements Serializable {

    private UUID carId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String regNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String brand;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String model;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Owner owner;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate regDate;



    public Car() {
    }



    public Car(String regNumber, String brand, String model, Owner owner, LocalDate regDate) {
        this.carId = UUID.randomUUID();
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.owner = owner;
        this.regDate = regDate;
    }



}
