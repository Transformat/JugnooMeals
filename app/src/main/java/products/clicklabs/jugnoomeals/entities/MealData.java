package products.clicklabs.jugnoomeals.entities;


public class MealData {
    public String imageSource;
    public String mealName;
    public String mealPrice;
    public String mealTime;
    public String mealDetail;
    public String mealDescription;

    public MealData(String mealName,
                    String imageSource,
                    String mealPrice,
                    String mealTime,
                    String mealDetail,
                    String mealDescription) {
        this.mealName = mealName;
        this.imageSource = imageSource;
        this.mealPrice = mealPrice;
        this.mealTime = mealTime;
        this.mealDetail = mealDetail;
        this.mealDescription = mealDescription;
    }
}
