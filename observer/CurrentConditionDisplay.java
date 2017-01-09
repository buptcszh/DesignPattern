import java.util.Observer;

public class CurrentConditionDisplay {
  Observable observable;
  private float temperature;
  private float humidity;

  public CurrentConditionDisplay(Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void update(Observable obs, Object arg) {
    if (obs instanceof WeatherData) {
      // "拉"数据的做法
      WeatherData weatherData = (WeatherData) obs;
      this.temperature = obs.getTemperature();
      this.humidity = obs.getHumidity();
      display();
    }
  }

  public void display() {
    System.out.println("Current conditions:" +
                        temperature + "F degrees and" +
                        humidity + "% humidity");
  }
}
