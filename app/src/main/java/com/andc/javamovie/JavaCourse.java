package com.andc.javamovie;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class JavaCourse extends YouTubeBaseActivity {
    Button play;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_course);
        play = findViewById(R.id.play);
        youTubePlayerView = findViewById(R.id.youtubeview);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                youTubePlayer.loadVideo("VQttXb6qE6k");
                youTubePlayer.loadPlaylist("PLu0W_9lII9agS67Uits0UnJyrYiXhDS6q");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        play.setOnClickListener(view -> youTubePlayerView.initialize("key=API_KEY",onInitializedListener));
    }
}