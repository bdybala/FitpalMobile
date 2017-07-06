package bdyb.fitpalmobile.service;

import java.util.List;

import bdyb.fitpalmobile.dto.InputDataDto;
import bdyb.fitpalmobile.dto.LoginDto;
import bdyb.fitpalmobile.dto.NewUserDto;
import bdyb.fitpalmobile.dto.UserDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestService {

    @GET("/api/users")
    Call<List<UserDto>> getUsers();

    @POST("/api/users/authenticate")
    Call<Boolean> authUser(@Body LoginDto loginDto);

    @POST("/api/users")
    Call<UserDto> addUser(@Body NewUserDto newUserDto);

    @GET("/api/users/by-login/{login}")
    Call<UserDto> getUserByLogin(@Path("login") String login);

    @POST("/api/calculations")
    Call<Integer> calculateKcal(@Body InputDataDto inputDataDto);
}
