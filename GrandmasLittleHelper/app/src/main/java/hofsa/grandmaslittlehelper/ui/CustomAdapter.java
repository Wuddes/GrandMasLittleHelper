package hofsa.grandmaslittlehelper.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import hofsa.grandmaslittlehelper.R;
import hofsa.grandmaslittlehelper.core.data.Drug;

public class CustomAdapter extends ArrayAdapter {

    private Context context;
    private int resource;
    private LayoutInflater inflater;

    public CustomAdapter (Context context, List<Drug> values) { // or String[][] or whatever

        super(context, R.layout.customlistview, values);

        this.context = context;
        this.resource = R.layout.customlistview;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = (RelativeLayout) inflater.inflate(resource, null);

        Drug item = (Drug) getItem(position);

        TextView textviewTitle = (TextView) convertView.findViewById(R.id.customlistviewTitle);
        TextView textviewSubtitle = (TextView) convertView.findViewById(R.id.customlistviewSubtitle);
        ImageView imageview = (ImageView) convertView.findViewById(R.id.customlistviewImage);

        //fill the textviews and imageview with the values
        textviewTitle.setText(item.getName());
        textviewSubtitle.setText(item.getAffliction());

        Drawable image = context.getResources().getDrawable(R.drawable.k19360733);
        imageview.setImageDrawable(image);

        return convertView;
    }
}