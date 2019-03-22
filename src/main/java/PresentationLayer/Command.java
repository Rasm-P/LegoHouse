package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "main", new MainPage() );
        commands.put( "order", new Orders() );
        commands.put( "finalizeorder", new FinalizeOrder() );
        commands.put( "orderstatus", new OrderStatus() );
        commands.put( "history", new OrderHistory() );
        commands.put( "stykliste", new ShowStykliste() );
        commands.put( "logout", new Logout() );
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException, OrderSampleException;

}
