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

public class SquareWebViewFragment extends Fragment
{
    public WebView squareWebView;

    private ImageView squareWebViewBackButton;


    @Override
    public View onCreateView (LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_square_webview, container, false);

        squareWebViewBackButton = (ImageView) v.findViewById (R.id.squareWebViewBackButton);

        squareWebView = (WebView) v.findViewById (R.id.squareWebView);
        squareWebView.setWebViewClient (new WebViewClient());
        squareWebView.loadUrl ("https://en.wikipedia.org/wiki/Square");


        squareWebViewBackButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SquareFragment squareFragment = (SquareFragment) SquareFragment.squareFragment;
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragmentHolder,squareFragment);
                transaction.commit();
            }
        });


        return v;
    }

    public WebView getSquareWebView()
    {
        return squareWebView;
    }
}
