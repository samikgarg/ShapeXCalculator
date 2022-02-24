package com.samazebra.mathematicalgeometrycalculator;

import android.util.Log;

public class Rectangle
{
    private double mLength;
    private double mWidth;
    private double mDiagonal;
    private double mPerimeter;
    private double mArea;

    private String mWorking;


    public String getWorking()
    {
        return mWorking;
    }


    public double lengthLength (double length)
{
    mLength = length;

    mWorking =
            "Length =" + " " + mLength;

    return mLength;
}

    public double lengthDiagonalWidth (double diagonal, double width)
    {
        mDiagonal = diagonal;
        mWidth = width;
        double working1 = mDiagonal * mDiagonal;
        double working2 = mWidth * mWidth;
        double working3 = working1 - working2;
        mLength = Math.sqrt(working3);

        mWorking =
                "l = √(d² - w²)" + "\n"
                        + "l = √(" + mDiagonal + "²" + " " + "-" + " " + mWidth + "²)" + "\n"
                        + "l = √(" + working1 + " " + "-" + " " + working2 + ")" + "\n"
                        + "l = √" + working3 + "\n"
                        + "l =" + " " + mLength;

        return mLength;
    }

    public double lengthPerimeterWidth (double perimeter, double width)
    {
        mPerimeter = perimeter;
        mWidth = width;
        double working1 = mWidth * 2;
        double working2 = mPerimeter - working1;
        mLength =  working2 / 2;

        mWorking =
                "l = (P - 2 × w) / 2" + "\n"
                        + "l = (" + mPerimeter + " " + "-" + " " + "2" + " " + "×" + " " + mWidth + ")" + " " + "/ 2" + "\n"
                        + "l = (" + mPerimeter + " " + "-" + " " + working1 + ")" + " " + "/ 2" + "\n"
                        + "l =" + " " + working2 + " " + "/ 2" + "\n"
                        + "l =" + " " + mLength;

        return mLength;
    }

    public double lengthAreaWidth (double area, double width)
    {
        mArea = area;
        mWidth = width;

        mLength = mArea / mWidth;

        mWorking =
                "l = A / w" + "\n"
                        + "l =" + " " + mArea + " " + "/" + " " + mWidth + "\n"
                        + "l = " + " " + mLength;

        return mLength;
    }

    public double lengthPerimeterDiagonal (double perimeter, double diagonal)
    {
        mPerimeter = perimeter;
        mDiagonal = diagonal;
        double working1 = mPerimeter / 4;
        double working2 = 0.25;
        double working3 = mDiagonal * mDiagonal;
        double working4 = mPerimeter * mPerimeter;
        double working5 = 8 * working3;
        double working6 = working5 - working4;
        double working7 = Math.sqrt (working6);
        double working8 = working2 * working7;
        mLength = working1 + working8;

        Log.i ("", "" + working2);
        Log.i ("", "" + 1 / 4);

        mWorking =
                "l = (P / 4) + (1 / 4) × √(8 × d² - P²)" + "\n"
                        + "l = (" + mPerimeter + " / 4) + (1 / 4) × √(8 × " + mDiagonal + "² - " + mPerimeter + "²)" + "\n"
                        + "l =" + " " + working1 + " " + "+" + " " + working2 + " " +  "×" + " " + "√(8 ×" + " " + working3 + " " + "-" + " " + working4 + ")" + "\n"
                        + "l =" + " " + working1 + " " + "+" + " " + working2 + " " +  "×" + " " + "√(" + working5 + " " + "-" + " " + working4 + ")" + "\n"
                        + "l =" + " " + working1 + " " + "+" + " " + working2 + " " +  "×" + " " + "√" + working6 + "\n"
                        + "l =" + " " + working1 + " " + "+" + " " + working2 + " " +  "×" + " " + working7 + "\n"
                        + "l =" + " " + working1 + " " + "+" + " " + working8 + "\n"
                        + "l = " + " " + mLength;

        return mLength;
    }

