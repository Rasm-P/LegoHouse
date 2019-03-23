package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Rasmus2
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static Styklist stykliste(float length, float width, float height) throws OrderSampleException {
        float TotalWithHeigth2x4;
        float TotalWithHeigth2x2;
        float TotalWithHeigth1x2;
        float TotalWindows2x2;
        float TotalDoors3x2;
        float Window = 4;
        float Door = 6;
        float Reference2x4 = 8;
        float Reference2x2 = 4;
        float Reference1x2 = 2;

        float total = ((length * width) * height) / Reference2x4;
        total = total / 2;
        total = total - (Window + Door);

        if ((total % 1) != 0) {
            float Decimal = total - (int) total;
            total = (float) Math.floor(total);
            TotalWithHeigth2x4 = total / Reference2x4;
            TotalWithHeigth2x2 = (total * 2) / Reference2x2;
            if ((Decimal * Reference2x4 * 2 / 2) % 2 == 0) {
                TotalWithHeigth1x2 = (Decimal * Reference2x4 * 2) / Reference1x2;
            } else {
                TotalWithHeigth1x2 = ((float) Math.ceil(Decimal) * Reference2x4 * 2 / 2) / Reference1x2;
            }
            TotalWindows2x2 = height / Window;
            TotalDoors3x2 =  height / Door;
        } else {
            TotalWithHeigth2x4 = total / Reference2x4;
            TotalWithHeigth2x2 = (total * 2) / Reference2x2;
            TotalWithHeigth1x2 = 0;
            TotalWindows2x2 = height / Window;
            TotalDoors3x2 = height / Door;
        }
        Styklist orderLine = new Styklist(TotalWithHeigth2x4, TotalWithHeigth2x2, TotalWithHeigth1x2, TotalWindows2x2, TotalDoors3x2);
        return orderLine;
    }

    public static void createOrder(User user, float length, float width, float height) throws OrderSampleException {
        Order order = new Order(user.getId(), LocalDate.now(), length, width, height);
        OrderMapper.createOrder(order, user);
    }

    public static List<Order> getAllOrdersList() throws OrderSampleException {
        List<Order> list = OrderMapper.getAllOrders();
        return list;
    }

    public static Order findOrder(int order_id) throws OrderSampleException {
        Order order = OrderMapper.findSpecificOrder(order_id);
        return order;
    }

    public static void changeOrderStatus(int status, Order order) throws OrderSampleException {
        OrderMapper.changeOrderStatus(status, order);
    }

    public static List<Order> getOrderHistory(User user) throws OrderSampleException {
        List<Order> list = OrderMapper.getOrderHistory(user);
        return list;
    }

}
