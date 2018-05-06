package developersudhanshu.com.udacitypracticalquizone;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView username, email, description;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        username = (TextView) findViewById(R.id.tv_username);
        email = (TextView) findViewById(R.id.tv_email);
        description = (TextView) findViewById(R.id.tv_desc);

        sharedPreferences = getSharedPreferences(Constants.SHARED_PREFERNCES, MODE_PRIVATE);

        if(getIntent() != null){
            if(getIntent().hasExtra(Constants.USERNAME_KEY)){
                String usernameText = getIntent().getStringExtra(Constants.USERNAME_KEY);
                username.setText(usernameText);
                sharedPreferences.edit().putString(Constants.USERNAME_KEY, usernameText).apply();
            }else{
                username.setText(sharedPreferences.getString(Constants.USERNAME_KEY, null));
            }
            if(getIntent().hasExtra(Constants.EMAIL_KEY)){
                String emailText = getIntent().getStringExtra(Constants.EMAIL_KEY);
                email.setText(emailText);
                sharedPreferences.edit().putString(Constants.EMAIL_KEY, emailText).apply();
            }else{
                email.setText(sharedPreferences.getString(Constants.EMAIL_KEY, null));
            }
            if(getIntent().hasExtra(Constants.DESCRIPTION_KEY)){
                String descText = getIntent().getStringExtra(Constants.DESCRIPTION_KEY);
                description.setText(descText);
                sharedPreferences.edit().putString(Constants.DESCRIPTION_KEY, descText).apply();
            }else{
                description.setText(sharedPreferences.getString(Constants.DESCRIPTION_KEY, null));
            }
        }

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
