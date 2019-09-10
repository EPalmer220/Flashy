package com.example.flashy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button studyButton;
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studyButton = (Button) findViewById(R.id.studyButton);

        // programs study and play buttons to open the "study" and "play" pages respectively
        studyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openStudyActivity();
            }
        });

        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openPlayActivity();
            }
        });
    }

    /**
     * Opens the "Study" tab
     */
    public void openStudyActivity() {
        Intent intent = new Intent(this, StudyActivity.class);
        startActivity(intent);
    }

    /**
     * Opens the "Play" tab
     */
    public void openPlayActivity() {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }
}
