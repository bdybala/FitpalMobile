package bdyb.fitpalmobile.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Years;

import java.util.Date;

import bdyb.fitpalmobile.R;
import bdyb.fitpalmobile.dto.InputDataDto;
import bdyb.fitpalmobile.dto.LoginDto;
import bdyb.fitpalmobile.dto.UserDto;
import bdyb.fitpalmobile.enums.PhysicalActivity;
import bdyb.fitpalmobile.service.RestService;
import bdyb.fitpalmobile.session.SaveSharedPreferences;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static bdyb.fitpalmobile.config.Constants.API_BASE_URL;
import static bdyb.fitpalmobile.enums.PhysicalActivity.HIGH;
import static bdyb.fitpalmobile.enums.PhysicalActivity.LOW;
import static bdyb.fitpalmobile.enums.PhysicalActivity.MEDIUM;

public class KcalActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kcal_activity);
    }

    public void handleDisplayButton(View view) {

        UserDto userDto = getUser(SaveSharedPreferences.getUserName(KcalActivity.this));

        RadioButton radioLow = (RadioButton) findViewById(R.id.kcal_radioLow);
        RadioButton radioMedium = (RadioButton) findViewById(R.id.kcal_radioMedium);
        RadioButton radioHigh = (RadioButton) findViewById(R.id.kcal_radioHigh);


        InputDataDto inputDataDto = new InputDataDto();
        inputDataDto.setAge(getAgeFromBirthday(userDto.getBirthday()));
        inputDataDto.setGender(userDto.getGender());
        inputDataDto.setMass(userDto.getMass());
        inputDataDto.setHeight(userDto.getHeight());

        if (radioLow.isChecked()) {
            System.out.println("LOW");
            inputDataDto.setPhysicalActivity(LOW);
        } else if (radioMedium.isChecked()) {
            System.out.println("MEDIUM");
            inputDataDto.setPhysicalActivity(MEDIUM);
        } else if (radioHigh.isChecked()) {
            System.out.println("HIGH");
            inputDataDto.setPhysicalActivity(HIGH);
        }

        // send retrofit POST with inputData



    }

    private Integer getAgeFromBirthday(Long birthday) {
        return Years.yearsBetween(new DateTime(birthday).toLocalDate(), new LocalDate()).getYears();
    }

    private UserDto getUser(String login) {
        final UserDto userDto = new UserDto();
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

        Call<UserDto> call = service.getUserByLogin(login);

        call.enqueue(new Callback<UserDto>() {
            @Override
            public void onResponse(Call<UserDto> call, Response<UserDto> response) {
                // TOAST
                if (!response.isSuccessful()) {
                    Toast.makeText(KcalActivity.this, "Failure!! : ",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(KcalActivity.this, "Success! : " + response.body(),
                            Toast.LENGTH_LONG).show();
                    userDto.setId(response.body().getId());
                    userDto.setLogin(response.body().getLogin());
                    userDto.setFirstName(response.body().getFirstName());
                    userDto.setSurname(response.body().getSurname());
                    userDto.setBirthday(response.body().getBirthday());
                    userDto.setGender(response.body().getGender());
                    userDto.setHeight(response.body().getHeight());
                    userDto.setDesiredIntervalToLoseWeight(response.body().getDesiredIntervalToLoseWeight());
                    userDto.setRole(response.body().getRole());

                }
            }

            @Override
            public void onFailure(Call<UserDto> call, Throwable t) {

            }
        });
        return null;
    }
}
