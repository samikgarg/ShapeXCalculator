package com.samazebra.mathematicalgeometrycalculator;

import android.util.Log;

import java.nio.MappedByteBuffer;

public class IsoscelesTriangle
{
    private double mSideLength;
    private double mBase;
    private double mHeight;
    private double mPerimeter;
    private double mArea;

    private String mWorking;


    public String getWorking()
    {
        return mWorking;
    }


    public double sideLengthSideLength (double sideLength)
    {
        mSideLength = sideLength;

        mWorking =
                "Side Length =" + " " + mSideLength;

        return mSideLength;
    }

    public double sideLengthHeightBase (double height, double base)
    {
        mHeight = height;
        mBase = base;
        double working1 = 0.5;
        double working2 = mBase * mBase;
        double working3 = mHeight * mHeight;
        double working4 = working3 * 4;
        double working5 = working2 + working4;
        double working6 = Math.sqrt(working5);
        mSideLength = working1 * working6;

        mWorking =
                "l = (1 / 2) × √(b² + 4 × h²)" + "<br>"
                        +"l = (1 / 2) × √(" + mBase + "² + 4 × "  + mHeight + "²)" + "<br>"
                        + "l = (1 / 2) × √(" + working2 + " + 4 × " + working3 + ")" + "<br>"
                        + "l = " + working1 + " × √(" + working2 + " + " + working4 + ")" + "<br>"
                        + "l = " + working1 + " × √" + working5  + "<br>"
                        + "l = " + working1 + " × " + working6 + "<br>"
                        + "l =" + " " + mSideLength;

        return mSideLength;
    }

    public double sideLengthPerimeterBase (double perimeter, double base)
    {
        mPerimeter = perimeter;
        mBase = base;
        double working1 = mPerimeter - mBase;
        mSideLength =  working1 / 2;

        mWorking =
                "l = (P - b) / 2" + "<br>"
                        + "l = (" + mPerimeter + " - " + mBase + ") / 2" + "<br>"
                        + "l = " + working1 + " / 2" + "<br>"
                        + "l =" + " " + mSideLength;

        return mSideLength;
    }

    public double sideLengthAreaBase (double area, double base)
    {
        mArea = area;
        mBase = base;
        double working1 = mArea * mArea;
        double working2 = mBase * mBase * mBase * mBase;
        double working3 = mBase * mBase;
        double working4 = 16 * working1;
        double working5 = 4 * working3;
        double working6 = working4 + working2;
        double working7 = working6 / working5;
        mSideLength = Math.sqrt(working7);

        mWorking =
                "l = √[(16 × A² + b<sup><font size=\"9\">4</font></sup>) / (4 × b²)]" + "<br>"
                        + "l = √[(16 × " + mArea + "² + " + mBase + "<sup><font size=\"9\">4</font></sup>) / (4 × " + mBase + "²)]" + "<br>"
                        + "l = √[(16 × " + working1 + " + " + working2 + " / (4 × " + working3 + ")]" + "<br>"
                        + "l = √[(" + working4 + " + " + working2 + ") / " + working5 + "]" + "<br>"
                        + "l = √[" + working6 + " / " + working5 + "]" + "<br>"
                        + "l = √" + working7 + "<br>"
                        + "l = " + " " + mSideLength;

        return mSideLength;
    }

    public double sideLengthPerimeterHeight (double perimeter, double height)
    {
        mPerimeter = perimeter;
        mHeight = height;
        double working1 = mPerimeter * mPerimeter;
        double working2 = mHeight * mHeight;
        double working3 = 4 * working2;
        double working4 = working3 + working1;
        double working5 = 4 * mPerimeter;
        mSideLength = working4 / working5;

        mWorking =
                "l = (4 × h² + P²) / (4 × P)" + "<br>"
                        + "l = (4 × " + mHeight + "² + " + mPerimeter + "²) / (4 × " + mPerimeter + ")" + "<br>"
                        + "l = (4 × " + working2 + " + " + working1 + ") / (4 × " + mPerimeter + ")" + "<br>"
                        + "l = (" + working3 + " + " + working1 + ") / " + working5 + "<br>"
                        + "l = " + working4 + " / " + working5 + "<br>"
                        + "l = " + " " + mSideLength;

        return mSideLength;
    }

