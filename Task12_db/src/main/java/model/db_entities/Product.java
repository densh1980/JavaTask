package model.db_entities;


public class Product {

//    CREATE TABLE IF NOT EXISTS `shmyhin_epam_tasks_db`.`products` (
//            `id` INT NOT NULL AUTO_INCREMENT,
//  `name` VARCHAR(45) NULL,
//  `description` VARCHAR(255) NULL,
//  `production_year` INT NULL,
//  `Qty` INT NULL,
//  `price` INT NULL,
//  `rating` INT NULL,
//  `record_mediums_id` INT NULL,
//  `media_types_id` INT NOT NULL,
//    PRIMARY KEY (`id`))

    private int id;
    private String name;
    private String description;
    private  int productionYear;
    private int qty;
    private  int price;
    private int  rating;
    private int record_mediums_id;
    private  int media_types_id;

    public Product(int id, String name, String description, int productionYear, int qty, int price, int rating, int record_mediums_id, int media_types_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productionYear = productionYear;
        this.qty = qty;
        this.price = price;
        this.rating = rating;
        this.record_mediums_id = record_mediums_id;
        this.media_types_id = media_types_id;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRecord_mediums_id() {
        return record_mediums_id;
    }

    public void setRecord_mediums_id(int record_mediums_id) {
        this.record_mediums_id = record_mediums_id;
    }

    public int getMedia_types_id() {
        return media_types_id;
    }

    public void setMedia_types_id(int media_types_id) {
        this.media_types_id = media_types_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", productionYear=" + productionYear +
                ", qty=" + qty +
                ", price=" + price +
                ", rating=" + rating +
                ", record_mediums_id=" + record_mediums_id +
                ", media_types_id=" + media_types_id +
                '}';
    }
}
