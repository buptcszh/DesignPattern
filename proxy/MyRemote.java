import java.rmi.*;

// 扩展标记接口Remote
public interface MyRemote extends Remote {
  // 声明的方法都要抛出RemoteException异常
  public String sayHello() throws RemoteException;
}
