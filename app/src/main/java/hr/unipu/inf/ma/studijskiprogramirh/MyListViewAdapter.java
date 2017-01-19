package hr.unipu.inf.ma.studijskiprogramirh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Dijana on 6.1.2017..
 */

public class MyListViewAdapter extends BaseAdapter { //LISTVIEW ADAPTER VEZAN ZA SEARCHVIEW

    Context mContext;
    LayoutInflater inflater;
    private List<Podrucje> podrucjeList = null;
    private ArrayList<Podrucje> arraylist;

    public MyListViewAdapter(Context context, List<Podrucje> podrucjeList) {
        mContext = context;
        this.podrucjeList = podrucjeList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Podrucje>();
        this.arraylist.addAll(podrucjeList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return podrucjeList.size();
    }

    @Override
    public Podrucje getItem(int position) {
        return podrucjeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            //lociranje TextView-a u xml-u
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //postavlja rezultate u TextView
        holder.name.setText(podrucjeList.get(position).getPodrucje());
        return view;
    }

    //filter klasa
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        podrucjeList.clear();
        if (charText.length() == 0) {
            podrucjeList.addAll(arraylist);
        } else {
            for (Podrucje wp : arraylist) {
                if (wp.getPodrucje().toLowerCase(Locale.getDefault()).contains(charText)) {
                    podrucjeList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}