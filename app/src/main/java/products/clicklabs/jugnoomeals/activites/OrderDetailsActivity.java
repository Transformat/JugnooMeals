package products.clicklabs.jugnoomeals.activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import products.clicklabs.jugnoomeals.R;


public class OrderDetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

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
}
