/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.time.LocalDate;

/**
 *
 * @author Rasmus2
 */
public class Order {
    private int order_id;
    private int user_id;
    private LocalDate order_date;
    private float order_length;
    private float order_width;
    private float order_height;
    private int order_status = 0;

    public Order(int user_id, LocalDate order_date, float order_length, float order_width, float order_height) {
        this.user_id = user_id;
        this.order_date = order_date;
        this.order_length = order_length;
        this.order_width = order_width;
        this.order_height = order_height;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public float getOrder_length() {
        return order_length;
    }

    public float getOrder_width() {
        return order_width;
    }

    public float getOrder_height() {
        return order_height;
    }

    public int getOrder_status() {
        return order_status;
    }

    public String getSent() {
        if (order_status == 1) {
            return "Sent";
        } else {
            return "Not sent";
        }
    }

    @Override
    public String toString() {
        return "Order_id=" + order_id + ", Order_date=" + order_date + ", Order_length=" + order_length + ", Order_width=" + order_width + ", Order_height=" + order_height + ", Order_status=" + getSent();
    }

}
