package ua.epam.csv;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import ua.epam.entities.User;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Denys_Shmyhin on 10/6/2016.
 */
public class ParserCsv {
    public static void main(String[] args) throws IOException {

        URL url = ParserCsv.class.getResource("/users.csv");
        List<User> emps = parseCSVToBeanList(url);
        emps.forEach(s -> System.out.println(s));

    }
    private static List<User> parseCSVToBeanList(URL url) throws IOException {

        HeaderColumnNameTranslateMappingStrategy<User> beanStrategy
                = new HeaderColumnNameTranslateMappingStrategy<User>();
        beanStrategy.setType(User.class);
        //id,first_name,last_name,phone,email
        Map<String, String> columnMapping = new HashMap<String, String>();
        columnMapping.put("id", "id");
        columnMapping.put("first_name", "firstName");
        columnMapping.put("last_name", "lastName");
        columnMapping.put("phone", "phone");
        columnMapping.put("email", "email");

        beanStrategy.setColumnMapping(columnMapping);

        CsvToBean<User> csvToBean = new CsvToBean<User>();
        CSVReader reader = new CSVReader(new FileReader(url.getPath()));
        List<User> emps = csvToBean.parse(beanStrategy, reader);
        return  emps;
    }


}
