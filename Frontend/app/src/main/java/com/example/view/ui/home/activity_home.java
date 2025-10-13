
package com.example.view.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.view.R;

public class activity_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupCardClicks();
    }

    private void setupCardClicks() {

        // --- Image Card ---
        findViewById(R.id.imageCard).setOnClickListener(v -> {
            Toast.makeText(this, "Opening Images...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity_home.this, ImagesActivity.class);
            startActivity(intent);
        });

        // --- Video Card ---
        findViewById(R.id.videoCard).setOnClickListener(v -> {
            Toast.makeText(this, "Opening Videos...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity_home.this, VideosActivity.class);
            startActivity(intent);
        });

        // --- Audio Card ---
        findViewById(R.id.audioCard).setOnClickListener(v -> {
            Toast.makeText(this, "Opening Audio...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity_home.this, AudioActivity.class);
            startActivity(intent);
        });

        // --- Documents Card ---
        findViewById(R.id.docCard).setOnClickListener(v -> {
            Toast.makeText(this, "Opening Documents...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity_home.this, DocumentsActivity.class);
            startActivity(intent);
        });

        // --- Downloads Card ---
        findViewById(R.id.downloadCard).setOnClickListener(v -> {
            Toast.makeText(this, "Opening Downloads...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity_home.this, DownloadsActivity.class);
            startActivity(intent);
        });

        // --- Applications Card ---
        findViewById(R.id.appCard).setOnClickListener(v -> {
            Toast.makeText(this, "Opening Applications...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(activity_home.this, AppsActivity.class);
            startActivity(intent);
        });
    }
}

