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

public class TriangleWebViewFragment extends Fragment
{
    public WebView triangleWebView;

    private ImageView triangleWebViewBackButton;

    @Override
    public View onCreateView (LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_triangle_webview, container, false);

        triangleWebViewBackButton = (ImageView) v.findViewById (R.id.triangleWebViewBackButton);

        triangleWebView = (WebView) v.findViewById (R.id.triangleWebView);
        triangleWebView.setWebViewClient (new WebViewClient());
        triangleWebView.loadUrl ("https://en.wikipedia.org/wiki/Triangle");


        triangleWebViewBackButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TriangleChoicesFragment fragment = new TriangleChoicesFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragmentHolder, fragment);
                transaction.commit();
            }
        });


        return v;
    }

    public WebView getTriangleWebView()
    {
        return triangleWebView;
    }
}
