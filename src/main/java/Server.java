import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Server {

    public static void main(String[] agrs){

        ApplicationContext bf = new ClassPathXmlApplicationContext("Server.xml");
        System.out.println("Server has started...");

    }

}
