package se.lexicon.util;



import java.io.*;



public class SerializationUtil {

    public static <T> void serialize(T t){
        String fileName = t.getClass().getName() + ".ser";

        try(
                FileOutputStream stream= new FileOutputStream(fileName);
                ObjectOutputStream out= new ObjectOutputStream(stream);
        ){
            out.writeObject(t);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static <T> T deserialize(String fileName){

        try (
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        ){
            return  (T)in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }



}
