package com.samazebra.mathematicalgeometrycalculator;

public class Circle
{
    public static double PI = 3;

    private double mRadius;
    private double mDiameter;
    private double mCircumference;
    private double mArea;

    private String mWorking;


    public String getWorking()
    {
        return mWorking;
    }


    public double radiusRadius (double radius)
    {
        mRadius = radius;

        mWorking = "Radius =" + " " + mRadius;

        return mRadius;
    }

    public double radiusDiameter (double diameter)
    {
        mDiameter = diameter;
        mRadius = mDiameter / 2;

        mWorking =
                "r = d / 2" + System.getProperty ("line.separator")
                        + "r =" + " " + mDiameter + " " + "/ 2" + System.getProperty ("line.separator")
                        + "r =" + " " + mRadius;

        return mRadius;
    }

    public double radiusCircumference (double circumference)
    {
        mCircumference = circumference;
        double working = 2 * Circle.PI;
        mRadius = mCircumference / working;

        mWorking =
                "r = C / 2 × π" + System.getProperty ("line.separator")
                + "r =" + " " + mCircumference + " " + "/ 2 ×" + " " + Circle.PI + System.getProperty ("line.separator")
                + "r =" + " " + mCircumference + " " + "/" + " " + working + System.getProperty ("line.separator")
                + "r =" + " " + mRadius;


        return mRadius;
    }

    public double radiusArea (double area)
    {
        mArea = area;
        double working = mArea / Circle.PI;
        mRadius = Math.sqrt (working);

        mWorking =
                "r = √(A / π)" + System.getProperty ("line.separator")
                        + "r =" + " " + "√(" + mArea + " " + "/" + " " + Circle.PI + ")" + System.getProperty ("line.separator")
                        + "r =" + " " + "√" + working + System.getProperty ("line.separator")
                        + "r =" + " " + mRadius;

        return mRadius;
    }


    public double diameterDiameter (double diameter)
    {
        mDiameter = diameter;

        mWorking = "Diameter =" + " " + mDiameter;

        return mDiameter;
    }

    public double diameterRadius (double radius)
    {
        mRadius = radius;
        mDiameter = mRadius * 2;

        mWorking =
                "d = r × 2" + System.getProperty ("line.separator")
                        + "d =" + " " + mRadius + " " + "×" + " " + "2" + System.getProperty ("line.separator")
                        + "d =" + " " + mDiameter;

        return mDiameter;
    }

    public double diameterCircumference (double circumference)
    {
        mCircumference = circumference;
        mDiameter = mCircumference / Circle.PI;

        mWorking =
                "d = C / π" + System.getProperty ("line.separator")
                        + "d =" + " " + mCircumference + " " + "/" + " " + Circle.PI + System.getProperty ("line.separator")
                        + "d =" + " " + mDiameter;

        return mDiameter;
    }

    public double diameterArea (double area)
    {
        mArea = area;
        double working = mArea / Circle.PI;
        double working2 = Math.sqrt (working);
        mDiameter = 2 * working2;

        mWorking =
                "d = 2 × √(A / π)" + System.getProperty ("line.separator")
                        + "d = 2 × √(" + mArea + " " + "/" + " " + Circle.PI + ")" + System.getProperty ("line.separator")
                        + "d = 2 × √" + working + System.getProperty ("line.separator")
                        + "d = 2 ×" + " " + working2 + System.getProperty ("line.separator")
                        + "d =" + " " + mDiameter;

        return mDiameter;
    }


    public double circumferenceCircumference (double circumference)
    {
        mCircumference = circumference;

        mWorking = "Circumference =" + " " + mCircumference;

        return mCircumference;
    }

    public double circumferenceRadius (double radius)
    {
        mRadius = radius;
        double working = 2 * Circle.PI;
        mCircumference = mRadius * working;

        mWorking =
                "C = 2 × π × r" + System.getProperty ("line.separator")
                + "C = 2 ×" + " " + Circle.PI + " " + "×" + " " + mRadius + System.getProperty ("line.separator")
                + "C =" + " " + working + " " + "×" + " " + mRadius + System.getProperty ("line.separator")
                + "C =" + " " + mCircumference;

        return mCircumference;
    }

    public double circumferenceDiameter (double diameter)
    {
        mDiameter = diameter;
        mCircumference = diameter * Circle.PI;

        mWorking =
                "C = π × d" + System.getProperty ("line.separator")
                + "C =" + " " + Circle.PI + " " + "×" + " " + mDiameter + System.getProperty ("line.separator")
                + "C =" + " " + mCircumference;

        return mCircumference;
    }

    public double circumferenceArea (double area)
    {
        mArea = area;

        double working = mArea * Circle.PI;
        double working2 = Math.sqrt(working);
        mCircumference = 2 * working2;

        mWorking =
               "C = 2 × √(A × π)" + System.getProperty("line.separator")
                       + "C = 2 × √(" + mArea + " " + "×" + " " + Circle.PI + ")" + System.getProperty("line.separator")
                       + "C = 2 × √" + working + System.getProperty("line.separator")
                       + "C = 2 ×" + " " + working2 + System.getProperty("line.separator")
                       + "C =" + " " + mCircumference;

        return mCircumference;
    }


    public double areaArea (double area)
    {
        mArea = area;

        mWorking = "Area =" + " " + mArea;

        return mArea;
    }

    public double areaRadius (double radius)
    {
        mRadius = radius;
        double working = mRadius * mRadius;
        mArea = Circle.PI * working;

        mWorking =
                "A = π × r²" + System.getProperty ("line.separator")
                        + "A =" + " " + Circle.PI + " " + "×" + " " + mRadius + "²" + System.getProperty ("line.separator")
                        + "A =" + " " + Circle.PI + " " + "×" + " " + working + System.getProperty ("line.separator")
                        + "A =" + " " + mArea;

        return mArea;
    }

    public double areaDiameter (double diameter)
    {
        mDiameter = diameter;
        double working = mDiameter * mDiameter;
        double working2 = Circle.PI * working;
        mArea = working2 / 4;

        mWorking =
                "A = (π × d²) / 4" + System.getProperty ("line.separator")
                + "A = (" + Circle.PI + " " + "×" + " " + mDiameter + "²) / 4" + System.getProperty ("line.separator")
                + "A = (" + Circle.PI + " " + "×" + " " + working + ") / 4" + System.getProperty ("line.separator")
                + "A =" + " " + working2 + " " + "/ 4" + System.getProperty ("line.separator")
                + "a =" + " " + mArea;

        return mArea;
    }

    public double areaCircumference (double circumference)
    {
        mCircumference = circumference;
        double working = mCircumference * mCircumference;
        double working2 = 4 * Circle.PI;
        mArea = working / working2;

        mWorking =
                "A = C² / (4 × π)" + System.getProperty ("line.separator")
                        + "A =" + " " + mCircumference + "² / (4 ×" + " " + Circle.PI + ")" + System.getProperty ("line.separator")
                        + "A =" + " " + working + " " + "/" + " " + working2 + System.getProperty ("line.separator")
                        + "A =" + " " + mArea;

        return mArea;
    }


}