    public double lengthAreaDiagonal (double area, double diagonal)
    {
        mArea = area;
        mDiagonal = diagonal;
        double working1 = mDiagonal * mDiagonal * mDiagonal * mDiagonal;
        double working2 = mArea * mArea;
        double working3 = 4 * working2;
        double working4 = working1 - working3;
        double working5 = mDiagonal * mDiagonal;
        double working6 = Math.sqrt (working4);
        double working7 = working5 - working6;
        double working8 = Math.sqrt (2);
        double working10 = working8 * working5;
        double working16 = Math.sqrt(working7);
        double working11 = working10 * working16;
        double working12 = working8 * working6;
        double working13 = working12 * working16;
        double working14 = working11 + working13;
        double working15 = 4 * mArea;
        mLength = working14 / working15;

       mWorking =
               "l = {√2 × d² × √[d² - √(d<sup><small>4</small></sup> - 4 × A²)] + √2 × √(d<sup><small>4</small></sup> - 4 × A²) × √[d² - √(d<sup><small>4</small></sup> - 4 × A²)]} / (4 × A)" + "<br>"
                        + "l = {√2 × " + mDiagonal + "² × √[" + mDiagonal + "² - √(" + mDiagonal + "<sup><small>4</small></sup> - 4 × " + mArea + "²)] + √2 × √(" + mDiagonal + "<sup><small>4</small></sup> - 4 × " + mArea + "²) × √[" + mDiagonal + "² - √(" + mDiagonal + "<sup><small>4</small></sup> - 4 × " + mArea + "²)]} / (4 × " + mArea + ")" + "<br>"
                        + "l = {√2 × " + mDiagonal + "² × √[" + mDiagonal + "² - √(" + working1 + " " + "- 4 ×" + " " + working2 + ")] + √2 × √(" + working1 + " " + "- 4 ×" + " " + working2 + ") × √[" + mDiagonal + "² - √(" + working1 + " " + "- 4 ×" + " " + working2 + ")]} /" + " " + working15 + "<br>"
                        + "l = {√2 × " + mDiagonal + "² × √[" + mDiagonal + "² - √(" + working1 + " " + "-" + " " + working3 + ")] + √2 × √(" + working1 + " " + "-" + " " + working3 + ") × √[" + mDiagonal + "² - √(" + working1 + " " + "-" + " " + working3 + ")]} /" + " " + working15 + "<br>"
                        + "l = {√2 × " + mDiagonal + "² × √[" + mDiagonal + "² - √" + working4 + "] + √2 × √" + working4 + " " + "× √[d² - √" + working4 + "]} /" + " " + working15 + "<br>"
                        + "l = {√2 × " + mDiagonal + "² × √[" + working5 + " " + "-" + " " + working6 + "] + √2 ×" + " " + working6 + " " + "× √[" + working5 + " " + "-" + " " + working6 + "]} /" + " " + working15 + "<br>"
                        + "l = {√2 × " + mDiagonal + "² × √" + working7 + " " + "+" + " " + "√2 ×" + " " + working6 + " " + "× √" + working7 + "} /" + " " + working15 + "<br>"
                        + "l = {" + working8 + " " + "×" + " " + working5 + " " + "×" + " " + working16 + " " + "+" + " " + working8 + " " + "×" + " " + working6 + " " + "×" + " " + working16 + "} /" + " " + working15 + "<br>"
                        + "l = {" + working10 + " " + "×" + " " + working16 + " " + "+" + " " + working12 + " " + "×" + " " + working16 + "} /" + " " + working15 + "<br>"
                        + "l = {" + working11 + " " + "+" + " " + working13 + "} /" + " " + working15 + "<br>"
                        + "l =" + " " + working14 + " " + "/" + " " + working15 + "<br>"
                        + "l = " + " " + mLength;

      // <p style="font-size:30px">This is a paragraph.</p>


        return mLength;
    }

    public double lengthPerimeterArea (double perimeter, double area)
    {
        mPerimeter = perimeter;
        mArea = area;
        double working1 = mPerimeter * mPerimeter;
        double working2 = mPerimeter / 2;
        double working3 = working1 / 4;
        double working4 = 4 * mArea;
        double working5 = working3 - working4;
        double working6 = Math.sqrt(working5);
        double working7 = working2 + working6;
        mLength = working7 / 2;

        mWorking =
                "l = [(P / 2) + √(P² / 4 - 4 × A)] / 2" + "\n"
                        + "l = [(" + mPerimeter + " / 2) + √(" + mPerimeter + "² / 4 - 4 × " + mArea + ")] / 2" + "\n"
                        + "l = [(" + mPerimeter + " / 2) + √(" + working1 + " / 4 - 4 × " + mArea + ")] / 2" + "\n"
                        + "l = [" + working2 + " + √(" + working3 + " - " + working4 + ")] / 2" + "\n"
                        + "l = [" + working2 + " + √" + working5 + "] / 2" + "\n"
                        + "l = [" + working2 + " + " + working6 + "] / 2" + "\n"
                        + "l = " + working7 + " / 2" + "\n"
                        + "l = " + mLength;

        return mLength;
    }


