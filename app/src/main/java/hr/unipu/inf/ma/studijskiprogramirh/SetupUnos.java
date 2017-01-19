package hr.unipu.inf.ma.studijskiprogramirh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

/**
 * Created by Dijana on 18.11.2016..
 */

public class SetupUnos extends AppCompatActivity { //METODA ZA POSTAVLJANJE PRIKAZA ZA UNOS NA SVAKOM OD TRI EKRANA (PO PODRUČJU, PO GRADU I PO UČILIŠTU)

    public void setup(int toolbar, String name, int relLay, int button) {

        Toolbar toolBar = (Toolbar) findViewById(toolbar);

        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle(name);

        //animacija padajuceg elementa na ekranu za unos
        RelativeLayout Rel = (RelativeLayout) findViewById(relLay);
        Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down_animation);
        Rel.startAnimation(slide_down);

        final ImageButton mybutton = (ImageButton) findViewById(button);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetupUnos.this, Rezultat.class);
                startActivity(intent);
            }
        });

        //efekt pritiska na gumb
        mybutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mybutton.setAlpha(.80f);
                        Intent i  = new Intent(SetupUnos.this, Rezultat.class);
                        startActivity(i);
                        return true;
                    case MotionEvent.ACTION_UP:
                        mybutton.setAlpha(1f);
                        return true;
                }
                return false;
            }
        });

        //animacija buttona na ekranu za unos
        final Animation button_anim = AnimationUtils.loadAnimation(this, R.anim.button_animation);
        // 'Odskočni' interpolator amplitude 0,2 i frekvencije 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        button_anim.setInterpolator(interpolator);
        mybutton.startAnimation(button_anim);
    }
}