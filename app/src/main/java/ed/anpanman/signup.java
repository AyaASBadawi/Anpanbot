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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    private EditText usrname,pswd,mail,cpswd;
    private Button skip,btnmake,havacc;
    Animation atg, atg2, atg3,atg4,atg5;
    private FirebaseAuth mAuth;
    private FirebaseFirestore fireStoreDB;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        fireStoreDB = FirebaseFirestore.getInstance();
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


        btnmake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final  String email=mail.getText().toString().trim();
                final  String Username=usrname.getText().toString().trim();
                final String pass=pswd.getText().toString().trim();
                final String confirm=cpswd.getText().toString().trim();
                try {
                    if (TextUtils.isEmpty(email)||TextUtils.isEmpty(Username)||TextUtils.isEmpty(pass)) {
                        Toast.makeText(signup.this, "كل العناصر مطلوبه", Toast.LENGTH_LONG).show();

                    }
                    if(pass.length()<6&&!isValidPassword(pass))
                    {
                        Toast.makeText(signup.this, "كلمه السر يجب ان تتكون من 6 رموز على الاقل ويجب ان تحتوى على ارقام وحروف", Toast.LENGTH_LONG).show();
                    }

                    if (!pass.equals(confirm)) {
                        Toast.makeText(signup.this, "كمة السر لا تتوافق مع تاكيد كلمه السر", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Register(email, pass,Username);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }


        });

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


        usrname.startAnimation(atg);
        mail.startAnimation(atg2);
        pswd.startAnimation(atg3);
        cpswd.startAnimation(atg3);
        btnmake.startAnimation(atg3);
        havacc.startAnimation(atg4);
        skip.startAnimation(atg4);




    }
    private void Register(final String email, String pass, final String userName){


        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = mAuth.getCurrentUser();
                            assert firebaseUser != null;
                            String userid = firebaseUser.getUid();

                            reference = FirebaseDatabase.getInstance().getReference("Student").child(userid);
                            HashMap<String,String>hashMap=new HashMap<>();
                            hashMap.put("id",userid);
                            hashMap.put("username",userName);
                            hashMap.put("Email",email);
                            hashMap.put("imageURL","default");
                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(signup.this, Home.class);
                                        intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TASK|intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish();
                                    }


                                }
                            });

                        } else {
                            Toast.makeText(signup.this, "Registration failed", Toast.LENGTH_LONG).show();
                            Log.v("error", task.getResult().toString());
                        }
                    }
                });

   }
    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}