    public double widthWidth (double width)
    {
        mWidth = width;

        mWorking =
                "Width =" + " " + mWidth;

        return mLength;
    }

    public double widthDiagonalLength (double diagonal, double length)
    {
        mDiagonal = diagonal;
        mLength = length;
        double working1 = mDiagonal * mDiagonal;
        double working2 = mLength * mLength;
        double working3 = working1 - working2;
        mWidth = Math.sqrt(working3);

        mWorking =
                "w = √(d² - l²)" + "\n"
                        + "w = √(" + mDiagonal + "²" + " " + "-" + " " + mLength + "²)" + "\n"
                        + "w = √(" + working1 + " " + "-" + " " + working2 + ")" + "\n"
                        + "w = √" + working3 + "\n"
                        + "w =" + " " + mWidth;

        return mWidth;
    }

    public double widthPerimeterLength (double perimeter, double length)
    {
        mPerimeter = perimeter;
        mLength = length;
        double working1 = mLength * 2;
        double working2 = mPerimeter - working1;
        mLength = working2 / 2;

        mWorking =
                "w = (P - 2 × l) / 2" + "\n"
                        + "w = (" + mPerimeter + " " + "-" + " " + "2" + " " + "×" + " " + mLength + ")" + " " + "/ 2" + "\n"
                        + "w = (" + mPerimeter + " " + "-" + " " + working1 + ")" + " " + "/ 2" + "\n"
                        + "w =" + " " + working2 + " " + "/ 2" + "\n"
                        + "w =" + " " + mWidth;

        return mWidth;
    }

    public double widthAreaLength (double area, double length)
    {
        mArea = area;
        mLength = length;

        mWidth = mArea / mLength;

        mWorking =
                "w = A / l" + "\n"
                        + "w =" + " " + mArea + " " + "/" + " " + mLength + "\n"
                        + "w = " + " " + mWidth;

        return mWidth;
    }

    public double widthPerimeterDiagonal (double perimeter, double diagonal)
    {
        mPerimeter = perimeter;
        mDiagonal = diagonal;
        double working1 = mPerimeter / 4;
        double working2 = 0.25;
        double working3 = mDiagonal * mDiagonal;
        double working4 = mPerimeter * mPerimeter;
        double working5 = 8 * working3;
        double working6 = working5 - working4;
        double working7 = Math.sqrt (working6);
        double working8 = working2 * working7;
        mLength = working1 - working8;

        mWorking =
                "l = (P / 4) - (1 / 4) × √(8 × d² - P²)" + "\n"
                        + "l = (" + mPerimeter + " / 4) - (1 / 4) × √(8 × " + mDiagonal + "² - " + mPerimeter + "²)" + "\n"
                        + "l =" + " " + working1 + " " + "-" + " " + working2 + " " +  "×" + " " + "√(8 ×" + " " + working3 + " " + "-" + " " + working4 + ")" + "\n"
                        + "l =" + " " + working1 + " " + "-" + " " + working2 + " " +  "×" + " " + "√(" + working5 + " " + "-" + " " + working4 + ")" + "\n"
                        + "l =" + " " + working1 + " " + "-" + " " + working2 + " " +  "×" + " " + "√" + working6 + "\n"
                        + "l =" + " " + working1 + " " + "-" + " " + working2 + " " +  "×" + " " + working7 + "\n"
                        + "l =" + " " + working1 + " " + "-" + " " + working8 + "\n"
                        + "l = " + " " + mLength;

        return mWidth;
    }

