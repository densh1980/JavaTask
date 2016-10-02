package model;

import model.db_entities.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;


public class VideoAudioShop {

    ArrayList<Category> categories;
    ArrayList<MediaType> mediaType;
    ArrayList<Order> orders;
    ArrayList<Product> products;
    ArrayList<RecordMedium> recordMediums;
    ArrayList<User> users;

    Connection connection;
    public void initDbConnection () throws SQLException, IOException {

        InputStream is = this.getClass().getResourceAsStream("/config.properties");
        Properties props = new Properties();
        props.load(is);
        String conStr = props.getProperty("url")+
                        props.getProperty("time_options")+
                        props.getProperty("security_options");
        connection = DriverManager.getConnection(conStr,props.getProperty("dbuser"),props.getProperty("dbpassword"));

    }

    /***
     * fetch new data from DB
     */
        public void updateModel(){

            updateOrders();
            updateProducts();
            updateUsers();
//            updateCategories();
//            updateMediaType();
//            updateRecordMediums();
    }

    // update functions for each table from db

    public void updateCategories() {
        categories = new ArrayList<>();
        try( PreparedStatement query = connection.prepareStatement("SELECT * FROM categories")) {

            ResultSet rs = query.executeQuery();
            while(rs.next()){
                Category   cat = new Category(rs.getInt("id"), rs.getString("name"));
                categories.add(cat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void updateOrders() {
        orders = new ArrayList<>();
        try( PreparedStatement query = connection.prepareStatement("SELECT * FROM orders")) {

            ResultSet rs = query.executeQuery();
            while(rs.next()){
                Order  ord = new Order(rs.getInt("id"),
                                        rs.getDate("date"),
                                        Order.OrderStatus.valueOf(rs.getString("order_status").toUpperCase()),
                                        rs.getInt("total_amount"),
                                        rs.getInt("id"));
                orders.add(ord);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProducts() {

        products = new ArrayList<>();
        try( PreparedStatement query = connection.prepareStatement("SELECT * FROM products")) {

            ResultSet rs = query.executeQuery();
            while(rs.next()){
                Product  prd = new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("production_year"),
                        rs.getInt("Qty"),
                        rs.getInt("price"),
                        rs.getInt("rating"),
                        rs.getInt("record_mediums_id"),
                        rs.getInt("media_types_id"));

                products.add(prd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void  updateUsers() {

       users = new ArrayList<>();
        try( PreparedStatement query = connection.prepareStatement("SELECT * FROM users")) {

            ResultSet rs = query.executeQuery();
            while(rs.next()){
                User usr = new User(rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone"),
                        rs.getString("email"));
                users.add(usr);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateRecordMediums() {
        throw new NotImplementedException();
    }

    public void  updateMediaType() {
        mediaType = new ArrayList<>();
        try( PreparedStatement query = connection.prepareStatement("SELECT * FROM media_types")) {

            ResultSet rs = query.executeQuery();
            while(rs.next()){
                MediaType   media = new MediaType(rs.getInt("id"), rs.getString("type"));
                mediaType.add(media);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // getters

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<MediaType> getMediaType() {
        return mediaType;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<RecordMedium> getRecordMediums() {
        return recordMediums;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
