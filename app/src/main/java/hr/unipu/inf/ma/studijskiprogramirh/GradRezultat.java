package hr.unipu.inf.ma.studijskiprogramirh;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GradRezultat extends AppCompatActivity { //KRAJNJI REZULTAT PRETRAŽIVANJA PO GRADU, POSLJEDNJI DETALJIZIRANI EKRAN

    private Baza db;
    private String sastavnica;
    Program detalji;
    String[] detailsArray = {
            "STUDIJ: ", //0
            "POLJE: ", //1
            "TRAJANJE: ", //2
            "ECTS: ", //3
            "TITULA: ", //4
            "URL: " //5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grad_rezultat);

        sastavnica = getIntent().getExtras().getString("sastavnica","sastavnica");

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbarRezultat);
        toolBar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle(sastavnica);

        //pronalaze se detalji odabrane sastavnice iz baze
        //u svaki element detailsArray-a dodaje se odgovarajući podatak
        db = new Baza(this);
        detalji = db.dohvatiDetaljeSastavnice(sastavnica);
        detailsArray[0] += detalji.getStudij();
        detailsArray[1] += detalji.getPolje();
        detailsArray[2] += detalji.getTrajanje();
        detailsArray[3] += detalji.getEcts();
        detailsArray[4] += detalji.getTitula();
        detailsArray[5] += detalji.getUrl();

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.listview_rezultat_details, detailsArray);
        ListView listView = (ListView) findViewById(R.id.details_list);
        listView.setAdapter(adapter);
    }
}