package com.example.sander.email;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    EditText editEmail, editSubject, editMessage;
    Button btn_Send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = (EditText)findViewById(R.id.editEmail);
        editSubject = (EditText)findViewById(R.id.editSubject);
        editMessage = (EditText)findViewById(R.id.editMessage);
        btn_Send = (Button)findViewById(R.id.btn_send);

        btn_Send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String to = editEmail.getText().toString();
                String subject = editSubject.getText().toString();
                String message = editMessage.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                //brackets [] because you have a list of people to send it to
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);

                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent, "Select Email app"));

            }
        });
    }
}
