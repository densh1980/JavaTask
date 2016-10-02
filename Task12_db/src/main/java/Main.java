import model.VideoAudioShop;

import java.io.IOException;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
        VideoAudioShop shop = new VideoAudioShop();
        try {

            shop.initDbConnection();
            shop.updateModel();

            System.out.println("Users Table");
            shop.getUsers().forEach( u -> System.out.println(u) );

            System.out.println("\n Product Table");
            shop.getProducts().forEach(p -> System.out.println(p));

            System.out.println("\n Orders Table");
            shop.getOrders().forEach(o -> System.out.println(o));


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
