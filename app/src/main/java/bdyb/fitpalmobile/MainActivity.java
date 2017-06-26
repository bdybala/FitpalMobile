package bdyb.fitpalmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import bdyb.fitpalmobile.activity.LoginActivity;
import bdyb.fitpalmobile.activity.RegisterActivity;
import bdyb.fitpalmobile.session.SaveSharedPreferences;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (SaveSharedPreferences.getUserName(MainActivity.this).length() == 0) {
            // need to log in!!
        } else {
            // already logged in!!
        }
    }

    void handleSignIn(View view) {
        Log.i("handleSignIn", "Sign In!");
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        MainActivity.this.startActivity(loginIntent);
    }

    void handleSignUp(View view) {
        Log.i("handleSignUp", "Sign Up!");
        Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
        MainActivity.this.startActivity(registerIntent);
    }
}
