package ed.anpanman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity
{

    private EditText mail,pswd;
    private Button skip,create_account,btnlogin;
    Animation atg, atg2, atg3,atg4,atg5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       //ui
        skip=(Button)findViewById(R.id.btnskip);
        create_account=(Button)findViewById(R.id.btn_create_account);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        mail = (EditText)findViewById(R.id.mail);
        pswd = (EditText)findViewById(R.id.pswd);
//animation
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        atg2 = AnimationUtils.loadAnimation(this, R.anim.atg2);
        atg3 = AnimationUtils.loadAnimation(this, R.anim.atg3);
        atg4 = AnimationUtils.loadAnimation(this, R.anim.atg4);
        atg5 = AnimationUtils.loadAnimation(this, R.anim.atg5);
//firebase



        skip.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(login.this, Home.class);
                startActivity(it);
            }
        });
        create_account.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(login.this, signup.class);
                startActivity(it);
            }
        });

        mail.startAnimation(atg);
        pswd.startAnimation(atg2);

        btnlogin.startAnimation(atg2);
        create_account.startAnimation(atg3);

        skip.startAnimation(atg4);

    }

}
