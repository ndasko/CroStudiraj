package hr.unipu.inf.ma.studijskiprogramirh;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

public class RezultatDemo extends AppCompatActivity { //testna klasa; rezultat u obliku listview-a, nakon unosa pretraživanja

    private ListView listView;
    private Baza db;
    List<Program> sviProgrami;
    List<String> ucilista;
    List<String> polja;
    private Spinner spinner2;
    private Spinner spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listdb_rezultat);

        //dohvaćanje baze
        db = new Baza(this);
        //spremanje svih programa u listu
        ucilista = db.dohvatiUcilista();
        polja = db.dohvatiPolja();
        if(sviProgrami.isEmpty()) {
            //ako je lista prazna - napuni bazu i pokušaj opet
            db.napuniBazu();
            recreate();
        }

        //izgled liste
        ArrayAdapter<Program> adapter = new ArrayAdapter<Program>(this, R.layout.textview_rezultat, sviProgrami);

        listView = (ListView) findViewById(R.id.list_view);
        //postavljanje adaptera na listu
        listView.setAdapter(adapter);
        listView.setBackgroundColor(Color.parseColor("#FFD587"));


        /* spinner = (Spinner) findViewById(R.id.spinner2);
        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, ucilista));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                List<String> odabranaPolja = db.dohvatiOdabranaPolja(ucilista.get(position));
                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, odabranaPolja));
                Log.d("onitemselected", "onItemSelected: " +odabranaPolja);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner = (Spinner) findViewById(R.id.spinner3);
        spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, polja));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                List<String> odabranaUcilist = db.dohvatiOdabranaUcilist(ucilista.get(position));
                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, odabranaUcilist));
                Log.d("onitemselected", "onItemSelected: " +odabranaUcilist);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spinner2 = (Spinner) findViewById(R.id.spinner2);
        //spinner2.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, ucilista));

        //spinner3 = (Spinner) findViewById(R.id.spinner3);
        //spinner3.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, polja));
        */
    }
}