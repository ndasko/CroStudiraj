package hr.unipu.inf.ma.studijskiprogramirh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class GradFragment extends Fragment { //FRAGMENT VEZAN ZA PRETRAŽIVANJE PO GRADU

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_grad, container, false);

        final ImageButton GradButton = (ImageButton) v.findViewById(R.id.grad_button);
        GradButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GradUnos.class);
                startActivity(intent);
            }
        });

        //efekt pritiska na gumb 'Pretraživanje po gradu'
        GradButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        GradButton.setAlpha(.80f);
                        Intent i  = new Intent(getActivity(), GradUnos.class);
                        startActivity(i);
                        return true;
                    case MotionEvent.ACTION_UP:
                        GradButton.setAlpha(1f);
                        return true;
                }
                return false;
            }
        });

        return v;
    }
}