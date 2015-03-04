package products.clicklabs.jugnoomeals.activites;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import products.clicklabs.jugnoomeals.R;


public class NavigationDrawerFragment extends Fragment {

    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
    LinearLayout supportButtonLayout, promotionButtonLayout, aboutButtonLayout, cashButtonLayout, orderDetailsLayout;
    private NavigationDrawerCallbacks mCallbacks;
    private DrawerLayout mDrawerLayout;
    private ViewGroup mDrawerView;
    private View mFragmentContainerView;
    private int mCurrentSelectedPosition = 0;
    private boolean mFromSavedInstanceState;
    private boolean mUserLearnedDrawer;

    public NavigationDrawerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);
        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
            mFromSavedInstanceState = true;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mDrawerView = (ViewGroup) inflater.inflate(
                R.layout.fragment_navigation_drawer, container, false);
        promotionButtonLayout = (LinearLayout) mDrawerView.findViewById(R.id.promotion_button_navigation_drawer);
        aboutButtonLayout = (LinearLayout) mDrawerView.findViewById(R.id.about_button_navigation_drawer);
        cashButtonLayout = (LinearLayout) mDrawerView.findViewById(R.id.cash_button_navigation_drawer);
        orderDetailsLayout = (LinearLayout) mDrawerView.findViewById(R.id.order_details_button_navigation_drawer);
        supportButtonLayout = (LinearLayout) mDrawerView.findViewById(R.id.support_button_navigation_drawer);

        supportButtonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent supportActivityIntent = new Intent(getActivity(), SupportActivity.class);
                startActivity(supportActivityIntent);
                getActivity().finish();
            }
        });
        promotionButtonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(getActivity(), ShareAndPromotionActivity.class);
                startActivity(shareIntent);
                getActivity().finish();
            }
        });
        aboutButtonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutUsIntent = new Intent(getActivity(), AboutUsActivity.class);
                startActivity(aboutUsIntent);
                getActivity().finish();
            }
        });
        cashButtonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        orderDetailsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderHistoryIntent = new Intent(getActivity(), OrderHistoryActivity.class);
                startActivity(orderHistoryIntent);
                getActivity().finish();
            }
        });


        return mDrawerView;
    }

    /**
     * Users of this fragment must call this method to set up the navigation drawer interactions.
     *
     * @param fragmentId   The android:id of this fragment in its activity's layout.
     * @param drawerLayout The DrawerLayout containing this fragment's UI.
     */
    public void setUp(int fragmentId, DrawerLayout drawerLayout) {
        mFragmentContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(mFragmentContainerView);
        }

        // Defer code dependent on restoration of previous instance state.
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }

    public static interface NavigationDrawerCallbacks {
        void onNavigationDrawerItemSelected(int position);
    }
}
