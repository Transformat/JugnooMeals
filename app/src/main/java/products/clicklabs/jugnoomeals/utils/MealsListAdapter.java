package products.clicklabs.jugnoomeals.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import products.clicklabs.jugnoomeals.R;


public class MealsListAdapter extends BaseAdapter {
    Context context;
    ImageView mealImage;
    TextView mealName, mealPrice, mealDayName, mealTime, mealQuantity;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
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
        return view;
    }

}
