import java.util.Observable;

// 注意Observable是一个类
public class WeatherData extends Observable {
  private float temperature;
  private float humidity;
  private float pressure;

  public WeatherData() {}

  public void measurementsChanged() {
    setChange();  // protected方法
    notifyObservers();  // “推”数据的做法
  }

  public void setMeasurements(float temperature,
                              float humidity,
                              float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }

  public float getTemperature() {
    return temperature;
  }

  public float getHumidity() {
    return humidity;
  }

  public float getPressure() {
    return pressure;
  }
}
