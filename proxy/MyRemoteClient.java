import java.rmi.*;
import java.rmi.registry.*;

public class MyRemoteClient {
  public static void main(String[] args) {
    new MyRemoteClient().go();
  }

  public void go() {
    try {
      // 获取注册表
      Registry registry = LocateRegistry.getRegistry("127.0.0.1");
      // 获得存根
      MyRemote service = (MyRemote) registry.lookup("RemoteHello");

      String s = service.sayHello();
      System.out.println(s);
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }
}
