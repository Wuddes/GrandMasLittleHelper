package hofsa.grandmaslittlehelper.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import hofsa.grandmaslittlehelper.R;

/**
 * Created by Sam on 06.12.14.
 */
public class StartFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View startFragment = inflater.inflate(R.layout.fragment_startfragment,container,false);
        TextView textView = (TextView)startFragment.findViewById(R.id.StartFragment_WillkommenText);
        final Button startButton = (Button)startFragment.findViewById(R.id.StartFragment_Knopf);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startButton.setText(getActivity().getString(R.string.button_text_mod));
            }
        });
        textView.setText("Willkommen 2");

        return startFragment;

    }
}
