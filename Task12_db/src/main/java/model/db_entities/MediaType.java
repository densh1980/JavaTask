package model.db_entities;

public class MediaType {

//    CREATE TABLE IF NOT EXISTS `shmyhin_epam_tasks_db`.`media_types` (
//            `id` INT NOT NULL,
//            `type` VARCHAR(45) NULL,
//    PRIMARY KEY (`id`))

    private int id;
    private String type;

    public MediaType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MediaType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
