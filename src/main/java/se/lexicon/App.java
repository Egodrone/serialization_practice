package se.lexicon;



import se.lexicon.model.Car;
import se.lexicon.model.Starship;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class App {


    public static void main(String[] args) {

        System.out.println(" ********* Exercises ********* ");
        System.out.println("------------------------------------------");

        /*
        * 1) Create a textfile (.txt) and fill it with some text content. (/content/text_article.txt)
        * In Java create a method that read in a String from file and return the String using FileReader.
        */

        File test_article_file = new File("content/text_article.txt");

        String result = read_str(test_article_file);
        System.out.println(result);

        System.out.println("------------------------------------------");

        /*
        * 2) Create a textfile (.txt) and fill it with lines of names. (/content/names.txt)
        * In Java create a method that read in the lines into a Collection of your choice using
        * BufferedReader. One line for each element in the Collection.
        */

        //File names_file = new File("content/names_file.txt");

        String textPath = "content/names.txt";
        List<String> text_lines = read_line(textPath);
        text_lines.forEach(System.out::println);

        System.out.println("------------------------------------------");

        /*
        * 3) In Java create a Collection that contains at least five String objects.
        * Then create a method that write each String object from the collection into a textfile.
        */

        List<String> strObj = new ArrayList<>();
        textPath = "content/sn_models.txt";
        strObj.add("SN 8 - model");
        strObj.add("SN 9 - model");
        strObj.add("SN 10 - model");
        strObj.add("SN 11 - model");
        strObj.add("SN 12 - model");
        write_to_text_file(textPath, strObj);

        System.out.println("------------------------------------------");

        /*
         * 4) Create a method that can copy a file using both BufferedInputStream and
         * BufferedOutputStream.
         */

        File copyFilesFrom = new File("content/sn_models.txt");
        File copyFilesTo = new File("content/copy_of_the_models.txt");

        copy_model_files(copyFilesFrom, copyFilesTo);

        System.out.println("------------------------------------------");
        /*
         * 5) In Java create a class called Car with properties like reg number, brand and model etc... The
         * Car class must implement Serializable. To also fulfil the contract make a default constructor.
         * a. Create a List of Cars and add some objects into it.
         * b. Save the List of Cars to a file using ObjectOutputStream.
         * c. Read the List of Cars from file using ObjectInputStream.
         */

        //List<Car> carList =
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("ART 342", "Volvo", "X60", 2020));
        carList.add(new Car("XCT 992", "BMW", "AAA", 2021));
        carList.add(new Car("ART 342", "Nissan", "BBB", 2000));
        carList.forEach(System.out::println);

        /*
         * 6) Make a small program called car_register.
         * a. Create models Car and Owner.
         * b. Car should have fields: carId, regNumber, brand, model, regDate and owner. It
         * should also implement Serializable together with a default constructor.
         * c. Owner should have fields: ownerId, name, birthdate. Owner also need to implement
         * Serializable and have a default contructor.
         * d. Create two collections, one for Cars and the other for Owners.
         * e. Create functionality to serialize the collections to JSON files.
         * f. Create functionality to deserialize the JSON files to it’s resepective Collection.
         */
    }


    public static String read_str(File source) {

        StringBuilder sb = new StringBuilder();

        try (
                FileReader reader = new FileReader(source)
        ) {
            int i;
            while ((i = reader.read()) != -1) {
                // append to string
                char letter = (char) i;
                sb.append(letter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }



    public static List<String> read_line(String source) {

        List<String> result = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(source))) {
            result = reader.lines()
                    .flatMap(line -> Stream.of(line.split(",")))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println(" File path is incorrect: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(" Error accrued: " + e.getMessage());
        }

        return result;
    }



    public static void write_to_text_file(String destination, List<String> objToAdd) {

        FileSystem fileSystem = FileSystems.getDefault();
        Path path = fileSystem.getPath(destination);

        objToAdd.forEach(name -> {
            try {
                Files.write(path, name.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                Files.write(path, "\n".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }



    public static void copy_model_files(File source, File destination) {
        //4
        try (
                FileInputStream inputStream = new FileInputStream(source);
                BufferedInputStream in = new BufferedInputStream(inputStream);
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination))
        ) {

            byte[] buffer = new byte[1024]; // 1 MB
            int byteRead;
            while ((byteRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, byteRead);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
