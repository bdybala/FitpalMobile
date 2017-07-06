package bdyb.fitpalmobile.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import bdyb.fitpalmobile.R;
import bdyb.fitpalmobile.dto.InputDataDto;
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

public class KcalActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kcal_activity);
    }

    public void handleDisplayButton(View view) {
        RadioButton radioLow = (RadioButton) findViewById(R.id.kcal_radioLow);
        RadioButton radioMeidum = (RadioButton) findViewById(R.id.kcal_radioMedium);
        RadioButton radioHigh = (RadioButton) findViewById(R.id.kcal_radioHigh);

        if (radioLow.isChecked())
            System.out.println("LOW");
        else if (radioMeidum.isChecked())
            System.out.println("MEDIUM");
        else if (radioHigh.isChecked())
            System.out.println("HIGH");

        InputDataDto inputDataDto;

//        UserDto userDto = getUser(SaveSharedPreferences.getUserName(KcalActivity.this));
    }

//    private UserDto getUser(String login) {
//        final UserDto userDto = new UserDto();
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        Retrofit.Builder builder = new Retrofit.
//                Builder()
//                .baseUrl(API_BASE_URL)
//                .addConverterFactory(
//                        GsonConverterFactory.create()
//                );
//        Retrofit retrofit = builder
//                .client(httpClient.build())
//                .build();
//        RestService service = retrofit.create(RestService.class);
//
//        Call<UserDto> call = service.getUserByLogin(login);
//
//        call.enqueue(new Callback<UserDto>() {
//            @Override
//            public void onResponse(Call<UserDto> call, Response<UserDto> response) {
//                // TOAST
//                if (!response.isSuccessful()) {
//                    Toast.makeText(KcalActivity.this, "Failure!! : ",
//                            Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(KcalActivity.this, "Success! : " + response.body(),
//                            Toast.LENGTH_LONG).show();
//                    userDto.setId(response.body().getId());
//                    userDto.setLogin(response.body().getLogin());
//                    userDto.setFirstName(response.body().getFirstName());
//                    userDto.setSurname(response.body().getSurname());
//                    userDto.setBirthday(response.body().getBirthday());
//                    u.
//                }
//            }
//
//            @Override
//            public void onFailure(Call<UserDto> call, Throwable t) {
//
//            }
//        });
//    }
}
