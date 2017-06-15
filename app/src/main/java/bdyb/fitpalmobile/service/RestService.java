package bdyb.fitpalmobile.service;

import java.util.List;

import bdyb.fitpalmobile.dto.LoginDto;
import bdyb.fitpalmobile.dto.UserDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestService {

    @GET("/api/users")
    Call<List<UserDto>> getUsers();

    @POST("/api/users/authenticate")
    Call<Boolean> authUser(@Body LoginDto loginDto);
}
