package cn.ly;

public class Car {
    private int number;//序号
    private String name;//车名
    private int cost;//一辆的租车费
    private int loadPeople;//最大载客量
    private double loadGoods;//最大载货量

    public Car(int number, String name, int cost, int loadPeople, double loadGoods) {
        this.number = number;
        this.name = name;
        this.cost = cost;
        this.loadPeople = loadPeople;
        this.loadGoods = loadGoods;
    }

    public Car() {
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getLoadPeople() {
        return loadPeople;
    }

    public double getLoadGoods() {
        return loadGoods;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setLoadPeople(int loadPeople) {
        this.loadPeople = loadPeople;
    }

    public void setLoadGoods(double loadGoods) {
        this.loadGoods = loadGoods;
    }
}
