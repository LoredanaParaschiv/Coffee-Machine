package machine;

public enum CoffeeType {
    ESPRESSO(250,1,0,16,4),
    LATTE(350, 1, 75, 20, 7),
    CAPPUCCINO(200, 1,100, 12, 6);

    int waterNeeded;
    int cupsNeeded;
    int milkNeeded;
    int cofBeansNeeded;
    int cost;

    CoffeeType(int waterNeeded, int cupsNeeded, int milkNeeded, int cofBeansNeeded, int cost) {
        this.waterNeeded = waterNeeded;
        this.cupsNeeded = cupsNeeded;
        this.milkNeeded = milkNeeded;
        this.cofBeansNeeded = cofBeansNeeded;
        this.cost = cost;
    }
}
