public class NYPizzaStore extends PizzaStore {
  // 类似简单工厂
  Pizza createPizza(String type) {
    if (type.equals("cheese")) {
      return new NYStyleCheesePizza();
    } else return null;
  }
}
