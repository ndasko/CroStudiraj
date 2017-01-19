package hr.unipu.inf.ma.studijskiprogramirh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class UcilisteFragment extends Fragment { //FRAGMENT VEZAN ZA PRETRAŽIVANJE PO UČILIŠTU

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_uciliste, container, false);

        final ImageButton UcilisteButton = (ImageButton) v.findViewById(R.id.uciliste_button);
        UcilisteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UcilisteUnos.class);
                startActivity(intent);
            }
        });

        //efekt pritiska na gumb 'Pretraživanje po učilištu'
        UcilisteButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        UcilisteButton.setAlpha(.80f);
                        Intent i  = new Intent(getActivity(), UcilisteUnos.class);
                        startActivity(i);
                        return true;
                    case MotionEvent.ACTION_UP:
                        UcilisteButton.setAlpha(1f);
                        return true;
                }
                return false;
            }
        });

        return v;
    }
}