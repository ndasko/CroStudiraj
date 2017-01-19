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

public class GradRezultatUciliste extends AppCompatActivity { //EKRAN SA LISTOM SVIH UČILIŠTA PRETHODNO ODABRANOG GRADA

    private Baza db;
    private ListView listView;
    private String data;
    private String uciliste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grad_rezultat_uciliste);

        db = new Baza(this);
        listView = (ListView) findViewById(R.id.list_view);
        data = getIntent().getExtras().getString("grad","Zagreb");

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarGradRezultat);
        toolBar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle(data);

        final List<String> odabranaUcilista = db.dohvatiOdabranaUcilista(data); //lista dohvaća odabrana učilišta po gradu, grad se označava iz liste gradova
        listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.textview_rezultat, odabranaUcilista)); //način na koji se liste iz jave pretvaraju u liste na ekranu

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent (GradRezultatUciliste.this, GradRezultatSastavnica.class);
                uciliste = odabranaUcilista.get(position);
                intent.putExtra("uciliste", uciliste);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.screen_animation,R.anim.screen_animation2).toBundle();
                startActivity(intent, bndlanimation);
            }
        });
    }
}
