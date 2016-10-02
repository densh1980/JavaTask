package model.db_entities;

public class RecordMedium {
//    CREATE TABLE IF NOT EXISTS `shmyhin_epam_tasks_db`.`record_mediums` (
//            `id` INT NOT NULL AUTO_INCREMENT,
//  `type` VARCHAR(45) NULL COMMENT 'CD,DVD,Blu-ray,vinil_record,cassette',
//    PRIMARY KEY (`id`))

    private int id;
    private String type;

    public RecordMedium(int id, String type) {
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
        return "RecordMedium{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
