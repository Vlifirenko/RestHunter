package resthunter.rest;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.Put;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.MediaType;
import org.androidannotations.api.rest.RestClientSupport;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.util.MultiValueMap;

import resthunter.content.rest.PlaceListResponse;
import resthunter.content.rest.PlaceResponse;
import resthunter.content.rest.UserListResponse;
import resthunter.content.rest.UserRegisterResponse;
import resthunter.content.rest.UserResponse;

@Rest(rootUrl = "http://www.resthunter.com/",
        converters = {FormHttpMessageConverter.class, GsonHttpMessageConverter.class},
        interceptors = {HeadersRequestInterceptor.class, LoggingInterceptor.class})
public interface RestClient extends RestClientSupport {

    @Post("/api/v1/users")
    @Accept((MediaType.APPLICATION_JSON))
    UserRegisterResponse userRegister(MultiValueMap<String, Object> user);

    @Put("/api/v1/users/{id}")
    @Accept((MediaType.APPLICATION_JSON))
    UserRegisterResponse userUpdate(MultiValueMap<String, Object> user, String id);

    @Get("/api/v1/users")
    @Accept((MediaType.APPLICATION_JSON))
    UserListResponse getUserList();

    @Get("/api/v1/users/{id}")
    @Accept((MediaType.APPLICATION_JSON))
    UserResponse getUser(String id);

    @Get("/api/v1/places")
    @Accept((MediaType.APPLICATION_JSON))
    PlaceListResponse getPlaceList();

    @Get("/api/v1/places/{id}")
    @Accept((MediaType.APPLICATION_JSON))
    PlaceResponse getPlace(String id);

    @Get("api/v1/geousers?lat={lat}&lng={lng}&radius={radius}")
    @Accept((MediaType.APPLICATION_JSON))
    UserListResponse getGeoUsers(String lat, String lng, String radius);

    @Get("api/v1/geoplaces?lat={lat}&lng={lng}&radius={radius}")
    @Accept((MediaType.APPLICATION_JSON))
    PlaceListResponse getGeoPlaces(String lat, String lng, String radius);
}
