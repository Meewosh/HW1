package com.example.hw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hw1.tasks.TaskListContent;

import java.util.Random;

public class AddItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    public void Save(View view) {
        EditText name = findViewById ( R.id.editText );
        EditText surname = findViewById ( R.id.editText2 );
        EditText date = findViewById ( R.id.editText3 );
        EditText number = findViewById ( R.id.editText4);
        if(!name.getText ().toString ().equals ( "" ) && !surname.getText ().toString ().equals ( "" ) && !date.getText ().toString ().equals ( "" ) && !number.getText ().toString ().equals ( "" ))
        {
            Random random = new Random ( );
            String selectedImage;
            Intent intent = getIntent ();
            selectedImage = intent.getStringExtra ( "photo");
            if (intent.getStringExtra ( "photo" )==null) {
                selectedImage="drawable "+(random.nextInt (3)+1);
            }
            TaskListContent.addItem ( new TaskListContent.Task ( "Task." +TaskListContent.ITEMS.size ()+1, name.getText ().toString (), surname.getText ().toString (),date.getText ().toString (),number.getText ().toString (), selectedImage) );
            Intent main_intent=new Intent ( );
            setResult ( RESULT_OK, main_intent );
            finish ();
        }
    }
}
