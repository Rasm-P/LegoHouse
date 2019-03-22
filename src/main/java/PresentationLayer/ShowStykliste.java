/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderSampleException;
import FunctionLayer.User;
import FunctionLayer.Styklist;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rasmus2
 */
public class ShowStykliste extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderSampleException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LogicFacade.login(email, password);
        
        int order_id = Integer.parseInt(request.getParameter("specificorder"));
        HttpSession session = request.getSession();
        Order order = LogicFacade.findOrder(order_id);
        session.setAttribute("Specificorder", order);
        
        Styklist styklist = LogicFacade.stykliste(order.getOrder_length(), order.getOrder_width(), order.getOrder_height());
        session.setAttribute("styklist", styklist);

        return "styklistpage";
    }

    
}
