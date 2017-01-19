package hr.unipu.inf.ma.studijskiprogramirh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.List;

public class UcilisteUnos extends AppCompatActivity { //UNOS ZA PRETRAŽIVANJE PO UČILIŠTU

    private Baza db;
    List<String> ucilista;
    public Spinner spinner;
    private String uciliste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uciliste_unos);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarUcilisteUnos);
        db = new Baza(this);
        ucilista = db.dohvatiUcilista();
        spinner = (Spinner) findViewById(R.id.spinner);

        if(ucilista.isEmpty()) { //ako je lista prazna - napuni bazu i pokušaj opet
            db.napuniBazu();
            recreate();
        }

        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle("Pretraživanje po učilištu");

        //animacija padajuceg elementa na ekranu za odabir
        RelativeLayout Rel = (RelativeLayout) findViewById(R.id.Rel3);
        Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down_animation);
        Rel.startAnimation(slide_down);

        //izbornik gradova u obliku spinnera
        spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.textview_rezultat, ucilista));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, //AdapterView: AdapterView gdje se dogodila selekcija
                                       View view, //View: view koji je kliknut
                                       int position, //int: pozicija view-a u adapteru
                                       long id) { //long: id retka stavke koja je selektirana
                uciliste = ucilista.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final ImageButton mybutton = (ImageButton) findViewById(R.id.uciliste_unos_button);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UcilisteUnos.this, UcilisteRezultatSastavnica.class);
                intent.putExtra("uciliste", uciliste);
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
                        Intent intent = new Intent(UcilisteUnos.this, UcilisteRezultatSastavnica.class);
                        intent.putExtra("uciliste", uciliste);
                        startActivity(intent);
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
        //'Odskočni' interpolator amplitude 0,2 i frekvencije 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        button_anim.setInterpolator(interpolator);
        mybutton.startAnimation(button_anim);
    }
}