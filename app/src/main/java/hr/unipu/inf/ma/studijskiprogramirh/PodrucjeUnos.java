package hr.unipu.inf.ma.studijskiprogramirh;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class PodrucjeUnos extends SetupUnos implements SearchView.OnQueryTextListener { //UNOS ZA PRETRAŽIVANJE PO PODRUČJU (SAMO PRIMJER)

    ListView list;
    MyListViewAdapter adapter;
    SearchView editsearch;
    String[] podrucjeList;
    ArrayList<Podrucje> arraylist = new ArrayList<Podrucje>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podrucje_unos);

        setup(R.id.toolbarPodrucjeUnos, "Pretraživanje po području", R.id.Rel1, R.id.podrucje_unos_button);

        podrucjeList = new String[]{"Aeronautika", "Biologija", "Dizajn",
                "Ekonomija", "Poduzetništvo", "Geografija", "Strojarstvo", "Financije",
                "Brodogradnja","Informatika","Medicina"};

        list = (ListView) findViewById(R.id.list_view);

        for (int i = 0; i < podrucjeList.length; i++) {
            Podrucje podrucje = new Podrucje(podrucjeList[i]);
            arraylist.add(podrucje);
        }

        //prosljeđuje rezultate klasi MyListViewAdapter
        adapter = new MyListViewAdapter(this, arraylist);

        //veže Adapter na ListView
        list.setAdapter(adapter);

        //lociranje EditText-a u xml-u
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}