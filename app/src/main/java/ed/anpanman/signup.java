package ed.anpanman;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {

    private EditText usrname,pswd,mail,cpswd;
    private Button skip,btnmake,havacc;
    Animation atg, atg2, atg3,atg4,atg5;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        skip=(Button)findViewById(R.id.btnskip);
        havacc=(Button)findViewById(R.id.btn_havacc);
        btnmake=(Button)findViewById(R.id.btn_mack_account);
        mail = (EditText)findViewById(R.id.ed_mail);
        pswd = (EditText)findViewById(R.id.ed_psw);
        cpswd = (EditText)findViewById(R.id.ed_confirm);
        usrname = (EditText)findViewById(R.id.ed_uname);


        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        atg2 = AnimationUtils.loadAnimation(this, R.anim.atg2);
        atg3 = AnimationUtils.loadAnimation(this, R.anim.atg3);
        atg4 = AnimationUtils.loadAnimation(this, R.anim.atg4);
        atg5 = AnimationUtils.loadAnimation(this, R.anim.atg5);

       havacc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(signup.this, login.class);
                startActivity(it);
            }
        });
        skip.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(signup.this, Home.class);
                startActivity(it);

            }
        });
        btnmake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=mail.getText().toString().trim();
                String pass=pswd.getText().toString().trim();
                String confirm=cpswd.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    Toast.makeText(signup.this, "please enter email", Toast.LENGTH_LONG);
                    return;
                }
                if(TextUtils.isEmpty(pass)) {
                    Toast.makeText(signup.this, "please enter Password", Toast.LENGTH_LONG);
                    return;
                }
                if(TextUtils.isEmpty(confirm)) {
                    Toast.makeText(signup.this, "please confirm password", Toast.LENGTH_LONG);
                    return;
                }
                if (pass.equals(confirm))
                {
                    mAuth.createUserWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                       startActivity(new Intent(getApplicationContext(),Home.class));
                                        Toast.makeText(signup.this, "Registration Complete", Toast.LENGTH_LONG);
                                    } else {
                                        Toast.makeText(signup.this, "Registration failed", Toast.LENGTH_LONG);
                                    }

                                        }
                            });
                }
            }
        });


      usrname.startAnimation(atg);
        mail.startAnimation(atg2);
        pswd.startAnimation(atg3);
        cpswd.startAnimation(atg3);
        btnmake.startAnimation(atg3);
        havacc.startAnimation(atg4);
        skip.startAnimation(atg4);




    }
}
