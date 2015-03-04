package products.clicklabs.jugnoomeals.activites;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import products.clicklabs.jugnoomeals.R;
import products.clicklabs.jugnoomeals.entities.OrderData;


public class OrderHistoryActivity extends Activity {

    ListView orderHistoryList;
    List<OrderData> orderDataList;
    OrderHistoryListAdapter orderHistoryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        orderHistoryList = (ListView) findViewById(R.id.order_history_list_view);
        orderDataList = new ArrayList<>();
        orderHistoryListAdapter = new OrderHistoryListAdapter(OrderHistoryActivity.this, orderDataList);
        orderHistoryList.setAdapter(orderHistoryListAdapter);
        orderHistoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent orderDetailsIntent = new Intent(OrderHistoryActivity.this, OrderDetailsActivity.class);
                startActivity(orderDetailsIntent);
                finish();
            }
        });
    }

    public void onClick(View view) {
        Intent mainMenuIntent = new Intent(this, MainMealMenuActivity.class);
        startActivity(mainMenuIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mainMenuIntent = new Intent(this, MainMealMenuActivity.class);
        startActivity(mainMenuIntent);
        finish();
    }

    static class OrderHistoryListAdapter extends BaseAdapter {
        Context context;
        List<OrderData> orderDatas;
        TextView orderDate;
        TextView orderStatus;
        TextView orderAddress;
        TextView orderPrice;

        public OrderHistoryListAdapter(Context context, List<OrderData> orderDatas) {
            this.context = context;
            this.orderDatas = orderDatas;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Object getItem(int position) {
            return orderDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return true;
        }

        @Override
        public boolean isEnabled(int position) {
            return true;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.order_history_list_adapter, null);
            orderDate = (TextView) view.findViewById(R.id.text_order_history_date);
            orderAddress = (TextView) view.findViewById(R.id.text_order_history_address);
            orderPrice = (TextView) view.findViewById(R.id.text_order_history_price);
            orderStatus = (TextView) view.findViewById(R.id.text_order_history_status);
            orderDate.setText("Thursday 20/02/2015");
            orderAddress.setText("CDCL,Chandigarh");
            orderPrice.setText("₹" + "60");
            orderStatus.setText("Delivered");
            return view;
        }
    }
}
