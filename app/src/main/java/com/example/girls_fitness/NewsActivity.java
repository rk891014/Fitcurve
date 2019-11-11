package com.example.girls_fitness;

import android.content.Context;
import android.os.Bundle;

import com.example.girls_fitness.Model.Model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {
    private static final String TAG = "NewsActivity";
    RecyclerView recyclerView;
    DatabaseReference reference;
    StorageReference mStorageref;
    private FirebaseRecyclerAdapter adapter;
    ArrayList<Model> imageList=new ArrayList<>();

    private Context mContext = NewsActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        reference = FirebaseDatabase.getInstance().getReference();
        reference.keepSynced(true);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mStorageref = FirebaseStorage.getInstance().getReference();
        imageList = new ArrayList<>();

        init();

    }

    private void init() {
  //  clearAll();
  //      String DeviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);


        DatabaseReference query = FirebaseDatabase.getInstance().getReference("data");

        query.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Model model = postSnapshot.getValue(Model.class);
                    imageList.add(model);
                }
                MyAdapter adapter=new MyAdapter(imageList,mContext);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.e("ErrorTAG", "loadPost:onCancelled", databaseError.toException());

            }
        });
    }

    private void clearAll() {
        if(imageList!=null){
            imageList.clear();
        }
        imageList = new ArrayList<>();
    }

}