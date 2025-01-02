package com.example.petzybyimash.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import android.widget.MediaController;

import com.example.petzybyimash.R;
import com.example.petzybyimash.databinding.ActivityArticleBinding;


public class ArticleActivity extends AppCompatActivity {
    ActivityArticleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        // Initialize the VideoView
        VideoView videoView = findViewById(R.id.videoView);

        // Set the URI for the video in the raw folder
        Uri videoUri = Uri.parse("android.resource://petzybyimash/" + R.raw.dog_nutrition);

        // Set the video URI to the VideoView
        videoView.setVideoURI(videoUri);

        // Add media controls to the VideoView
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Start the video automatically
        videoView.start();



        binding.backButton.setOnClickListener(view -> {
            startActivity(new Intent(ArticleActivity.this,MainActivity.class));
        });
    }
}