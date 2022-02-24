package com.samazebra.mathematicalgeometrycalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EquilateralTriangleFragment extends Fragment
{
    private int mSquareSpinnerSelected;

    private double mAnswer;
    private long mAnswerLong;

    private String mWorking;

    private int mDecimalPoints;

    private boolean mParameterChecker = false;

    private boolean mCheckBoxChecker ;
    private boolean mCheckBoxStartChecker;

    private boolean mShowAnswerChecker = false;

    public static Fragment equilateralTriangleFragment;


    @Override
    public View onCreateView (LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_equilateral_triangle, container, false);


        final EditText equilateralTriangleSideLengthEditText = (EditText) v.findViewById (R.id.equilateralTriangleSideLengthEditText);
        final EditText equilateralTriangleHeightEditText = (EditText) v.findViewById (R.id.equilateralTriangleHeightEditText);
        final EditText equilateralTrianglePerimeterEditText = (EditText) v.findViewById (R.id.equilateralTrianglePerimeterEditText);
        final EditText equilateralTriangleAreaEditText = (EditText) v.findViewById (R.id.equilateralTriangleAreaEditText);

        final TextView equilateralTriangleWorking = (TextView) v.findViewById (R.id.equilateralTriangleWorking);
        final TextView equilateralTriangleAnswer = (TextView) v.findViewById (R.id.equilateralTriangleAnswer);

        final ImageView equilateralTriangleBackButton = (ImageView) v.findViewById (R.id.equilateralTriangleBackButton);
        final ImageView equilateralTriangleWebViewIcon = (ImageView) v.findViewById (R.id.equilateralTriangleWebViewIcon);
        final ImageView equilateralTriangleFormulaeIcon = (ImageView) v.findViewById (R.id.equilateralTriangleFormulaeIcon);

        final Button btnEquilateralTriangleCalculate = (Button) v.findViewById (R.id.btnEquilateralTriangleCalculate);
        final Button btnEquilateralTriangleClear = (Button) v.findViewById (R.id.btnEquilateralTriangleClear);

        final Spinner equilateralTriangleSpinner = (Spinner) v.findViewById (R.id.equilateralTriangleSpinner);

        final SeekBar equilateralTriangleSeekBar = (SeekBar) v.findViewById (R.id.equilateralTriangleSeekBar);
        final TextView equilateralTriangleSeekBarValue = v.findViewById (R.id.equilateralTriangleSeekBarValue);

        final CheckBox cbEquilateralTriangleWorking = (CheckBox) v.findViewById (R.id.cbEquilateralTriangleWorking);

        mCheckBoxChecker = false;
        mCheckBoxStartChecker = false;


        equilateralTriangleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser)
            {
                equilateralTriangleSeekBarValue.setText ("" + value);
                mDecimalPoints = value;

                BigDecimal bigDecimal = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);

                mAnswerLong = Math.round(mAnswer);

                if (mDecimalPoints == 0)
                {
                    equilateralTriangleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + mAnswerLong);
                }
                else
                {
                    equilateralTriangleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + bigDecimal.doubleValue());
                }
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                //Nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                //Nothing
            }
        });

        equilateralTriangleSeekBarValue.setText ("" + mDecimalPoints);


        cbEquilateralTriangleWorking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (cbEquilateralTriangleWorking.isChecked())
                {
                    mCheckBoxChecker = true;

                    if (mCheckBoxStartChecker)
                    {
                        equilateralTriangleWorking.setVisibility (View.VISIBLE);
                    }
                }
                else
                {
                    mCheckBoxChecker = false;
                }

                if (!cbEquilateralTriangleWorking.isChecked())
                {
                    equilateralTriangleWorking.setVisibility (View.GONE);
                }
            }
        });


        equilateralTriangleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                EquilateralTriangle equilateralTriangle = new EquilateralTriangle();

                switch (position) {
                    case 0:

                        mSquareSpinnerSelected = 0;

                        if (mShowAnswerChecker)
                        {
                            if (equilateralTriangleSideLengthEditText.getText().length() > 0)
                            {
                                double equilateralTriangleSideLength = Double.parseDouble(equilateralTriangleSideLengthEditText.getText().toString());

                                mAnswer = equilateralTriangle.sideLengthSideLength(equilateralTriangleSideLength);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (equilateralTriangleHeightEditText.getText().length() > 0)
                            {
                                double equilateralTriangleHeight = Double.parseDouble(equilateralTriangleHeightEditText.getText().toString());

                                mAnswer = equilateralTriangle.sideLengthHeight(equilateralTriangleHeight);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (equilateralTrianglePerimeterEditText.getText().length() > 0)
                            {
                                double equilateralTrianglePerimeter = Double.parseDouble(equilateralTrianglePerimeterEditText.getText().toString());

                                mAnswer = equilateralTriangle.sideLengthPerimeter(equilateralTrianglePerimeter);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (equilateralTriangleAreaEditText.getText().length() > 0)
                            {
                                double equilateralTriangleArea = Double.parseDouble(equilateralTriangleAreaEditText.getText().toString());

                                mAnswer = equilateralTriangle.sideLengthArea(equilateralTriangleArea);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }

                            if (mParameterChecker)
                            {
                                mCheckBoxStartChecker = true;

                                BigDecimal bigDecimal = new BigDecimal(mAnswer).setScale(mDecimalPoints, RoundingMode.HALF_EVEN);
                                mAnswerLong = Math.round(mAnswer);

                                if (mDecimalPoints == 0)
                                {
                                    equilateralTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                }
                                else
                                {
                                    equilateralTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                }

                                equilateralTriangleAnswer.setVisibility(View.VISIBLE);

                                if (mCheckBoxChecker && mCheckBoxStartChecker)
                                {
                                    equilateralTriangleWorking.setVisibility(View.VISIBLE);
                                }

                            }

                        }

                        break;


                    case 1:

                        mSquareSpinnerSelected = 1;

                        if (mShowAnswerChecker)
                        {
                            if (equilateralTriangleHeightEditText.getText().length() > 0)
                            {
                            double equilateralTriangleHeight = Double.parseDouble(equilateralTriangleHeightEditText.getText().toString());

                            mAnswer = equilateralTriangle.heightHeight(equilateralTriangleHeight);

                            mWorking = equilateralTriangle.getWorking();
                            equilateralTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                            }
                            else if (equilateralTriangleSideLengthEditText.getText().length() > 0)
                            {
                                double equilateralTriangleSideLength = Double.parseDouble(equilateralTriangleSideLengthEditText.getText().toString());

                                mAnswer = equilateralTriangle.heightSideLength(equilateralTriangleSideLength);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (equilateralTrianglePerimeterEditText.getText().length() > 0)
                            {
                                double equilateralTrianglePerimeter = Double.parseDouble(equilateralTrianglePerimeterEditText.getText().toString());

                                mAnswer = equilateralTriangle.heightPerimeter(equilateralTrianglePerimeter);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (equilateralTriangleAreaEditText.getText().length() > 0)
                            {
                                double equilateralTriangleArea = Double.parseDouble(equilateralTriangleAreaEditText.getText().toString());

                                mAnswer = equilateralTriangle.heightArea(equilateralTriangleArea);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }

                            if (mParameterChecker)
                            {
                                mCheckBoxStartChecker = true;

                                BigDecimal bigDecimal = new BigDecimal(mAnswer).setScale(mDecimalPoints, RoundingMode.HALF_EVEN);
                                mAnswerLong = Math.round(mAnswer);

                                if (mDecimalPoints == 0)
                                {
                                    equilateralTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                }
                                else
                                {
                                    equilateralTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                }

                                equilateralTriangleAnswer.setVisibility(View.VISIBLE);

                                if (mCheckBoxChecker && mCheckBoxStartChecker)
                                {
                                    equilateralTriangleWorking.setVisibility(View.VISIBLE);
                                }

                            }

                        }

                        break;


                    case 2:

                        mSquareSpinnerSelected = 2;

                        if (mShowAnswerChecker)
                        {
                            if (equilateralTrianglePerimeterEditText.getText().length() > 0)
                            {
                                double equilateralTrianglePerimeter = Double.parseDouble(equilateralTrianglePerimeterEditText.getText().toString());

                                mAnswer = equilateralTriangle.perimeterPerimeter(equilateralTrianglePerimeter);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (equilateralTriangleSideLengthEditText.getText().length() > 0)
                            {
                                double equilateralTriangleSideLength = Double.parseDouble(equilateralTriangleSideLengthEditText.getText().toString());

                                mAnswer = equilateralTriangle.perimeterSideLength(equilateralTriangleSideLength);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (equilateralTriangleHeightEditText.getText().length() > 0)
                            {
                                double equilateralTriangleHeight = Double.parseDouble(equilateralTriangleHeightEditText.getText().toString());

                                mAnswer = equilateralTriangle.perimeterHeight(equilateralTriangleHeight);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (equilateralTriangleAreaEditText.getText().length() > 0)
                            {
                                double equilateralTriangleArea = Double.parseDouble(equilateralTriangleAreaEditText.getText().toString());

                                mAnswer = equilateralTriangle.perimeterArea(equilateralTriangleArea);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }

                            if (mParameterChecker)
                            {
                                mCheckBoxStartChecker = true;

                                BigDecimal bigDecimal = new BigDecimal(mAnswer).setScale(mDecimalPoints, RoundingMode.HALF_EVEN);
                                mAnswerLong = Math.round(mAnswer);

                                if (mDecimalPoints == 0)
                                {
                                    equilateralTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                }
                                else
                                {
                                    equilateralTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                }

                                equilateralTriangleAnswer.setVisibility(View.VISIBLE);

                                if (mCheckBoxChecker && mCheckBoxStartChecker)
                                {
                                    equilateralTriangleWorking.setVisibility(View.VISIBLE);
                                }

                            }

                        }

                        break;

                    case 3:

                        mSquareSpinnerSelected = 3;

                        if (mShowAnswerChecker)
                        {
                            if (equilateralTriangleAreaEditText.getText().length() > 0)
                            {
                                double equilateralTriangleArea = Double.parseDouble(equilateralTriangleAreaEditText.getText().toString());

                                mAnswer = equilateralTriangle.areaArea(equilateralTriangleArea);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (equilateralTriangleSideLengthEditText.getText().length() > 0)
                            {
                                double equilateralTriangleSideLength = Double.parseDouble(equilateralTriangleSideLengthEditText.getText().toString());

                                mAnswer = equilateralTriangle.areaSideLength(equilateralTriangleSideLength);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (equilateralTriangleHeightEditText.getText().length() > 0)
                            {
                                double equilateralTriangleHeight = Double.parseDouble(equilateralTriangleHeightEditText.getText().toString());

                                mAnswer = equilateralTriangle.areaHeight(equilateralTriangleHeight);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (equilateralTrianglePerimeterEditText.getText().length() > 0)
                            {
                                double equilateralTrianglePerimeter = Double.parseDouble(equilateralTrianglePerimeterEditText.getText().toString());

                                mAnswer = equilateralTriangle.areaPerimeter(equilateralTrianglePerimeter);

                                mWorking = equilateralTriangle.getWorking();
                                equilateralTriangleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }

                            if (mParameterChecker)
                            {
                                mCheckBoxStartChecker = true;

                                BigDecimal bigDecimal = new BigDecimal(mAnswer).setScale(mDecimalPoints, RoundingMode.HALF_EVEN);
                                mAnswerLong = Math.round(mAnswer);

                                if (mDecimalPoints == 0)
                                {
                                    equilateralTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                }
                                else
                                {
                                    equilateralTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                }

                                equilateralTriangleAnswer.setVisibility(View.VISIBLE);

                                if (mCheckBoxChecker && mCheckBoxStartChecker)
                                {
                                    equilateralTriangleWorking.setVisibility(View.VISIBLE);
                                }

                            }

                        }

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                Log.e ("Error: ", "Nothing Selected");
            }
        });

        equilateralTriangleBackButton.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EquilateralTriangleFragment.equilateralTriangleFragment = getActivity().getSupportFragmentManager().findFragmentById (R.id.fragmentHolder);

                HomeScreenFragment fragment = new HomeScreenFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();
            }
        });

        equilateralTriangleWebViewIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EquilateralTriangleFragment.equilateralTriangleFragment = getActivity().getSupportFragmentManager().findFragmentById (R.id.fragmentHolder);

                EquilateralTriangleWebViewFragment fragment = new EquilateralTriangleWebViewFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();
            }
        });

        equilateralTriangleFormulaeIcon.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EquilateralTriangleFormulaeDialog dialog = new EquilateralTriangleFormulaeDialog();
                dialog.show(getActivity().getSupportFragmentManager(), "123");
            }
        });


        equilateralTriangleWorking.setVisibility (View.GONE);
        equilateralTriangleAnswer.setVisibility (View.INVISIBLE);

        btnEquilateralTriangleClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                equilateralTriangleSideLengthEditText.getText().clear();
                equilateralTriangleHeightEditText.getText().clear();
                equilateralTrianglePerimeterEditText.getText().clear();
                equilateralTriangleAreaEditText.getText().clear();

                equilateralTriangleWorking.setVisibility (View.GONE);
                equilateralTriangleAnswer.setVisibility (View.INVISIBLE);

                mCheckBoxStartChecker = false;
                mShowAnswerChecker = false;
            }
        });


        btnEquilateralTriangleCalculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                EquilateralTriangle equilateralTriangle = new EquilateralTriangle();

                if (mSquareSpinnerSelected == 0)
                {
                    if (equilateralTriangleSideLengthEditText.getText().length() > 0)
                    {
                        double equilateralTriangleSideLength = Double.parseDouble(equilateralTriangleSideLengthEditText.getText().toString());

                        mAnswer = equilateralTriangle.sideLengthSideLength(equilateralTriangleSideLength);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (equilateralTriangleHeightEditText.getText().length() > 0)
                    {
                        double equilateralTriangleHeight = Double.parseDouble(equilateralTriangleHeightEditText.getText().toString());

                        mAnswer = equilateralTriangle.sideLengthHeight(equilateralTriangleHeight);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (equilateralTrianglePerimeterEditText.getText().length() > 0)
                    {
                        double equilateralTrianglePerimeter = Double.parseDouble(equilateralTrianglePerimeterEditText.getText().toString());

                        mAnswer = equilateralTriangle.sideLengthPerimeter(equilateralTrianglePerimeter);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (equilateralTriangleAreaEditText.getText().length() > 0)
                    {
                        double equilateralTriangleArea = Double.parseDouble(equilateralTriangleAreaEditText.getText().toString());

                        mAnswer = equilateralTriangle.sideLengthArea(equilateralTriangleArea);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }

                    else
                    {
                        Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();

                        mParameterChecker = false;
                    }
                }


                else if (mSquareSpinnerSelected == 1)
                {
                    if (equilateralTriangleHeightEditText.getText().length() > 0)
                    {
                        double equilateralTriangleHeight = Double.parseDouble(equilateralTriangleHeightEditText.getText().toString());

                        mAnswer = equilateralTriangle.heightHeight(equilateralTriangleHeight);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (equilateralTriangleSideLengthEditText.getText().length() > 0)
                    {
                        double equilateralTriangleSideLength = Double.parseDouble(equilateralTriangleSideLengthEditText.getText().toString());

                        mAnswer = equilateralTriangle.heightSideLength(equilateralTriangleSideLength);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (equilateralTrianglePerimeterEditText.getText().length() > 0)
                    {
                        double equilateralTrianglePerimeter = Double.parseDouble(equilateralTrianglePerimeterEditText.getText().toString());

                        mAnswer = equilateralTriangle.heightPerimeter(equilateralTrianglePerimeter);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (equilateralTriangleAreaEditText.getText().length() > 0)
                    {
                        double equilateralTriangleArea = Double.parseDouble(equilateralTriangleAreaEditText.getText().toString());

                        mAnswer = equilateralTriangle.heightArea(equilateralTriangleArea);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }

                    else
                    {
                        Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();

                        mParameterChecker = false;
                    }
                }


                else if (mSquareSpinnerSelected == 2)
                {
                    if (equilateralTrianglePerimeterEditText.getText().length() > 0)
                    {
                        double equilateralTrianglePerimeter = Double.parseDouble(equilateralTrianglePerimeterEditText.getText().toString());

                        mAnswer = equilateralTriangle.perimeterPerimeter(equilateralTrianglePerimeter);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (equilateralTriangleSideLengthEditText.getText().length() > 0)
                    {
                        double equilateralTriangleSideLength = Double.parseDouble(equilateralTriangleSideLengthEditText.getText().toString());

                        mAnswer = equilateralTriangle.perimeterSideLength(equilateralTriangleSideLength);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (equilateralTriangleHeightEditText.getText().length() > 0)
                    {
                        double equilateralTriangleHeight = Double.parseDouble(equilateralTriangleHeightEditText.getText().toString());

                        mAnswer = equilateralTriangle.perimeterHeight(equilateralTriangleHeight);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (equilateralTriangleAreaEditText.getText().length() > 0)
                    {
                        double equilateralTriangleArea = Double.parseDouble(equilateralTriangleAreaEditText.getText().toString());

                        mAnswer = equilateralTriangle.perimeterArea(equilateralTriangleArea);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }

                    else
                    {
                        Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();

                        mParameterChecker = false;
                    }
                }

                else if (mSquareSpinnerSelected == 3)
                {
                    if (equilateralTriangleAreaEditText.getText().length() > 0)
                    {
                        double equilateralTriangleArea = Double.parseDouble(equilateralTriangleAreaEditText.getText().toString());

                        mAnswer = equilateralTriangle.areaArea(equilateralTriangleArea);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (equilateralTriangleSideLengthEditText.getText().length() > 0)
                    {
                        double equilateralTriangleSideLength = Double.parseDouble(equilateralTriangleSideLengthEditText.getText().toString());

                        mAnswer = equilateralTriangle.areaSideLength(equilateralTriangleSideLength);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (equilateralTriangleHeightEditText.getText().length() > 0)
                    {
                        double equilateralTriangleHeight = Double.parseDouble(equilateralTriangleHeightEditText.getText().toString());

                        mAnswer = equilateralTriangle.areaHeight(equilateralTriangleHeight);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (equilateralTrianglePerimeterEditText.getText().length() > 0)
                    {
                        double equilateralTrianglePerimeter = Double.parseDouble(equilateralTrianglePerimeterEditText.getText().toString());

                        mAnswer = equilateralTriangle.areaPerimeter(equilateralTrianglePerimeter);

                        mWorking = equilateralTriangle.getWorking();
                        equilateralTriangleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }

                    else
                    {
                        Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();
                        mParameterChecker = false;
                    }
                }

                if (mParameterChecker == true)
                {
                    mCheckBoxStartChecker = true;
                    mShowAnswerChecker = true;

                    BigDecimal bigDecimal = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);
                    mAnswerLong = Math.round(mAnswer);

                    if (mDecimalPoints == 0)
                    {
                        equilateralTriangleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + mAnswerLong);
                    }
                    else
                    {
                        equilateralTriangleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + bigDecimal.doubleValue());
                    }

                    equilateralTriangleAnswer.setVisibility (View.VISIBLE);

                    if (mCheckBoxChecker && mCheckBoxStartChecker)
                    {
                        equilateralTriangleWorking.setVisibility(View.VISIBLE);
                    }

                }
            }

        });


        return v;
    }

}
