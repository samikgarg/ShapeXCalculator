package com.samazebra.mathematicalgeometrycalculator;

public class EquilateralTriangle
{
    private double mSideLength;
    private double mHeight;
    private double mPerimeter;
    private double mArea;

    private double sqrt3 = Math.sqrt (3);

    private String mWorking;


    public String getWorking ()
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

    public double sideLengthHeight (double height)
    {
        mHeight = height;
        double working1 = 2 * mHeight;
        mSideLength = working1 / sqrt3;

        mWorking =
                "l = (2 × h) / √3" + "\n"
                        + "l = (2 × " + mHeight + ") / " + sqrt3 + "\n"
                        + "l = " + working1 + " / " + sqrt3 + "\n"
                        + "l =" + " " + mSideLength;

        return mSideLength;
    }

    public double sideLengthPerimeter (double perimeter)
    {
        mPerimeter = perimeter;
        mSideLength = mPerimeter / 3;

        mWorking =
                "l = P / 3" + "\n"
                        + "l = " + mPerimeter + " / 3" + "\n"
                        + "l =" + " " + mSideLength;

        return mSideLength;
    }

    public double sideLengthArea (double area)
    {
        mArea = area;
        double working1 = 4 * mArea;
        double working2 = working1 / sqrt3;
        mSideLength = Math.sqrt (working2);

        mWorking =
                "l = √[(4 × A) / √3]" + "\n"
                        + "l = √[(4 × " + mArea + ") / " + sqrt3+ "]" + "\n"
                        + "l = √[" + working1 + " / " + sqrt3 + "]" + "\n"
                        + "l = √" + working2 + " / " + sqrt3 + "\n"
                        + "l =" + " " + mSideLength;

        return mSideLength;
    }


    public double heightSideLength (double sideLength)
    {
        mSideLength = sideLength;
        double working1 = mSideLength * sqrt3;
        mHeight = working1 / 2;

        mWorking =
                "h = (l × √3) / 2" + "\n"
                        + "h = (" + mSideLength + " × " + sqrt3 + ") / 2" + "\n"
                        + "h = " + working1 + " / 2" + "\n"
                        + "h =" + " " + mHeight;

        return mHeight;
    }

    public double heightHeight (double height)
    {
        mHeight = height;

        mWorking =
                "Height =" + " " + mHeight;

        return mHeight;
    }

    public double heightPerimeter (double perimeter)
    {
        mPerimeter = perimeter;
        double working1 = mPerimeter / 3;
        double working2 = working1 * sqrt3;
        mHeight = working2 / 2;

       mWorking =
               "h = [(P / 3) × √3] / 2" + "\n"
                       + "h = [(" + mPerimeter + " / 3) × " + sqrt3 + "] / 2" + "\n"
                       + "h = [" + working1 + " × " + sqrt3 + "] / 2" + "\n"
                       + "h = " + working2 + " / 2" + "\n"
                       + "h =" + " " + mHeight;

        return mHeight;
    }

    public double heightArea (double area)
    {
        mArea = area;
        double working1 = 4 * mArea;
        double working2 = working1 / sqrt3;
        double working3 = Math.sqrt (working2);
        double working4 = working3 * sqrt3;
        mHeight = working4 / 2;

        mWorking =
        "h = {√[(4 × A) / √3] × √3} / 2" + "\n"
                + "h = {√[(4 × " + mArea + ") / " + sqrt3 + "] × " + sqrt3 + "} / 2" + "\n"
                + "h = {√[" + working1 + " / " + sqrt3 + "] × " + sqrt3 + "} / 2" + "\n"
                + "h = {√" + working2 + " × " + sqrt3 + "} / 2" + "\n"
                + "h = {" + working3 + " × " + sqrt3 + "} / 2" + "\n"
                + "h = " + working4 + " / 2" + "\n"
                + "h =" + " " + mHeight;

        return mHeight;
    }


    public double perimeterSideLength (double sideLength)
    {
        mSideLength = sideLength;
        mPerimeter = mSideLength * 3;

        mWorking =
                "P = 3 × l" + System.getProperty ("line.separator")
                        + "P = " + mSideLength + "× 3" + System.getProperty ("line.separator")
                        + "P =" + " " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterHeight (double height)
    {
        mHeight = height;
        double working1 = mHeight * 2;
        double working2 = working1 / sqrt3;
        mPerimeter = 3 * working2;

        mWorking =
                "P = 3 × [(2 × h) / √3]" + "\n"
                        + "P = 3 × [(2 × " + mHeight + ") / " + sqrt3 + "]" + "\n"
                        + "P = 3 × [" + working1 + " / " + sqrt3 + "]" + "\n"
                        + "P = 3 × " + working2 + "\n"
                        + "P = " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterPerimeter (double perimeter)
    {
        mPerimeter = perimeter;

        mWorking =
                "Perimeter =" + " " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterArea (double area)
    {
        mArea = area;
        double working1 = 4 * mArea;
        double working2 = working1 / sqrt3;
        double working3 = Math.sqrt (working2);
        mPerimeter = 3 * working3;

        mWorking =
                "P = 3 × √[(4 × A) / √3]" + "\n"
                        + "P = 3 × √[(4 × " + mArea + ") / " + sqrt3 + "]" + "\n"
                        + "P = 3 × √[" + working1 + " / " + sqrt3 + "]" + "\n"
                        + "P = 3 × √" + working2 + "\n"
                        + "P = 3 × " + working3 + "\n"
                        + "P = " + mPerimeter;

        return mPerimeter;
    }


    public double areaSideLength (double sideLength)
    {
        mSideLength = sideLength;
        double working1 = sqrt3 / 4;
        double working2 = mSideLength * mSideLength;
        mArea = working1 * working2;

        mWorking =
                "A = (√3 / 4) × l²" + "\n"
                        + "A = (" + sqrt3 + " / 4) × " + mSideLength + "²" + "\n"
                        + "A = " + working1 + "  × " + working2 + "\n"
                        + "A = " + mArea;

        return mArea;
    }


    public double areaHeight (double height)
    {
        mHeight = height;
        double working1 = sqrt3 / 4;
        double working2 = 2 * mHeight;
        double working3 = working2 / sqrt3;
        double working4 = working3 * working3;
        mArea = working1 * working4;

        mWorking =
                "A = (√3 / 4) × [(2 × h) / √3]²" + "\n"
                        + "A = (" + sqrt3 + " / 4) × [(2 × " + mHeight + ") / " + sqrt3 + "]²" + "\n"
                        + "A = " + working1 + " × [" + working2 + " / " + sqrt3 + "]²" + "\n"
                        + "A = " + working1 + " × " + working3 + "²" + "\n"
                        + "A = " + working1 + " × " + working4 + "\n"
                        + "A = " + mArea;

        return mArea;
    }


    public double areaPerimeter (double perimeter)
    {
        mPerimeter = perimeter;
        double working1 = sqrt3 / 4;
        double working2 = mPerimeter / 3;
        double working3 = working2 * working2;
        mArea = working1 * working3;

        mWorking =
                "A = (√3 / 4) × (P / 3)²" + "\n"
                        + "A = (" + sqrt3 + " / 4) × (" + mPerimeter + " / 3)²" + "\n"
                        + "A = " + working1 + " × " + working2 + "²" + "\n"
                        + "A = " + working1 + " × " + working3 + "\n"
                        + "A = " + mArea;

        return mArea;
    }

    public double areaArea (double area)
    {
        mArea = area;

        mWorking =
                "Area = " + mArea;

        return mArea;
    }

}
