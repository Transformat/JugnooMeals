package products.clicklabs.jugnoomeals.activites;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import products.clicklabs.jugnoomeals.R;
import products.clicklabs.jugnoomeals.utils.NonScrollableList;


public class OrderDetailsActivity extends Activity {
    NonScrollableList orderItemsList;
    OrderDetailsListAdapter orderDetailsListAdapter;

    /**
     * Expands ListView for fixed height of item inside a ScrollView
     */

    public static void expandListForFixedHeight(ListView list) {

        try {

            if (list.getCount() > 0) {

                ListAdapter listAdap = list.getAdapter();

                int totalHeight = 0;


                View listItem = listAdap.getView(0, null, list);

                listItem.measure(0, 0);

                int singleHeight = listItem.getMeasuredHeight();

                totalHeight = singleHeight * list.getCount();


//	for (int i = 0; i < listAdap.getCount(); i++) {

//	View listItem = listAdap.getView(i, null, list);

//	listItem.measure(0, 0);

//	totalHeight += listItem.getMeasuredHeight();

//	}

                ViewGroup.LayoutParams params = list.getLayoutParams();

                params.height = totalHeight + (list.getDividerHeight() * (list.getCount() - 1));

                list.setLayoutParams(params);

                list.requestLayout();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static void expandListForVariableHeight(ListView list) {

        try {

            if (list.getCount() > 0) {

                ListAdapter listAdap = list.getAdapter();

                int totalHeight = 0;


                for (int i = 0; i < listAdap.getCount(); i++) {

                    View listItem = listAdap.getView(i, null, list);

                    listItem.measure(0, 0);

                    totalHeight += listItem.getMeasuredHeight();

                }

                ViewGroup.LayoutParams params = list.getLayoutParams();

                params.height = totalHeight + (list.getDividerHeight() * (list.getCount() - 1));

                list.setLayoutParams(params);

                list.requestLayout();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        orderItemsList = (NonScrollableList) findViewById(R.id.list_order_items);
        orderDetailsListAdapter = new OrderDetailsListAdapter(OrderDetailsActivity.this);
        orderItemsList.setAdapter(orderDetailsListAdapter);


    }

    public void onClick(View view) {
        Intent orderHistoryIntent = new Intent(this, OrderHistoryActivity.class);
        startActivity(orderHistoryIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent orderHistoryIntent = new Intent(this, OrderHistoryActivity.class);
        startActivity(orderHistoryIntent);
        finish();
    }
    /*
    ** Expands ListView for variable height of item inside a ScrollView
    */

    static class OrderDetailsListAdapter extends BaseAdapter {
        TextView itemName;
        TextView itemQty;
        TextView itemPrice;
        Context context;

        public OrderDetailsListAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 15;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.order_details_list_adapter, null);
            itemName = (TextView) view.findViewById(R.id.text_meal_name_order_list);
            itemQty = (TextView) view.findViewById(R.id.text_meal_qty_order_list);
            itemPrice = (TextView) view.findViewById(R.id.text_meal_amount_order_list);
            itemName.setText("Rajmah Chawal");
            itemQty.setText("2");
            itemPrice.setText("1000");
            return view;
        }
    }
}
