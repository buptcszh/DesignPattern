public abstract class Pizza {
  String name;
  String dough;
  String sauce;

  abstract void prepare();

  void bake() {
    System.out.println("Bake for 25 minutes at 350");
  }

  void cut() {
    System.out.println("Cutting the pizza into diagonal slices");
  }

  void box() {
    System.out.println("Place pizza in official PizzaStore box");
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
}
