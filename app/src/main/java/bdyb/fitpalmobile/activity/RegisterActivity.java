package bdyb.fitpalmobile.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import bdyb.fitpalmobile.R;
import bdyb.fitpalmobile.dto.LoginDto;
import bdyb.fitpalmobile.dto.NewUserDto;
import bdyb.fitpalmobile.dto.UserDto;
import bdyb.fitpalmobile.service.RestService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static bdyb.fitpalmobile.config.Constants.API_BASE_URL;

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
//        DatePicker birthdayPicker = ((DatePicker)this.findViewById(R.id.register_birthday));
//        Date birthday = new Date(birthdayPicker.getYear(), birthdayPicker.getMonth(), birthdayPicker.getDayOfMonth());

        NewUserDto newUserDto = new NewUserDto(login, password, firstName, surname, height, mass, null);

        Log.d("TTT", "SUBMIt!!: " + newUserDto);
        newUserDto.setBirthday(new Date().getTime());
        registerUser(newUserDto);
    }

    public void registerUser(NewUserDto newUserDto) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.
                Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(
                        GsonConverterFactory.create()
                );
        Retrofit retrofit = builder
                .client(httpClient.build())
                .build();
        RestService service = retrofit.create(RestService.class);

        Call<UserDto> call = service.addUser(newUserDto);

        call.enqueue(new Callback<UserDto>() {
            @Override
            public void onResponse(Call<UserDto> call, Response<UserDto> response) {
                // TOAST
                if (!response.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Failure!! : ",
                            Toast.LENGTH_LONG).show();
                    return;
                } else {
                    Toast.makeText(RegisterActivity.this, "Success! : " + response.body().toString(),
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserDto> call, Throwable t) {

            }
        });
    }

}
