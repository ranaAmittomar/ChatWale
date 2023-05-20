package com.example.chatwale.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.chatwale.R;
import com.example.chatwale.Models.User;
import com.example.chatwale.Adapters.UsersAdapter;
import com.example.chatwale.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseDatabase database;
    ArrayList<User> users;
    UsersAdapter usersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database = FirebaseDatabase.getInstance();
        users = new ArrayList<>();
        usersAdapter = new UsersAdapter(this,users);
//       binding.chatRecyclerView.setLayoutManager(new LinearLayoutManager(this)); either we do this,or we can define in XML file(check MainActivityXML)
        binding.chatRecyclerView.setAdapter(usersAdapter);
        database.getReference().child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                users.clear();
                for(DataSnapshot snapshot1:snapshot.getChildren()){
                    User user = snapshot1.getValue(User.class);
                    users.add(user);
                }
                usersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

    /*
*
* //        Below is the CODE FOR CHECK ID.We don't use Switch Statement because,the constants are not final in a library project. Therefore your code would no longer compile.
//        int id = item.getItemId();
//        if(id==R.id.search){
//            Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show();
//        } else if (id==R.id.settings) {
//            Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show();
//        } else if (id==R.id.group) {
//            Toast.makeText(this,"Groups",Toast.LENGTH_SHORT).show();
//        } else if (id==R.id.invite) {
//            Toast.makeText(this,"Invite",Toast.LENGTH_SHORT).show();
//        }
* */
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}