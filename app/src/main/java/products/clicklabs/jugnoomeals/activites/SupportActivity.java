package products.clicklabs.jugnoomeals.activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import products.clicklabs.jugnoomeals.R;


public class SupportActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_button_support_activity:
                Intent mainMenuIntent = new Intent(this, MainMealMenuActivity.class);
                startActivity(mainMenuIntent);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent mainMenuIntent = new Intent(this, MainMealMenuActivity.class);
        startActivity(mainMenuIntent);
        finish();
    }
}
