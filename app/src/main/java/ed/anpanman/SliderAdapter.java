package ed.anpanman;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater LayoutInflater;

    public SliderAdapter ( Context contex){
        this.context=contex;
    }

    public int[] slideimage=
    {
        R.drawable.eat_icon,
        R.drawable.sleep_icon,
        R.drawable.study_icon


    };

    public String[] slide_heading=
    {
        "Eat","Sleep","Study"

    };


    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==(RelativeLayout) object;

    }

    public Object instantiateItem(ViewGroup container,int position)
    {
        LayoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=LayoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImage=(ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading =(TextView) view.findViewById(R.id.slide_heading);


        slideImage.setImageResource(slideimage[position]);
        slideHeading.setText(slide_heading[position]);

        container.addView(view);
        return view;
    }


    public void destroyItem(ViewGroup container,int position, Object object)
    {

        container.removeView((RelativeLayout) object);
    }
}
