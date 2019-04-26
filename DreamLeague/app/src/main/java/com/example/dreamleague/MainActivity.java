package com.example.dreamleague;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private TextView mTextViewResult2;
    private Heap teamsHeap;
    Button buttonParse;

    private RequestQueue mQueue;
    ArrayList<Player> players = new ArrayList<Player>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamsHeap = new Heap(8);

        mTextViewResult = findViewById(R.id.text_view_result);      //Team one
        mTextViewResult2 = findViewById(R.id.text_view_result2);    //Team two

        buttonParse = findViewById(R.id.button_parse);

        mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonParse.setEnabled(false);
                jsonParse();
            }
        });
    }

    private void jsonParse() {
        String url = "https://api.myjson.com/bins/1b9gu0";


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("players");
                            //Getting the whole elements of json data.
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject player = jsonArray.getJSONObject(i);

                                /*
                                "name": "LeBron James",
                                "jerseynumber": 23,
                                "position": "Smallforward",
                                 "rating": 99
                                 */

                                String name = player.getString("name");
                                int jersey = player.getInt("jerseynumber");
                                String position = player.getString("position");
                                int rating = player.getInt("rating");
                                //Turn them into objects
                                Player p = new Player(name, jersey, position, rating);
                                players.add(p);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

    public void createTeam(String name, TextView tv){
        final Random rand = new Random();
        Player[] ps = new Player[5];
        //Creating team one and changing selected players' availability
        //to false (removing them from the array list)
        for (int a = 0; a < 5; a++) {
            int n = rand.nextInt(players.size());
            //mTextViewResult.append(players.get(n).toString());
            ps[a] = players.get(n);
            players.remove(n);
        }
        Team t = new Team(name, ps);
        //Maybe show stuff
        teamsHeap.push(t);
    }
}
