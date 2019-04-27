package com.example.dreamleague;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.dreamleague.TeamsCol.TeamEight;
import com.example.dreamleague.TeamsCol.TeamFive;
import com.example.dreamleague.TeamsCol.TeamFour;
import com.example.dreamleague.TeamsCol.TeamOne;
import com.example.dreamleague.TeamsCol.TeamSeven;
import com.example.dreamleague.TeamsCol.TeamSix;
import com.example.dreamleague.TeamsCol.TeamThree;
import com.example.dreamleague.TeamsCol.TeamTwo;
import com.example.dreamleague.TeamsCol.Winner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    private static TextView mTextViewResult;
    public static Heap teamsHeap;
    Button buttonParse;

    private static RequestQueue mQueue;
    static ArrayList<Player> players = new ArrayList<Player>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarId);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new TeamOne(), "T1");
        adapter.AddFragment(new TeamTwo(), "T2");
        adapter.AddFragment(new TeamThree(), "T3");
        adapter.AddFragment(new TeamFour(), "T4");
        adapter.AddFragment(new TeamFive(), "T5");
        adapter.AddFragment(new TeamSix(), "T6");
        adapter.AddFragment(new TeamSeven(), "T7");
        adapter.AddFragment(new TeamEight(), "T8");
        adapter.AddFragment(new Winner(), "W");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        teamsHeap = new Heap(8);

        mTextViewResult = findViewById(R.id.text_view_result);      //Team one
        buttonParse = findViewById(R.id.button_parse);

        mQueue = Volley.newRequestQueue(this);
    }

    public static void jsonParse(final String tn, final TextView tv) {
        String url = "https://api.myjson.com/bins/1eh1ek";
        final Random rand = new Random();
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

                            Player[] ps = new Player[5];
                            for (int a = 0; a<5; a++){
                                int n = rand.nextInt(players.size());
                                tv.append(players.get(n).toString());
                                ps[a] = players.get(n);
                                players.remove(n);
                            }
                            Team t = new Team(tn, ps);
                            teamsHeap.push(t);

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

    /*
    public static void createTeam(String name, TextView tv){
        final Random rand = new Random();
        Player[] ps = new Player[5];
        //Creating team one and changing selected players' availability
        //to false (removing them from the array list)
        for (int a = 0; a < 5; a++) {
            int n = rand.nextInt(players.size());
            tv.append(players.get(n).toString());
            ps[a] = players.get(n);
            players.remove(n);
        }
        Team t = new Team(name, ps);
        teamsHeap.push(t);
    }*/
}