    public double widthAreaDiagonal (double area, double diagonal)
    {
        mArea = area;
        mDiagonal = diagonal;
        double working1 = mDiagonal * mDiagonal * mDiagonal * mDiagonal;
        double working2 = mArea * mArea;
        double working3 = 4 * working2;
        double working4 = working1 - working3;
        double working17 = working1 + working3;
        double working5 = mDiagonal * mDiagonal;
        double working6 = Math.sqrt (working4);
        double working18 = Math.sqrt (working17);
        double working7 = working5 + working18;
        double working8 = Math.sqrt (2);
        double working10 = working8 * working5;
        double working16 = Math.sqrt(working7);
        double working11 = working10 * working16;
        double working12 = working8 * working6;
        double working13 = working12 * working16;
        double working14 = working11 - working13;
        double working15 = 4 * mArea;
        mWidth = working14 / working15;

        mWorking =
                "w = {√2 × d² × √[d² + √(d<sup><small>4</small></sup> + 4 × A²)] - √2 × √(d<sup><small>4</small></sup> - 4 × A²) × √[d² + √(d<sup><small>4</small></sup> + 4 × A²)]} / (4 × A)" + "<br>"
                        + "w = {√2 × " + mDiagonal + "² × √[" + mDiagonal + "² + √(" + mDiagonal + "<sup><small>4</small></sup> + 4 × " + mArea + "²)] - √2 × √(" + mDiagonal + "<sup><small>4</small></sup> - 4 × " + mArea + "²) × √[" + mDiagonal + "² + √(d<sup><small>4</small></sup> + 4 × " + mArea + "²)]} / (4 × " + mArea + ")" + "<br>"
                        + "w = {√2 × " + mDiagonal + "² × √[" + mDiagonal + "² + √(" + working1 + " " + "+ 4 ×" + " " + working2 + ")] - √2 × √(" + working1 + " " + "- 4 ×" + " " + working2 + ") × √[" + mDiagonal + "² + √(" + working1 + " " + "+ 4 ×" + " " + working2 + ")]} /" + " " + working15 + "<br>"
                        + "w = {√2 × " + mDiagonal + "² × √[" + mDiagonal + "² + √(" + working1 + " " + "+" + " " + working3 + ")] - √2 × √(" + working1 + " " + "-" + " " + working3 + ") × √[d² + √(" + working1 + " " + "+" + " " + working3 + ")]} /" + " " + working15 + "<br>"
                        + "w = {√2 × " + mDiagonal + "² × √[" + mDiagonal + "² + √" + working17 + "] - √2 × √" + working4 + " " + "× √[\" + mDiagonal + \"² + √" + working17 + "]} /" + " " + working15 + "<br>"
                        + "w = {√2 × " + mDiagonal + "² × √[" + working5 + " " + "+" + " " + working18 + "] - √2 ×" + " " + working6 + " " + "× √[" + working5 + " " + "+" + " " + working6 + "]} /" + " " + working15 + "<br>"
                        + "w = {√2 × " + mDiagonal + "² × √" + working7 + " " + "-" + " " + "√2 ×" + " " + working6 + " " + "× √" + working7 + "} /" + " " + working15 + "<br>"
                        + "w = {" + working8 + " " + "×" + " " + working5 + " " + "×" + " " + working16 + " " + "-" + " " + working8 + " " + "×" + " " + working6 + " " + "×" + " " + working16 + "} /" + " " + working15 + "<br>"
                        + "w = {" + working10 + " " + "×" + " " + working16 + " " + "-" + " " + working12 + " " + "×" + " " + working16 + "} /" + " " + working15 + "<br>"
                        + "w = {" + working11 + " " + "-" + " " + working13 + "} /" + " " + working15 + "<br>"
                        + "w =" + " " + working14 + " " + "/" + " " + working15 + "<br>"
                        + "w = " + " " + mLength;

        return mWidth;
    }

    public double widthPerimeterArea (double perimeter, double area)
    {
        mPerimeter = perimeter;
        mArea = area;
        double working1 = mPerimeter * mPerimeter;
        double working2 = mPerimeter / 2;
        double working3 = working1 / 4;
        double working4 = 4 * mArea;
        double working5 = working3 - working4;
        double working6 = Math.sqrt(working5);
        double working7 = working2 - working6;
        mWidth = working7 / 2;

        mWorking =
                "l = [(P / 2) - √(P² / 4 - 4 × A)] / 2" + "\n"
                        + "l = [(" + mPerimeter + " / 2) - √(" + mPerimeter + "² / 4 - 4 × " + mArea + ")] / 2" + "\n"
                        + "l = [(" + mPerimeter + " / 2) - √(" + working1 + " / 4 - 4 × " + mArea + ")] / 2" + "\n"
                        + "l = [" + working2 + " - √(" + working3 + " - " + working4 + ")] / 2" + "\n"
                        + "l = [" + working2 + " - √" + working5 + "] / 2" + "\n"
                        + "l = [" + working2 + " - " + working6 + "] / 2" + "\n"
                        + "l = " + working7 + " / 2" + "\n"
                        + "l = " + mWidth;

        return mWidth;
    }


    public double diagonalDiagonal (double diagonal)
    {
        mDiagonal = diagonal;

        mWorking =
                "Diagonal =" + " " + mDiagonal;

        return mDiagonal;
    }

