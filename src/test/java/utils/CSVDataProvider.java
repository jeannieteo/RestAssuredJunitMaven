// File: src/test/java/utilities/CSVDataProvider.java
package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

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
}
