package products.clicklabs.jugnoomeals.entities;

public class OrderItem {

    public String mealName;
    public int quantity;
    public double totalPrice;

    public OrderItem(String mealName, int quantity, double totalPrice) {
        this.mealName = mealName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

}