    public double diagonalLengthWidth (double length, double width)
    {
        mLength = length;
        mWidth = width;
        double working1 = mLength * mLength;
        double working2 = mWidth * mWidth;
        double working3 = working1 + working2;
        mDiagonal = Math.sqrt (working3);

        mWorking =
                "d = √(l² + w²)" + "\n"
                        + "d = √(" + mLength + "² + " + mWidth + "²)" + "\n"
                        + "d = √(" + working1 + " + " + working2 + ")" + "\n"
                        + "d = √" + working3 + "\n"
                        + "l = " + mWidth;

        return mDiagonal;
    }

    public double diagonalLengthPerimeter (double length, double perimeter)
    {
        mLength = length;
        mPerimeter = perimeter;
        double working1 = mPerimeter / 2;
        double working2 = working1 - mLength;
        double working3 = working2 * working2;
        double working4 = mLength * mLength;
        double working5 = working3 + working4;
        mDiagonal = Math.sqrt (working5);

        mWorking =
                "d = √[l² + (P / 2 - l)²]" + "\n"
                        + "d = √[" + mLength + "² + (" + mPerimeter + " / 2 - " + mLength + ")²]" + "\n"
                        + "d = √[" + mLength + "² + (" + working1 + " - " + mLength + ")²]" + "\n"
                        + "d = √[" + mLength + "² + " + working2 + "²]" + "\n"
                        + "d = √[" + working4 + " + " + working3 + "]" + "\n"
                        + "d = √" + working5 + "\n"
                        + "d = " + mDiagonal;

        return mDiagonal;
    }

    public double diagonalLengthArea (double length, double area)
    {
        mLength = length;
        mArea = area;
        double working1 = mArea / mLength;
        double working2 = working1 * working1;
        double working3 = mLength * mLength;
        double working4 = working2 + working3;
        mDiagonal = Math.sqrt (working4);

        mWorking =
                "d = √[l² + (A / l)²]" + "\n"
                        + "d = √[" + mLength + "² + (" + mArea + " / 2)²]" + "\n"
                        + "d = √[" + mLength + "² + " + working1 + "²]" + "\n"
                        + "d = √[" + working3 + " + " + working2 + "]" + "\n"
                        + "d = √" + working4 + "\n"
                        + "d = " + mDiagonal;

        return mDiagonal;
    }

    public double diagonalWidthPerimeter (double width, double perimeter)
    {
        mWidth = width;
        mPerimeter = perimeter;
        double working1 = mPerimeter / 2;
        double working2 = working1 - mWidth;
        double working3 = working2 * working2;
        double working4 = mWidth * mWidth;
        double working5 = working3 + working4;
        mDiagonal = Math.sqrt (working5);

        mWorking =
                "d = √[w² + (P / 2 - w)²]" + "\n"
                        + "d = √[" + mWidth + "² + (" + mPerimeter + " / 2 - " + mWidth + ")²]" + "\n"
                        + "d = √[" + mWidth + "² + (" + working1 + " - " + mWidth + ")²]" + "\n"
                        + "d = √[" + mWidth + "² + " + working2 + "²]" + "\n"
                        + "d = √[" + working4 + " + " + working3 + "]" + "\n"
                        + "d = √" + working5 + "\n"
                        + "d = " + mDiagonal;

        return mDiagonal;
    }

    public double diagonalWidthArea (double width, double area)
    {
        mWidth = width;
        mArea = area;
        double working1 = mArea / mWidth;
        double working2 = working1 * working1;
        double working3 = mWidth * mWidth;
        double working4 = working2 + working3;
        mDiagonal = Math.sqrt (working4);

        mWorking =
                "d = √[w² + (A / w)²]" + "\n"
                        + "d = √[" + mWidth + "² + (" + mArea + " / 2)²]" + "\n"
                        + "d = √[" + mWidth + "² + " + working1 + "²]" + "\n"
                        + "d = √[" + working3 + " + " + working2 + "]" + "\n"
                        + "d = √" + working4 + "\n"
                        + "d = " + mDiagonal;

        return mDiagonal;
    }

