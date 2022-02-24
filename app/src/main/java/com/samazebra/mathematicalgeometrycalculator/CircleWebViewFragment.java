package com.samazebra.mathematicalgeometrycalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class CircleWebViewFragment extends Fragment
{
    public WebView circleWebView;

    private ImageView circleWebViewBackButton;


    @Override
    public View onCreateView (LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_circle_webview, container, false);

        circleWebViewBackButton = (ImageView) v.findViewById (R.id.circleWebViewBackButton);

        circleWebView = (WebView) v.findViewById (R.id.circleWebView);
        circleWebView.setWebViewClient (new WebViewClient());
        circleWebView.loadUrl ("https://en.wikipedia.org/wiki/Circle");

        circleWebViewBackButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CircleFragment circleFragment = (CircleFragment) CircleFragment.circleFragment;
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragmentHolder, circleFragment);
                transaction.commit();
            }
        });


        return v;
    }

    public WebView getCircleWebView()
    {
        return circleWebView;
    }
}
