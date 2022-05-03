package com.example.pw_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.pw_assignment.adapter.RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.security.auth.Subject;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    List<Student> list;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager( this));
        fetchData();

    }

    private void fetchData() {
        final String url="https://my-json-server.typicode.com/easygautam/data/users";
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        for(int i=0;i<response.length();i++){
                            try {

                                JSONObject student=response.getJSONObject(i);
                                String Name_PW=student.getString("name");
                                JSONArray subjects= student.getJSONArray("subjects");
                                JSONArray qualifications= student.getJSONArray("qualification");
                                String profileLink=student.getString("profileImage");
                                System.out.println(subjects.toString());
                                System.out.println(qualifications.toString());
                                List<String> students_Subjects = new ArrayList<String>();
                                if(subjects!=null){
                                    for(int j=0; j<subjects.length();j++){
                                        students_Subjects.add((String) subjects.get(j));
                                    }
                                }
                                List<String> students_qualifications = new ArrayList<String>();
                                if(qualifications!=null){
                                    for(int j=0; j<qualifications.length();j++){
                                        students_qualifications.add((String) qualifications.get(j));
                                    }
                                }
                                list.add(new Student(Name_PW,students_Subjects,students_qualifications,profileLink));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        recyclerViewAdapter=new RecyclerViewAdapter(getApplicationContext(),list);
                        recyclerView.setAdapter(recyclerViewAdapter);
                        Log.i("Run:","Data added");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                    }
                });
        requestQueue.add(jsonArrayRequest);

    }
}