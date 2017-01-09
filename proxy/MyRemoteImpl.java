import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class MyRemoteImpl implements MyRemote {
  public MyRemoteImpl() {}

  public String sayHello() {
    return "Server says, 'Hey'";
  }

  public static void main(String[] args) {
    try {
      // 生成动态存根
      MyRemote service = (MyRemote) UnicastRemoteObject.exportObject(new MyRemoteImpl(), 0);

      // 创建注册表
      Registry registry = LocateRegistry.createRegistry(1099);
      // 向注册表注册存根
      registry.rebind("RemoteHello", service);
    } catch(Exception ex) {
      ex.printStackTrace();
    }
  }
}
