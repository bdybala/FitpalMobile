package bdyb.fitpalmobile.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import bdyb.fitpalmobile.MainActivity;
import bdyb.fitpalmobile.R;
import bdyb.fitpalmobile.dto.LoginDto;
import bdyb.fitpalmobile.dto.UserDto;
import bdyb.fitpalmobile.service.RestService;
import bdyb.fitpalmobile.session.SaveSharedPreferences;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static bdyb.fitpalmobile.config.Constants.API_BASE_URL;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        getUsers();
    }

    public void authenticateUser(View view) {
        EditText login = (EditText) this.findViewById(R.id.login_login);
        EditText password = (EditText) this.findViewById(R.id.login_password);

        authUser(login.getText().toString(), password.getText().toString());
    }

    private void authUser(final String login, String password) {
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

        Call<Boolean> call = service.authUser(new LoginDto(login, password));

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                // TOAST
                if (!response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Failure!! : ",
                            Toast.LENGTH_LONG).show();
                    return;
                } else if (response.body().toString().equals("true")) {
                    Toast.makeText(LoginActivity.this, "Success! : " + response.body().toString(),
                            Toast.LENGTH_LONG).show();
                    SaveSharedPreferences.setUserName(LoginActivity.this, login);
                    //redirect to new view
                    Intent kcalIntent = new Intent(LoginActivity.this, KcalActivity.class);
                    LoginActivity.this.startActivity(kcalIntent);
                } else {
                    Toast.makeText(LoginActivity.this, "Failure! : " + response.body().toString(),
                            Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });
    }

    private void getUsers() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.
                Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(
                        GsonConverterFactory.create()
                );
        Retrofit retrofit =
                builder
                        .client(httpClient.build())
                        .build();
        RestService service = retrofit.create(RestService.class);

        Call<List<UserDto>> call = service.getUsers();

        call.enqueue(new Callback<List<UserDto>>() {
            @Override
            public void onResponse(Call<List<UserDto>> call, Response<List<UserDto>> response) {
                // The network call was a success and we got a response
                Log.d("onResponse:", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<UserDto>> call, Throwable t) {
                // the network call was a failure
                t.printStackTrace();
            }
        });
    }
}
