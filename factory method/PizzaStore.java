public abstract class PizzaStore {
  public Pizza orderPizza(String type) {
    Pizza pizza = createPizza(type);
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
  }

  // 工厂方法：创建一个框架，让子类决定如何实现
  // 支持增加任意产品
  protected abstract Pizza createPizza(String type);
}
