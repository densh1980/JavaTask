package ua.epam.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import ua.epam.entities.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Denys_Shmyhin on 10/6/2016.
 */

public class ParseExcel {

    public static void main(String[] args) {

        String  path = ParseExcel.class.getResource("/users.xls").getPath();
        parse(path).forEach(user -> System.out.println(user));
    }


    public static List<User> parse(String fileName) {
        //инициализируем потоки
//        String result = "";
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //разбираем первый лист входного файла на объектную модель

        List<User>  result  = new ArrayList<User>();
        Sheet sheet = workBook.getSheetAt(0);

        int numberOfEntities =  sheet.getLastRowNum();
        int numberOfFields = 4;

        for (int i = 1; i <= numberOfEntities; i++) {
            User user = new User();
            Row row = sheet.getRow(i);
            user.setId((int)row.getCell(0).getNumericCellValue());
            user.setFirstName(row.getCell(1).toString());
            user.setLastName(row.getCell(2).toString());
            user.setPhone(row.getCell(3).toString());
            user.setEmail(row.getCell(4).toString());
            result.add(user);
        }

        return result;
    }


}
