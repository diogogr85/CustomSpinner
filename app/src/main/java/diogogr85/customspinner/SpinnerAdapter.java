package diogogr85.customspinner;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diogogr85 on 20/09/16.
 */
public class SpinnerAdapter extends ArrayAdapter<String> {

    private final Context mContext;

    public SpinnerAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        mContext = context.getApplicationContext();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view = super.getView(position, convertView, parent);

        final TextView textView = (TextView) view;
        textView.setTextSize(16);
        if(position == 0) {
            textView.setTypeface(null, Typeface.ITALIC);
            textView.setTextColor(ContextCompat.getColor(mContext, android.R.color.darker_gray));
        } else {
            textView.setTextColor(ContextCompat.getColor(mContext, android.R.color.black));
        }

        //eliminate inner padding
        view.setPadding(0, 0, 0, 0);

        return view;
    }

//    @Override
//    public void setDropDownViewResource(int resource) {
//        super.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//    }
}
