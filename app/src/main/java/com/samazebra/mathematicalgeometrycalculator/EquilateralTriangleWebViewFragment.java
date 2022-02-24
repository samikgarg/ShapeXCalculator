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

public class EquilateralTriangleWebViewFragment extends Fragment
{
    public WebView equilateralTriangleWebView;

    private ImageView equilateralTriangleWebViewBackButton;


    @Override
    public View onCreateView (LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_equilateral_triangle_webview, container, false);

        equilateralTriangleWebViewBackButton = (ImageView) v.findViewById (R.id.equilateralTriangleWebViewBackButton);

        equilateralTriangleWebView = (WebView) v.findViewById (R.id.equilateralTriangleWebView);
        equilateralTriangleWebView.setWebViewClient (new WebViewClient());
        equilateralTriangleWebView.loadUrl ("https://en.wikipedia.org/wiki/Equilateral_triangle");


        equilateralTriangleWebViewBackButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EquilateralTriangleFragment equilateralTriangleFragment = (EquilateralTriangleFragment) EquilateralTriangleFragment.equilateralTriangleFragment;
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace(R.id.fragmentHolder,equilateralTriangleFragment);
                transaction.commit();
            }
        });


        return v;
    }

    public WebView getSquareWebView()
    {
        return equilateralTriangleWebView;
    }
}
