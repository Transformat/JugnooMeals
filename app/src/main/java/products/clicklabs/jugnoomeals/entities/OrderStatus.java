package products.clicklabs.jugnoomeals.entities;

public enum OrderStatus {
    ORDERED(0, "In Process"),
    DRIVER_ASSIGNED(1, "In Process"),
    DELIVERED(2, "Delivered"),
    ON_THE_WAY(3, "On the way"),
    CANCELED(4, "Canceled");

    private int ordinal;
    private String message;

    private OrderStatus(int ordinal, String message) {
        this.ordinal = ordinal;
        this.message = message;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public String getMessage() {
        return message;
    }

}

