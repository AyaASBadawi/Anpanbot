package ed.anpanman;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Start extends AppCompatActivity {
      private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView [] mDots;

    public SliderAdapter sliderAdapter;

    private Button backbtn;
    private Button nextbtn;
    private int mcurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mSlideViewPager=(ViewPager)findViewById(R.id.slideviewpager);
        mDotLayout=(LinearLayout)findViewById(R.id.dots);
        backbtn=(Button)findViewById(R.id.prevbtn);
        nextbtn=(Button)findViewById(R.id.nextbtn);
        sliderAdapter =new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        addDOtsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListnner);

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mcurrentPage+1);
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mcurrentPage-1);
            }
        });

    }
    public void addDOtsIndicator(int position)

    {

        mDots=new TextView[3];
        mDotLayout.removeAllViews();
        for (int i = 0; i < 3; i++) {

            mDots[i] = new TextView(this);

            //noinspection deprecation
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);

          // mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDots[i].setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorTransparentWhite, null));
            mDotLayout.addView(mDots[i]);

        }
        if (mDots.length>0)
        {
            mDots[position].setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorWhite, null));

           // mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }
   ViewPager.OnPageChangeListener viewListnner = new ViewPager.OnPageChangeListener() {
       @Override
       public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

       }

       @Override
       public void onPageSelected(int position) {
           addDOtsIndicator(position);
           mcurrentPage=position;
           if(position==0)
           {
               nextbtn.setEnabled(true);
               backbtn.setEnabled(false);
               backbtn.setVisibility(View.INVISIBLE);
               nextbtn.setVisibility(View.VISIBLE);
               nextbtn.setText("Next");
               backbtn.setText("");
           }
           else if(position==2)
               {
                   nextbtn.setEnabled(true);
                   backbtn.setEnabled(true);
                   backbtn.setVisibility(View.VISIBLE);
                   nextbtn.setVisibility(View.VISIBLE);
                    nextbtn.setText("Finish");
                   backbtn.setText("Back");
                   nextbtn.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Intent it=new Intent(Start.this,login.class);
                           startActivity(it);

                       }
                   });

               }

               else
           {
               nextbtn.setEnabled(true);
               backbtn.setEnabled(true);
               nextbtn.setVisibility(View.VISIBLE);
               backbtn.setVisibility(View.VISIBLE);
               nextbtn.setText("Next");
               backbtn.setText("Back");
           }
       }

       @Override
       public void onPageScrollStateChanged(int state) {

       }
   };


}
