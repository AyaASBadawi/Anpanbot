package ed.anpanman;

import android.content.Intent;
import android.graphics.Rect;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Util;

public class Home extends AppCompatActivity {
    TextView nameuser, walletuser, review, network, plugins, myapps, mainmenus,
            pagetitle, pagesubtitle;
    Button btnguide;
    Animation atg, atg3, atg4;
    ImageView imageView3,chat,qb,quiz,lessons;
    BoomMenuButton bmb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nameuser =(TextView) findViewById(R.id.nameuser);

        review = (TextView)findViewById(R.id.review);
        network =(TextView) findViewById(R.id.network);
        plugins = (TextView)findViewById(R.id.plugins);
        myapps = (TextView)findViewById(R.id.myapps);
        pagetitle = (TextView)findViewById(R.id.pagetitle);
        pagesubtitle = (TextView)findViewById(R.id.pagesubtitle);
        btnguide = (Button)findViewById(R.id.btnguide);
        imageView3 = (ImageView)findViewById(R.id.imageView3);
        chat = (ImageView)findViewById(R.id.imgchat);
        qb= (ImageView)findViewById(R.id.imgqb);
        quiz= (ImageView)findViewById(R.id.imgquiz);
        lessons= (ImageView)findViewById(R.id.imglessons);

//boom menu
        bmb = (BoomMenuButton) findViewById(R.id.bmb);

        bmb.setButtonEnum(ButtonEnum.TextOutsideCircle);
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            int posiion =i;
          if (posiion==0)
          {
              TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                      .normalImageRes(R.drawable.ic_chat)
                      .rotateImage(false)
                      .rotateText(false)
                      .normalTextRes(R.string.chat)
                      .shadowEffect(true)
                      .shadowOffsetX(20)
                      .shadowOffsetY(0)
                      .shadowRadius(Util.dp2px(20))
                      .shadowCornerRadius(Util.dp2px(20))
                      .shadowColor(R.color.colorPrimaryDark)
                      .textPadding(new Rect(5, 5, 5, 5))

                     .listener(new OnBMClickListener() {
                          @Override
                          public void onBoomButtonClick(int index) {
                              // When the boom-button corresponding this builder is clicked.
                              Intent it = new Intent(Home.this, chat.class);
                              startActivity(it);
                          }
                      });

              bmb.addBuilder(builder);
          }
          else if (posiion==1)
          {
              TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                      .normalImageRes(R.drawable.ic_profile)
                      .rotateImage(false)
                      .rotateText(false)
                      .normalTextRes(R.string.profile)
                      .shadowEffect(true)
                      .shadowOffsetX(20)
                      .shadowOffsetY(0)
                      .shadowRadius(Util.dp2px(20))
                      .shadowCornerRadius(Util.dp2px(20))
                      .shadowColor(R.color.colorPrimaryDark)
                      .textPadding(new Rect(5, 5, 5, 5))
                      .listener(new OnBMClickListener() {
                          @Override
                          public void onBoomButtonClick(int index) {
                              // When the boom-button corresponding this builder is clicked.
                              Intent it = new Intent(Home.this, Profile.class);
                              startActivity(it);
                          }
                      });

              bmb.addBuilder(builder);
          }
          else if (posiion==2)
          {
              TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                      .normalImageRes(R.drawable.ic_quiz)
                      .rotateImage(false)
                      .rotateText(false)
                      .normalTextRes(R.string.quiz)
                      .shadowEffect(true)
                      .shadowOffsetX(20)
                      .shadowOffsetY(0)
                      .shadowRadius(Util.dp2px(20))
                      .shadowCornerRadius(Util.dp2px(20))
                      .shadowColor(R.color.colorPrimaryDark)
                      .textPadding(new Rect(5, 5, 5, 5))
                      .listener(new OnBMClickListener() {
                          @Override
                          public void onBoomButtonClick(int index) {
                              // When the boom-button corresponding this builder is clicked.
                              Intent it = new Intent(Home.this, quiz.class);
                              startActivity(it);
                          }
                      });

              bmb.addBuilder(builder);
          }
          else if (posiion==3)
          {
              TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                      .normalImageRes(R.drawable.ic_bq)
                      .rotateImage(false)
                      .rotateText(false)
                      .normalTextRes(R.string.bq)
                      .shadowEffect(true)
                      .shadowOffsetX(20)
                      .shadowOffsetY(0)
                      .shadowRadius(Util.dp2px(20))
                      .shadowCornerRadius(Util.dp2px(20))
                      .shadowColor(R.color.colorPrimaryDark)
                      .textPadding(new Rect(5, 5, 5, 5))
                      .listener(new OnBMClickListener() {
                          @Override
                          public void onBoomButtonClick(int index) {
                              // When the boom-button corresponding this builder is clicked.
                              Intent it = new Intent(Home.this, QBank.class);
                              startActivity(it);
                          }
                      });

              bmb.addBuilder(builder);
          }
          else if (posiion==4)
          {
              TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                      .normalImageRes(R.drawable.ic_lessons)
                      .rotateImage(false)
                      .rotateText(false)
                      .normalTextRes(R.string.lesson)
                      .shadowEffect(true)
                      .shadowOffsetX(20)
                      .shadowOffsetY(0)
                      .shadowRadius(Util.dp2px(20))
                      .shadowCornerRadius(Util.dp2px(20))
                      .shadowColor(R.color.colorPrimaryDark)
                      .textPadding(new Rect(5, 5, 5, 5))
                      .listener(new OnBMClickListener() {
                          @Override
                          public void onBoomButtonClick(int index) {
                              // When the boom-button corresponding this builder is clicked.
                              Intent it = new Intent(Home.this, lessons.class);
                              startActivity(it);
                          }
                      });

              bmb.addBuilder(builder);
          }
          else if (posiion==5)

