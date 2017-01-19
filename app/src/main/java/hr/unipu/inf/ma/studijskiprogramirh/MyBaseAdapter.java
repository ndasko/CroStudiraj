package hr.unipu.inf.ma.studijskiprogramirh;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by Dijana on 22.11.2016..
 */

public class MyBaseAdapter extends BaseExpandableListAdapter { //ZA PRUŽANJE PODATAKA I VIEW-A IZ ODREĐENIH PODATAKA U OBLIKU 'PROŠIRIVOG' LISTVIEW-A

    private Context context;

    private String[] data;

    MyBaseAdapter(Context context, String[] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getGroupCount() {
        return data.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data[childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    //vraća view za grupe, stavke
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String listTitle = data[groupPosition];
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_rezultat_group, null);
        }
        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        listTitleTextView.setBackgroundColor(Color.parseColor("#FFB939"));
        return convertView;
    }

    @Override
    //vraća view za podgrupe, podstavke
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String expandedListText = data[groupPosition];
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_rezultat_item, null);
        }
        TextView expandedListTextView = (TextView) convertView.findViewById(R.id.expandedListItem);
        expandedListTextView.setTypeface(null, Typeface.BOLD);
        expandedListTextView.setText(expandedListText);
        expandedListTextView.setBackgroundColor(Color.parseColor("#FFD587"));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}