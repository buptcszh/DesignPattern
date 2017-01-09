/*
public class Singleton {
  // 在静态初始化器中创建单例，可以保证线程安全
  private static Singleton uniqueInstance = new Singleton();

  private Singleton() {}

  public static Singleton getInstance() {
    return uniqueInstance;
  }
}
*/

public class Singleton {
  // 延迟初始化，volatile关键字禁止指令重排
  private volatile static Singleton uniqueInstance;

  private Singleton() {}

  public static Singleton getInstance() {
    // 双重检查加锁
    if (uniqueInstance == null) {
      synchronized(Singleton.class) {
        if (uniqueInstance == null) {
          // new不是原子操作，有可能发生指令重排：分配空间->返回引用->初始化
          // 这样其他线程可能得到一个不完整的对象
          uniqueInstance = new Singleton();
        }
      }
    }
    return uniqueInstance;
  }
}
