package resthunter.rest;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.MediaType;
import org.androidannotations.api.rest.RestClientSupport;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.util.MultiValueMap;

/**
 * Created by gorodechnyj on 10.02.14.
 */
//@Rest(rootUrl      = "http://apitma.telemetry.i-free.com",
//@Rest(rootUrl      = "http://test-api.telemetry.i-free.com",
@Rest(rootUrl      = "http://dev.apitma.telemetry.i-free.com",
      converters   = {FormHttpMessageConverter.class,  GsonHttpMessageConverter.class},
      interceptors = {HeadersRequestInterceptor.class, LoggingInterceptor.class})
public interface RestClient extends RestClientSupport {

    /*
    @Get("/tasks?username={username}&password={password}&page=1&size=100")
    @Accept(MediaType.APPLICATION_JSON)
    TaskListPage getTasks(String username, String password);

    @Get("/tasks/{taskId}/act?username={username}&password={password}")
    @Accept(MediaType.APPLICATION_JSON)
    Act getAct(long taskId, String username, String password);

    @Post("/tasks/{taskId}/act?username={username}&password={password}")
    @Accept(MediaType.APPLICATION_JSON)
    ActResponse postAct(Act act, long taskId, String username, String password);

    @Post("/tasks/{taskId}/status?username={username}&password={password}")
    @Accept(MediaType.APPLICATION_JSON)
    ChangeTaskStatusResponse changeTaskStatus(ChangeTaskStatusRequest request, long taskId, String username, String password);

    @Post("/tasks/{taskId}/signature?username={username}&password={password}")
    @Accept(MediaType.APPLICATION_JSON)
    SignatureResponse postSignature(MultiValueMap signData, long taskId, String username, String password);

    @Get("/tasks/{taskId}/parking?username={username}&password={password}&parkingId={parkingCardId}")
    @Accept(MediaType.APPLICATION_JSON)
    ParkingResponse assignVehicleParking(long taskId, String username, String password, String parkingCardId);

    @Get("/tasks/{taskId}/carwash?username={username}&password={password}&parkingId={parkingCardId}")
    @Accept(MediaType.APPLICATION_JSON)
    CarwashResponse assignCarwash(long taskId, String username, String password, String parkingCardId);

    @Post("/vehicle/{vehicleId}/status?username={username}&password={password}")
    @Accept(MediaType.APPLICATION_JSON)
    ChangeVehicleStatusResponse changeVehicleStatus(ChangeVehicleStatueRequest request, long vehicleId, String username, String password);

    @Post("/damage?username={username}&password={password}")
    @Accept(MediaType.APPLICATION_JSON)
    @RequiresHeader("Content-Type")
    DamageResponse postDamage(MultiValueMap<String, Object> signData, String username, String password);

    @Post("/tasks/{taskId}/driverLicence?username={username}&password={password}")
    @Accept(MediaType.APPLICATION_JSON)
    @RequiresHeader("Content-Type")
    DriverLicenceResponse postDriverLicence(MultiValueMap<String, Object> signData, long taskId, String username, String password);

    @Get("/user/setkey?cardId={cardId}&username={username}&password={password}")
    @Accept(MediaType.APPLICATION_JSON)
    AssignKeyResponse assignUserKey(String cardId, String username, String password);

    @Get("/dictionary/carriers?username={username}&password={password}")
    @Accept(MediaType.APPLICATION_JSON)
    CarriersDictionary getCarriers(String username, String password);
    */

    void setHeader(String name, String value);

    String getHeader(String name);
}
