// 抽象工厂：提供一个接口，用于生产不同产品族的全部产品
// 不能增加新的产品
public interface PizzaIngredientFactory {
  public Dough createDough();

  public Sauce createSauce();
}
