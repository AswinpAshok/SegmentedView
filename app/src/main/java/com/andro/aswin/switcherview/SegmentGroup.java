package com.andro.aswin.switcherview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.autofill.AutofillValue;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

/**
 * Created by ASWIN on 1/23/2018.
 */

public class SegmentGroup extends RadioGroup {
    private Paint mBoarderPaint;
    private int mBoarderColor;
    private float mBoarderSize;
    private RectF bounds;
    private int defaultBlue;


    public SegmentGroup(Context context, AttributeSet attrs) {
        super(context, attrs);

        setWillNotDraw(false);
        defaultBlue=Color.parseColor("#007bff");

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.SegmentGroup,
                0, 0);
        try {

//            mBoarderSize=a.getDimensionPixelSize(R.styleable.SwitcherGroup_boarderWidth,0);
//            Log.d("######", "SwitcherGroup: "+mBoarderSize);
            mBoarderColor=a.getColor(R.styleable.SegmentGroup_boarderColor,defaultBlue);
            Log.d("####", "SwitcherGroup: def blue "+defaultBlue+" boarder color : "+mBoarderColor);


        } finally {
            a.recycle();
        }

        mBoarderSize=3 * getResources().getDisplayMetrics().density;

        mBoarderPaint=new Paint();
        mBoarderPaint.setAntiAlias(true);
        mBoarderPaint.setColor(mBoarderColor);
        mBoarderPaint.setStrokeWidth(5);
        mBoarderPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        super.setOnHierarchyChangeListener(listener);
    }

    @Override
    protected void onFinishInflate() {

        super.onFinishInflate();
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
    }

    @Override
    public void check(int id) {
        super.check(id);
    }

    @Override
    public int getCheckedRadioButtonId() {
        return super.getCheckedRadioButtonId();
    }

    @Override
    public void clearCheck() {
        super.clearCheck();
    }

    @Override
    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        super.setOnCheckedChangeListener(listener);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return super.generateLayoutParams(attrs);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return super.checkLayoutParams(p);
    }

    @Override
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }

    @Override
    public void onProvideAutofillStructure(ViewStructure structure, int flags) {
        super.onProvideAutofillStructure(structure, flags);
    }

    @Override
    public void autofill(AutofillValue value) {
        super.autofill(value);
    }

    @Override
    public int getAutofillType() {
        return super.getAutofillType();
    }

    @Override
    public AutofillValue getAutofillValue() {
        return super.getAutofillValue();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        bounds=new RectF();
        bounds.set(5,5,getMeasuredWidth()-5,getMeasuredHeight()-5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(bounds,10,10,mBoarderPaint);
    }


}
