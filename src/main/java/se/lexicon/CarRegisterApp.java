package se.lexicon;



import se.lexicon.modelCarRegister.Car;
import se.lexicon.modelCarRegister.Owner;
import se.lexicon.util.JsonIOUtil;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class CarRegisterApp {

    public static void main(String[] args) {
        System.out.println("car_register program");

        JsonIOUtil util = new JsonIOUtil();
        List<Car> cars = new ArrayList<>();
        List<Owner> owners = new ArrayList<>();

        Owner owner1 = new Owner("Stefan", LocalDate.parse("1980-01-01"));
        Owner owner2 = new Owner("Jocko", LocalDate.parse("1990-01-01"));

        owners.add(owner1);
        owners.add(owner2);

        Car bugatti = new Car("ABC123","Bugatti","Veyron EB", owner1, LocalDate.parse("2021-02-27"));
        Car bmw = new Car("TTB666","BMW","X6", owner2, LocalDate.parse("2020-01-01"));
        cars.add(bugatti);
        cars.add(bmw);

        File carFile = new File("cars.json");
        File ownerFile = new File("owner.json");

        util.serializeCarListToJson(cars, carFile);
        util.serializeOwnerListToJson(owners, ownerFile);

        List<Car> result =  util.deserializeJsonListToCar(carFile);
        List<Owner> result2 =  util.deserializeJsonListToOwner(ownerFile);
        System.out.println(result.toString());
        System.out.println(result2.toString());
        System.out.println("-----------------------------------------");
    }



}
