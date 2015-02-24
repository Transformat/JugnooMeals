package products.clicklabs.jugnoomeals.entities;


public class MealData {
    String imageSource;
    String mealName;
    String mealPrice;
    String mealTime;
    String mealDetail;
    String mealDescription;

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
