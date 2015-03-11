package products.clicklabs.jugnoomeals.activites;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import products.clicklabs.jugnoomeals.R;
import products.clicklabs.jugnoomeals.entities.MealData;


public class MainMealMenuActivity extends FragmentActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    MealsListAdapter mealAdapter;
    ListView mealList;
    List<MealData> mealDataList;
    DrawerLayout navigationDrawer;

    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_meal_menu);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        mealDataList = new ArrayList<>();
        mealDataList.add(new MealData("Rajmah Chawal", "abc", "60", "12:00-3:00", "Hello", "Basmati"));
        mealDataList.add(new MealData("Curry Chawal", "abc", "60", "12:00-3:00", "Hi", "Basmati"));
        mealList = (ListView) findViewById(R.id.list_view_main_menu);
        mealAdapter = new MealsListAdapter(MainMealMenuActivity.this, mealDataList);
        mealList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mealDetailIntent = new Intent(getApplicationContext(), MealDetailActivity.class);
                startActivity(mealDetailIntent);
                finish();
            }
        });
        mealList.setAdapter(mealAdapter);
        navigationDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            navigationDrawer.openDrawer(Gravity.START);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open_drawer_image_button:
                navigationDrawer.openDrawer(Gravity.START);
                break;
        }


    }


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                //mTitle = getString(R.string.title_section1);
                break;
            case 2:
                //mTitle = getString(R.string.title_section2);
                break;
            case 3:
                //mTitle = getString(R.string.title_section3);
                break;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */


        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_meal_menu, container, false);

            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainMealMenuActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    static class MealsListAdapter extends BaseAdapter {
        Context context;
        ImageView mealImage;
        TextView mealName, mealPrice, mealDayName, mealTime, mealQuantity;
        List<MealData> mealDataList;

        public MealsListAdapter(Context context, List<MealData> mealDataList) {
            this.context = context;
            this.mealDataList = mealDataList;
        }

        @Override
        public boolean isEnabled(int position) {
            return true;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return true;
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
            return 0;
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

}
