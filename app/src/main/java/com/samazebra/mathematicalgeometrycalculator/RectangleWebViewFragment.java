package com.samazebra.mathematicalgeometrycalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class RectangleWebViewFragment extends Fragment
{
    public WebView rectangleWebView;

    private ImageView rectangleWebViewBackButton;


    @Override
    public View onCreateView (LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_rectangle_webview, container, false);

        rectangleWebViewBackButton = (ImageView) v.findViewById (R.id.rectangleWebViewBackButton);

        rectangleWebView = (WebView) v.findViewById (R.id.rectangleWebView);
        rectangleWebView.setWebViewClient (new WebViewClient());
        rectangleWebView.loadUrl ("https://en.wikipedia.org/wiki/Rectangle");


        rectangleWebViewBackButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                RectangleFragment rectangleFragment = (RectangleFragment) RectangleFragment.rectangleFragment;
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragmentHolder, rectangleFragment);
                transaction.commit();
            }
        });


        return v;
    }

    public WebView getRectangleWebView()
    {
        return rectangleWebView;
    }
}