    public double sideLengthAreaHeight (double area, double height)
    {
        mArea = area;
        mHeight = height;
        double working1 = mHeight * mHeight;
        double working2 = mArea * mArea;
        double working3 = working2 / working1;
        double working4 = working3 + working1;
        mSideLength = Math.sqrt (working4);

        mWorking =
                "l = √(A² / h² + h²)"
                        + "l = √(" + mArea + "² / " + mHeight + "² + " + mHeight + "²)"
                        + "l = √(" + working2 + " / " + working1 + " + " + working1 + ")"
                        + "l = √(" + working3 + " + " + working1 + ")"
                        + "l = √" + working4
                        + "l = " + " " + mSideLength;

        return mSideLength;
    }


    public double baseBase (double base)
    {
        mBase = base;

        mWorking =
                "Base =" + " " + mBase;

        return mBase;
    }

    public double baseHeightSideLength (double height, double sideLength)
    {
        mHeight = height;
        mSideLength = sideLength;
        double working1 = mHeight * mHeight;
        double working2 = mSideLength * mSideLength;
        double working3 = working2 - working1;
        double working4 = Math.sqrt(working3);
        mBase = 2 * working4;

        mWorking =
                "b = 2 × √(l² - h²)" + "<br>"
                        + "b = 2 × √(" + mSideLength + "² - " + mHeight + "²)" + "<br>"
                        + "b = 2 × √(" + working2 + " - " + working1 + ")" + "<br>"
                        + "b = 2 × √" + working3 + "<br>"
                        + "b = 2 × " + working4 + "<br>"
                        + "b = " + mBase;

        return mBase;
    }

    public double basePerimeterSideLength (double perimeter, double sideLength)
    {
        mPerimeter = perimeter;
        mSideLength = sideLength;
        double working1 = mSideLength * 2;
        mBase = mPerimeter - working1;

        mWorking =
                "b = P - 2 × l" + "<br>"
                        + "b = (" + mPerimeter + " " + "-" + " " + "2" + " " + "×" + " " + mSideLength + ")" + "<br>"
                        + "b = (" + mPerimeter + " " + "-" + " " + working1 + ")" + " " + "<br>"
                        + "b =" + " " + mBase;

        return mBase;
    }

    public double basePerimeterHeight (double perimeter, double height)
    {
        mPerimeter = perimeter;
        mHeight = height;
        double working1 = mHeight * mHeight;
        double working2 = working1 / mPerimeter;
        double working3 = mPerimeter / 2;
        double working4 = 2 * working2;
        mSideLength = working3 - working4;

        mWorking =
                "b = (P / 2) - 2 × (h² / P)" + "<br>"
                        + "b = (" + mPerimeter + " / 2) - 2 × (" + mHeight + "² / " + mPerimeter + ")" + "<br>"
                        + "b = (" + mPerimeter + " / 2) - 2 × (" + working1 + " / " + mPerimeter + ")" + "<br>"
                        + "b = " + working3 + " - 2 × " + working2 + "<br>"
                        + "b = " + working3 + " - " + working4 + "<br>"
                        + "b = " + " " + mBase;

        return mBase;
    }

    public double baseAreaHeight (double area, double height)
    {
        mArea = area;
        mHeight = height;
        double working1 = mArea * 2;
        mBase = working1 / mHeight;

        mWorking =
                "b = 2 × A / h" + "<br>"
                        + "b = 2 × " + mArea + " / " + mHeight + "<br>"
                        + "b = " + working1 + " / " + mHeight + "<br>"
                        + "b = " + " " + mBase;

        return mBase;
    }

    public double heightHeight (double height)
    {
        mHeight = height;

        mWorking =
                "Height =" + " " + mHeight;

        return mHeight;
    }

    public double heightSideLengthBase (double sideLength, double base)
    {
        mSideLength = sideLength;
        mBase = base;
        double working1 = mBase * mBase;
        double working2 = working1 / 4;
        double working3 = mSideLength * mSideLength;
        double working4 = working3 - working2;
        mHeight = Math.sqrt (working4);

        mWorking =
                "h = √[l² - (b² / 4)]" + "<br>"
                        + "h = √[" + mSideLength + "² - (" + mBase + "² / 4)]" + "<br>"
                        + "h = √[" + mSideLength + "² - (" + working1 + " / 4)]" + "<br>"
                        + "h = √[" + mSideLength + "² - " + working2 + "]" + "<br>"
                        + "h = √[" + working3 + " - " + working2 + "]" + "<br>"
                        + "h = √" + working4 + "<br>"
                        + "h = " + mHeight;

        return mHeight;
    }

