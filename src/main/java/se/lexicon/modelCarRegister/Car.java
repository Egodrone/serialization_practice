package se.lexicon.modelCarRegister;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;



public class Car implements Serializable {
    //carId, regNumber, brand, model, regDate and owner
    private UUID carId;
    private String regNumber;
    private String brand;
    private String model;
    private LocalDate regDate;
    private String owner;

    public Car() {
    }
}
