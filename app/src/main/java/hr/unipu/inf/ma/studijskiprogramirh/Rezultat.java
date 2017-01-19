package hr.unipu.inf.ma.studijskiprogramirh;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

/**
 * Created by Dijana on 7.1.2017..
 */

public class Rezultat extends AppCompatActivity { //REZULTAT U OBLIKU LISTVIEW-A, NAKON PRETRAŽIVANJA

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_rezultat);

        //dohvaćanje listview-a
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.rezultat_list);

        //pripremanje podataka listview-a
        String[] data = {"Učilište 1", "Učilište 2"};

        //adapter za omogućavanje pristupa data elementima
        MyBaseAdapter adapter = new MyBaseAdapter(getApplicationContext(), data);

        //postavljanje list adaptera
        listView.setAdapter(adapter);

        //novi intent vezan za krajnji detaljizirani rezultat pretraživanja, zadnji ekran, uz animaciju
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent slideactivity = new Intent(Rezultat.this, RezultatDetalji.class);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.screen_animation,R.anim.screen_animation2).toBundle();
                startActivity(slideactivity, bndlanimation);
                return true;
            }
        });
    }
}