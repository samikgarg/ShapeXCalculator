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

public class SquareFragment extends Fragment
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

    public static Fragment squareFragment;


    @Override
    public View onCreateView (LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_square, container, false);


        final EditText squareSideLengthEditText = (EditText) v.findViewById (R.id.squareSideLengthEditText);
        final EditText squareDiagonalEditText = (EditText) v.findViewById (R.id.squareDiagonalEditText);
        final EditText squarePerimeterEditText = (EditText) v.findViewById (R.id.squarePerimeterEditText);
        final EditText squareAreaEditText = (EditText) v.findViewById (R.id.squareAreaEditText);

        final TextView squareWorking = (TextView) v.findViewById (R.id.squareWorking);
        final TextView squareAnswer = (TextView) v.findViewById (R.id.squareAnswer);

        final ImageView squareBackButton = (ImageView) v.findViewById (R.id.squareBackButton);
        final ImageView squareWebViewIcon = (ImageView) v.findViewById (R.id.squareWebViewIcon);
        final ImageView squareFormulaeIcon = (ImageView) v.findViewById (R.id.squareFormulaeIcon);

        final Button btnSquareCalculate = (Button) v.findViewById (R.id.btnSquareCalculate);
        final Button btnSquareClear = (Button) v.findViewById (R.id.btnSquareClear);

        final Spinner squareSpinner = (Spinner) v.findViewById (R.id.squareSpinner);

        final SeekBar squareSeekBar = (SeekBar) v.findViewById (R.id.squareSeekBar);
        final TextView squareSeekBarValue = v.findViewById (R.id.squareSeekBarValue);

        final CheckBox cbSquareWorking = (CheckBox) v.findViewById (R.id.cbSquareWorking);

        mCheckBoxChecker = false;
        mCheckBoxStartChecker = false;


        squareSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean fromUser)
            {
                squareSeekBarValue.setText ("" + value);
                mDecimalPoints = value;

                BigDecimal bigDecimal = new BigDecimal (mAnswer).setScale (mDecimalPoints, RoundingMode.HALF_EVEN);

                mAnswerLong = Math.round(mAnswer);

                if (mDecimalPoints == 0)
                {
                    squareAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + mAnswerLong);
                }
                else
                {
                    squareAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + bigDecimal.doubleValue());
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

        squareSeekBarValue.setText ("" + mDecimalPoints);


        cbSquareWorking.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (cbSquareWorking.isChecked())
                {
                    mCheckBoxChecker = true;

                    if (mCheckBoxStartChecker)
                    {
                        squareWorking.setVisibility (View.VISIBLE);
                    }
                }
                else
                {
                    mCheckBoxChecker = false;
                }

                if (!cbSquareWorking.isChecked())
                {
                    squareWorking.setVisibility (View.GONE);
                }
            }
        });


        squareSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Square square = new Square();

                switch (position) {
                    case 0:

                        mSquareSpinnerSelected = 0;

                        if (mShowAnswerChecker)
                        {

                            if (squareSideLengthEditText.getText().length() > 0)
                            {
                                double squareSideLength = Double.parseDouble(squareSideLengthEditText.getText().toString());

                                mAnswer = square.sideLengthSideLength(squareSideLength);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (squarePerimeterEditText.getText().length() > 0)
                            {
                                double squarePerimeter = Double.parseDouble(squarePerimeterEditText.getText().toString());

                                mAnswer = square.sideLengthPerimeter(squarePerimeter);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (squareAreaEditText.getText().length() > 0)
                            {
                                double squareArea = Double.parseDouble(squareAreaEditText.getText().toString());

                                mAnswer = square.sideLengthArea(squareArea);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (squareDiagonalEditText.getText().length() > 0)
                            {
                                double squareDiagonal = Double.parseDouble(squareDiagonalEditText.getText().toString());

                                mAnswer = square.sideLengthDiagonal(squareDiagonal);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }

                            if (mParameterChecker)
                            {
                                mCheckBoxStartChecker = true;

                                BigDecimal bigDecimal = new BigDecimal(mAnswer).setScale(mDecimalPoints, RoundingMode.HALF_EVEN);
                                mAnswerLong = Math.round(mAnswer);

                                if (mDecimalPoints == 0)
                                {
                                    squareAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                }
                                else
                                    {
                                    squareAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                }

                                squareAnswer.setVisibility(View.VISIBLE);

                                if (mCheckBoxChecker && mCheckBoxStartChecker)
                                {
                                    squareWorking.setVisibility(View.VISIBLE);
                                }

                            }

                        }

                        break;


                    case 1:

                        mSquareSpinnerSelected = 1;

                        if (mShowAnswerChecker)
                        {

                            if (squareDiagonalEditText.getText().length() > 0)
                            {
                                double squareDiagonal = Double.parseDouble(squareDiagonalEditText.getText().toString());

                                mAnswer = square.diagonalDiagonal(squareDiagonal);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (squareSideLengthEditText.getText().length() > 0)
                            {
                                double squareSideLength = Double.parseDouble(squareSideLengthEditText.getText().toString());

                                mAnswer = square.diagonalSideLength(squareSideLength);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (squarePerimeterEditText.getText().length() > 0)
                            {
                                double squarePerimeter = Double.parseDouble(squarePerimeterEditText.getText().toString());

                                mAnswer = square.diagonalPerimeter(squarePerimeter);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (squareAreaEditText.getText().length() > 0)
                            {
                                double squareArea = Double.parseDouble(squareAreaEditText.getText().toString());

                                mAnswer = square.diagonalArea(squareArea);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;

                            }

                            if (mParameterChecker)
                            {
                                mCheckBoxStartChecker = true;

                                BigDecimal bigDecimal = new BigDecimal(mAnswer).setScale(mDecimalPoints, RoundingMode.HALF_EVEN);
                                mAnswerLong = Math.round(mAnswer);

                                if (mDecimalPoints == 0)
                                {
                                    squareAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                }
                                else
                                {
                                    squareAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                }

                                squareAnswer.setVisibility(View.VISIBLE);

                                if (mCheckBoxChecker && mCheckBoxStartChecker)
                                {
                                    squareWorking.setVisibility(View.VISIBLE);
                                }

                            }

                        }

                        break;


                    case 2:

                        mSquareSpinnerSelected = 2;

                        if (mShowAnswerChecker)
                        {

                            if (squarePerimeterEditText.getText().length() > 0)
                            {
                                double squarePerimeter = Double.parseDouble(squarePerimeterEditText.getText().toString());

                                mAnswer = square.perimeterPerimeter(squarePerimeter);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (squareSideLengthEditText.getText().length() > 0)
                            {
                                double squareSideLength = Double.parseDouble(squareSideLengthEditText.getText().toString());

                                mAnswer = square.perimeterSideLength(squareSideLength);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (squareAreaEditText.getText().length() > 0)
                            {
                                double squareArea = Double.parseDouble(squareAreaEditText.getText().toString());

                                mAnswer = square.perimeterArea(squareArea);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (squareDiagonalEditText.getText().length() > 0)
                            {
                                double squareDiagonal = Double.parseDouble(squareDiagonalEditText.getText().toString());

                                mAnswer = square.perimeterDiagonal(squareDiagonal);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }

                            if (mParameterChecker)
                            {
                                mCheckBoxStartChecker = true;

                                BigDecimal bigDecimal = new BigDecimal(mAnswer).setScale(mDecimalPoints, RoundingMode.HALF_EVEN);
                                mAnswerLong = Math.round(mAnswer);

                                if (mDecimalPoints == 0)
                                {
                                    squareAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                }
                                else
                                {
                                    squareAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                }

                                squareAnswer.setVisibility(View.VISIBLE);

                                if (mCheckBoxChecker && mCheckBoxStartChecker)
                                {
                                    squareWorking.setVisibility(View.VISIBLE);
                                }

                            }

                        }

                        break;

                    case 3:

                        mSquareSpinnerSelected = 3;

                        if (mShowAnswerChecker)
                        {

                            if (squareAreaEditText.getText().length() > 0)
                            {
                                double squareArea = Double.parseDouble(squareAreaEditText.getText().toString());

                                mAnswer = square.areaArea(squareArea);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (squareSideLengthEditText.getText().length() > 0)
                            {
                                double squareSideLength = Double.parseDouble(squareSideLengthEditText.getText().toString());

                                mAnswer = square.areaSideLength(squareSideLength);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (squarePerimeterEditText.getText().length() > 0)
                            {
                                double squarePerimeter = Double.parseDouble(squarePerimeterEditText.getText().toString());

                                mAnswer = square.areaPerimeter(squarePerimeter);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }
                            else if (squareDiagonalEditText.getText().length() > 0)
                            {
                                double squareDiagonal = Double.parseDouble(squareDiagonalEditText.getText().toString());

                                mAnswer = square.areaDiagonal(squareDiagonal);

                                mWorking = square.getWorking();
                                squareWorking.setText(mWorking);

                                mParameterChecker = true;
                            }

                            if (mParameterChecker)
                            {
                                mCheckBoxStartChecker = true;

                                BigDecimal bigDecimal = new BigDecimal(mAnswer).setScale(mDecimalPoints, RoundingMode.HALF_EVEN);
                                mAnswerLong = Math.round(mAnswer);

                                if (mDecimalPoints == 0)
                                {
                                    squareAnswer.setText("" + getResources().getString(R.string.answer_) + " " + mAnswerLong);
                                }
                                else
                                {
                                    squareAnswer.setText("" + getResources().getString(R.string.answer_) + " " + bigDecimal.doubleValue());
                                }

                                squareAnswer.setVisibility(View.VISIBLE);

                                if (mCheckBoxChecker && mCheckBoxStartChecker)
                                {
                                    squareWorking.setVisibility(View.VISIBLE);
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

        squareBackButton.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SquareFragment.squareFragment = getActivity().getSupportFragmentManager().findFragmentById (R.id.fragmentHolder);

                HomeScreenFragment fragment = new HomeScreenFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();
            }
        });

        squareWebViewIcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SquareFragment.squareFragment = getActivity().getSupportFragmentManager().findFragmentById (R.id.fragmentHolder);

                SquareWebViewFragment fragment = new SquareWebViewFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                transaction.replace (R.id.fragmentHolder, fragment);
                transaction.commit();
            }
        });

        squareFormulaeIcon.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SquareFormulaeDialog dialog = new SquareFormulaeDialog();
                dialog.show(getActivity().getSupportFragmentManager(), "123");
            }
        });


        squareWorking.setVisibility (View.GONE);
        squareAnswer.setVisibility (View.INVISIBLE);

        btnSquareClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                squareSideLengthEditText.getText().clear();
                squareDiagonalEditText.getText().clear();
                squarePerimeterEditText.getText().clear();
                squareAreaEditText.getText().clear();

                squareWorking.setVisibility (View.GONE);
                squareAnswer.setVisibility (View.INVISIBLE);

                mCheckBoxStartChecker = false;
                mShowAnswerChecker = false;
            }
        });


        btnSquareCalculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Square square = new Square();

                if (mSquareSpinnerSelected == 0)
                {
                    if (squareSideLengthEditText.getText().length() > 0)
                    {
                        double squareSideLength = Double.parseDouble (squareSideLengthEditText.getText().toString());

                        mAnswer = square.sideLengthSideLength (squareSideLength);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

                        mParameterChecker = true;
                    }

                    else if (squarePerimeterEditText.getText().length() > 0)
                    {
                        double squarePerimeter = Double.parseDouble (squarePerimeterEditText.getText().toString());

                        mAnswer = square.sideLengthPerimeter (squarePerimeter);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

                        mParameterChecker = true;
                    }

                    else if (squareAreaEditText.getText().length() > 0)
                    {
                        double squareArea = Double.parseDouble (squareAreaEditText.getText().toString());

                        mAnswer = square.sideLengthArea (squareArea);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

                        mParameterChecker = true;
                    }

                    else if (squareDiagonalEditText.getText().length() > 0)
                    {
                        double squareDiagonal = Double.parseDouble (squareDiagonalEditText.getText().toString());

                        mAnswer = square.sideLengthDiagonal (squareDiagonal);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

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
                    if (squareDiagonalEditText.getText().length() > 0)
                    {
                        double squareDiagonal = Double.parseDouble (squareDiagonalEditText.getText().toString());

                        mAnswer = square.diagonalDiagonal (squareDiagonal);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

                        mParameterChecker = true;
                    }

                    else if (squareSideLengthEditText.getText().length() > 0)
                    {
                        double squareSideLength = Double.parseDouble (squareSideLengthEditText.getText().toString());

                        mAnswer = square.diagonalSideLength (squareSideLength);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

                        mParameterChecker = true;
                    }

                    else if (squarePerimeterEditText.getText().length() > 0)
                    {
                        double squarePerimeter = Double.parseDouble (squarePerimeterEditText.getText().toString());

                        mAnswer = square.diagonalPerimeter (squarePerimeter);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

                        mParameterChecker = true;
                    }

                    else if (squareAreaEditText.getText().length() > 0)
                    {
                        double squareArea = Double.parseDouble (squareAreaEditText.getText().toString());

                        mAnswer = square.diagonalArea (squareArea);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

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
                    if (squarePerimeterEditText.getText().length() > 0)
                    {
                        double squarePerimeter = Double.parseDouble (squarePerimeterEditText.getText().toString());

                        mAnswer = square.perimeterPerimeter (squarePerimeter);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

                        mParameterChecker = true;
                    }

                    else if (squareSideLengthEditText.getText().length() > 0)
                    {
                        double squareSideLength = Double.parseDouble (squareSideLengthEditText.getText().toString());

                        mAnswer = square.perimeterSideLength (squareSideLength);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

                        mParameterChecker = true;
                    }

                    else if (squareAreaEditText.getText().length() > 0)
                    {
                        double squareArea = Double.parseDouble (squareAreaEditText.getText().toString());

                        mAnswer = square.perimeterArea (squareArea);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

                        mParameterChecker = true;
                    }

                    else if (squareDiagonalEditText.getText().length() > 0)
                    {
                        double squareDiagonal = Double.parseDouble (squareDiagonalEditText.getText().toString());

                        mAnswer = square.perimeterDiagonal (squareDiagonal);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

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
                    if (squareAreaEditText.getText().length() > 0)
                    {
                        double squareArea = Double.parseDouble (squareAreaEditText.getText().toString());

                        mAnswer = square.areaArea (squareArea);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

                        mParameterChecker = true;
                    }

                    else if (squareSideLengthEditText.getText().length() > 0)
                    {
                        double squareSideLength = Double.parseDouble(squareSideLengthEditText.getText().toString());

                        mAnswer = square.areaSideLength(squareSideLength);

                        mWorking = square.getWorking();
                        squareWorking.setText(mWorking);

                        mParameterChecker = true;
                    }

                    else if (squarePerimeterEditText.getText().length() > 0)
                    {
                        double squarePerimeter = Double.parseDouble (squarePerimeterEditText.getText().toString());

                        mAnswer = square.areaPerimeter (squarePerimeter);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

                        mParameterChecker = true;
                    }

                    else if (squareDiagonalEditText.getText().length() > 0)
                    {
                        double squareDiagonal = Double.parseDouble (squareDiagonalEditText.getText().toString());

                        mAnswer = square.areaDiagonal (squareDiagonal);

                        mWorking = square.getWorking();
                        squareWorking.setText (mWorking);

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
                        squareAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + mAnswerLong);
                    }
                    else
                    {
                        squareAnswer.setText ("" + getResources().getString (R.string.answer_) + " " + bigDecimal.doubleValue());
                    }

                    squareAnswer.setVisibility (View.VISIBLE);

                    if (mCheckBoxChecker && mCheckBoxStartChecker)
                    {
                        squareWorking.setVisibility(View.VISIBLE);
                    }

                }
        }

        });


        return v;
    }

}
