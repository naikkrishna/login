package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText namet = findViewById(R.id.nameedt);
        final EditText pricet = findViewById(R.id.priceedt);
        final EditText qtyt = findViewById(R.id.qtyedt);

        final Button send = findViewById(R.id.sendbtn);
        final Button activity = findViewById(R.id.activitybtn);


        final HashMap<String,String> order =new HashMap<>();


        send.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                 String name=namet.getText().toString();
                                 int price=Integer.parseInt(pricet.getText().toString());
                                  int qty=Integer.parseInt(qtyt.getText().toString());
                               //  order.put("Name",name);
                             //   order.put("Price",price+" ");
                             //  order.put("Qty",qty+" ");
                                item item1=new item();
                                item1.setName(name);
                                item1.setPrice(price);
                                item1.setQty(qty);

                                         FirebaseFirestore db= FirebaseFirestore.getInstance();
                                        db.collection("order")
                                                .add(item1);



                                         }

                                     });
        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
