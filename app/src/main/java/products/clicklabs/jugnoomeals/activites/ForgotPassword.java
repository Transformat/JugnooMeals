package products.clicklabs.jugnoomeals.activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import products.clicklabs.jugnoomeals.R;


public class ForgotPassword extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.back_button_forgot_password_activity:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
