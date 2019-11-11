package com.example.girls_fitness;

        import android.os.Bundle;

        import com.firebase.client.ChildEventListener;
        import com.firebase.client.DataSnapshot;
        import com.firebase.client.Firebase;
        import com.firebase.client.FirebaseError;
        import com.google.android.material.floatingactionbutton.FloatingActionButton;
        import com.google.android.material.snackbar.Snackbar;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;
        import androidx.constraintlayout.solver.ArrayLinkedVariables;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.util.Log;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import java.util.ArrayList;
        import java.util.List;

public class Motivational_Quotes extends AppCompatActivity {
    private static final String TAG = "Motivational_Quotes";
    ArrayList<String> myArrayList = new ArrayList<>();
    RecyclerView myRecyclerView;
    Firebase myFirebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivational__quotes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("data");


        Firebase.setAndroidContext(this);
        myFirebase = new Firebase("gs://girls-fitness-2f107.appspot.com");
        final ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.activity_list_item,myArrayList);


        myRecyclerView=(RecyclerView) findViewById(R.id.recyclerView);

        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

     //   myRecyclerView.setAdapter(new MyAdapter(myArrayList));




        myFirebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Log.d(TAG, "onChildAdded: called"+dataSnapshot.getValue().toString());
                String myChildValues = dataSnapshot.getValue(String.class);
                myArrayList.add(myChildValues);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }
    @Override
    public void onStart(){
    super.onStart();

    }

}
