package products.clicklabs.jugnoomeals.activites;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import products.clicklabs.jugnoomeals.R;

public class OtpVerificationActivity extends Activity {
    TextView otpMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        otpMessage = (TextView) findViewById(R.id.otp_message);
        otpMessage.setText("Please enter your One Time Password sent over SMS to +9068333157 over here to verify");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.verification_button:
                break;
            case R.id.back_button_otp_activity:
                Intent signUp = new Intent(this, SignUpActivity.class);
                startActivity(signUp);
                finish();
                break;

        }

    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent signUp = new Intent(this, SignUpActivity.class);
        startActivity(signUp);
        finish();
    }

}

