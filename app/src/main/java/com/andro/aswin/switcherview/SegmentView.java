package com.andro.aswin.switcherview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * Created by ASWIN on 1/20/2018.
 */

public class SegmentView extends android.support.v7.widget.AppCompatRadioButton {

    private String mText;
    private float mTextSize,mBoarderSize;
    private Paint mTextPaintSelected,mTextPaintNormal,mBackgroundPaint;
    private RectF bounds;
    private float mTextHeight,mTextWidth;
    private float paddingLeft,paddingBottom;
    private int finalViewHeight,finalViewWidth;
    private int selectionColor,textColorNormal,textColorSelected;
    private int defaultBlue;
    private boolean isLastSegment=false;
    private boolean isFirstSegment=false;
    private RectF lastSegmentRectf,firstSegmentRectf;
    private String TAG="#####";




    public SegmentView(Context context, AttributeSet attrs) {
        super(context, attrs);

        defaultBlue=Color.parseColor("#007bff");
        bounds=new RectF();
        lastSegmentRectf=new RectF();
        firstSegmentRectf=new RectF();

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.SegmentView,
                0, 0);
        try {
            mText = a.getString(R.styleable.SegmentView_text);
            mTextSize=a.getDimensionPixelSize(R.styleable.SegmentView_textSize,0);
            selectionColor=a.getColor(R.styleable.SegmentView_selectionColor,defaultBlue);
            textColorNormal=a.getColor(R.styleable.SegmentView_textColorNormal,defaultBlue);
            textColorSelected=a.getColor(R.styleable.SegmentView_textColorSelected,Color.WHITE);
            selectionColor=a.getColor(R.styleable.SegmentView_selectionColor,defaultBlue);
            isLastSegment=a.getBoolean(R.styleable.SegmentView_isLastSegment,false);
            isFirstSegment=a.getBoolean(R.styleable.SegmentView_isFirstSegment,false);

        } finally {
            a.recycle();
        }

        if(isLastSegment){
            lastSegmentRectf=new RectF();
            lastSegmentRectf.set(0,5,getWidth()-5,getHeight()-5);
        }else {
            lastSegmentRectf=new RectF();
            lastSegmentRectf.set(0,5,getWidth()-5,getHeight()-5);
        }

        mBackgroundPaint=new Paint();
        mBackgroundPaint.setColor(selectionColor);
        mBackgroundPaint.setStrokeWidth(10);


        mTextPaintNormal=new Paint();
        mTextPaintNormal.setAntiAlias(true);
        mTextPaintNormal.setColor(textColorNormal);
        mTextPaintNormal.setTextSize(mTextSize);

        mTextPaintSelected=new Paint();
        mTextPaintSelected.setAntiAlias(true);
        mTextPaintSelected.setColor(textColorSelected);
        mTextPaintSelected.setTextSize(mTextSize);

        paddingLeft=25 * getResources().getDisplayMetrics().density;
        paddingBottom=10 * getResources().getDisplayMetrics().density;

        Rect textBounds=new Rect();
        Rect hackBound=new Rect();
        mTextPaintNormal.getTextBounds(mText,0,mText.length(),textBounds);
        mTextPaintNormal.getTextBounds("hlqj",0,4,hackBound);

        mTextHeight=hackBound.height();
        mTextWidth=textBounds.width();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        finalViewHeight= (int) (mTextHeight+(2*paddingBottom));

        finalViewWidth= (int) (mTextWidth+(2*paddingLeft));

        bounds.set(0,5,finalViewWidth,finalViewHeight-5);

        lastSegmentRectf.set(0,5,finalViewWidth-5,finalViewHeight-5);

        firstSegmentRectf.set(5,5,finalViewWidth-5,finalViewHeight-5);

        setMeasuredDimension(finalViewWidth,finalViewHeight);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        if(isChecked()) {

            if(isFirstSegment){
                canvas.drawRoundRect(firstSegmentRectf,10,10,mBackgroundPaint);
                canvas.drawRect(10,5,finalViewWidth-5,finalViewHeight-5,mBackgroundPaint);
            }else

            if(isLastSegment){
                canvas.drawRoundRect(lastSegmentRectf,10,10,mBackgroundPaint);
                canvas.drawRect(0,5,finalViewWidth-10,finalViewHeight-5,mBackgroundPaint);
            } else

            {
                canvas.drawRect(bounds, mBackgroundPaint);
            }
        }
        int yPos = (int) ((canvas.getHeight() / 2) - ((mTextPaintNormal.descent() + mTextPaintNormal.ascent()) / 2)) ;

        if(isChecked()) {
            canvas.drawText(mText, (finalViewWidth - (paddingLeft + mTextWidth)), yPos, mTextPaintSelected);
        }else {
            canvas.drawText(mText, (finalViewWidth - (paddingLeft + mTextWidth)), yPos, mTextPaintNormal);
        }
        if(!isLastSegment && !isChecked()){
            canvas.drawLine(finalViewWidth,5,finalViewWidth,finalViewHeight-5,mBackgroundPaint);
        }

    }

    @Override
    public void toggle() {
        super.toggle();
    }

    @Override
    public boolean isChecked() {
        return super.isChecked();
    }

    public String getText(){
        return mText;
    }
}
