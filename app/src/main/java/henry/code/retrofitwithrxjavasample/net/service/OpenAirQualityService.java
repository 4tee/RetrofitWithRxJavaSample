package henry.code.retrofitwithrxjavasample.net.service;

import henry.code.retrofitwithrxjavasample.model.Response;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface OpenAirQualityService {

    @GET("v1/countries")
    Observable<Response> fetchData();
}
