package com.example.youtubeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.commit451.youtubeextractor.YouTubeExtractionResult;
import com.commit451.youtubeextractor.YouTubeExtractor;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import at.huber.youtubeExtractor.YouTubeUriExtractor;
import at.huber.youtubeExtractor.YtFile;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyYoutubeActivity extends YouTubeBaseActivity  implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView playerView;

    public static final String API_KEY= "AIzaSyA__RrU6xF_mefIWlzt4gyURXeWTXgYbj0";
    private final YouTubeExtractor mExtractor = YouTubeExtractor.create();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_my_youtube );
        playerView=findViewById ( R.id.youtube_view );
        playerView.initialize ( API_KEY, this );

    }

    @Override
    public void onInitializationSuccess
            (YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean wasRestored) {

        if (!wasRestored) {
            youTubePlayer.cueVideo("wKJ9KzGQq0w");
            youTubePlayer.setPlayerStateChangeListener ( new YouTubePlayer.PlayerStateChangeListener () {
                @Override
                public void onLoading() {

                    youTubePlayer.play ();
                }

                @Override
                public void onLoaded(String s) {

                }

                @Override
                public void onAdStarted() {

                }

                @Override
                public void onVideoStarted() {

                }

                @Override
                public void onVideoEnded() {

                }

                @Override
                public void onError(YouTubePlayer.ErrorReason errorReason) {

                }
            } );
            youTubePlayer.setPlayerStyle ( YouTubePlayer.PlayerStyle.DEFAULT );
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }


}
