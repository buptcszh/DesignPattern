// 装饰者
public class Mocha extends CondimentDecorator {
  Beverage beverage;  // 被装饰者

  public Mocha(Beverage beverage) {
    this.beverage = beverage;
  }

  public String getDescription() {
    return beverage.getDescription + ", Mocha";
  }

  public double cost() {
    return .20 + beverage.cost();
  }
}
