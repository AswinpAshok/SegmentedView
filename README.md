# SegmentedView

This is my attempt to port [iOS segmented control](https://developer.apple.com/ios/human-interface-guidelines/controls/segmented-controls/) to android.

Currently only horizontal orientation is supported.

## Screnshot 

![](https://raw.githubusercontent.com/AswinpAshok/SegmentedView/master/ScreenShot/Screenshot.jpg
)

To use this library, add

    compile 'com.aswin:segmentedcontrol:1.0.0'
    
 to your app level build.gradle file
 
 ## Usage
 
 Add `SegmentView` in xml layout, enclosed in `SegmentGroup` like following
 
     <com.aswin.segmentedcontrol.SegmentGroup
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/group"
        android:orientation="horizontal">

        <com.aswin.segmentedcontrol.SegmentView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:isFirstSegment="true"
            app:text="Aswin"
            app:textSize="14sp"
            android:id="@+id/seg_1"/>
        <com.aswin.segmentedcontrol.SegmentView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:text="Amal"
            app:textSize="14sp"
            android:id="@+id/seg_2"
            android:checked="true"/>
        <com.aswin.segmentedcontrol.SegmentView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:textSize="14sp"
            app:text="Vishnu"
            android:id="@+id/seg_3"/>

        <com.aswin.segmentedcontrol.SegmentView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:textSize="14sp"
            app:text="Linto"
            android:id="@+id/seg_4"
            app:isLastSegment="true"/>

    </com.aswin.segmentedcontrol.SegmentGroup>
    
 Detecting user interaction to the view in activity/ fragment
 
    SegmentGroup group;
    SegmentView segment_1,segment_2,segment_3,segment_4;
       
    group= findViewById(R.id.group);
    segment_1= findViewById(R.id.seg_1);
    segment_2= findViewById(R.id.seg_2);
    segment_3= findViewById(R.id.seg_3);
    segment_4= findViewById(R.id.seg_4);
    
    group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
            
                case(R.id.seg_1) :{
                    Toast.makeText(MainActivity.this,segment_1.getText(),Toast.LENGTH_SHORT).show();
                    //SEGMENT_1 CLICKED, DO YOUR STUFF HERE
                }break;
                   
                case (R.id.seg_2):{
                    Toast.makeText(MainActivity.this,segment_2.getText(),Toast.LENGTH_SHORT).show();
                    //SEGMENT_2 CLICKED, DO YOUR STUFF HERE
                }break;
                
                case (R.id.seg_3):{
                    Toast.makeText(MainActivity.this,segment_3.getText(),Toast.LENGTH_SHORT).show();
                    //SEGMENT_3 CLICKED, DO YOUR STUFF HERE
                }break;
                
                case (R.id.seg_4):{
                    Toast.makeText(MainActivity.this,segment_4.getText(),Toast.LENGTH_SHORT).show();
                    //SEGMENT_4 CLICKED, DO YOUR STUFF HERE
                }break;
                   
               default: break;
            }
        }
    });
    
**Important notes**
* Use `SegmentView` and `SegmentGroup` dimensions (height and width) as `wrap_content`.
* Don't forget to assign `id` for SegmentedViews.
* Don't forget to add `android:orientation="horizontal"` to `SegmentGroup`
* Declare `app` manespace as `xmlns:app="http://schemas.android.com/apk/res-auto"`.
* Use `app:text` to set text to the view.
* For the first `SegmentView`, you should add `app:isFirstSegment="true"`.
* For the last `SegmentView`, you should add `app:isLastSegment="true"`.



