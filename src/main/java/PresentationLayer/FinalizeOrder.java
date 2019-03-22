/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.Order;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderSampleException;
import FunctionLayer.User;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rasmus2
 */
public class FinalizeOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LogicFacade.login(email, password);

        float width = Float.parseFloat(request.getParameter("width"));
        float length = Float.parseFloat(request.getParameter("length"));
        float height = Float.parseFloat(request.getParameter("height"));

        if (width < 4 || length < 4 || height < 4) {
            try {
                throw new OrderSampleException("The size of your house was too small");
            } catch (OrderSampleException ex) {
                Logger.getLogger(FinalizeOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            LogicFacade.createOrder(user, length, width, height);
        }

        return user.getRole() + "page";
    }

}
