package com.example.irfanportfolio2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

public class StudentPortalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_studentportal, container, false);

        WebView webViewStudentPortal = view.findViewById(R.id.webViewStudentPortal);

        // Enable JavaScript (optional, depending on the website)
        WebSettings webSettings = webViewStudentPortal.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Load the URL
        webViewStudentPortal.loadUrl("https://istudent.uitm.edu.my/index_isp.htm");
        return view;
    }
}

