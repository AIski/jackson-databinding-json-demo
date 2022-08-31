package pl.alski.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {

        try{

            //create the object mapper

            ObjectMapper mapper = new ObjectMapper();

            //read JSON file and map/convert to Java POJO: data/sample-full.json

            Student theStudent=
                    mapper.readValue(
                            new File("data/sample-full.json"),
                            Student.class);

            // print first name and last name

            System.out.println("Student first name = " + theStudent.getFirstName());
            System.out.println("Student last name = " + theStudent.getLastName());

            //print out address:
            Address tempAddress=theStudent.getAddress();
            System.out.println("Student Address Street = " + tempAddress.getStreet());
            System.out.println("Student Adress City = " + tempAddress.getCity());

            System.out.println("Student Languages: ");
            for (String lang: theStudent.getLanguages()){
                System.out.println(lang);
            }


        } catch (Exception exc){
            exc.printStackTrace();
        }



    }
}
