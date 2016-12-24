package edu.upc.eetac.dsa.part2minims2;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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

public class EtakemonUsuari extends ListActivity {
    String username = null;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //List<ProfemonLocationResult> l = PokEETACApiManager.getProfemons();
        username = getIntent().getExtras().getString("Name");

        final String TAG="PokEETAC";
        String BASE_URL = "http://10.0.2.2:8080/myapp/User";
        Log.i(TAG, "****************************** get Profemons!!!!!!");
        AsyncHttpClient client;
        client = new AsyncHttpClient();
        client.get(BASE_URL + "/get/etakemon/"+username, null, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                Log.e(TAG, throwable.getMessage());
            }


            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

                Type listType = new TypeToken<ArrayList<Etakemon>>(){}.getType();
                List<Etakemon> etakList = new Gson().fromJson(responseString, listType);

                setListAdapter(new ElmeuArrayAdapter(EtakemonUsuari.this, etakList));
                Log.i(TAG, responseString);
            }
        });
    }

}
