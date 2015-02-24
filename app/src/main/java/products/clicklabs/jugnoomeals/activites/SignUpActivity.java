package products.clicklabs.jugnoomeals.activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import products.clicklabs.jugnoomeals.R;


public class SignUpActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_button_signup_activity:
                Intent splash = new Intent(this, SplashScreenActivity.class);
                startActivity(splash);
                finish();
                break;
            case R.id.signup_button_signup_activity:
                Intent verification = new Intent(this, OtpVerificationActivity.class);
                startActivity(verification);
                finish();
                break;
            case R.id.terms_and_condition_clickable:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent splash = new Intent(this, SplashScreenActivity.class);
        startActivity(splash);
        finish();
    }
}
