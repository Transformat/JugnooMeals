package products.clicklabs.jugnoomeals.entities;


import java.util.ArrayList;

public class OrderData {
    public int orderId;
    public int driverId;
    public String orderTime;
    public OrderStatus orderStatus;
    public String orderStatusMessage;
    public String phoneNo;
    public String address;
    public double total;
    public double usedCredits;
    public double serviceTax;
    public double deliveryCharge;
    public String paymentMode;
    public ArrayList<OrderItem> orderItems;

    public OrderData(int orderId, int driverId, String orderTime, int orderStatus, String orderStatusMessage, String phoneNo, String address,
                     double total, double usedCredits, double serviceTax, double deliveryCharge, String paymentMode,
                     ArrayList<OrderItem> orderItems) {
        this.orderId = orderId;
        this.driverId = driverId;
        this.orderTime = orderTime;

        if (OrderStatus.ORDERED.getOrdinal() == orderStatus) {
            this.orderStatus = OrderStatus.ORDERED;
        } else if (OrderStatus.DRIVER_ASSIGNED.getOrdinal() == orderStatus) {
            this.orderStatus = OrderStatus.DRIVER_ASSIGNED;
        } else if (OrderStatus.DELIVERED.getOrdinal() == orderStatus) {
            this.orderStatus = OrderStatus.DELIVERED;
        } else if (OrderStatus.ON_THE_WAY.getOrdinal() == orderStatus) {
            this.orderStatus = OrderStatus.ON_THE_WAY;
        } else {
            this.orderStatus = OrderStatus.CANCELED;
        }

        this.orderStatusMessage = orderStatusMessage;
        this.phoneNo = phoneNo;
        this.address = address;
        this.total = total;
        this.usedCredits = usedCredits;
        this.serviceTax = serviceTax;
        this.deliveryCharge = deliveryCharge;
        this.paymentMode = paymentMode;
        this.orderItems = new ArrayList<>();
        this.orderItems.addAll(orderItems);
    }

    @Override
    public boolean equals(Object o) {
        try {
            if (((OrderData) o).orderId == this.orderId) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.equals(o);
    }
}
