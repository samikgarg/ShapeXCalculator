package com.samazebra.mathematicalgeometrycalculator;

public class Square
{
    private double mSideLength;
    private double mDiagonal;
    private double mPerimeter;
    private double mArea;

    private double sqrt2 = Math.sqrt (2);

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

    public double sideLengthDiagonal (double diagonal)
    {
        mDiagonal = diagonal;
        mSideLength = mDiagonal / sqrt2;

        mWorking =
            "l = d / √2" + System.getProperty ("line.separator")
                    + "l =" + " " + mDiagonal + " " + "/" + " " + sqrt2 + System.getProperty ("line.separator")
                    + "l =" + " " + mSideLength;

        return mSideLength;
    }

    public double sideLengthPerimeter (double perimeter)
    {
        mPerimeter = perimeter;
        mSideLength = mPerimeter / 4;

        mWorking =
                "l = P / 4" + System.getProperty ("line.separator")
                + "l =" + " " + mPerimeter + " " + "/" + " " + "4" + System.getProperty ("line.separator")
                + "l =" + " " + mSideLength;

        return mSideLength;
    }

    public double sideLengthArea (double area)
    {
        mArea = area;
        mSideLength = Math.sqrt (mArea);

        mWorking =
                "l = √A" + System.getProperty ("line.separator")
                 + "l = √" + mArea + System.getProperty ("line.separator")
                 + "l =" + " " + mSideLength;

        return mSideLength;
    }


    public double diagonalSideLength (double sideLength)
    {
        mSideLength = sideLength;
        mDiagonal = sqrt2 * mSideLength;

        mWorking =
                "d = √2 × l" + System.getProperty ("line.separator")
                        + "d =" + " " + sqrt2 + " " + "×" + " " + mSideLength + System.getProperty ("line.separator")
                        + "d =" + " " + mDiagonal;

        return mDiagonal;
    }

    public double diagonalDiagonal (double diagonal)
    {
        mDiagonal = diagonal;

        mWorking =
                "Diagonal =" + " " + mDiagonal;

        return mDiagonal;
    }

    public double diagonalPerimeter (double perimeter)
    {
        mPerimeter = perimeter;
        mSideLength = mPerimeter / 4;
        mDiagonal = sqrt2 * mSideLength;

        double working = sqrt2 * mPerimeter;

        mWorking =
                "d = (√2 × P) / 4" + System.getProperty ("line.separator")
                 + "d =" + " " + "(" + sqrt2 + " " + "×" + " " + mPerimeter + ")" + " " + "/" + " " + "4" + System.getProperty ("line.separator")
                 + "d =" + " " + working + " " + "/" + " " + "4" + System.getProperty ("line.separator")
                 + "d =" + " " + mDiagonal;

        return mDiagonal;
    }

    public double diagonalArea (double area)
    {
        mArea = area;
        mSideLength = Math.sqrt (mArea);
        mDiagonal = sqrt2 * mSideLength;

        double working = 2 * mArea;

        mWorking =
                "d = √(2 × A)" + System.getProperty ("line.separator")
                        + "d = (√2 ×" + " " + mArea + ")" + System.getProperty ("line.separator")
                        + "d =" + " " + "√" + working + System.getProperty ("line.separator")
                        + "d =" + " " + mDiagonal;

        return mDiagonal;
    }


    public double perimeterSideLength (double sideLength)
    {
        mSideLength = sideLength;
        mPerimeter = mSideLength * 4;

        mWorking =
                "P = l × 4" + System.getProperty ("line.separator")
                + "P =" + " " + mSideLength + " " + "× 4" + System.getProperty ("line.separator")
                + "P =" + " " + mPerimeter;

        return mPerimeter;
    }

    public double perimeterDiagonal (double diagonal)
    {
        mDiagonal = diagonal;
        mSideLength = mDiagonal / sqrt2;
        mPerimeter = mSideLength * 4;

        double working = 4 * mDiagonal;

        mWorking =
                "P = (4 × d) / √2" + System.getProperty ("line.separator")
                        + "P =" + " " + "(4 ×" + " " + mDiagonal + ")" + " " + "/" + " " + "√2" + System.getProperty ("line.separator")
                        + "P =" + " " + working + " " + "/" + " " + sqrt2 + System.getProperty ("line.separator")
                        + "P =" + " " + mPerimeter;

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
        mSideLength = Math.sqrt (mArea);
        mPerimeter = mSideLength * 4;

        mWorking =
                "P = 4 × √A" + System.getProperty ("line.separator")
                + "P = 4 × √" + mArea + System.getProperty ("line.separator")
                + "P = 4 ×" + " " + mSideLength + System.getProperty ("line.separator")
                + "P =" + " " + mPerimeter;

        return mPerimeter;
    }


    public double areaSideLength (double sideLength)
    {
        mSideLength = sideLength;
        mArea = mSideLength * mSideLength;

        mWorking =
                "A = l²" + System.getProperty ("line.separator")
                + "A =" + " " + mSideLength + "²" + System.getProperty ("line.separator")
                + "A =" + " " + mArea;

        return mArea;
    }


    public double areaDiagonal (double diagonal)
    {
        mDiagonal = diagonal;
        mSideLength = mDiagonal / sqrt2;
        mArea = mSideLength * mSideLength;

        double working = mDiagonal * mDiagonal;

        mWorking =
                "A = d² / 2" + System.getProperty ("line.separator")
                + "A =" + " " + mDiagonal + "²" + " " + "/" + " " + "2" + System.getProperty ("line.separator")
                + "A =" + " " + working + " " + "/" + " " + "2" + System.getProperty ("line.separator")
                + "A =" + " " + mArea;

        return mArea;
    }


    public double areaPerimeter (double perimeter)
    {
        mPerimeter = perimeter;
        mSideLength = mPerimeter / 4;
        mArea = mSideLength * mSideLength;

        double working = mPerimeter * mPerimeter;

        mWorking =
                "A = P² / 16" + System.getProperty ("line.separator")
                + "A =" + " " + mPerimeter + "²" + " " + "/" + " " + "16" + System.getProperty ("line.separator")
                + "A =" + " " + working + " " + "/" + " " + "16" + System.getProperty ("line.separator")
                + "A =" + " " + mArea;

        return mArea;
    }

    public double areaArea (double area)
    {
        mArea = area;

        mWorking =
                "Area =" + " " + mArea;

        return mArea;
    }

}
