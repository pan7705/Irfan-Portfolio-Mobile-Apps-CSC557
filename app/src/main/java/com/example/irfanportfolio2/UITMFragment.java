// UITMFragment.java
package com.example.irfanportfolio2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;

public class UITMFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uitm, container, false);

        WebView webViewUITM = view.findViewById(R.id.webViewUITM);

        // Enable JavaScript (optional, depending on the website)
        WebSettings webSettings = webViewUITM.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Load the URL
        webViewUITM.loadUrl("https://uitm.edu.my/index.php/en/");

        return view;
    }
}
