package ed.anpanman;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity
{

    private EditText mail,pswd;
    private Button skip,create_account,btnlogin;
    Animation atg, atg2, atg3,atg4,atg5;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       //ui
        skip=(Button)findViewById(R.id.btnskip);
        create_account=(Button)findViewById(R.id.btn_create_account);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        firebaseAuth=FirebaseAuth.getInstance();

        mail = (EditText)findViewById(R.id.mail);
        pswd = (EditText)findViewById(R.id.pswd);
//animation
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        atg2 = AnimationUtils.loadAnimation(this, R.anim.atg2);
        atg3 = AnimationUtils.loadAnimation(this, R.anim.atg3);
        atg4 = AnimationUtils.loadAnimation(this, R.anim.atg4);
        atg5 = AnimationUtils.loadAnimation(this, R.anim.atg5);
//firebase

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = mail.getText().toString().trim();
                final String pass = pswd.getText().toString().trim();
                try {
                    if (TextUtils.isEmpty(email)||TextUtils.isEmpty(pass)) {
                        Toast.makeText(login.this, "كل الخانات مطلوبه", Toast.LENGTH_LONG).show();

                    }

                    if (pass.length() < 6) {
                        Toast.makeText(login.this, "Password is too short", Toast.LENGTH_LONG).show();
                    }
else{
                    firebaseAuth.signInWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Intent intent = new Intent(login.this, Home.class);
                                        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK|intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        // If sign in fails, display a message to the user.

                                        Toast.makeText(login.this, "فشل تسجيل الدخول", Toast.LENGTH_LONG).show();
                                        ;
                                    }
                                }
                            });

                }
                }
             catch(
            Exception e)

            {
                e.printStackTrace();
            }
        }  });

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
