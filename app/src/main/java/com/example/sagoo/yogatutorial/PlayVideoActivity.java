package com.example.sagoo.yogatutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PlayVideoActivity extends YouTubeBaseActivity {

    public static final String YT_API_KEY = "AIzaSyAT8jgYwHn8cUgT9BONR5sY1RqfVHthMvA";
    public String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        url = getIntent().getExtras().getString("URL");
        playVieo(url);
    }

    private void playVieo(final String url) {

        YouTubePlayerView youTubePlayerView =
                (YouTubePlayerView) findViewById(R.id.player);

        youTubePlayerView.initialize(YT_API_KEY,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {

                        // do any work here to cue video, play video, etc.
//                        youTubePlayer.cueVideo("5xVh-7ywKpE");
                        youTubePlayer.loadVideo(url);
//                        youTubePlayer.loadVideo("ArDNROuHMKQ");
                    }
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {
                        Toast.makeText(PlayVideoActivity.this, "Youtube Failed!", Toast.LENGTH_SHORT).show();

                    }
                });

    }
    }
