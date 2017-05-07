package br.com.andre.appindexexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onNewIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        String action = intent.getAction();
        String data = intent.getDataString();

        if(Intent.ACTION_VIEW.equals(action)) {
            String channelId = data.substring(data.indexOf("/") + 1);
            Log.d("AppIndex", channelId);
        }
    }
}
