package t0mat0ts.com.apisample.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import t0mat0ts.com.apisample.model.Prefectures;

public interface ApiService {
    @GET("prefectures")
    Call<Prefectures> getPrefectures(@Header("X-API-KEY") String apiKey);
}
