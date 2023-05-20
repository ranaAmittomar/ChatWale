package com.example.chatwale.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.chatwale.databinding.ActivityChatBinding;

public class ChatActivity extends AppCompatActivity {
    ActivityChatBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String name= getIntent().getStringExtra("name");
        String uid = getIntent().getStringExtra("uid");
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}