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
import java.util.Random;

public class CircleFragment extends Fragment
{
    private int mCircleSpinnerSelected;

    private double mAnswer;
    private long mAnswerLong;

    private String mWorking;

    private int mDecimalPoints;
    private int mPiDecimalPoints;

    private boolean mParameterChecker = false;

    private boolean mCheckBoxChecker ;
    private boolean mCheckBoxStartChecker;

    private boolean mShowAnswerChecker = false;


    public static Fragment circleFragment;

    @Override
    public View onCreateView (LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_circle, container, false);


        final EditText circleRadiusEditText = (EditText) v.findViewById (R.id.circleRadiusEditText);
        final EditText circleDiameterEditText = (EditText) v.findViewById (R.id.circleDiameterEditText);
        final EditText circleCircumferenceEditText = (EditText) v.findViewById (R.id.circleCircumferenceEditText);
        final EditText circleAreaEditText = (EditText) v.findViewById (R.id.circleAreaEditText);

        final TextView circleWorking = (TextView) v.findViewById (R.id.circleWorking);
        final TextView circleAnswer = (TextView) v.findViewById (R.id.circleAnswer);

        final ImageView circleBackButton = (ImageView) v.findViewById (R.id.circleBackButton);
        final ImageView circleWebViewIcon = (ImageView) v.findViewById (R.id.circleWebViewIcon);
        final ImageView circleFormulaeIcon = (ImageView) v.findViewById (R.id.circleFormulaeIcon);

        final Button btnCircleCalculate = (Button) v.findViewById (R.id.btnCircleCalculate);
        final Button btnCircleClear = (Button) v.findViewById (R.id.btnCircleClear);

        final Spinner circleSpinner = (Spinner) v.findViewById (R.id.circleSpinner);

        final SeekBar circleSeekBar = (SeekBar) v.findViewById (R.id.circleSeekBar);
        final TextView circleSeekBarValue = v.findViewById (R.id.circleSeekBarValue);

        final SeekBar circlePiSeekBar = (SeekBar) v.findViewById (R.id.circlePiPrecisionSeekBar);
        final TextView circlePiPrecisionSeekBarValue = v.findViewById (R.id.circlePiPrecisionSeekBarValue);
        final TextView circlePiValue = v.findViewById (R.id.circlePiValue);

        final CheckBox cbCircleWorking = (CheckBox) v.findViewById (R.id.cbCircleWorking);

        mCheckBoxChecker = false;
        mCheckBoxStartChecker = false;


        circleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged (SeekBar seekBar, int value, boolean fromUser)
            {
                circleSeekBarValue.setText ("" + value);
                mDecimalPoints = value;

                BigDecimal bigDecimal = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);

                mAnswerLong = Math.round(mAnswer);

