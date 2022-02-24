package com.samazebra.mathematicalgeometrycalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HomeScreenFragment extends Fragment
{
    public View onCreateView (LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_home_screen, container, false);

        CardView circleCardView;
        CardView equilateralTriangleCardView;
        CardView isoscelesTriangleCardView;
        CardView squareCardView;
        CardView rectangleCardView;

        circleCardView = (CardView) v.findViewById (R.id.circleCardView);
        equilateralTriangleCardView = (CardView) v.findViewById (R.id.equilateralTriangleCardView);
        isoscelesTriangleCardView = (CardView) v.findViewById (R.id.isoscelesTriangleCardView);
        squareCardView = (CardView) v.findViewById (R.id.squareCardView);
        rectangleCardView = (CardView) v.findViewById (R.id.rectangleCardView);



            circleCardView.setOnClickListener (new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Log.i ("Info: ", "Circle Pressed");

                    CircleFragment fragment;

                    if (CircleFragment.circleFragment == null)
                    {
                        fragment = new CircleFragment();
                    }
                    else
                    {
                        fragment = (CircleFragment) CircleFragment.circleFragment;
                    }

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                    transaction.replace (R.id.fragmentHolder, fragment);
                    transaction.commit();
                }

            });


            equilateralTriangleCardView.setOnClickListener (new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {

                    EquilateralTriangleFragment fragment = new EquilateralTriangleFragment();

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                    transaction.replace (R.id.fragmentHolder, fragment);
                    transaction.commit();
                }

            });

            isoscelesTriangleCardView.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                IsoscelesTriangleFragment fragment = new IsoscelesTriangleFragment();

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();
            }

        });


            squareCardView.setOnClickListener (new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Log.i ("Info: ", "Square Pressed");

                    SquareFragment fragment;

                    if (SquareFragment.squareFragment == null)
                    {
                        fragment = new SquareFragment();
                    }
                    else
                    {
                        fragment = (SquareFragment) SquareFragment.squareFragment;
                    }

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                    transaction.replace (R.id.fragmentHolder, fragment);
                    transaction.commit();
                }

            });

            rectangleCardView.setOnClickListener (new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Log.i ("Info: ", "Rectangle Pressed: ");

                    RectangleFragment fragment;

                    if (RectangleFragment.rectangleFragment == null)
                    {
                        fragment = new RectangleFragment();
                    }
                    else
                    {
                        fragment = (RectangleFragment) RectangleFragment.rectangleFragment;
                    }

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                    transaction.replace (R.id.fragmentHolder, fragment);
                    transaction.commit();
                }

            });

            return v;

    }

}
