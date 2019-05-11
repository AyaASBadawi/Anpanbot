package ed.anpanman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class parent extends AppCompatActivity {
    private Button create_account,btnlogin, home;
    Animation atg, atg2, atg3,atg4;
    ImageView imageView;
    TextView titel;

    FirebaseUser firebaseuser;
    @Override

    protected void onStart(){
        super.onStart();
        firebaseuser= FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseuser!=null)
        {

            Intent it = new Intent(parent.this, Home.class);
            startActivity(it);
            finish();
        }





    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
        create_account=(Button)findViewById(R.id.btn_create_account2);
        home=(Button)findViewById(R.id.btnhome);
        btnlogin=(Button)findViewById(R.id.btnlogin3);
        imageView= (ImageView)findViewById(R.id.imageView4);
        titel = (TextView)findViewById(R.id.pagetitle2);

         //animation
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        atg2 = AnimationUtils.loadAnimation(this, R.anim.atg2);
        atg3 = AnimationUtils.loadAnimation(this, R.anim.atg3);
        atg4 = AnimationUtils.loadAnimation(this, R.anim.atg4);


        create_account.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(parent.this, signup.class);
                startActivity(it);
            }
        });
        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(parent.this, Home.class);
                startActivity(it);
            }
        });

      btnlogin.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent it = new Intent(parent.this, login.class);
                                          startActivity(it);

                                      }
                                  });

        imageView.startAnimation(atg);
        titel.startAnimation(atg2);
        btnlogin.startAnimation(atg3);
        create_account.startAnimation(atg4);
        home.startAnimation(atg4);

    }
}
