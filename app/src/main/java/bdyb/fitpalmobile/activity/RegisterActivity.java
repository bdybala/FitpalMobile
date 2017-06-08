package bdyb.fitpalmobile.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

import java.util.Date;

import bdyb.fitpalmobile.R;
import bdyb.fitpalmobile.dto.NewUserDto;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
    }

    public void handleSubmitButton(View view) {

        String login = ((EditText)this.findViewById(R.id.register_login)).getText().toString();
        String firstName = ((EditText)this.findViewById(R.id.register_firstName)).getText().toString();
        String surname = ((EditText)this.findViewById(R.id.register_surname)).getText().toString();
        String password = ((EditText)this.findViewById(R.id.register_password)).getText().toString();
        Integer height = Integer.parseInt(((EditText)this.findViewById(R.id.register_height)).getText().toString());
        Integer mass = Integer.parseInt(((EditText)this.findViewById(R.id.register_mass)).getText().toString());
        Date birthday = new Date(((CalendarView)this.findViewById(R.id.register_birthday)).getDate());

        NewUserDto newUserDto = new NewUserDto(login, password, firstName, surname, height, mass, birthday);

        Log.d("TTT", "SUBMIt!!: " + newUserDto);
    }
}
