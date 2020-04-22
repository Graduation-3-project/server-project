import org.junit.Test;

import java.net.InetAddress;

public class getIP {

    
    @Test
    public void IPget()throws Exception{

            System.out.println("本机的IP = " + InetAddress.getLocalHost());
       // String address = InetAddress.getLocalHost().getHostAddress().toString();
    }

}