    public double diagonalPerimeterArea (double perimeter, double area)
    {
        mPerimeter = perimeter;
        mArea = area;
        double working1 = mPerimeter * mPerimeter;
        double working2 = mArea * 8;
        double working3 = 0.5;
        double working4 = working1 - working2;
        double working5 = Math.sqrt (working4);
        mDiagonal = working3 * working5;

        mWorking =
                "d = (1 / 2) × √(P² - 8 × A)" + "\n"
                        + "d = (1 / 2) × √(" + mPerimeter + "² - 8 × " + mArea + ")" + "\n"
                        + "d = (1 / 2) × √(" + working1 + " - 8 × " + mArea + ")" + "\n"
                        + "d = " + working3 + " × √(" + working1 + " - " + working2 + ")" + "\n"
                        + "d = " + working3 + " × √" + working4 + "\n"
                        + "d = " + working3 + " × " + working5 + "\n"
                        + "d = " + mDiagonal;

        return mDiagonal;
    }


    public double perimeterPerimeter (double perimeter)
    {
        mPerimeter = perimeter;

        mWorking =
                "Perimeter =" + " " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterLengthWidth (double length, double width)
    {
        mLength = length;
        mWidth = width;
        double working1 = mLength + mWidth;
        mPerimeter = 2 * working1;

        mWorking =
                "P = 2 × (l + w)" + "\n"
                        + "P = 2 × (" + mLength + " + " + mWidth + ")" + "\n"
                        + "P = 2 × " + working1 + "\n"
                        + "P = " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterLengthDiagonal (double length, double diagonal)
    {
        mLength = length;
        mDiagonal = diagonal;
        double working1 = mDiagonal + mDiagonal;
        double working2 = mLength * mLength;
        double working3 = working1 - working2;
        double working4 = Math.sqrt (working3);
        double working5 = 2 * working4;
        double working6 = 2 * mLength;
        mPerimeter = working6 + working5;

        mWorking =
                "P = 2 × l + 2 × √(d² - l²)" + "\n"
                        + "P = 2 × " + mLength + " + 2 × √(" + mDiagonal + "² - " + mLength + "²)" + "\n"
                        + "P = 2 × " + mLength + " + 2 × √(" + working1 + " - " + working2 + ")" + "\n"
                        + "P = 2 × " + mLength + " + 2 × √" + working3 + "\n"
                        + "P = 2 × " + mLength + " + 2 × " + working4 + "\n"
                        + "P = " + working6 + " + " + working5 + "\n"
                        + "P = " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterLengthArea (double length, double area)
    {
        mLength = length;
        mArea = area;
        double working1 = mArea / mLength;
        double working2 = 2 * mLength;
        double working3 = 2 * working1;
        mPerimeter = working2 + working3;

        mWorking =
                "P = 2 × l + 2 × (A / l)" + "\n"
                        + "P = 2 × " + mLength + " + 2 × (" + mArea + " / " + mLength + ")" + "\n"
                        + "P = 2 × " + mLength + " + 2 × " + working1 + "\n"
                        + "P = " + working2 + " + " + working3 + "\n"
                        + "P = " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterWidthDiagonal (double width, double diagonal)
    {
        mWidth = width;
        mDiagonal = diagonal;
        double working1 = mDiagonal + mDiagonal;
        double working2 = mWidth * mWidth;
        double working3 = working1 - working2;
        double working4 = Math.sqrt (working3);
        double working5 = 2 * working4;
        double working6 = 2 * mWidth;
        mPerimeter = working6 + working5;

        mWorking =
                "P = 2 × w + 2 × √(d² - w²)" + "\n"
                        + "P = 2 × " + mWidth + " + 2 × √(" + mDiagonal + "² - " + mWidth + "²)" + "\n"
                        + "P = 2 × " + mWidth + " + 2 × √(" + working1 + " - " + working2 + ")" + "\n"
                        + "P = 2 × " + mWidth + " + 2 × √" + working3 + "\n"
                        + "P = 2 × " + mWidth + " + 2 × " + working4 + "\n"
                        + "P = " + working6 + " + " + working5 + "\n"
                        + "P = " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterWidthArea (double width, double area)
    {
        mWidth = width;
        mArea = area;
        double working1 = mArea / mWidth;
        double working2 = 2 * mWidth;
        double working3 = 2 * working1;
        mPerimeter = working2 + working3;

        mWorking =
                "P = 2 × w + 2 × (A / w)" + "\n"
                        + "P = 2 × " + mWidth + " + 2 × (" + mArea + " / " + mWidth + ")" + "\n"
                        + "P = 2 × " + mWidth + " + 2 × " + working1 + "\n"
                        + "P = " + working2 + " + " + working3 + "\n"
                        + "P = " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterDiagonalArea (double diagonal, double area)
    {
        mDiagonal = diagonal;
        mArea = area;
        double working1 = mDiagonal * mDiagonal * mDiagonal * mDiagonal;
        double working2 = mArea * mArea;
        double working3 = 0.5;
        double working4 = 4 * working2;
        double working5 = working1 - working4;
        double working6 = mDiagonal * mDiagonal;
        double working7 = Math.sqrt (working5);
        double working8 = 2 * working6;
        double working9 = 2 * working7;
        double working10 = working3 * working6;
        double working11 = working3 * working7;
        double working12 = working8 + working9;
        double working13 = working10 + mArea;
        double working14 = working13 - working11;
        double working15 = Math.sqrt (working12);
        double working16 = working14 / mArea;
        mPerimeter = working15 * working16;

        mWorking =
                "P = {√[2 × d² + 2 × √(d<sup><small>4</small></sup> - 4 × A²)]} × {[(1 / 2) × d² + A - (1 / 2) × √(d<sup><small>4</small></sup> - 4 × A²)] / A}" + "<br>"
                        + "P = {√[2 × " + mDiagonal + "² + 2 × √(" + mDiagonal + "<sup><small>4</small></sup> - 4 × " + mArea + "²)]} × {[(1 / 2) × " + mDiagonal + "² + " + mArea + " - (1 / 2) × √(" + mDiagonal + "<sup><small>4</small></sup> - 4 × " + mArea + "²)] / " + mArea + "}" + "<br>"
                        + "P = {√[2 × " + mDiagonal + "² + 2 × √(" + working1 + " - 4 × " + working2 + ")]} × {[(1 / 2) × " + mDiagonal + "² + " + mArea + " - (1 / 2) × √(" + working1 + " - 4 × " + working2 + ")] / " + mArea + "}" + "<br>"
                        + "P = {√[2 × " + mDiagonal + "² + 2 × √(" + working1 + " - " + working4 + ")]} × {[" + working3 + " × " + mDiagonal + "² + " + mArea + " - " + working3 + " × √(" + working1 + " - " + working4 + ")] / " + mArea + "}" + "<br>"
                        + "P = {√[2 × " + mDiagonal + "² + 2 × √" + working5 + "]} × {[" + working3 + " × " + mDiagonal + "² + " + mArea + " - " + working3 + " × √" + working5 + "] / " + mArea + "}" + "<br>"
                        + "P = {√[2 × " + working6 + " + 2 × " + working7 + "]} × {[" + working3 + " × " + working6 + " + " + mArea + " - " + working3 + " × " + working7 + "] / " + mArea + "}" + "<br>"
                        + "P = {√[" + working8 + " + " + working9 + "]} × {[" + working10 + " + " + mArea + " - " + working11 + "] / " + mArea + "}" + "<br>"
                        + "P = {√" + working12 + "} × {[" + working13 + " - " + working11 + "] / " + mArea + "}" + "<br>"
                        + "P = {√" + working12 + "} × {" + working14 + " / " + mArea + "}" + "<br>"
                        + "P = " + working15 + " × {" + working14 + " / " + mArea + "}" + "<br>"
                        + "P = " + working15 + " × " + working16  + "<br>"
                        + "P = " + mPerimeter;

        return mPerimeter;
    }


    public double areaArea (double area)
    {
        mArea = area;

        mWorking =
                "Area =" + " " + mArea;

        return mArea;
    }

    public double areaLengthWidth (double length, double width)
    {
        mLength = length;
        mWidth = width;
        mArea = mLength * mWidth;

        mWorking =
                "A = l × w" + "\n"
                        + "A = " + mLength + " × " + mWidth + "\n"
                        + "A = " + mArea;

        return mArea;
    }

    public double areaLengthDiagonal (double length, double diagonal)
    {
        mLength = length;
        mDiagonal = diagonal;
        double working1 = mDiagonal * mDiagonal;
        double working2 = mLength * mLength;
        double working3 = working1 - working2;
        double working4 = Math.sqrt (working3);
        mArea = mLength * working4;

        mWorking =
                "A = l × √(d² - l²)" + "\n"
                        + "A = " + mLength + " × √(" + mDiagonal + "² - " + mLength + "²)" + "\n"
                        + "A = " + mLength + " × √(" + working1 + " - " + working2 + ")" + "\n"
                        + "A = " + mLength + " × √" + working3 + "\n"
                        + "A = " + mLength + " × " + working4 + "\n"
                        + "A = " + mArea;

        return mArea;
    }

    public double areaLengthPerimeter (double length, double perimeter)
    {
        mLength = length;
        mPerimeter = perimeter;
        double working1 = 0.5;
        double working2 = mLength * mLength;
        double working3 = mPerimeter * working1;
        mArea = working3 - working2;

        mWorking =
                "A = P × (1 / 2) - l²" + "\n"
                        + "A = " + mPerimeter + " × (1 / 2) - " + mLength + "²" + "\n"
                        + "A = " + mPerimeter + " × " + working1 + " - " + mLength + "²" + "\n"
                        + "A = " + mPerimeter + " × " + working1 + " - " + working2 + "\n"
                        + "A = " + working3 + " - " + working2 + "\n"
                        + "A = " + mArea;

        return mArea;
    }

    public double areaWidthDiagonal (double width, double diagonal)
    {
        mWidth = width;
        mDiagonal = diagonal;
        double working1 = mDiagonal * mDiagonal;
        double working2 = mWidth * mWidth;
        double working3 = working1 - working2;
        double working4 = Math.sqrt (working3);
        mArea = mWidth * working4;

        mWorking =
                "A = l × √(d² - l²)" + "\n"
                        + "A = " + mWidth + " × √(" + mDiagonal + "² - " + mWidth + "²)" + "\n"
                        + "A = " + mWidth + " × √(" + working1 + " - " + working2 + ")" + "\n"
                        + "A = " + mWidth + " × √" + working3 + "\n"
                        + "A = " + mWidth + " × " + working4 + "\n"
                        + "A = " + mArea;

        return mArea;
    }

    public double areaWidthPerimeter (double width, double perimeter)
    {
        mWidth = width;
        mPerimeter = perimeter;
        double working1 = 0.5;
        double working2 = mWidth * mWidth;
        double working3 = mPerimeter * working1;
        mArea = working3 - working2;

        mWorking =
                "A = P × (1 / 2) - l²" + "\n"
                        + "A = " + mPerimeter + " × (1 / 2) - " + mWidth + "²" + "\n"
                        + "A = " + mPerimeter + " × " + working1 + " - " + mWidth + "²" + "\n"
                        + "A = " + mPerimeter + " × " + working1 + " - " + working2 + "\n"
                        + "A = " + working3 + " - " + working2 + "\n"
                        + "A = " + mArea;

        return mArea;
    }

    public double areaDiagonalPerimeter (double diagonal, double perimeter)
    {
        mDiagonal = diagonal;
        mPerimeter = perimeter;
        double working1 = mDiagonal * mDiagonal;
        double working2 = mPerimeter * mPerimeter;
        double working3 = mPerimeter / 4;
        double working4 = 0.25;
        double working5 = 8 * working1;
        double working6 = working5 - working2;
        double working7 = Math.sqrt (working6);
        double working8 = working4 * working7;
        double working9 = working3 - working8;
        double working10 = working3 + working8;
        mArea = working9 * working10;

        mWorking =
                "A = [(P / 4) - (1 / 4) × √(8 × d² - P²)] × [(P / 4) + (1 / 4) × √(8 × d² - P²)]" + "\n"
                        + "A = [(" + mPerimeter + " / 4) - (1 / 4) × √(8 × " + mDiagonal + "² - " + mPerimeter + "²)] × [(" + mPerimeter + " / 4) + (1 / 4) × √(8 × " + mDiagonal + "² - " + mPerimeter + "²)]" + "\n"
                        + "A = [(" + mPerimeter + " / 4) - (1 / 4) × √(8 × " + working1 + " - " + working2 + ")] × [(" + mPerimeter + " / 4) + (1 / 4) × √(8 × " + working1 + " - " + working2 + ")]" + "\n"
                        + "A = [" + working3 + " - " + working4 + " × √(" + working5 + " - " + working2 + ")] × [" + working3 + " + " + working4 + " × √(" + working5 + " - " + working2 + ")]" + "\n"
                        + "A = [" + working3 + " - " + working4 + " × √" + working6 + "] × [" + working3 + " + " + working4 + " × √" + working6 + "]" + "\n"
                        + "A = [" + working3 + " - " + working4 + " × " + working7 + "] × [" + working3 + " + " + working4 + " × " + working7 + "]" + "\n"
                        + "A = [" + working3 + " - " + working8 + "] × [" + working3 + " + " + working8 + "]" + "\n"
                        + "A = " + working9 + " × " + working10  + "\n"
                        + "A = " + mArea;

        return mArea;
    }
}
