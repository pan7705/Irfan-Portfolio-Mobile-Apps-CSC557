package com.example.irfanportfolio2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class HobbyFragment extends Fragment {

    private ImageView cyclingImageView;
    private ImageView musicImageView;
    private int currentCyclingImageIndex = 0;
    private int currentMusicImageIndex = 0;
    private int[] cyclingImageResources = {R.drawable.crituitm, R.drawable.cycling, R.drawable.cycling3};
    private int[] musicImageResources = {R.drawable.a7x, R.drawable.a7x2, R.drawable.a7x3};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hobby, container, false);

        cyclingImageView = view.findViewById(R.id.image_cycling);
        musicImageView = view.findViewById(R.id.image_music);

        Button btnCyclingPrevious = view.findViewById(R.id.btnCyclingPrevious);
        Button btnCyclingNext = view.findViewById(R.id.btnCyclingNext);

        Button btnMusicPrevious = view.findViewById(R.id.btnMusicPrevious);
        Button btnMusicNext = view.findViewById(R.id.btnMusicNext);

        // Set initial images
        cyclingImageView.setImageResource(cyclingImageResources[currentCyclingImageIndex]);
        musicImageView.setImageResource(musicImageResources[currentMusicImageIndex]);

        btnCyclingPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPreviousCyclingImage();
            }
        });

        btnCyclingNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextCyclingImage();
            }
        });

        btnMusicPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPreviousMusicImage();
            }
        });

        btnMusicNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextMusicImage();
            }
        });



        //youtube video
        // Find the WebView
        WebView webViewFrontendVideo = view.findViewById(R.id.webViewFrontendVideo);

        // Configure WebSettings
        WebSettings webSettings = webViewFrontendVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true); // Enable DOM storage
        webSettings.setMediaPlaybackRequiresUserGesture(false); // Allow autoplay

        // Load YouTube video (replace "VIDEO_ID" with your YouTube video ID)
        String videoId = "6meCVoEo18o";
        String videoUrl = "https://www.youtube.com/embed/" + videoId;
        String html = "<iframe width=\"100%\" height=\"100%\" src=\"" + videoUrl + "\" frameborder=\"0\" allowfullscreen></iframe>";

        webViewFrontendVideo.loadData(html, "text/html", "utf-8");

        return view;
    }

    private void showPreviousCyclingImage() {
        if (currentCyclingImageIndex > 0) {
            currentCyclingImageIndex--;
        } else {
            currentCyclingImageIndex = cyclingImageResources.length - 1;
        }
        cyclingImageView.setImageResource(cyclingImageResources[currentCyclingImageIndex]);
    }

    private void showNextCyclingImage() {
        if (currentCyclingImageIndex < cyclingImageResources.length - 1) {
            currentCyclingImageIndex++;
        } else {
            currentCyclingImageIndex = 0;
        }
        cyclingImageView.setImageResource(cyclingImageResources[currentCyclingImageIndex]);
    }

    private void showPreviousMusicImage() {
        if (currentMusicImageIndex > 0) {
            currentMusicImageIndex--;
        } else {
            currentMusicImageIndex = musicImageResources.length - 1;
        }
        musicImageView.setImageResource(musicImageResources[currentMusicImageIndex]);
    }

    private void showNextMusicImage() {
        if (currentMusicImageIndex < musicImageResources.length - 1) {
            currentMusicImageIndex++;
        } else {
            currentMusicImageIndex = 0;
        }
        musicImageView.setImageResource(musicImageResources[currentMusicImageIndex]);
    }
}

