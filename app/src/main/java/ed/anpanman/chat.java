package ed.anpanman;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import ed.anpanman.Adapter.MessageAdapter;
import ed.anpanman.Model.Chat;
import ed.anpanman.Model.Student;

public class chat extends AppCompatActivity {



    CircleImageView profile_image;

    ImageButton btn_mic,btn_send;
    TextView mess,username;


    MessageAdapter messageAdapter;
    List<Chat>mchat;
    RecyclerView recyclerView;


    FirebaseUser fuser;
    DatabaseReference reference;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);


        mess = (TextView) findViewById(R.id.txt_message);
        btn_mic = (ImageButton) findViewById(R.id.btn_mic);
        btn_send = (ImageButton) findViewById(R.id.btn_send);
        profile_image = (CircleImageView) findViewById(R.id.profile_image);
        username = (TextView) findViewById(R.id.username);

        intent = getIntent();
        final String userid = intent.getStringExtra("userid");

        fuser = FirebaseAuth.getInstance().getCurrentUser();

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mess.equals("")) {
                    String msg = mess.getText().toString().trim();
                    SendMessage(fuser.getUid(), userid, msg);

                } else {
                    Toast.makeText(chat.this, "لا يمكن ارسال رساله فارغه !!", Toast.LENGTH_LONG).show();
                }
                mess.setText("");
            }
        });


        reference = FirebaseDatabase.getInstance().getReference("Student").child(userid);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Student student = dataSnapshot.getValue(Student.class);
                username.setText(student.getUsername());
                if (student.getImageURL().equals("default")) {
                    profile_image.setImageResource(R.drawable.userpic);
                } else {
                    Glide.with(chat.this).load(student.getImageURL());
                }
                readMesagges(fuser.getUid(),userid,"default");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void SendMessage(String sender, String reciever,String message)
    {
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("Sender",sender);
        hashMap.put("Receiver",reciever);
        hashMap.put("Message",message);
        ref.child("Chat").push().setValue(hashMap);

    }
    private void readMesagges(final String myid, final String userid, final String imageurl){
        mchat = new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("Chats");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mchat.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Chat chat = snapshot.getValue(Chat.class);
                    if (chat.getReceiver().equals(myid) && chat.getSender().equals(userid) ||
                            chat.getReceiver().equals(userid) && chat.getSender().equals(myid)){
                        mchat.add(chat);
                    }

                    messageAdapter = new MessageAdapter(chat.this, mchat, imageurl);
                    recyclerView.setAdapter(messageAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