                if (mDecimalPoints == 0)
                {
                    circleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + mAnswerLong);
                }
                else
                {
                    circleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + bigDecimal.doubleValue());
                }
            }

                @Override
            public void onStartTrackingTouch (SeekBar seekBar)
            {
                //Nothing
            }

            @Override
            public void onStopTrackingTouch (SeekBar seekBar)
            {
                //Nothing
            }
        });


        cbCircleWorking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (cbCircleWorking.isChecked())
                {
                    mCheckBoxChecker = true;

                    if (mCheckBoxStartChecker)
                    {
                        circleWorking.setVisibility (View.VISIBLE);
                    }
                }
                else
                {
                    mCheckBoxChecker = false;
                }

                if (!cbCircleWorking.isChecked())
                {
                    circleWorking.setVisibility (View.GONE);
                }
            }
        });


        circleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Circle circle = new Circle();

                switch (position) {
                    case 0:

                        mCircleSpinnerSelected = 0;

                        if (mShowAnswerChecker)
                        {
                            if (circleRadiusEditText.getText().length() > 0)
                            {
                                double circleRadius = Double.parseDouble(circleRadiusEditText.getText().toString());

                                mAnswer = circle.radiusRadius (circleRadius);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (circleDiameterEditText.getText().length() > 0)
                            {
                                double circleDiameter = Double.parseDouble(circleDiameterEditText.getText().toString());

                                mAnswer = circle.radiusDiameter (circleDiameter);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (circleCircumferenceEditText.getText().length() > 0)
                            {
                                double circleCircumference = Double.parseDouble(circleCircumferenceEditText.getText().toString());

                                mAnswer = circle.radiusCircumference (circleCircumference);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (circleAreaEditText.getText().length() > 0)
                            {
                                double circleArea = Double.parseDouble(circleAreaEditText.getText().toString());

                                mAnswer = circle.radiusArea(circleArea);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }

                            if (mParameterChecker)
                            {
                                mCheckBoxStartChecker = true;

                                BigDecimal bigDecimal = new BigDecimal(mAnswer).setScale(mDecimalPoints, RoundingMode.HALF_EVEN);
                                mAnswerLong = Math.round(mAnswer);

                                if (mDecimalPoints == 0)
                                {
                                    circleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                }
                                else
                                {
                                    circleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                }

                                circleAnswer.setVisibility(View.VISIBLE);

                                if (mCheckBoxChecker && mCheckBoxStartChecker)
                                {
                                    circleWorking.setVisibility(View.VISIBLE);
                                }

                            }

                        }

                        break;


                    case 1:

                        mCircleSpinnerSelected = 1;

                        if (mShowAnswerChecker)
                        {
                            if (circleDiameterEditText.getText().length() > 0)
                            {
                                double circleDiameter = Double.parseDouble(circleDiameterEditText.getText().toString());

                                mAnswer = circle.diameterDiameter(circleDiameter);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (circleRadiusEditText.getText().length() > 0)
                            {
                                double circleDiameter = Double.parseDouble(circleRadiusEditText.getText().toString());

                                mAnswer = circle.diameterRadius(circleDiameter);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (circleCircumferenceEditText.getText().length() > 0)
                            {
                                double circleCircumference = Double.parseDouble(circleCircumferenceEditText.getText().toString());

                                mAnswer = circle.diameterCircumference(circleCircumference);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (circleAreaEditText.getText().length() > 0)
                            {
                                double circleArea = Double.parseDouble(circleAreaEditText.getText().toString());

                                mAnswer = circle.diameterArea(circleArea);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;

                            }

                            if (mParameterChecker)
                            {
                                mCheckBoxStartChecker = true;

                                BigDecimal bigDecimal = new BigDecimal(mAnswer).setScale(mDecimalPoints, RoundingMode.HALF_EVEN);
                                mAnswerLong = Math.round(mAnswer);

                                if (mDecimalPoints == 0)
                                {
                                    circleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                }
                                else
                                {
                                    circleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                }

                                circleAnswer.setVisibility(View.VISIBLE);

                                if (mCheckBoxChecker && mCheckBoxStartChecker)
                                {
                                    circleWorking.setVisibility(View.VISIBLE);
                                }

                            }

                        }

                        break;


                    case 2:

                        mCircleSpinnerSelected = 2;

                        if (mShowAnswerChecker)
                        {
                            if (circleCircumferenceEditText.getText().length() > 0)
                            {
                                double circleCircumference = Double.parseDouble(circleCircumferenceEditText.getText().toString());

                                mAnswer = circle.circumferenceCircumference(circleCircumference);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (circleRadiusEditText.getText().length() > 0)
                            {
                                double circleRadius = Double.parseDouble(circleRadiusEditText.getText().toString());

                                mAnswer = circle.circumferenceRadius(circleRadius);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (circleDiameterEditText.getText().length() > 0)
                            {
                                double circleDiameter = Double.parseDouble(circleDiameterEditText.getText().toString());

                                mAnswer = circle.circumferenceDiameter(circleDiameter);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (circleAreaEditText.getText().length() > 0)
                            {
                                double circleArea = Double.parseDouble(circleAreaEditText.getText().toString());

                                mAnswer = circle.circumferenceArea(circleArea);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }

                            if (mParameterChecker)
                            {
                                mCheckBoxStartChecker = true;

                                BigDecimal bigDecimal = new BigDecimal(mAnswer).setScale(mDecimalPoints, RoundingMode.HALF_EVEN);
                                mAnswerLong = Math.round(mAnswer);

                                if (mDecimalPoints == 0)
                                {
                                    circleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                }
                                else
                                {
                                    circleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                }

                                circleAnswer.setVisibility(View.VISIBLE);

                                if (mCheckBoxChecker && mCheckBoxStartChecker)
                                {
                                    circleWorking.setVisibility(View.VISIBLE);
                                }

                            }

                        }

                        break;

                    case 3:

                        mCircleSpinnerSelected = 3;

                        if (mShowAnswerChecker)
                        {
                            if (circleAreaEditText.getText().length() > 0)
                            {
                                double circleArea = Double.parseDouble(circleAreaEditText.getText().toString());

                                mAnswer = circle.areaArea(circleArea);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (circleRadiusEditText.getText().length() > 0)
                            {
                                double circleRadius = Double.parseDouble(circleRadiusEditText.getText().toString());

                                mAnswer = circle.areaRadius(circleRadius);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (circleDiameterEditText.getText().length() > 0)
                            {
                                double circleDiameter = Double.parseDouble(circleDiameterEditText.getText().toString());

                                mAnswer = circle.areaDiameter(circleDiameter);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (circleCircumferenceEditText.getText().length() > 0)
                            {
                                double squareCircumference = Double.parseDouble(circleCircumferenceEditText.getText().toString());

                                mAnswer = circle.areaCircumference(squareCircumference);

                                mWorking = circle.getWorking();
                                circleWorking.setText(mWorking);

                                mParameterChecker = true;
                            }

                            if (mParameterChecker)
                            {
                                mCheckBoxStartChecker = true;

                                BigDecimal bigDecimal = new BigDecimal(mAnswer).setScale(mDecimalPoints, RoundingMode.HALF_EVEN);
                                mAnswerLong = Math.round(mAnswer);

                                if (mDecimalPoints == 0)
                                {
                                    circleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                }
                                else
                                {
                                    circleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                }

                                circleAnswer.setVisibility(View.VISIBLE);

                                if (mCheckBoxChecker && mCheckBoxStartChecker)
                                {
                                    circleWorking.setVisibility(View.VISIBLE);
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

        circlePiSeekBar.setOnSeekBarChangeListener (new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser)
            {
                Circle.PI = Math.PI;

                circlePiPrecisionSeekBarValue.setText ("" + value);
                mPiDecimalPoints = value;

                BigDecimal bigDecimal = new BigDecimal (Circle.PI).setScale (mPiDecimalPoints, RoundingMode.HALF_EVEN);

                Circle.PI = bigDecimal.doubleValue();

                circlePiValue.setText(getResources().getString(R.string.pi) + " " + bigDecimal);


                if (mShowAnswerChecker)
                {
                    Circle circle = new Circle();

                    if (mCircleSpinnerSelected == 0)
                    {
                        if (circleRadiusEditText.getText().length() > 0)
                        {
                            double circleRadius = Double.parseDouble(circleRadiusEditText.getText().toString());

                            mAnswer = circle.radiusRadius (circleRadius);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (circleDiameterEditText.getText().length() > 0)
                        {
                            double circleDiameter = Double.parseDouble(circleDiameterEditText.getText().toString());

                            mAnswer = circle.radiusDiameter (circleDiameter);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (circleCircumferenceEditText.getText().length() > 0)
                        {
                            double circleCircumference = Double.parseDouble(circleCircumferenceEditText.getText().toString());

                            mAnswer = circle.radiusCircumference (circleCircumference);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (circleAreaEditText.getText().length() > 0)
                        {
                            double circleArea = Double.parseDouble(circleAreaEditText.getText().toString());

                            mAnswer = circle.radiusArea(circleArea);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                    }

                    else if (mCircleSpinnerSelected == 1)
                    {
                        if (circleDiameterEditText.getText().length() > 0)
                        {
                            double circleDiameter = Double.parseDouble(circleDiameterEditText.getText().toString());

                            mAnswer = circle.diameterDiameter(circleDiameter);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (circleRadiusEditText.getText().length() > 0)
                        {
                            double circleDiameter = Double.parseDouble(circleRadiusEditText.getText().toString());

                            mAnswer = circle.diameterRadius(circleDiameter);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (circleCircumferenceEditText.getText().length() > 0)
                        {
                            double circleCircumference = Double.parseDouble(circleCircumferenceEditText.getText().toString());

                            mAnswer = circle.diameterCircumference(circleCircumference);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (circleAreaEditText.getText().length() > 0)
                        {
                            double circleArea = Double.parseDouble(circleAreaEditText.getText().toString());

                            mAnswer = circle.diameterArea(circleArea);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;

                        }
                    }

                    else if (mCircleSpinnerSelected == 2)
                    {
                        if (circleCircumferenceEditText.getText().length() > 0)
                        {
                            double circleCircumference = Double.parseDouble(circleCircumferenceEditText.getText().toString());

                            mAnswer = circle.circumferenceCircumference(circleCircumference);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (circleRadiusEditText.getText().length() > 0)
                        {
                            double circleRadius = Double.parseDouble(circleRadiusEditText.getText().toString());

                            mAnswer = circle.circumferenceRadius(circleRadius);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (circleDiameterEditText.getText().length() > 0)
                        {
                            double circleDiameter = Double.parseDouble(circleDiameterEditText.getText().toString());

                            mAnswer = circle.circumferenceDiameter(circleDiameter);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (circleAreaEditText.getText().length() > 0)
                        {
                            double circleArea = Double.parseDouble(circleAreaEditText.getText().toString());

                            mAnswer = circle.circumferenceArea(circleArea);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                    }

                    else if (mCircleSpinnerSelected == 3)
                    {
                        if (circleAreaEditText.getText().length() > 0)
                        {
                            double circleArea = Double.parseDouble(circleAreaEditText.getText().toString());

                            mAnswer = circle.areaArea(circleArea);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (circleRadiusEditText.getText().length() > 0)
                        {
                            double circleRadius = Double.parseDouble(circleRadiusEditText.getText().toString());

                            mAnswer = circle.areaRadius(circleRadius);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (circleDiameterEditText.getText().length() > 0)
                        {
                            double circleDiameter = Double.parseDouble(circleDiameterEditText.getText().toString());

                            mAnswer = circle.areaDiameter(circleDiameter);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (circleCircumferenceEditText.getText().length() > 0)
                        {
                            double squareCircumference = Double.parseDouble(circleCircumferenceEditText.getText().toString());

                            mAnswer = circle.areaCircumference(squareCircumference);

                            mWorking = circle.getWorking();
                            circleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                    }

                    if (mParameterChecker)
                    {
                        mCheckBoxStartChecker = true;
                        mShowAnswerChecker = true;

                        BigDecimal bigDecimal2 = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);
                        mAnswerLong = Math.round(mAnswer);

                        if (mDecimalPoints == 0)
                        {
                            circleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + mAnswerLong);
                        }
                        else
                        {
                            circleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + bigDecimal2.doubleValue());
                        }

                        circleAnswer.setVisibility (View.VISIBLE);

                        if (mCheckBoxChecker && mCheckBoxStartChecker)
                        {
                            circleWorking.setVisibility(View.VISIBLE);
                        }

                    }
                }
            }

            @Override
            public void onStartTrackingTouch (SeekBar seekBar)
            {
                //Nothing
            }

            @Override
            public void onStopTrackingTouch (SeekBar seekBar)
            {
                //Nothing
            }
        });

        circleSeekBarValue.setText ("" + mDecimalPoints);
        circlePiPrecisionSeekBarValue.setText ("" + mPiDecimalPoints);
        circlePiValue.setText ("π =" + " " + Circle.PI);

        circleBackButton.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CircleFragment.circleFragment = getActivity().getSupportFragmentManager().findFragmentById (R.id.fragmentHolder);

                HomeScreenFragment fragment = new HomeScreenFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();
            }
        });

        circleWebViewIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CircleFragment.circleFragment = getActivity().getSupportFragmentManager().findFragmentById (R.id.fragmentHolder);

                CircleWebViewFragment fragment = new CircleWebViewFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();
            }
        });

        circleFormulaeIcon.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CircleFormulaeDialog dialog = new CircleFormulaeDialog();
                dialog.show(getActivity().getSupportFragmentManager(), "123");
            }
        });


        circleWorking.setVisibility (View.GONE);
        circleAnswer.setVisibility (View.INVISIBLE);

        btnCircleClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                circleRadiusEditText.getText().clear();
                circleDiameterEditText.getText().clear();
                circleCircumferenceEditText.getText().clear();
                circleAreaEditText.getText().clear();

                circleWorking.setVisibility (View.GONE);
                circleAnswer.setVisibility (View.INVISIBLE);

                mCheckBoxStartChecker = false;
                mShowAnswerChecker = false;
            }
        });

        btnCircleCalculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Circle circle = new Circle();

                if (mCircleSpinnerSelected == 0)
                {
                    if (circleRadiusEditText.getText().length() > 0)
                    {
                        double circleRadius = Double.parseDouble(circleRadiusEditText.getText().toString());

                        mAnswer = circle.radiusRadius (circleRadius);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (circleDiameterEditText.getText().length() > 0)
                    {
                        double circleDiameter = Double.parseDouble(circleDiameterEditText.getText().toString());

                        mAnswer = circle.radiusDiameter (circleDiameter);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (circleCircumferenceEditText.getText().length() > 0)
                    {
                        double circleCircumference = Double.parseDouble(circleCircumferenceEditText.getText().toString());

                        mAnswer = circle.radiusCircumference (circleCircumference);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (circleAreaEditText.getText().length() > 0)
                    {
                        double circleArea = Double.parseDouble(circleAreaEditText.getText().toString());

                        mAnswer = circle.radiusArea(circleArea);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }

                    else
                    {
                        Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();

                        mParameterChecker = false;
                    }
                }


                else if (mCircleSpinnerSelected == 1)
                {
                    if (circleDiameterEditText.getText().length() > 0)
                    {
                        double circleDiameter = Double.parseDouble(circleDiameterEditText.getText().toString());

                        mAnswer = circle.diameterDiameter(circleDiameter);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (circleRadiusEditText.getText().length() > 0)
                    {
                        double circleDiameter = Double.parseDouble(circleRadiusEditText.getText().toString());

                        mAnswer = circle.diameterRadius(circleDiameter);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (circleCircumferenceEditText.getText().length() > 0)
                    {
                        double circleCircumference = Double.parseDouble(circleCircumferenceEditText.getText().toString());

                        mAnswer = circle.diameterCircumference(circleCircumference);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (circleAreaEditText.getText().length() > 0)
                    {
                        double circleArea = Double.parseDouble(circleAreaEditText.getText().toString());

                        mAnswer = circle.diameterArea(circleArea);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;

                    }

                    else
                    {
                        Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();

                        mParameterChecker = false;
                    }
                }


                else if (mCircleSpinnerSelected == 2)
                {
                    if (circleCircumferenceEditText.getText().length() > 0)
                    {
                        double circleCircumference = Double.parseDouble(circleCircumferenceEditText.getText().toString());

                        mAnswer = circle.circumferenceCircumference(circleCircumference);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (circleRadiusEditText.getText().length() > 0)
                    {
                        double circleRadius = Double.parseDouble(circleRadiusEditText.getText().toString());

                        mAnswer = circle.circumferenceRadius(circleRadius);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (circleDiameterEditText.getText().length() > 0)
                    {
                        double circleDiameter = Double.parseDouble(circleDiameterEditText.getText().toString());

                        mAnswer = circle.circumferenceDiameter(circleDiameter);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (circleAreaEditText.getText().length() > 0)
                    {
                        double circleArea = Double.parseDouble(circleAreaEditText.getText().toString());

                        mAnswer = circle.circumferenceArea(circleArea);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "" + getResources().getString(R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();

                        mParameterChecker = false;
                    }
                }

                else if (mCircleSpinnerSelected == 3)
                {
                    if (circleAreaEditText.getText().length() > 0)
                    {
                        double circleArea = Double.parseDouble(circleAreaEditText.getText().toString());

                        mAnswer = circle.areaArea(circleArea);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (circleRadiusEditText.getText().length() > 0)
                    {
                        double circleRadius = Double.parseDouble(circleRadiusEditText.getText().toString());

                        mAnswer = circle.areaRadius(circleRadius);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (circleDiameterEditText.getText().length() > 0)
                    {
                        double circleDiameter = Double.parseDouble(circleDiameterEditText.getText().toString());

                        mAnswer = circle.areaDiameter(circleDiameter);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }
                    else if (circleCircumferenceEditText.getText().length() > 0)
                    {
                        double squareCircumference = Double.parseDouble(circleCircumferenceEditText.getText().toString());

                        mAnswer = circle.areaCircumference(squareCircumference);

                        mWorking = circle.getWorking();
                        circleWorking.setText(mWorking);

                        mParameterChecker = true;
                    }

                    else
                    {
                        Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();
                        mParameterChecker = false;
                    }
                }

                if (mParameterChecker)
                {
                    mCheckBoxStartChecker = true;
                    mShowAnswerChecker = true;

                    BigDecimal bigDecimal = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);
                    mAnswerLong = Math.round(mAnswer);

                    if (mDecimalPoints == 0)
                    {
                        circleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + mAnswerLong);
                    }
                    else
                    {
                        circleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + bigDecimal.doubleValue());
                    }

                    circleAnswer.setVisibility (View.VISIBLE);

                    if (mCheckBoxChecker && mCheckBoxStartChecker)
                    {
                        circleWorking.setVisibility(View.VISIBLE);
                    }

                }
            }

        });

        return v;
    }
}
