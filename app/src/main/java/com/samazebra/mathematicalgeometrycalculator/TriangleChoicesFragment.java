package com.samazebra.mathematicalgeometrycalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class TriangleChoicesFragment extends Fragment
{
    public View onCreateView (LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_triangle_choices, container, false);

        CardView triangleEquilateralCardView = (CardView) v.findViewById(R.id.triangleEquilateralCardView);;
        CardView triangleIsoscelesCardView = (CardView) v.findViewById(R.id.triangleIsoscelesCardView);;
        //CardView triangleScaleneCardView = (CardView) v.findViewById(R.id.triangleScaleneCardView);;

        ImageView triangleChoicesBackButton = (ImageView) v.findViewById(R.id.triangleChoicesBackButton);
        ImageView triangleWebViewIcon = (ImageView) v.findViewById(R.id.triangleWebViewIcon);


        triangleEquilateralCardView.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.i ("Info: ", "Circle Pressed");

                EquilateralTriangleFragment fragment;

                if (EquilateralTriangleFragment.equilateralTriangleFragment == null)
                {
                    fragment = new EquilateralTriangleFragment();
                }
                else
                {
                    fragment = (EquilateralTriangleFragment) EquilateralTriangleFragment.equilateralTriangleFragment;
                }

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();
            }

        });


        triangleIsoscelesCardView.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.i ("Info: ", "Circle Pressed");

                IsoscelesTriangleFragment fragment;

                if  (IsoscelesTriangleFragment.isoscelesTriangleFragment == null)
                {
                    fragment = new IsoscelesTriangleFragment();
                }
                else
                {
                    fragment = (IsoscelesTriangleFragment) IsoscelesTriangleFragment.isoscelesTriangleFragment;
                }

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();
            }

        });


        triangleChoicesBackButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Log.i ("Info: ", "Triangle Pressed: " + R.id.triangleChoicesBackButton);
                Log.i ("Info: ", "Triangle Pressed: " + v.findViewById(R.id.triangleChoicesBackButton));

                Log.i ("Info: ", "Triangle Pressed: " + R.id.triangleWebViewIcon);
                Log.i ("Info: ", "Triangle Pressed: " + v.findViewById(R.id.triangleWebViewIcon));

                HomeScreenFragment fragment = new HomeScreenFragment();

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();
            }
        });


        triangleWebViewIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i ("info:", "Reached 100");

                TriangleWebViewFragment fragment = new TriangleWebViewFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();

                Log.i ("info:", "Reached 101");
            }
        });


        return v;
    }
}
