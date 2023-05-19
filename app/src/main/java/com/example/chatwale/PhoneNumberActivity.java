package com.example.chatwale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.chatwale.databinding.ActivityPhoneNumberBinding;

public class PhoneNumberActivity extends AppCompatActivity {

    ActivityPhoneNumberBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.phoneBox.requestFocus();
        binding.continueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneNumberActivity.this,OTPActivity.class);
                intent.putExtra("phoneNumber",binding.phoneBox.getText().toString());
                startActivity(intent);
            }
        });
    }
}