package t0mat0ts.com.apisample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import t0mat0ts.com.apisample.api.ApiService;
import t0mat0ts.com.apisample.model.Prefectures;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "https://opendata.resas-portal.go.jp/api/v1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService service = retrofit.create(ApiService.class);
                Call<Prefectures> hoge = service.getPrefectures("API_KEY");
                try {
                    hoge.enqueue(new Callback<Prefectures>() {
                        @Override
                        public void onResponse(Call<Prefectures> call, Response<Prefectures> response) {
                            if (response != null) {
                                String.valueOf(response.body().result.size());
                                Log.e("apicall", response.body().result.get(1).toString());
                            }
                        }

                        @Override
                        public void onFailure(Call<Prefectures> call, Throwable t) {
                        }
                    });
                } catch (Exception e) {

                }
            }
        });
    }
}
