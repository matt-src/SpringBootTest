package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {

    private String trend;
    private String price;

    public Current() {
    }

    public String getTrend() {
        return trend;
    }

    public String getPrice() {
        return price;
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Current{" +
                "trend=" + trend +
                ", price='" + price + '\'' +
                '}';
    }
}