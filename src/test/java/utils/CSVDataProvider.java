// File: src/test/java/utilities/CSVDataProvider.java
package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import model.Order;
import model.Pet;

public class CSVDataProvider {

    public static List<Pet> readPetCSV(String filePath) {
        List<Pet> pets = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            boolean skipHeader = true;
            while ((nextLine = reader.readNext()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }
                Pet pet = new Pet();
                pet.setId(Long.parseLong(nextLine[0]));
                pet.setName(nextLine[1]);
                pet.setStatus(nextLine[2]);
                pets.add(pet);
            }
        } catch (IOException|CsvValidationException e) {
            e.printStackTrace();
        }
        return pets;
    }

    public static List<Order> readOrderCSV(String filename) {
        List<Order> orders = new ArrayList<>();
        try(CSVReader csvReader = new CSVReader(new FileReader(filename)))   {
            String[] nextLine;
            boolean isFirstLine = true;
            while ((nextLine = csvReader.readNext()) != null) {
                if (isFirstLine) { // Skip header
                isFirstLine = false;
                continue;
            }
                Order order = new Order();
                order.setId(Integer.parseInt(nextLine[0]));
                order.setPetId(Integer.parseInt(nextLine[1]));
                order.setQuantity(Integer.parseInt(nextLine[2]));
                Date dateNow = new Date();
                order.setShipDate(dateNow.toString());
                order.setStatus(nextLine[3]);
                order.setComplate(Boolean.getBoolean(nextLine[4]));

            }
        }  catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    
        return orders;
    }
}
