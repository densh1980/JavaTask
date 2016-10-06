package ua.epam.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ua.epam.entities.User;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Denys_Shmyhin on 10/6/2016.
 */

public class ParserJson {

    public static void main(String[] args) throws IOException, URISyntaxException, InstantiationException, IllegalAccessException {

        URL url = ParserJson.class.getResource("/source_users.json");
        Path path = Paths.get(url.toURI());

        //read  enteties from json

        List<User> res = readUsersFromJson(path);
        res.forEach(s -> System.out.println(s));

        // make some changes in id and phone
        res = res.stream()
                .filter(u -> u.getFirstName().contains("Иван"))
                .map(user -> {
                    int s = user.getId() + 10;
                    user.setId(s);
                    user.setPhone("911");
                    return user;
                })
                .collect(Collectors.toList());
        //write  result enteties to new json

        Path path2 = Paths.get("c:/temp/users_new.json");
        writeUserToJsonFile(res, path2);

    }

    public static void writeUserToJsonFile(List<User> list, Path path) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        //write to file
        mapper.writeValue(new File(path.toString()), list);

    }

    public static List<User> readUsersFromJson(Path path) throws IOException {

        byte[] data = Files.readAllBytes(path);
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(data, User[].class));
    }

}
