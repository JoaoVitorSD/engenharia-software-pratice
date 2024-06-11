import lombok.Data;

import java.util.Objects;

public class Game {
    private String name;
    private  int sells;
    private float price;
    private float amountSold;

    public Game(String name, float price) {
        this.name = name;
        this.sells = 0;
        this.price = price;
        this.amountSold =0;
    }

    public void sell(float discount){
        this.sells++;
        this.amountSold += this.price * (1 - discount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSells() {
        return sells;
    }

    public void setSells(int sells) {
        this.sells = sells;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(float amountSold) {
        this.amountSold = amountSold;
    }
}
