package com.example.petzybyimash.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.petzybyimash.R;
import com.example.petzybyimash.databinding.ActivityIntroBinding;

public class introActivity extends BaseActivity {
ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityIntroBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setVariable();
        //getWindow().setStatusBarColor(Color.parseColor("FFE485"));
    }

    private void setVariable() {
        binding.loginBtn.setOnClickListener(view -> {
            if (mAuth.getCurrentUser()!=null){
                startActivity(new Intent(introActivity.this,MainActivity.class));
            }else {
                startActivity(new Intent(introActivity.this,LoginActivity.class));
            }
        });

        binding.signupBtn.setOnClickListener(view -> {
                startActivity(new Intent(introActivity.this,SignupActivity.class));
        });
    }
}