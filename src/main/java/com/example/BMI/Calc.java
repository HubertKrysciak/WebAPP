package com.example.BMI;

import java.text.DecimalFormat;

public class Calc {
    public static float bmi(float w, float h){
        float calcbmi = (float) (w/(Math.pow(h, 2)));
        return calcbmi;
    }
}