package model.db_entities;

/**
 * Created by Андрей on 02.10.2016.
 */
public class Category {

//    CREATE TABLE IF NOT EXISTS `shmyhin_epam_tasks_db`.`categories` (
//     id` INT NOT NULL AUTO_INCREMENT,
//    `name` VARCHAR(45) NULL,
//    PRIMARY KEY (`id`),
//    INDEX `categories_category_idx` (`name` ASC))

    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
