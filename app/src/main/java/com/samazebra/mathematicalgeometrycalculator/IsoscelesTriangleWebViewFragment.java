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

public class IsoscelesTriangleWebViewFragment extends Fragment
{
    public WebView isoscelesTriangleWebView;

    private ImageView isoscelesTriangleWebViewBackButton;


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_isosceles_triangle_webview, container, false);

        isoscelesTriangleWebViewBackButton = (ImageView) v.findViewById(R.id.isoscelesTriangleWebViewBackButton);

        isoscelesTriangleWebView = (WebView) v.findViewById(R.id.isoscelesTriangleWebView);
        isoscelesTriangleWebView.setWebViewClient(new WebViewClient());
        isoscelesTriangleWebView.loadUrl("https://en.wikipedia.org/wiki/Isosceles_triangle");


        isoscelesTriangleWebViewBackButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                IsoscelesTriangleFragment isoscelesTriangleFragment = (IsoscelesTriangleFragment) IsoscelesTriangleFragment.isoscelesTriangleFragment;
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragmentHolder, isoscelesTriangleFragment);
                transaction.commit();
            }
        });


        return v;
    }

    public WebView getRectangleWebView()
    {
        return isoscelesTriangleWebView;
    }

}
