package developersudhanshu.com.udacitypracticalquizone;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    EditText username, email, description;
    TextInputLayout tilEmail, tilUsername, tilDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = (Button) findViewById(R.id.btn_submit);
        username = (EditText) findViewById(R.id.et_username);
        email = (EditText) findViewById(R.id.et_email);
        description = (EditText) findViewById(R.id.et_description);
        tilUsername = (TextInputLayout) findViewById(R.id.til_person);
        tilEmail = (TextInputLayout) findViewById(R.id.til_email);
        tilDescription = (TextInputLayout) findViewById(R.id.til_desc);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameText = String.valueOf(username.getText());
                String emailText = String.valueOf(email.getText());
                String descriptionText = String.valueOf(description.getText());

                if(TextUtils.isEmpty(usernameText)){
                    tilUsername.setError("Username cannot be empty");
                    return;
                }
                tilUsername.setError(null);
                if(TextUtils.isEmpty(emailText)){
                    tilEmail.setError("Email cannot be empty");
                    return;
                }
                tilEmail.setError(null);
                if(TextUtils.isEmpty(descriptionText)){
                    tilDescription.setError("Description cannot be empty");
                    return;
                }
                tilDescription.setError(null);

                Intent detailsActivityIntent = new Intent(MainActivity.this, DetailsActivity.class);
                detailsActivityIntent.putExtra(Constants.USERNAME_KEY, usernameText);
                detailsActivityIntent.putExtra(Constants.EMAIL_KEY, emailText);
                detailsActivityIntent.putExtra(Constants.DESCRIPTION_KEY, descriptionText);
                startActivity(detailsActivityIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_detail:
                Intent i = new Intent(this, DetailsActivity.class);
                startActivity(i);
        }
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString(Constants.USERNAME_KEY, username.getText().toString());
        outState.putString(Constants.EMAIL_KEY, email.getText().toString());
        outState.putString(Constants.DESCRIPTION_KEY, description.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        username.setText(savedInstanceState.getString(Constants.USERNAME_KEY));
        email.setText(savedInstanceState.getString(Constants.EMAIL_KEY));
        description.setText(savedInstanceState.getString(Constants.DESCRIPTION_KEY));
    }
}
