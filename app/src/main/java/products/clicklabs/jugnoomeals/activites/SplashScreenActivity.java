package products.clicklabs.jugnoomeals.activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import products.clicklabs.jugnoomeals.R;


public class SplashScreenActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.login_button_splash:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.signup_button_splash:
                break;
        }


    }
}
