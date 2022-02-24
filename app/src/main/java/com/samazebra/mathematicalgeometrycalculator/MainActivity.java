package com.samazebra.mathematicalgeometrycalculator;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);


        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById (R.id.fragmentHolder);

        if (fragment == null)
        {
            fragment = new HomeScreenFragment();

            fragmentManager.beginTransaction()
                    .add (R.id.fragmentHolder, fragment)
                    .commit();
        }
    }

    @Override
    public void onBackPressed()
    {
        Fragment fragment = getSupportFragmentManager().findFragmentById (R.id.fragmentHolder);

        if (fragment instanceof HomeScreenFragment)
        {
            super.onBackPressed();
        }
        else if (fragment instanceof SquareWebViewFragment)
        {
            SquareFragment squareFragment = (SquareFragment) SquareFragment.squareFragment;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragmentHolder, squareFragment);
            transaction.commit();

        }
        else if (fragment instanceof RectangleWebViewFragment)
        {
            RectangleFragment rectangleFragment = (RectangleFragment) RectangleFragment.rectangleFragment;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragmentHolder, rectangleFragment);
            transaction.commit();
        }
        else if (fragment instanceof CircleWebViewFragment)
        {
            CircleFragment circleFragment = (CircleFragment) CircleFragment.circleFragment;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragmentHolder, circleFragment);
            transaction.commit();
        }
        else if (fragment instanceof TriangleWebViewFragment)
        {
            TriangleChoicesFragment triangleChoicesFragment = (TriangleChoicesFragment) new TriangleChoicesFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragmentHolder, triangleChoicesFragment);
            transaction.commit();

        }
        else if (fragment instanceof EquilateralTriangleWebViewFragment)
        {
            EquilateralTriangleFragment equilateralTriangleFragment = (EquilateralTriangleFragment) EquilateralTriangleFragment.equilateralTriangleFragment;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragmentHolder, equilateralTriangleFragment);
            transaction.commit();
        }
        else if (fragment instanceof IsoscelesTriangleWebViewFragment)
        {
            IsoscelesTriangleFragment isoscelesTriangleFragment = (IsoscelesTriangleFragment) IsoscelesTriangleFragment.isoscelesTriangleFragment;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragmentHolder, isoscelesTriangleFragment);
            transaction.commit();

        }
        /*else if (fragment instanceof IsoscelesTriangleFragment)
        {
            IsoscelesTriangleFragment.isoscelesTriangleFragment = getSupportFragmentManager().findFragmentById(R.id.fragmentHolder);

            TriangleChoicesFragment triangleChoicesFragment = new TriangleChoicesFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragmentHolder, triangleChoicesFragment);
            transaction.commit();
        }
        else if (fragment instanceof EquilateralTriangleFragment)
        {
            EquilateralTriangleFragment.equilateralTriangleFragment = getSupportFragmentManager().findFragmentById(R.id.fragmentHolder);

            TriangleChoicesFragment triangleChoicesFragment = new TriangleChoicesFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragmentHolder, triangleChoicesFragment);
            transaction.commit();
        }*/
        else
        {
            if (fragment instanceof SquareFragment)
        {
            SquareFragment.squareFragment = getSupportFragmentManager().findFragmentById(R.id.fragmentHolder);
        }
        else if (fragment instanceof CircleFragment)
        {
            CircleFragment.circleFragment = getSupportFragmentManager().findFragmentById(R.id.fragmentHolder);
        }
        else if (fragment instanceof RectangleFragment)
        {
            RectangleFragment.rectangleFragment = getSupportFragmentManager().findFragmentById(R.id.fragmentHolder);
        }

            HomeScreenFragment homeScreenFragment = new HomeScreenFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragmentHolder, homeScreenFragment);
            transaction.commit();
        }
    }

}
