package com.samazebra.mathematicalgeometrycalculator;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
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

public class IsoscelesTriangleFragment extends Fragment
{
    private int mIsoscelesTriangleSpinnerSelected;

    private double mAnswer;
    private long mAnswerLong;

    private String mWorking;

    private int mDecimalPoints;

    private boolean mParameterChecker = false;

    private boolean mCheckBoxChecker ;
    private boolean mCheckBoxStartChecker;

    private boolean mShowAnswerChecker = false;

    public static Fragment isoscelesTriangleFragment;


    @Override
    public View onCreateView (LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_isosceles_triangle, container, false);

        final EditText isoscelesTriangleSideLengthEditText = (EditText) v.findViewById (R.id.isoscelesTriangleSideLengthEditText);
        final EditText isoscelesTriangleBaseEditText = (EditText) v.findViewById (R.id.isoscelesTriangleBaseEditText);
        final EditText isoscelesTriangleHeightEditText = (EditText) v.findViewById (R.id.isoscelesTriangleHeightEditText);
        final EditText isoscelesTrianglePerimeterEditText = (EditText) v.findViewById (R.id.isoscelesTrianglePerimeterEditText);
        final EditText isoscelesTriangleAreaEditText = (EditText) v.findViewById (R.id.isoscelesTriangleAreaEditText);
        //final EditText isoscelesTriangleAngleAEditText = (EditText) v.findViewById (R.id.isoscelesTriangleAngleAEditText);
        //final EditText isoscelesTriangleAngleBEditText = (EditText) v.findViewById (R.id.isoscelesTriangleAngleBEditText);
        //final EditText isoscelesTriangleAngleXEditText = (EditText) v.findViewById (R.id.isoscelesTriangleAngleXEditText);
        //final EditText isoscelesTriangleAngleYEditText = (EditText) v.findViewById (R.id.isoscelesTriangleAngleYEditText);

        final TextView isoscelesTriangleWorking = (TextView) v.findViewById (R.id.isoscelesTriangleWorking);
        final TextView isoscelesTriangleAnswer = (TextView) v.findViewById (R.id.isoscelesTriangleAnswer);

        final ImageView isoscelesTriangleBackButton = (ImageView) v.findViewById (R.id.isoscelesTriangleBackButton);
        final ImageView isoscelesTriangleWebViewIcon = (ImageView) v.findViewById (R.id.isoscelesTriangleWebViewIcon);
        final ImageView isoscelesTriangleFormulaeIcon = (ImageView) v.findViewById (R.id.isoscelesTriangleFormulaeIcon);

        final Button btnIsoscelesTriangleCalculate = (Button) v.findViewById (R.id.btnIsoscelesTriangleCalculate);
        final Button btnIsoscelesTriangleClear = (Button) v.findViewById (R.id.btnIsoscelesTriangleClear);

        final Spinner isoscelesTriangleSpinner = (Spinner) v.findViewById (R.id.isoscelesTriangleSpinner);

        final SeekBar isoscelesTriangleSeekBar = (SeekBar) v.findViewById (R.id.isoscelesTriangleSeekBar);
        final TextView isoscelesTriangleSeekBarValue = v.findViewById (R.id.isoscelesTriangleSeekBarValue);

        final CheckBox cbIsoscelesTriangleWorking = (CheckBox) v.findViewById (R.id.cbIsoscelesTriangleWorking);

        mCheckBoxChecker = false;
        mCheckBoxStartChecker = false;


        isoscelesTriangleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser)
            {
                isoscelesTriangleSeekBarValue.setText ("" + value);
                mDecimalPoints = value;

                try{
                    BigDecimal bigDecimal = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);
                    mAnswerLong = Math.round(mAnswer);

                    if (mDecimalPoints == 0)
                    {
                        isoscelesTriangleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + mAnswerLong);
                    }
                    else
                    {
                        isoscelesTriangleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + bigDecimal.doubleValue());
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getActivity(),"INVALID RESULT",Toast.LENGTH_SHORT).show();
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

        isoscelesTriangleSeekBarValue.setText ("" + mDecimalPoints);


        cbIsoscelesTriangleWorking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (cbIsoscelesTriangleWorking.isChecked())
                {
                    mCheckBoxChecker = true;

                    if (mCheckBoxStartChecker)
                    {
                        isoscelesTriangleWorking.setVisibility (View.VISIBLE);
                    }
                }
                else
                {
                    mCheckBoxChecker = false;
                }

                if (!cbIsoscelesTriangleWorking.isChecked())
                {
                    isoscelesTriangleWorking.setVisibility (View.GONE);
                }
            }
        });


        isoscelesTriangleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                IsoscelesTriangle isoscelesTriangle = new IsoscelesTriangle();

                try{
                    switch (position) {
                        case 0:

                            mIsoscelesTriangleSpinnerSelected = 0;

                            if (mShowAnswerChecker)
                            {

                                if (isoscelesTriangleSideLengthEditText.getText().length() > 0)
                                {
                                    double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.sideLengthSideLength(sideLength);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleBaseEditText.getText().length() > 0 && isoscelesTriangleHeightEditText.getText().length() > 0)
                                {
                                    double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                                    double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.sideLengthHeightBase (height, base);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTrianglePerimeterEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                                {
                                    double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                                    double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.sideLengthPerimeterBase(perimeter, base);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleAreaEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                                {
                                    double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());
                                    double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.sideLengthAreaBase(area, base);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTrianglePerimeterEditText.getText().length() > 0)
                                {
                                    double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());
                                    double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.sideLengthPerimeterHeight(perimeter, height);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTriangleAreaEditText.getText().length() > 0)
                                {
                                    double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());
                                    double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.sideLengthAreaHeight(area, height);

                                    mWorking = isoscelesTriangle.getWorking();
                               /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                                {
                                    isoscelesTriangleWorking.setText(Html.fromHtml(mWorking, Html.FROM_HTML_MODE_LEGACY));
                                }
                                else
                                    isoscelesTriangleWorking.setText(Html.fromHtml(mWorking));*/

                                    convertHtml(isoscelesTriangleWorking);

                                    //isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                if (mParameterChecker)
                                {
                                    mCheckBoxStartChecker = true;


                                    BigDecimal bigDecimal = null;
                                    try{
                                        bigDecimal = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);
                                    }
                                    catch (Exception e)
                                    {
                                        Toast.makeText(getActivity(),"INVALID RESULT",Toast.LENGTH_SHORT).show();
                                    }


                                    mAnswerLong = Math.round(mAnswer);

                                    if (mDecimalPoints == 0)
                                    {
                                        isoscelesTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                    }
                                    else
                                    {
                                        isoscelesTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                    }

                                    isoscelesTriangleAnswer.setVisibility(View.VISIBLE);

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                                    {
                                        isoscelesTriangleWorking.setText(Html.fromHtml(mWorking, Html.FROM_HTML_MODE_LEGACY));
                                    }
                                    else
                                        isoscelesTriangleWorking.setText(Html.fromHtml(mWorking));

                                    if (mCheckBoxChecker && mCheckBoxStartChecker)
                                    {
                                        isoscelesTriangleWorking.setVisibility(View.VISIBLE);
                                    }

                                }

                            }

                            break;


                        case 1:

                            mIsoscelesTriangleSpinnerSelected = 1;

                            if (mShowAnswerChecker)
                            {
                                if (isoscelesTriangleBaseEditText.getText().length() > 0)
                                {
                                    double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.baseBase(base);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleSideLengthEditText.getText().length() > 0 && isoscelesTriangleHeightEditText.getText().length() > 0)
                                {
                                    double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                                    double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.baseHeightSideLength (height, sideLength);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTrianglePerimeterEditText.getText().length() > 0 && isoscelesTriangleSideLengthEditText.getText().length() > 0)
                                {
                                    double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                                    double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.basePerimeterSideLength(perimeter, sideLength);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTrianglePerimeterEditText.getText().length() > 0)
                                {
                                    double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());
                                    double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.basePerimeterHeight(perimeter, height);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTriangleAreaEditText.getText().length() > 0)
                                {
                                    double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());
                                    double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.baseAreaHeight(area, height);

                                    mWorking = isoscelesTriangle.getWorking();
                                    convertHtml(isoscelesTriangleWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTrianglePerimeterEditText.getText().length() > 0 && isoscelesTriangleAreaEditText.getText().length() > 0)
                                {
                                    double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());
                                    double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.baseAreaHeight(perimeter, area);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                if (mParameterChecker)
                                {
                                    mCheckBoxStartChecker = true;

                                    BigDecimal bigDecimal = null;
                                    try{
                                        bigDecimal = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);
                                    }
                                    catch (Exception e)
                                    {
                                        Toast.makeText(getActivity(),"INVALID RESULT",Toast.LENGTH_SHORT).show();
                                    }

                                    mAnswerLong = Math.round(mAnswer);

                                    if (mDecimalPoints == 0)
                                    {
                                        isoscelesTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                    }
                                    else
                                    {
                                        isoscelesTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                    }

                                    isoscelesTriangleAnswer.setVisibility(View.VISIBLE);

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                                    {
                                        isoscelesTriangleWorking.setText(Html.fromHtml(mWorking, Html.FROM_HTML_MODE_LEGACY));
                                    }
                                    else
                                        isoscelesTriangleWorking.setText(Html.fromHtml(mWorking));

                                    if (mCheckBoxChecker && mCheckBoxStartChecker)
                                    {
                                        isoscelesTriangleWorking.setVisibility(View.VISIBLE);
                                    }

                                }

                            }

                            break;


                        case 2:

                            mIsoscelesTriangleSpinnerSelected = 2;

                            if (mShowAnswerChecker)
                            {

                                if (isoscelesTriangleHeightEditText.getText().length() > 0)
                                {
                                    double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.heightHeight(height);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleSideLengthEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                                {
                                    double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                                    double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.heightSideLengthBase (sideLength, base);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTrianglePerimeterEditText.getText().length() > 0 && isoscelesTriangleSideLengthEditText.getText().length() > 0)
                                {
                                    double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                                    double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.heightSideLengthPerimeter(sideLength, perimeter);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTrianglePerimeterEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                                {
                                    double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                                    double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.heightBasePerimeter(base, perimeter);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleBaseEditText.getText().length() > 0 && isoscelesTriangleAreaEditText.getText().length() > 0)
                                {
                                    double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                                    double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.heightBaseArea(base, area);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                if (mParameterChecker)
                                {
                                    mCheckBoxStartChecker = true;

                                    BigDecimal bigDecimal = null;
                                    try{
                                        bigDecimal = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);
                                    }
                                    catch (Exception e)
                                    {
                                        Toast.makeText(getActivity(),"INVALID RESULT",Toast.LENGTH_SHORT).show();
                                    }
                                    mAnswerLong = Math.round(mAnswer);

                                    if (mDecimalPoints == 0)
                                    {
                                        isoscelesTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                    }
                                    else
                                    {
                                        isoscelesTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                    }

                                    isoscelesTriangleAnswer.setVisibility(View.VISIBLE);

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                                    {
                                        isoscelesTriangleWorking.setText(Html.fromHtml(mWorking, Html.FROM_HTML_MODE_LEGACY));
                                    }
                                    else
                                        isoscelesTriangleWorking.setText(Html.fromHtml(mWorking));

                                    if (mCheckBoxChecker && mCheckBoxStartChecker)
                                    {
                                        isoscelesTriangleWorking.setVisibility(View.VISIBLE);
                                    }

                                }

                            }

                            break;

                        case 3:

                            mIsoscelesTriangleSpinnerSelected = 3;

                            if (mShowAnswerChecker)
                            {
                                if (isoscelesTrianglePerimeterEditText.getText().length() > 0)
                                {
                                    double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.perimeterPerimeter(perimeter);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleSideLengthEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                                {
                                    double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                                    double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.perimeterSideLengthBase (sideLength, base);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTriangleSideLengthEditText.getText().length() > 0)
                                {
                                    double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                                    double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.perimeterSideLengthHeight(sideLength, height);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                                {
                                    double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                                    double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.perimeterBaseHeight(base, height);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleBaseEditText.getText().length() > 0 && isoscelesTriangleAreaEditText.getText().length() > 0)
                                {
                                    double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                                    double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.perimeterBaseArea(base, area);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTriangleAreaEditText.getText().length() > 0)
                                {
                                    double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());
                                    double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.perimeterHeightArea(height, area);

                                    mWorking = isoscelesTriangle.getWorking();
                                    convertHtml(isoscelesTriangleWorking);

                                    mParameterChecker = true;
                                }
                                if (mParameterChecker)
                                {
                                    mCheckBoxStartChecker = true;

                                    BigDecimal bigDecimal = null;
                                    try{
                                        bigDecimal = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);
                                    }
                                    catch (Exception e)
                                    {
                                        Toast.makeText(getActivity(),"INVALID RESULT",Toast.LENGTH_SHORT).show();
                                    }
                                    mAnswerLong = Math.round(mAnswer);

                                    if (mDecimalPoints == 0)
                                    {
                                        isoscelesTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                    }
                                    else
                                    {
                                        isoscelesTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                    }

                                    isoscelesTriangleAnswer.setVisibility(View.VISIBLE);

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                                    {
                                        isoscelesTriangleWorking.setText(Html.fromHtml(mWorking, Html.FROM_HTML_MODE_LEGACY));
                                    }
                                    else
                                        isoscelesTriangleWorking.setText(Html.fromHtml(mWorking));

                                    if (mCheckBoxChecker && mCheckBoxStartChecker)
                                    {
                                        isoscelesTriangleWorking.setVisibility(View.VISIBLE);
                                    }

                                }

                            }

                            break;


                        case 4:

                            mIsoscelesTriangleSpinnerSelected = 4;

                            if (mShowAnswerChecker)
                            {

                                if (isoscelesTriangleAreaEditText.getText().length() > 0)
                                {
                                    double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.areaArea(area);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleSideLengthEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                                {
                                    double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                                    double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.areaSideLengthBase (sideLength, base);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTriangleSideLengthEditText.getText().length() > 0)
                                {
                                    double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                                    double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.areaSideLengthHeight(sideLength, height);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                                {
                                    double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                                    double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.areaBaseHeight(base, height);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTriangleBaseEditText.getText().length() > 0 && isoscelesTrianglePerimeterEditText.getText().length() > 0)
                                {
                                    double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                                    double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.areaBasePerimeter(base, perimeter);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (isoscelesTrianglePerimeterEditText.getText().length() > 0 && isoscelesTriangleHeightEditText.getText().length() > 0)
                                {
                                    double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());
                                    double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                                    mAnswer = isoscelesTriangle.areaHeightPerimeter(height, perimeter);

                                    mWorking = isoscelesTriangle.getWorking();
                                    isoscelesTriangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                if (mParameterChecker)
                                {
                                    mCheckBoxStartChecker = true;

                                    BigDecimal bigDecimal = null;
                                    try{
                                        bigDecimal = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);
                                    }
                                    catch (Exception e)
                                    {
                                        Toast.makeText(getActivity(),"INVALID RESULT",Toast.LENGTH_SHORT).show();
                                    }
                                    mAnswerLong = Math.round(mAnswer);

                                    if (mDecimalPoints == 0)
                                    {
                                        isoscelesTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                    }
                                    else
                                    {
                                        isoscelesTriangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                    }

                                    isoscelesTriangleAnswer.setVisibility(View.VISIBLE);

                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                                    {
                                        isoscelesTriangleWorking.setText(Html.fromHtml(mWorking, Html.FROM_HTML_MODE_LEGACY));
                                    }
                                    else
                                        isoscelesTriangleWorking.setText(Html.fromHtml(mWorking));

                                    if (mCheckBoxChecker && mCheckBoxStartChecker)
                                    {
                                        isoscelesTriangleWorking.setVisibility(View.VISIBLE);
                                    }

                                }

                            }

                            break;

                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getActivity(),"INVALID RESULT",Toast.LENGTH_SHORT).show();
                    //e.printStackTrace();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                Log.e ("Error: ", "Nothing Selected");
            }
        });

        isoscelesTriangleBackButton.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IsoscelesTriangleFragment.isoscelesTriangleFragment = getActivity().getSupportFragmentManager().findFragmentById (R.id.fragmentHolder);

                HomeScreenFragment fragment = new HomeScreenFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();
            }
        });

        isoscelesTriangleWebViewIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IsoscelesTriangleFragment.isoscelesTriangleFragment = getActivity().getSupportFragmentManager().findFragmentById (R.id.fragmentHolder);

                IsoscelesTriangleWebViewFragment fragment = new IsoscelesTriangleWebViewFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();
            }
        });

        isoscelesTriangleFormulaeIcon.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IsoscelesTriangleFormulaeDialog dialog = new IsoscelesTriangleFormulaeDialog();
                dialog.show(getActivity().getSupportFragmentManager(), "123");
            }
        });


        isoscelesTriangleWorking.setVisibility (View.GONE);
        isoscelesTriangleAnswer.setVisibility (View.INVISIBLE);

        btnIsoscelesTriangleClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                isoscelesTriangleSideLengthEditText.getText().clear();
                isoscelesTriangleHeightEditText.getText().clear();
                isoscelesTrianglePerimeterEditText.getText().clear();
                isoscelesTriangleAreaEditText.getText().clear();

                isoscelesTriangleWorking.setVisibility (View.GONE);
                isoscelesTriangleAnswer.setVisibility (View.INVISIBLE);

                mCheckBoxStartChecker = false;
                mShowAnswerChecker = false;
            }
        });

        btnIsoscelesTriangleCalculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                try{
                    IsoscelesTriangle isoscelesTriangle = new IsoscelesTriangle();

                    if (mIsoscelesTriangleSpinnerSelected == 0)
                    {
                        if (isoscelesTriangleSideLengthEditText.getText().length() > 0)
                        {
                            double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());

                            mAnswer = isoscelesTriangle.sideLengthSideLength(sideLength);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleBaseEditText.getText().length() > 0 && isoscelesTriangleHeightEditText.getText().length() > 0)
                        {
                            double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                            double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                            mAnswer = isoscelesTriangle.sideLengthHeightBase (height, base);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTrianglePerimeterEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                        {
                            double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                            double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                            mAnswer = isoscelesTriangle.sideLengthPerimeterBase(perimeter, base);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleAreaEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                        {
                            double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());
                            double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());

                            mAnswer = isoscelesTriangle.sideLengthAreaBase(area, base);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTrianglePerimeterEditText.getText().length() > 0)
                        {
                            double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());
                            double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                            mAnswer = isoscelesTriangle.sideLengthPerimeterHeight(perimeter, height);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTriangleAreaEditText.getText().length() > 0)
                        {
                            double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());
                            double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());

                            mAnswer = isoscelesTriangle.sideLengthAreaHeight(area, height);

                            mWorking = isoscelesTriangle.getWorking();


                            //isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }

                        else
                        {
                            Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();

                            mParameterChecker = false;
                        }
                    }


                    else if (mIsoscelesTriangleSpinnerSelected == 1)
                    {
                        if (isoscelesTriangleBaseEditText.getText().length() > 0)
                        {
                            double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());

                            mAnswer = isoscelesTriangle.baseBase(base);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleSideLengthEditText.getText().length() > 0 && isoscelesTriangleHeightEditText.getText().length() > 0)
                        {
                            double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                            double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                            mAnswer = isoscelesTriangle.baseHeightSideLength (height, sideLength);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTrianglePerimeterEditText.getText().length() > 0 && isoscelesTriangleSideLengthEditText.getText().length() > 0)
                        {
                            double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                            double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                            mAnswer = isoscelesTriangle.basePerimeterSideLength(perimeter, sideLength);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTrianglePerimeterEditText.getText().length() > 0)
                        {
                            double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());
                            double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                            mAnswer = isoscelesTriangle.basePerimeterHeight(perimeter, height);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTriangleAreaEditText.getText().length() > 0)
                        {
                            double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());
                            double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());

                            mAnswer = isoscelesTriangle.baseAreaHeight(area, height);

                            mWorking = isoscelesTriangle.getWorking();
                            convertHtml(isoscelesTriangleWorking);

                            mParameterChecker = true;
                        }

                        else
                        {
                            Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();

                            mParameterChecker = false;
                        }
                    }


                    else if (mIsoscelesTriangleSpinnerSelected == 2)
                    {
                        if (isoscelesTriangleHeightEditText.getText().length() > 0)
                        {
                            double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                            mAnswer = isoscelesTriangle.heightHeight(height);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleSideLengthEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                        {
                            double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                            double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());

                            mAnswer = isoscelesTriangle.heightSideLengthBase (sideLength, base);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTrianglePerimeterEditText.getText().length() > 0 && isoscelesTriangleSideLengthEditText.getText().length() > 0)
                        {
                            double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                            double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                            mAnswer = isoscelesTriangle.heightSideLengthPerimeter(sideLength, perimeter);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTrianglePerimeterEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                        {
                            double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                            double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                            mAnswer = isoscelesTriangle.heightBasePerimeter(base, perimeter);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleBaseEditText.getText().length() > 0 && isoscelesTriangleAreaEditText.getText().length() > 0)
                        {
                            double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                            double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());

                            mAnswer = isoscelesTriangle.heightBaseArea(base, area);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }

                        else
                        {
                            Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();

                            mParameterChecker = false;
                        }
                    }

                    else if (mIsoscelesTriangleSpinnerSelected == 3)
                    {
                        if (isoscelesTrianglePerimeterEditText.getText().length() > 0)
                        {
                            double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                            mAnswer = isoscelesTriangle.perimeterPerimeter(perimeter);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleSideLengthEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                        {
                            double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                            double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());

                            mAnswer = isoscelesTriangle.perimeterSideLengthBase (sideLength, base);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTriangleSideLengthEditText.getText().length() > 0)
                        {
                            double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                            double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                            mAnswer = isoscelesTriangle.perimeterSideLengthHeight(sideLength, height);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                        {
                            double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                            double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                            mAnswer = isoscelesTriangle.perimeterBaseHeight(base, height);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleBaseEditText.getText().length() > 0 && isoscelesTriangleAreaEditText.getText().length() > 0)
                        {
                            double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                            double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());

                            mAnswer = isoscelesTriangle.perimeterBaseArea(base, area);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTriangleAreaEditText.getText().length() > 0)
                        {
                            double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());
                            double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());

                            mAnswer = isoscelesTriangle.perimeterHeightArea(height, area);

                            mWorking = isoscelesTriangle.getWorking();
                            convertHtml(isoscelesTriangleWorking);

                            mParameterChecker = true;
                        }

                        else
                        {
                            Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();
                            mParameterChecker = false;
                        }
                    }

                    else if (mIsoscelesTriangleSpinnerSelected == 4)
                    {

                        if (isoscelesTriangleAreaEditText.getText().length() > 0)
                        {
                            double area = Double.parseDouble(isoscelesTriangleAreaEditText.getText().toString());

                            mAnswer = isoscelesTriangle.areaArea(area);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleSideLengthEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                        {
                            double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                            double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());

                            mAnswer = isoscelesTriangle.areaSideLengthBase (sideLength, base);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTriangleSideLengthEditText.getText().length() > 0)
                        {
                            double sideLength = Double.parseDouble(isoscelesTriangleSideLengthEditText.getText().toString());
                            double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                            mAnswer = isoscelesTriangle.areaSideLengthHeight(sideLength, height);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleHeightEditText.getText().length() > 0 && isoscelesTriangleBaseEditText.getText().length() > 0)
                        {
                            double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                            double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                            mAnswer = isoscelesTriangle.areaBaseHeight(base, height);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTriangleBaseEditText.getText().length() > 0 && isoscelesTrianglePerimeterEditText.getText().length() > 0)
                        {
                            double base = Double.parseDouble(isoscelesTriangleBaseEditText.getText().toString());
                            double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());

                            mAnswer = isoscelesTriangle.areaBasePerimeter(base, perimeter);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (isoscelesTrianglePerimeterEditText.getText().length() > 0 && isoscelesTriangleHeightEditText.getText().length() > 0)
                        {
                            double perimeter = Double.parseDouble(isoscelesTrianglePerimeterEditText.getText().toString());
                            double height = Double.parseDouble(isoscelesTriangleHeightEditText.getText().toString());

                            mAnswer = isoscelesTriangle.areaHeightPerimeter(height, perimeter);

                            mWorking = isoscelesTriangle.getWorking();
                            isoscelesTriangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                    }

                    if (mParameterChecker)
                    {
                        mCheckBoxStartChecker = true;
                        mShowAnswerChecker = true;

                        BigDecimal bigDecimal = null;
                        try{
                            bigDecimal = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);
                        }
                        catch (Exception e)
                        {
                            Toast.makeText(getActivity(),"INVALID RESULT",Toast.LENGTH_SHORT).show();
                        }

                        mAnswerLong = Math.round(mAnswer);

                        if (mDecimalPoints == 0)
                        {
                            isoscelesTriangleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + mAnswerLong);
                        }
                        else
                        {
                            isoscelesTriangleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + bigDecimal.doubleValue());
                        }

                        isoscelesTriangleAnswer.setVisibility (View.VISIBLE);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                        {
                            isoscelesTriangleWorking.setText(Html.fromHtml(mWorking, Html.FROM_HTML_MODE_LEGACY));
                        }
                        else
                            isoscelesTriangleWorking.setText(Html.fromHtml(mWorking));

                        if (mCheckBoxChecker && mCheckBoxStartChecker)
                        {
                            isoscelesTriangleWorking.setVisibility(View.VISIBLE);
                        }

                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getActivity(),"INVALID RESULT",Toast.LENGTH_SHORT).show();
                    isoscelesTriangleAnswer.setText(getResources().getText(R.string.nan));
                    isoscelesTriangleWorking.setVisibility(View.VISIBLE);
                }
            }
        });



        return v;
    }

    private void convertHtml(TextView tWorking)
    {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        {
            tWorking.setText(Html.fromHtml(mWorking, Html.FROM_HTML_MODE_LEGACY));
        }
        else
            tWorking.setText(Html.fromHtml(mWorking));
    }
}
