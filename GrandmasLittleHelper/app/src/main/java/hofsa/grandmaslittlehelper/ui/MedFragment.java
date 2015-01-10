package hofsa.grandmaslittlehelper.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hofsa.grandmaslittlehelper.R;

/**
 * Created by Sam on 06.12.14.
 */
public class MedFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final List<String> MedikamentenListe = new ArrayList<String>();
        final View medFragment = inflater.inflate(R.layout.fragment_medfragment,container,false);
        final TextView headline = (TextView)medFragment.findViewById(R.id.MedFragment_Überschrift);
        final Button addMedButton = (Button)medFragment.findViewById(R.id.MedFragment_Knopf);
        addMedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MedikamentenListe.add("Beispielsmedikament ");

                ArrayAdapter<String> adapterMedikamenteHinzufuegen;
                adapterMedikamenteHinzufuegen = new ArrayAdapter<String>(MedFragment.this.getActivity(), android.R.layout.simple_list_item_1,MedikamentenListe);

                ListView lMed = (ListView)medFragment.findViewById(R.id.MedFragment_Liste);
                lMed.setAdapter(adapterMedikamenteHinzufuegen);

                headline.setText(getActivity().getString(R.string.medview_medikament_hinzufügt));
            }
        });
        headline.setText(R.string.medview_überschrift);

        return medFragment;

    }
}
