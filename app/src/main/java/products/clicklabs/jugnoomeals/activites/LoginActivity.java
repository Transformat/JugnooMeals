package products.clicklabs.jugnoomeals.activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import products.clicklabs.jugnoomeals.R;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_button_login_activity:
                Intent intentSplash = new Intent(this, SplashScreenActivity.class);
                startActivity(intentSplash);
                finish();
                break;
            case R.id.forgot_password_button:
                Intent intent = new Intent(this, ForgotPassword.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intentSplash = new Intent(this, SplashScreenActivity.class);
        startActivity(intentSplash);
        finish();
    }
}