    public double heightSideLengthPerimeter (double sideLength, double perimeter)
    {
        mSideLength = sideLength;
        mPerimeter = perimeter;
        double working1 = 2 * mSideLength;
        double working2 = mPerimeter - working1;
        double working3 = working2 * working2;
        double working4 = working3 / 4;
        double working5 = mSideLength * mSideLength;
        double working6 = working5 - working4;
        mHeight = Math.sqrt (working6);

        mWorking =
                "h = √{l² - [(P - 2 × l)² / 4]}" + "<br>"
                        + "h = √{" + mSideLength + "² - [(" + mPerimeter + " - 2 × " + mSideLength + ")² / 4]}" + "<br>"
                        + "h = √{" + mSideLength + "² - [(" + mPerimeter + " - " + working1 + ")² / 4]}" + "<br>"
                        + "h = √{" + mSideLength + "² - [" + working2 + "² / 4]}" + "<br>"
                        + "h = √{" + mSideLength + "² - [" + working3 + " / 4]}" + "<br>"
                        + "h = √{" + mSideLength + "² - " + working4 + "}" + "<br>"
                        + "h = √{" + working5 + " - " + working4 + "}" + "<br>"
                        + "h = √" + working6 + "<br>"
                        + "h = " + mHeight;

        return mHeight;
    }


    public double heightBasePerimeter (double base, double perimeter)
    {
        mBase = base;
        mPerimeter = perimeter;
        double working1 = 0.5;
        double working2 = 2 * mBase;
        double working3 = mPerimeter - working2;
        double working4 = mPerimeter * working3;
        double working5 = Math.sqrt(working4);
        mHeight = working1 * working5;

        mWorking =
                "h = (1 / 2) × √[P × (P - 2 × b)}" + "<br>"
                        + "h = (1 / 2) × √[" + mPerimeter + " × (" + mPerimeter + " - 2 × " + mBase + ")]" + "<br>"
                        + "h = " + working1 + " × √[" + mPerimeter + " × (" + mPerimeter + " - " + working2 + ")]" + "<br>"
                        + "h = " + working1 + " × √[" + mPerimeter + " × " + working3 + "]" + "<br>"
                        + "h = " + working1 + " × √" + working4 + "<br>"
                        + "h = " + working1 + " × " + working5 + "<br>"
                        + "h = " + mHeight;

        return mHeight;
    }

    public double heightBaseArea (double base, double area)
    {
        mBase = base;
        mArea = area;
        double working1 = mArea * 2;
        mHeight = working1 / mBase;

        mWorking =
                "h = 2 × A / b" + "<br>"
                        + "h = 2 × " + mArea + " / " + mBase + "<br>"
                        + "h = " + working1 + " / " + mBase + "<br>"
                        + "h = " + mHeight;

        return mHeight;
    }


