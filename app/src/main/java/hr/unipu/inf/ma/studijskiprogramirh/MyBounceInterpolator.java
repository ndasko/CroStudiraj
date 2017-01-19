package hr.unipu.inf.ma.studijskiprogramirh;

/**
 * Created by Dijana on 20.11.2016..
 */

public class MyBounceInterpolator implements android.view.animation.Interpolator { //ZA 'ODSKOČNI' EFEKT ANIMACIJE BUTTONA NA EKRANU ZA UNOS

    double mAmplitude = 1;
    double mFrequency = 10;

    MyBounceInterpolator(double amplitude, double frequency) {
        mAmplitude = amplitude;
        mFrequency = frequency;
    }

    public float getInterpolation(float time) {
        return (float) (-1 * Math.pow(Math.E, -time/ mAmplitude) *
                Math.cos(mFrequency * time) + 1);
    }
}