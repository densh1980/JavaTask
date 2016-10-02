package model.db_entities;


import java.util.Date;

public class Order {

//    CREATE TABLE IF NOT EXISTS `shmyhin_epam_tasks_db`.`orders` (
//   `id` INT NOT NULL AUTO_INCREMENT,
//  `date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
//  `order_status` ENUM('new', 'in_progress', 'closed') NULL DEFAULT 'new',
//            `total_amount` INT NULL,
//  `users_id` INT NOT NULL,
//    PRIMARY KEY (`id`))

    private int id;
    private Date date;
    private OrderStatus orderStatus;
    private int totalAmount;
    private int user_id;

    public Order(int id, Date date, OrderStatus orderStatus, int totalAmount, int user_id) {
        this.id = id;
        this.date = date;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.user_id = user_id;
    }

    public static enum OrderStatus{
        NEW, IN_PROGRESS, CLOSED
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", orderStatus=" + orderStatus +
                ", totalAmount=" + totalAmount +
                ", user_id=" + user_id +
                '}';
    }
}