    public double perimeterPerimeter (double perimeter)
    {
        mPerimeter = perimeter;

        mWorking =
                "Perimeter =" + " " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterSideLengthBase (double sideLength, double base)
    {
        mSideLength = sideLength;
        mBase = base;
        double working1 = mSideLength * 2;
        mPerimeter = working1 + mBase;

        mWorking =
                "P = 2 × l + b" + "<br>"
                        + "P = 2 × " + mSideLength + " + " + mBase + "<br>"
                        + "P = " + working1 + " + " + mBase + "<br>"
                        + "P = " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterSideLengthHeight (double sideLength, double height)
    {
        mSideLength = sideLength;
        mHeight = height;
        double working1 = mSideLength * mSideLength;
        double working2 = mHeight * mHeight;
        double working3 = working1 - working2;
        double working4 = Math.sqrt(working3);
        double working5 = 2 * working4;
        double working6 = 2 * mSideLength;
        mPerimeter = working6 + working5;

        mWorking =
                "P = 2 × l + 2 × √(l² - h²)" + "<br>"
                        + "P = 2 × " + mSideLength + "2 × √(" + mSideLength + "² - " + mHeight + "²)" + "<br>"
                        + "P = 2 × " + mSideLength + "2 × √(" + working1 + " - " + working2 + ")" + "<br>"
                        + "P = 2 × " + mSideLength + "2 × √" + working3 + "<br>"
                        + "P = 2 × " + mSideLength + "2 × " + working4 + "<br>"
                        + "P = " + working6 + working5 + "<br>"
                        + "P = " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterBaseHeight (double base, double height)
    {
        mBase = base;
        mHeight = height;
        double working1 = mHeight * mHeight;
        double working2 = mBase * mBase;
        double working3 = 4 * working1;
        double working4 = working3 + working2;
        double working5 = working4 / 4;
        double working6 = Math.sqrt(working5);
        double working7 = working6 * 2;
        mPerimeter = working7 + mBase;

        mWorking =
                "P = 2 × √[(4 × h² + b²) / 4] + b" + "<br>"
                        + "P = 2 × √[(4 × " + mHeight + "² + " + mBase + "²) / 4] + " + mBase + "<br>"
                        + "P = 2 × √[(4 × " + working1 + " + " + working2 + ") / 4] + " + mBase + "<br>"
                        + "P = 2 × √[(" + working3 + " + " + working2 + ") / 4] + " + mBase + "<br>"
                        + "P = 2 × √[" + working4 + " / 4] + " + mBase + "<br>"
                        + "P = 2 × √" + working5 + " + " + mBase + "<br>"
                        + "P = 2 × " + working6 + " + " + mBase + "<br>"
                        + "P = " + working7 + " + " + mBase + "<br>"
                        + "P = " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterBaseArea (double base, double area)
    {
        mBase = base;
        mArea = area;
        double working1 = mArea * mArea;
        double working2 = mBase * mBase * mBase * mBase;
        double working3 = mBase * mBase;
        double working4 = 16 * working1;
        double working5 = working4 + working2;
        double working6 = working5 / working3;
        double working7 = Math.sqrt(working6);
        mPerimeter = working7 + mBase;

        mWorking =
                "P = √[(16 × A² + b<sup><font size=\"9\">4</font></sup>) / b²] + b" + "<br>"
                        + "P = √[(16 × " + mArea + "² + " + mBase + "<sup><font size=\"9\">4</font></sup>) / " + mBase + "²] + " + mBase + "<br>"
                        + "P = √[(16 × " + working1 + " + " + working2 + ") / " + mBase + "²] + " + mBase + "<br>"
                        + "P = √[(" + working4 + " + " + working2 + ") / " + mBase + "²] + " + mBase + "<br>"
                        + "P = √[" + working5 + " / " + mBase + "²] + " + mBase + "<br>"
                        + "P = √[" + working5 + " / " + working3 + "] + " + mBase + "<br>"
                        + "P = √" + working6 + " + " + mBase + "<br>"
                        + "P = " + working6 + " + " + mBase + "<br>"
                        + "P = " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterHeightArea (double height, double area)
    {
        mHeight = height;
        mArea = area;
        double working1 = mArea / mHeight;
        double working2 = mHeight * mHeight;
        double working3 = working1 * working1;
        double working4 = 2 * working1;
        double working5 = working2 * working3;
        double working6 = Math.sqrt(working5);
        double working7 = 2 * working6;
        mPerimeter = working7 + working4;

        mWorking =
                "P = 2 × √[h² + (A / h)²] + [2 × (A / h)]" + "<br>"
                        + "P = 2 × √[" + mHeight + "² + (" + mArea + " / " + mHeight + ")²] + [2 × (" + mArea + " / " + mHeight + ")]" + "<br>"
                        + "P = 2 × √[" + mHeight + "² + " + working1 + "²] + [2 × " + working1 + "]" + "<br>"
                        + "P = 2 × √[" + working2 + " + " + working3 + "] + [2 × " + working1 + "]" + "<br>"
                        + "P = 2 × √[" + working2 + " + " + working3 + "] + " + working4 + "<br>"
                        + "P = 2 × √" + working5 + " + " + working4 + "<br>"
                        + "P = 2 × " + working6 + " + " + working4 + "<br>"
                        + "P = " + working7 + " + " + working4 + "<br>"
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

    public double areaSideLengthBase (double sideLength, double base)
    {
        mSideLength = sideLength;
        mBase = base;
        double working1 = mBase * mBase;
        double working2 = working1 / 4;
        double working3 = mSideLength * mSideLength;
        double working4 = working3 - working2;
        double working5 = Math.sqrt(working4);
        double working6 = mBase * working5;
        mArea = working6 / 2;

        mWorking =
                "A = {b × √[l² - (b² / 4)]} / 2" + "<br>"
                        + "A = {" + mBase + " × √[" + mSideLength + "² - (" + mBase + "² / 4)]} / 2" + "<br>"
                        + "A = {" + mBase + " × √[" + mSideLength + "² - (" + working1 + " / 4)]} / 2" + "<br>"
                        + "A = {" + mBase + " × √[" + mSideLength + "² - " + working2 + "]} / 2" + "<br>"
                        + "A = {" + mBase + " × √[" + working3 + " - " + working2 + "]} / 2" + "<br>"
                        + "A = {" + mBase + " × √" + working4 + "} / 2" + "<br>"
                        + "A = {" + mBase + " × " + working5 + "} / 2" + "<br>"
                        + "A = " + working6 + " / 2" + "<br>"
                        + "A = " + mArea;

        return mArea;
    }

    public double areaSideLengthHeight (double sideLength, double height)
    {
        mSideLength = sideLength;
        mHeight = height;
        double working1 = mHeight * mHeight;
        double working2 = mSideLength * mSideLength;
        double working3 = working1 - working2;
        double working4 = Math.sqrt (working3);
        mArea = mHeight * working4;

        mWorking =
                "A = h × √(l² - h²)" + "<br>"
                        + "A = " + mHeight + " × √(" + mHeight + "² - " + mSideLength + "²)" + "<br>"
                        + "A = " + mHeight + " × √(" + working1 + " - " + working2 + ")" + "<br>"
                        + "A = " + mHeight + " × √" + working3 + "<br>"
                        + "A = " + mHeight + " × " + working4 + "<br>"
                        + "A = " + mArea;

        return mArea;
    }

    public double areaBaseHeight (double base, double height)
    {
        mBase = base;
        mHeight = height;
        double working1 = mBase * mHeight;
        mArea = mBase * working1 / 2;

        mWorking =
                "A = (b × h) / 2" + "<br>"
                        + "A = (" + mBase + " × " + mHeight + ") / 2" + "<br>"
                        + "A = " + working1 + " / 2" + "<br>"
                        + "A = " + mArea;

        return mArea;
    }

    public double areaBasePerimeter (double base, double perimeter)
    {
        mBase = base;
        mPerimeter = perimeter;
        double working1 = 0.25;
        double working2 = 2 * mBase;
        double working3 = mPerimeter - working2;
        double working4 = mPerimeter * working3;
        double working5 = Math.sqrt(working4);
        double working6 = working1 * mBase;
        mArea = working6 * working5;

        mWorking =
                "A = (1 / 4) × b × √[P × (P - 2 × b)]" + "<br>"
                        + "A = (1 / 4) × " + mBase + " × √[" + mPerimeter + " × (" + mPerimeter + " - 2 × " + mBase + ")]" + "<br>"
                        + "A = " + working1 + " × " + mBase + " × √[" + mPerimeter + " × (" + mPerimeter + " - " + working2 + ")]" + "<br>"
                        + "A = " + working1 + " × " + mBase + " × √[" + mPerimeter + " × " + working3 + "]" + "<br>"
                        + "A = " + working1 + " × " + mBase + " × √" + working4 + "<br>"
                        + "A = " + working1 + " × " + mBase + " × " + working5 + "<br>"
                        + "A = " + working6 + " × " + working5 + "<br>"
                        + "A = " + mArea;

        return mArea;
    }

    public double areaHeightPerimeter (double height, double perimeter)
    {
        mHeight = height;
        mPerimeter = perimeter;
        double working1 = mHeight * mHeight * mHeight;
        double working2 = working1 / mPerimeter;
        double working3 = mHeight * mPerimeter;
        double working4 = working3 / 4;
        mArea = working4 - working2;

        mWorking =
                "A = (P × h) / 4 - (h³ / P)" + "<br>"
                        + "A = (" + mPerimeter + " × " + mHeight + ") / 4 - (" + mHeight + "³ / " + mPerimeter + ")" + "<br>"
                        + "A = (" + mPerimeter + " × " + mHeight + ") / 4 - (" + working1 + " / " + mPerimeter + ")" + "<br>"
                        + "A = " + working3 + " / 4 - " + working2 + "<br>"
                        + "A = " + working4 + " - " + working2 + "<br>"
                        + "A = " + mArea;

        return mArea;
    }
}
