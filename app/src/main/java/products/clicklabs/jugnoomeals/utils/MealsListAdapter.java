package products.clicklabs.jugnoomeals.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import products.clicklabs.jugnoomeals.R;
import products.clicklabs.jugnoomeals.entities.MealData;


public class MealsListAdapter extends BaseAdapter {
    Context context;
    ImageView mealImage;
    TextView mealName, mealPrice, mealDayName, mealTime, mealQuantity;
    List<MealData> mealDataList;

    public MealsListAdapter(Context context, List<MealData> mealDataList) {
        this.context = context;
        this.mealDataList = mealDataList;
    }

    @Override
    public int getCount() {
        return mealDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mealDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_menu_list_adapter, null);
        mealImage = (ImageView) view.findViewById(R.id.meal_image_main_menu);
        mealName = (TextView) view.findViewById(R.id.meal_name_main_menu);
        mealDayName = (TextView) view.findViewById(R.id.meal_day_name_main_menu);
        mealPrice = (TextView) view.findViewById(R.id.meal_price_main_menu);
        mealQuantity = (TextView) view.findViewById(R.id.meal_quantity_text_main_menu);
        mealTime = (TextView) view.findViewById(R.id.meal_time_main_menu);
        mealName.setText(mealDataList.get(position).mealName);
        mealDayName.setText(mealDataList.get(position).mealDetail);
        mealPrice.setText(mealDataList.get(position).mealPrice);
        mealQuantity.setText("3");
        return view;
    }

}