         {
              TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                      .normalImageRes(R.drawable.ic_totrank)
                      .rotateImage(false)
                      .rotateText(false)
                      .normalTextRes(R.string.totrank)
                      .shadowEffect(true)
                      .shadowOffsetX(20)
                      .shadowOffsetY(0)
                      .shadowRadius(Util.dp2px(20))
                      .shadowCornerRadius(Util.dp2px(20))
                      .shadowColor(R.color.colorPrimaryDark)
                      .textPadding(new Rect(5, 5, 5, 5))
                      .listener(new OnBMClickListener() {
                          @Override
                          public void onBoomButtonClick(int index) {
                              // When the boom-button corresponding this builder is clicked.
                              Intent it = new Intent(Home.this, tot_rank.class);
                              startActivity(it);
                          }
                      });


              bmb.addBuilder(builder);
          }
          else if (posiion==6)
          {
              TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                      .normalImageRes(R.drawable.ic_login)
                      .rotateImage(false)
                      .rotateText(false)
                      .normalTextRes(R.string.login)
                      .shadowEffect(true)
                      .shadowOffsetX(20)
                      .shadowOffsetY(0)
                      .shadowRadius(Util.dp2px(20))
                      .shadowCornerRadius(Util.dp2px(20))
                      .shadowColor(R.color.colorPrimaryDark)
                      .textPadding(new Rect(5, 5, 5, 5))
                      .listener(new OnBMClickListener() {
                          @Override
                          public void onBoomButtonClick(int index) {
                              // When the boom-button corresponding this builder is clicked.
                              Intent it = new Intent(Home.this, login.class);
                              startActivity(it);
                          }
                      });

              bmb.addBuilder(builder);
          }
          else if (posiion==7)
          {
              TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                      .normalImageRes(R.drawable.ic_rateus)
                      .rotateImage(false)
                      .rotateText(false)
                      .normalTextRes(R.string.ratus)
                      .shadowEffect(true)
                      .shadowOffsetX(20)
                      .shadowOffsetY(0)
                      .shadowRadius(Util.dp2px(20))
                      .shadowCornerRadius(Util.dp2px(20))
                      .shadowColor(R.color.colorPrimaryDark)
                      .textPadding(new Rect(5, 5, 5, 5))
                      .textGravity(Gravity.CENTER)

                      .ellipsize(TextUtils.TruncateAt.MIDDLE)

                      .textSize(10)
                      .listener(new OnBMClickListener() {
                          @Override
                          public void onBoomButtonClick(int index) {
                              // When the boom-button corresponding this builder is clicked.
                              Intent it = new Intent(Home.this, Ratus.class);
                              startActivity(it);
                          }
                      });

              bmb.addBuilder(builder);
          }






        }

chat.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v)
    {
        Intent it = new Intent(Home.this, chat.class);
        startActivity(it);
    }
});
        qb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(Home.this, QBank.class);
                startActivity(it);
            }
        });
        quiz.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(Home.this, quiz.class);
                startActivity(it);
            }
        });
        lessons.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(Home.this, quiz.class);
                startActivity(it);
            }
        });


        //animation
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        atg3 = AnimationUtils.loadAnimation(this, R.anim.atg3);
        atg4 = AnimationUtils.loadAnimation(this, R.anim.atg4);

      /*  Typeface MLight=Typeface.createFromAsset(getAssets(),"fonts/Ml.ttf");
        Typeface MMedium=Typeface.createFromAsset(getAssets(),"fonts/MM.ttf");
        Typeface MRegular=Typeface.createFromAsset(getAssets(),"fonts/MR.ttf");
        nameuser.setTypeface(MMedium);
        walletuser.setTypeface(MLight);
        mainmenus.setTypeface(MRegular);
        review.setTypeface(MMedium);
        network.setTypeface(MMedium);
        plugins.setTypeface(MMedium);
        myapps.setTypeface(MMedium);
        btnguide.setTypeface(MMedium);
        pagetitle.setTypeface(MRegular);
        pagesubtitle.setTypeface(MLight);*/

        // pass an animation
        imageView3.startAnimation(atg);

        pagetitle.startAnimation(atg3);
        pagesubtitle.startAnimation(atg3);

        btnguide.startAnimation(atg4);
    }
}
