package hr.unipu.inf.ma.studijskiprogramirh;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class GradRezultatSastavnica extends AppCompatActivity { //EKRAN SA LISTOM SVIH SASTAVNICA PRETHODNO ODABRANOG UČILIŠTA

    private Baza db;
    private ListView listView;
    private String data;
    private String sastavnica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grad_rezultat_sastavnica);

        db = new Baza(this);
        listView = (ListView) findViewById(R.id.list_view);
        data = getIntent().getExtras().getString("uciliste","uciliste");

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarGradRezultatSastavnica);
        toolBar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle(data);

        final List<String> odabraneSastavnice = db.dohvatiOdabraneSastavnice(data);
        listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.textview_rezultat, odabraneSastavnice));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent (GradRezultatSastavnica.this, GradRezultat.class);
                sastavnica = odabraneSastavnice.get(position);
                intent.putExtra("sastavnica", sastavnica);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.screen_animation,R.anim.screen_animation2).toBundle();
                startActivity(intent, bndlanimation);
            }
        });
    }
}