/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rasmus2
 */
public class OrderMapper {

    public static void createOrder(Order order, User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `useradmin`.`orders`(`user_id`,`order_date`,`order_length`,`order_width`,`order_heigth`,`order_status`) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user.getId());
            ps.setString(2, order.getOrder_date().toString());
            ps.setFloat(3, order.getOrder_length());
            ps.setFloat(4, order.getOrder_width());
            ps.setFloat(5, order.getOrder_height());
            ps.setInt(6, order.getOrder_status());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setOrder_id(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static List<Order> getAllOrders() throws LoginSampleException {
        List<Order> list = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM useradmin.orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getInt(2), rs.getDate(3).toLocalDate(), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6));
                order.setOrder_id(rs.getInt(1));
                order.setOrder_status(rs.getInt(7));
                list.add(order);
            }
            return list;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static List<Order> getOrderHistory(User user) throws LoginSampleException {
        List<Order> list = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM useradmin.orders WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user.getId());
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getInt(2), rs.getDate(3).toLocalDate(), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6));
                order.setOrder_id(rs.getInt(1));
                order.setOrder_status(rs.getInt(7));
                list.add(order);
            }
            return list;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void changeOrderStatus(int status, Order order) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE `useradmin`.`orders` SET `order_status` =? WHERE `order_id` =?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, status);
            ps.setInt(2, order.getOrder_id());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static Order findSpecificOrder(int order_id) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM useradmin.orders WHERE order_id=?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Order order = new Order(rs.getInt(2), rs.getDate(3).toLocalDate(), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6));
                order.setOrder_id(rs.getInt(1));
                order.setOrder_status(rs.getInt(7));
                return order;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getAllOrders());
    }

}
