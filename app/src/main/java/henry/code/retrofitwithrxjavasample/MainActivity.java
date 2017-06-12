package henry.code.retrofitwithrxjavasample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import henry.code.retrofitwithrxjavasample.databinding.ActivityMainBinding;
import henry.code.retrofitwithrxjavasample.model.Response;
import henry.code.retrofitwithrxjavasample.net.OpenAirQuality;
import henry.code.retrofitwithrxjavasample.util.DisposableManager;
import henry.code.retrofitwithrxjavasample.util.DisposingObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchDataWithRxType();
            }
        });
    }


    @Override
    protected void onDestroy() {
        DisposableManager.dispose();
        super.onDestroy();
    }


    private void fetchDataWithRxType() {
        OpenAirQuality.fetchData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposingObserver<Response>() {
                    @Override
                    public void onNext(Response response) {
                        if (response.getResults() != null) {
                            binding.content.setText(response.toString());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        binding.content.setText(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
