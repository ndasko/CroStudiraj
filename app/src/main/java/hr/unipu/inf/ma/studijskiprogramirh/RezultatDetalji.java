package hr.unipu.inf.ma.studijskiprogramirh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RezultatDetalji extends AppCompatActivity { //KRAJNJI REZULTAT PRETRAŽIVANJA, POSLJEDNJI DETALJIZIRANI EKRAN

    String[] detailsArray = {"SVEUČILIŠTE:","STUDIJ:","VRSTA:","ZNANOST:","POLJE:","TRAJANJE:",
            "ECTS:","TITULA:","URL:"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultat_detalji);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.listview_rezultat_details, detailsArray);

        ListView listView = (ListView) findViewById(R.id.details_list);
        listView.setAdapter(adapter);
    }
}
