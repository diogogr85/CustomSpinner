package diogogr85.customspinner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatSpinner;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.*;
import diogogr85.customspinner.SpinnerAdapter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by diogogr85 on 20/09/16.
 */
public class TextHintSpinner extends AppCompatSpinner {

    public TextHintSpinner(Context context, AttributeSet attrs) {
        this(context, attrs, R.style.CustomSpinner_Spinner);
        buildView(context, attrs);
    }

    public TextHintSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        buildView(context, attrs);
    }

    public TextHintSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
        buildView(context, attrs);
    }

    public TextHintSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode, Resources.Theme popupTheme) {
        super(context, attrs, defStyleAttr, mode, popupTheme);
        buildView(context, attrs);
    }

    private void buildView(Context context, AttributeSet attrs){
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.TextHintSpinner);

        boolean showHint;
        String hint = "";
        int dropDownResource = android.R.layout.simple_spinner_dropdown_item;
        int viewResource = android.R.layout.simple_spinner_item;
        final ArrayList<String> mEntriesValuesArray = new ArrayList<>();

        for(int i = 0; i < attributes.length(); i++) {
            int attr = attributes.getIndex(i);
//            if (attr == R.styleable.TextHintSpinner_showHint) {
//                showHint = attributes.getBoolean(attr, false);
//            } else
            if (attr == R.styleable.TextHintSpinner_hintText) {
                hint = attributes.getString(attr);
            } else if (attr == R.styleable.TextHintSpinner_dropdownResource) {
                dropDownResource = attributes.getResourceId(attr, android.R.layout.simple_spinner_dropdown_item);
            } else if (attr == R.styleable.TextHintSpinner_viewResource) {
                viewResource = attributes.getResourceId(attr, android.R.layout.simple_spinner_item);
            } else if (attr == R.styleable.TextHintSpinner_entries) {
                final CharSequence[] values = attributes.getTextArray(attr);
                if (values != null) {
                    if (!TextUtils.isEmpty(hint)) {
                        mEntriesValuesArray.add(hint);
                    }

                    for (CharSequence cs : values) {
                        mEntriesValuesArray.add(cs.toString());
                    }
                }
            }
        }

        attributes.recycle();
        final SpinnerAdapter adapter = new SpinnerAdapter(context, viewResource, mEntriesValuesArray);
        adapter.setDropDownViewResource(dropDownResource);
        setAdapter(adapter);

    }
}
