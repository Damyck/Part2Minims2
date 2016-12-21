package edu.upc.eetac.dsa.part2minims2;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Marc on 21/12/2016.
 */

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final String TAG="User";
        final String BASE_URL = "http://10.0.2.2:8080/myapp/user";
        Log.i(TAG, "****************************** LogIn!!!!!!");
        final AsyncHttpClient client;
        client = new AsyncHttpClient();


        Button buto1 = (Button) findViewById(R.id.buto1);

        buto1.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.nom);
                String name2 = name.toString();
                client.get(BASE_URL + "/get/"+name2, null, new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.e(TAG, throwable.getMessage());
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Intent intent1 = new Intent(LogIn.this, MainActivity.class);
                        startActivity(intent1);
                    }

                });



            }
        });
    }
}
