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

public class RectangleFragment extends Fragment
{
    private int mRectangleSpinnerSelected;

    private double mAnswer;
    private long mAnswerLong;

    private String mWorking;

    private int mDecimalPoints;

    private boolean mParameterChecker = false;

    private boolean mCheckBoxChecker;
    private boolean mCheckBoxStartChecker;

    private boolean mShowAnswerChecker = false;

    public static Fragment rectangleFragment;


    @Override
    public View onCreateView (LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_rectangle, container, false);

        final EditText rectangleLengthEditText = (EditText) v.findViewById (R.id.rectangleLengthEditText);
        final EditText rectangleWidthEditText = (EditText) v.findViewById (R.id.rectangleWidthEditText);
        final EditText rectangleDiagonalEditText = (EditText) v.findViewById (R.id.rectangleDiagonalEditText);
        final EditText rectanglePerimeterEditText = (EditText) v.findViewById (R.id.rectanglePerimeterEditText);
        final EditText rectangleAreaEditText = (EditText) v.findViewById (R.id.rectangleAreaEditText);
        //final EditText rectangleAngleAEditText = (EditText) v.findViewById (R.id.rectangleAngleAEditText);
        //final EditText rectangleAngleBEditText = (EditText) v.findViewById (R.id.rectangleAngleBEditText);
        //final EditText rectangleAngleXEditText = (EditText) v.findViewById (R.id.rectangleAngleXEditText);
        //final EditText rectangleAngleYEditText = (EditText) v.findViewById (R.id.rectangleAngleYEditText);

        final TextView rectangleWorking = (TextView) v.findViewById (R.id.rectangleWorking);
        final TextView rectangleAnswer = (TextView) v.findViewById (R.id.rectangleAnswer);

        final ImageView rectangleBackButton = (ImageView) v.findViewById (R.id.rectangleBackButton);
        final ImageView rectangleWebViewIcon = (ImageView) v.findViewById (R.id.rectangleWebViewIcon);
        final ImageView rectangleFormulaeIcon = (ImageView) v.findViewById (R.id.rectangleFormulaeIcon);

        final Button btnRectangleCalculate = (Button) v.findViewById (R.id.btnRectangleCalculate);
        final Button btnRectangleClear = (Button) v.findViewById (R.id.btnRectangleClear);

        final Spinner rectangleSpinner = (Spinner) v.findViewById (R.id.rectangleSpinner);

        final SeekBar rectangleSeekBar = (SeekBar) v.findViewById (R.id.rectangleSeekBar);
        final TextView rectangleSeekBarValue = v.findViewById (R.id.rectangleSeekBarValue);

        final CheckBox cbRectangleWorking = (CheckBox) v.findViewById (R.id.cbRectangleWorking);

        mCheckBoxChecker = false;
        mCheckBoxStartChecker = false;


        rectangleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser)
            {
                rectangleSeekBarValue.setText ("" + value);
                mDecimalPoints = value;

                try{
                    BigDecimal bigDecimal = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);
                    mAnswerLong = Math.round(mAnswer);

                    if (mDecimalPoints == 0)
                    {
                        rectangleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + mAnswerLong);
                    }
                    else
                    {
                        rectangleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + bigDecimal.doubleValue());
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

        rectangleSeekBarValue.setText ("" + mDecimalPoints);


        cbRectangleWorking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (cbRectangleWorking.isChecked())
                {
                    mCheckBoxChecker = true;

                    if (mCheckBoxStartChecker)
                    {
                        rectangleWorking.setVisibility (View.VISIBLE);
                    }
                }
                else
                {
                    mCheckBoxChecker = false;
                }

                if (!cbRectangleWorking.isChecked())
                {
                    rectangleWorking.setVisibility (View.GONE);
                }
            }
        });


        rectangleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Rectangle rectangle = new Rectangle();

                try{
                    switch (position) {
                        case 0:

                            mRectangleSpinnerSelected = 0;

                            if (mShowAnswerChecker)
                            {

                                if (rectangleLengthEditText.getText().length() > 0)
                                {
                                    double length = Double.parseDouble(rectangleLengthEditText.getText().toString());

                                    mAnswer = rectangle.lengthLength(length);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleWidthEditText.getText().length() > 0 && rectangleDiagonalEditText.getText().length() > 0)
                                {
                                    double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                                    double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                                    mAnswer = rectangle.lengthDiagonalWidth (diagonal, width);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                                {
                                    double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                                    double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                                    mAnswer = rectangle.lengthPerimeterWidth(perimeter, width);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleAreaEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                                {
                                    double area = Double.parseDouble(rectangleAreaEditText.getText().toString());
                                    double width = Double.parseDouble(rectangleWidthEditText.getText().toString());

                                    mAnswer = rectangle.lengthAreaWidth(area, width);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleDiagonalEditText.getText().length() > 0 && rectanglePerimeterEditText.getText().length() > 0)
                                {
                                    double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());
                                    double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                                    mAnswer = rectangle.lengthPerimeterDiagonal(perimeter, diagonal);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleDiagonalEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                                {
                                    double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());
                                    double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                                    mAnswer = rectangle.lengthAreaDiagonal(area, diagonal);

                                    mWorking = rectangle.getWorking();
                               /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                                {
                                    rectangleWorking.setText(Html.fromHtml(mWorking, Html.FROM_HTML_MODE_LEGACY));
                                }
                                else
                                    rectangleWorking.setText(Html.fromHtml(mWorking));*/

                                    convertHtml(rectangleWorking);

                                    //rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                                {
                                    double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());
                                    double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                                    mAnswer = rectangle.lengthPerimeterArea(perimeter, area);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

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
                                        rectangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                    }
                                    else
                                    {
                                        rectangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                    }

                                    rectangleAnswer.setVisibility(View.VISIBLE);

                                    if (mCheckBoxChecker && mCheckBoxStartChecker)
                                    {
                                        rectangleWorking.setVisibility(View.VISIBLE);
                                    }

                                }

                            }

                            break;


                        case 1:

                            mRectangleSpinnerSelected = 1;

                            if (mShowAnswerChecker)
                            {
                                if (rectangleWidthEditText.getText().length() > 0)
                                {
                                    double width = Double.parseDouble(rectangleWidthEditText.getText().toString());

                                    mAnswer = rectangle.widthWidth(width);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleLengthEditText.getText().length() > 0 && rectangleDiagonalEditText.getText().length() > 0)
                                {
                                    double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                                    double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                                    mAnswer = rectangle.widthDiagonalLength (diagonal, length);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                                {
                                    double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                                    double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                                    mAnswer = rectangle.widthPerimeterLength(perimeter, length);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleAreaEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                                {
                                    double area = Double.parseDouble(rectangleAreaEditText.getText().toString());
                                    double length = Double.parseDouble(rectangleLengthEditText.getText().toString());

                                    mAnswer = rectangle.widthAreaLength(area, length);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleDiagonalEditText.getText().length() > 0 && rectanglePerimeterEditText.getText().length() > 0)
                                {
                                    double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());
                                    double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                                    mAnswer = rectangle.widthPerimeterDiagonal(perimeter, diagonal);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleDiagonalEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                                {
                                    double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());
                                    double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                                    mAnswer = rectangle.widthAreaDiagonal(area, diagonal);

                                    mWorking = rectangle.getWorking();
                                    convertHtml(rectangleWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                                {
                                    double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());
                                    double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                                    mAnswer = rectangle.widthAreaDiagonal(perimeter, area);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

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
                                        rectangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                    }
                                    else
                                    {
                                        rectangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                    }

                                    rectangleAnswer.setVisibility(View.VISIBLE);

                                    if (mCheckBoxChecker && mCheckBoxStartChecker)
                                    {
                                        rectangleWorking.setVisibility(View.VISIBLE);
                                    }

                                }

                            }

                            break;


                        case 2:

                            mRectangleSpinnerSelected = 2;

                            if (mShowAnswerChecker)
                            {

                                if (rectangleDiagonalEditText.getText().length() > 0)
                                {
                                    double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                                    mAnswer = rectangle.diagonalDiagonal(diagonal);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleLengthEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                                {
                                    double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                                    double width = Double.parseDouble(rectangleWidthEditText.getText().toString());

                                    mAnswer = rectangle.diagonalLengthWidth (length, width);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                                {
                                    double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                                    double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                                    mAnswer = rectangle.diagonalLengthPerimeter(length, perimeter);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleAreaEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                                {
                                    double area = Double.parseDouble(rectangleAreaEditText.getText().toString());
                                    double length = Double.parseDouble(rectangleLengthEditText.getText().toString());

                                    mAnswer = rectangle.diagonalLengthArea(length, area);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                                {
                                    double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                                    double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                                    mAnswer = rectangle.diagonalWidthPerimeter(width, perimeter);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleWidthEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                                {
                                    double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                                    double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                                    mAnswer = rectangle.diagonalWidthArea(width, area);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                                {
                                    double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());
                                    double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                                    mAnswer = rectangle.diagonalPerimeterArea(perimeter, area);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

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
                                        rectangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                    }
                                    else
                                    {
                                        rectangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                    }

                                    rectangleAnswer.setVisibility(View.VISIBLE);

                                    if (mCheckBoxChecker && mCheckBoxStartChecker)
                                    {
                                        rectangleWorking.setVisibility(View.VISIBLE);
                                    }

                                }

                            }

                            break;

                        case 3:

                            mRectangleSpinnerSelected = 3;

                            if (mShowAnswerChecker)
                            {
                                if (rectanglePerimeterEditText.getText().length() > 0)
                                {
                                    double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                                    mAnswer = rectangle.perimeterPerimeter(perimeter);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleLengthEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                                {
                                    double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                                    double width = Double.parseDouble(rectangleWidthEditText.getText().toString());

                                    mAnswer = rectangle.perimeterLengthWidth (length, width);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleDiagonalEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                                {
                                    double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                                    double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                                    mAnswer = rectangle.perimeterLengthDiagonal(length, diagonal);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleAreaEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                                {
                                    double area = Double.parseDouble(rectangleAreaEditText.getText().toString());
                                    double length = Double.parseDouble(rectangleLengthEditText.getText().toString());

                                    mAnswer = rectangle.perimeterLengthArea(length, area);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleDiagonalEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                                {
                                    double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                                    double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                                    mAnswer = rectangle.perimeterWidthDiagonal(width, diagonal);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleWidthEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                                {
                                    double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                                    double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                                    mAnswer = rectangle.perimeterWidthArea(width, area);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleDiagonalEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                                {
                                    double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());
                                    double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                                    mAnswer = rectangle.perimeterDiagonalArea(diagonal, area);

                                    mWorking = rectangle.getWorking();
                                    convertHtml(rectangleWorking);

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
                                        rectangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                    }
                                    else
                                    {
                                        rectangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                    }

                                    rectangleAnswer.setVisibility(View.VISIBLE);

                                    if (mCheckBoxChecker && mCheckBoxStartChecker)
                                    {
                                        rectangleWorking.setVisibility(View.VISIBLE);
                                    }

                                }

                            }

                            break;


                        case 4:

                            mRectangleSpinnerSelected = 4;

                            if (mShowAnswerChecker)
                            {

                                if (rectangleAreaEditText.getText().length() > 0)
                                {
                                    double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                                    mAnswer = rectangle.areaArea(area);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleLengthEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                                {
                                    double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                                    double width = Double.parseDouble(rectangleWidthEditText.getText().toString());

                                    mAnswer = rectangle.areaLengthWidth (length, width);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleDiagonalEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                                {
                                    double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                                    double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                                    mAnswer = rectangle.areaLengthDiagonal(length, diagonal);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                                {
                                    double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());
                                    double length = Double.parseDouble(rectangleLengthEditText.getText().toString());

                                    mAnswer = rectangle.areaLengthPerimeter(length, perimeter);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleDiagonalEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                                {
                                    double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                                    double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                                    mAnswer = rectangle.areaWidthDiagonal(width, diagonal);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectangleWidthEditText.getText().length() > 0 && rectanglePerimeterEditText.getText().length() > 0)
                                {
                                    double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                                    double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                                    mAnswer = rectangle.areaWidthPerimeter(width, perimeter);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

                                    mParameterChecker = true;
                                }
                                else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleDiagonalEditText.getText().length() > 0)
                                {
                                    double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());
                                    double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                                    mAnswer = rectangle.areaDiagonalPerimeter(diagonal, perimeter);

                                    mWorking = rectangle.getWorking();
                                    rectangleWorking.setText(mWorking);

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
                                        rectangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                    }
                                    else
                                    {
                                        rectangleAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                    }

                                    rectangleAnswer.setVisibility(View.VISIBLE);

                                    if (mCheckBoxChecker && mCheckBoxStartChecker)
                                    {
                                        rectangleWorking.setVisibility(View.VISIBLE);
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

        rectangleBackButton.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                RectangleFragment.rectangleFragment = getActivity().getSupportFragmentManager().findFragmentById (R.id.fragmentHolder);

                HomeScreenFragment fragment = new HomeScreenFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();
            }
        });

        rectangleWebViewIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                RectangleFragment.rectangleFragment = getActivity().getSupportFragmentManager().findFragmentById (R.id.fragmentHolder);

                RectangleWebViewFragment fragment = new RectangleWebViewFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();
            }
        });

        rectangleFormulaeIcon.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                RectangleFormulaeDialog dialog = new RectangleFormulaeDialog();
                dialog.show(getActivity().getSupportFragmentManager(), "123");
            }
        });


        rectangleWorking.setVisibility (View.GONE);
        rectangleAnswer.setVisibility (View.INVISIBLE);

        btnRectangleClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                rectangleLengthEditText.getText().clear();
                rectangleDiagonalEditText.getText().clear();
                rectanglePerimeterEditText.getText().clear();
                rectangleAreaEditText.getText().clear();

                rectangleWorking.setVisibility (View.GONE);
                rectangleAnswer.setVisibility (View.INVISIBLE);

                mCheckBoxStartChecker = false;
                mShowAnswerChecker = false;
            }
        });

        btnRectangleCalculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                try{
                    Rectangle rectangle = new Rectangle();

                    if (mRectangleSpinnerSelected == 0)
                    {
                        if (rectangleLengthEditText.getText().length() > 0)
                        {
                            double length = Double.parseDouble(rectangleLengthEditText.getText().toString());

                            mAnswer = rectangle.lengthLength(length);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleWidthEditText.getText().length() > 0 && rectangleDiagonalEditText.getText().length() > 0)
                        {
                            double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                            double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                            mAnswer = rectangle.lengthDiagonalWidth (diagonal, width);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                        {
                            double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                            double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                            mAnswer = rectangle.lengthPerimeterWidth(perimeter, width);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleAreaEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                        {
                            double area = Double.parseDouble(rectangleAreaEditText.getText().toString());
                            double width = Double.parseDouble(rectangleWidthEditText.getText().toString());

                            mAnswer = rectangle.lengthAreaWidth(area, width);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleDiagonalEditText.getText().length() > 0 && rectanglePerimeterEditText.getText().length() > 0)
                        {
                            double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());
                            double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                            mAnswer = rectangle.lengthPerimeterDiagonal(perimeter, diagonal);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleDiagonalEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                        {
                            double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());
                            double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                            mAnswer = rectangle.lengthAreaDiagonal(area, diagonal);

                            mWorking = rectangle.getWorking();
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                            {
                                rectangleWorking.setText(Html.fromHtml(mWorking, Html.FROM_HTML_MODE_LEGACY));
                            }
                            else
                                rectangleWorking.setText(Html.fromHtml(mWorking));

                            //rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                        {
                            double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());
                            double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                            mAnswer = rectangle.widthPerimeterArea(perimeter, area);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }

                        else
                        {
                            Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();

                            mParameterChecker = false;
                        }
                    }


                    else if (mRectangleSpinnerSelected == 1)
                    {
                        if (rectangleWidthEditText.getText().length() > 0)
                        {
                            double width = Double.parseDouble(rectangleWidthEditText.getText().toString());

                            mAnswer = rectangle.widthWidth(width);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleLengthEditText.getText().length() > 0 && rectangleDiagonalEditText.getText().length() > 0)
                        {
                            double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                            double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                            mAnswer = rectangle.widthDiagonalLength (diagonal, length);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                        {
                            double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                            double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                            mAnswer = rectangle.widthPerimeterLength(perimeter, length);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleAreaEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                        {
                            double area = Double.parseDouble(rectangleAreaEditText.getText().toString());
                            double length = Double.parseDouble(rectangleLengthEditText.getText().toString());

                            mAnswer = rectangle.widthAreaLength(area, length);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleDiagonalEditText.getText().length() > 0 && rectanglePerimeterEditText.getText().length() > 0)
                        {
                            double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());
                            double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                            mAnswer = rectangle.widthPerimeterDiagonal(perimeter, diagonal);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleDiagonalEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                        {
                            double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());
                            double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                            mAnswer = rectangle.widthAreaDiagonal(area, diagonal);

                            mWorking = rectangle.getWorking();
                            convertHtml(rectangleWorking);

                            mParameterChecker = true;
                        }
                        else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                        {
                            double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());
                            double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                            mAnswer = rectangle.widthPerimeterArea(perimeter, area);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }

                        else
                        {
                            Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();

                            mParameterChecker = false;
                        }
                    }


                    else if (mRectangleSpinnerSelected == 2)
                    {
                        if (rectangleDiagonalEditText.getText().length() > 0)
                        {
                            double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                            mAnswer = rectangle.diagonalDiagonal(diagonal);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleLengthEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                        {
                            double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                            double width = Double.parseDouble(rectangleWidthEditText.getText().toString());

                            mAnswer = rectangle.diagonalLengthWidth (length, width);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                        {
                            double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                            double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                            mAnswer = rectangle.diagonalLengthPerimeter(length, perimeter);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleAreaEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                        {
                            double area = Double.parseDouble(rectangleAreaEditText.getText().toString());
                            double length = Double.parseDouble(rectangleLengthEditText.getText().toString());

                            mAnswer = rectangle.diagonalLengthArea(length, area);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                        {
                            double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                            double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                            mAnswer = rectangle.diagonalWidthPerimeter(width, perimeter);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleWidthEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                        {
                            double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                            double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                            mAnswer = rectangle.diagonalWidthArea(width, area);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                        {
                            double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());
                            double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                            mAnswer = rectangle.diagonalPerimeterArea(perimeter, area);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }

                        else
                        {
                            Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();

                            mParameterChecker = false;
                        }
                    }

                    else if (mRectangleSpinnerSelected == 3)
                    {
                        if (rectanglePerimeterEditText.getText().length() > 0)
                        {
                            double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                            mAnswer = rectangle.perimeterPerimeter(perimeter);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleLengthEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                        {
                            double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                            double width = Double.parseDouble(rectangleWidthEditText.getText().toString());

                            mAnswer = rectangle.perimeterLengthWidth (length, width);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleDiagonalEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                        {
                            double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                            double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                            mAnswer = rectangle.perimeterLengthDiagonal(length, diagonal);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleAreaEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                        {
                            double area = Double.parseDouble(rectangleAreaEditText.getText().toString());
                            double length = Double.parseDouble(rectangleLengthEditText.getText().toString());

                            mAnswer = rectangle.perimeterLengthArea(length, area);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleDiagonalEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                        {
                            double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                            double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                            mAnswer = rectangle.perimeterWidthDiagonal(width, diagonal);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleWidthEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                        {
                            double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                            double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                            mAnswer = rectangle.perimeterWidthArea(width, area);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleDiagonalEditText.getText().length() > 0 && rectangleAreaEditText.getText().length() > 0)
                        {
                            double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());
                            double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                            mAnswer = rectangle.perimeterDiagonalArea(diagonal, area);

                            mWorking = rectangle.getWorking();
                            convertHtml(rectangleWorking);

                            mParameterChecker = true;
                        }

                        else
                        {
                            Toast.makeText (getActivity(), "" + getResources().getString (R.string.not_enough_parameters), Toast.LENGTH_SHORT).show();
                            mParameterChecker = false;
                        }
                    }

                    else if (mRectangleSpinnerSelected == 4)
                    {

                        if (rectangleAreaEditText.getText().length() > 0)
                        {
                            double area = Double.parseDouble(rectangleAreaEditText.getText().toString());

                            mAnswer = rectangle.areaArea(area);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleLengthEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                        {
                            double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                            double width = Double.parseDouble(rectangleWidthEditText.getText().toString());

                            mAnswer = rectangle.areaLengthWidth (length, width);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleDiagonalEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                        {
                            double length = Double.parseDouble(rectangleLengthEditText.getText().toString());
                            double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                            mAnswer = rectangle.areaLengthDiagonal(length, diagonal);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleLengthEditText.getText().length() > 0)
                        {
                            double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());
                            double length = Double.parseDouble(rectangleLengthEditText.getText().toString());

                            mAnswer = rectangle.areaLengthPerimeter(length, perimeter);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleDiagonalEditText.getText().length() > 0 && rectangleWidthEditText.getText().length() > 0)
                        {
                            double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                            double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                            mAnswer = rectangle.areaWidthDiagonal(width, diagonal);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectangleWidthEditText.getText().length() > 0 && rectanglePerimeterEditText.getText().length() > 0)
                        {
                            double width = Double.parseDouble(rectangleWidthEditText.getText().toString());
                            double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());

                            mAnswer = rectangle.areaWidthPerimeter(width, perimeter);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                        else if (rectanglePerimeterEditText.getText().length() > 0 && rectangleDiagonalEditText.getText().length() > 0)
                        {
                            double perimeter = Double.parseDouble(rectanglePerimeterEditText.getText().toString());
                            double diagonal = Double.parseDouble(rectangleDiagonalEditText.getText().toString());

                            mAnswer = rectangle.areaDiagonalPerimeter(diagonal, perimeter);

                            mWorking = rectangle.getWorking();
                            rectangleWorking.setText(mWorking);

                            mParameterChecker = true;
                        }
                    }

                    if (mParameterChecker)
                    {
                        mCheckBoxStartChecker = true;
                        mShowAnswerChecker = true;

                        BigDecimal bigDecimal = null;

                      try
                      {
                          bigDecimal = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);
                      }
                      catch (Exception e)
                      {
                          Toast.makeText(getActivity(),"INVALID RESULT",Toast.LENGTH_SHORT).show();
                          rectangleAnswer.setText(getResources().getText(R.string.nan));
                          rectangleWorking.setVisibility(View.VISIBLE);
                      }

                        mAnswerLong = Math.round(mAnswer);

                        if (mDecimalPoints == 0)
                        {
                            rectangleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + mAnswerLong);
                        }
                        else
                        {
                            rectangleAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + bigDecimal.doubleValue());
                        }

                        rectangleAnswer.setVisibility (View.VISIBLE);

                        if (mCheckBoxChecker && mCheckBoxStartChecker)
                        {
                            rectangleWorking.setVisibility(View.VISIBLE);
                        }

                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getActivity(),"INVALID RESULT",Toast.LENGTH_SHORT).show();
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
