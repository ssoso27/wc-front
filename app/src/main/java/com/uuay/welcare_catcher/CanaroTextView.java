package com.uuay.welcare_catcher;

import android.content.Context;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatTextView;

/**
 * Created by Dmytro Denysenko on 5/6/15.
 */
public class CanaroTextView extends AppCompatTextView {
    public CanaroTextView(Context context) {
        this(context, null);
    }

    public CanaroTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanaroTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(GlobalApplication.canaroExtraBold);
    }

}
