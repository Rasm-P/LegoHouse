/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import FunctionLayer.Order;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rasmus2
 */
public class MainPage extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LogicFacade.login(email, password);

        if (user.getRole().equals("employee")) {
            if (request.getParameter("status") != null && !request.getParameter("status").equals("-1")) {
                int status = Integer.parseInt(request.getParameter("status"));
                int order_id = Integer.parseInt(request.getParameter("specificorder"));
                Order order = LogicFacade.findOrder(order_id);
                LogicFacade.changeOrderStatus(status, order);
            }
            HttpSession session = request.getSession();
            List<Order> list = LogicFacade.getAllOrdersList();
            session.setAttribute("AllOrders", list);
        }

        return user.getRole() + "page";
    }

    

    

}
