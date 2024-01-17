package com.example.listcontact;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import java.util.concurrent.ThreadLocalRandom;
public class mainActivity extends Activity  {

    int numberOfContact, numberOfPage;
    Button btnGen;
    EditText edtNumberOfContact;
    TextView txtChoose, txtEmpty;
    Spinner spnPage;
    long seed = System.currentTimeMillis();
    Random rand = new Random(seed);
    String[] name, phone, listName, listPhone;
    Integer[] avata, listAvata;
    ListView myListContact;

    @Override
    public void onCreate(Bundle saveStateInstance){
        super.onCreate(saveStateInstance);
        setContentView(R.layout.main_contact);
        txtChoose = (TextView) findViewById(R.id.txtChoose);
        edtNumberOfContact = (EditText) findViewById(R.id.txtChooseNumber);
        myListContact = (ListView) findViewById(R.id.listContact);
        txtEmpty = (TextView) findViewById(R.id.emptyList);
        btnGen = (Button) findViewById(R.id.btnGen);

        btnGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edt = edtNumberOfContact.getText().toString();
                if(edt.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please choose the number of contact",Toast.LENGTH_SHORT).show();
                }
                else{

                    numberOfContact = Integer.parseInt(edt);
                    listName = randomName(numberOfContact);
                    listPhone = randomPhoneNumber(numberOfContact);
                    listAvata = randomAvata(numberOfContact);
                    txtChoose.setText("");

                        spnPage = (Spinner) findViewById(R.id.spnPage);
                        if(numberOfContact % 5 == 0)
                            numberOfPage = numberOfContact/5;
                        else numberOfPage = numberOfContact/5 + 1;
                        Integer[] pagenumber = new Integer[numberOfPage];
                        for (int i = 0; i < numberOfPage; ++i) {
                            pagenumber[i] = i + 1;
                        }

                        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(mainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, pagenumber);
                        spnPage.setAdapter(adapter);
                        spnPage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                name = CreateName(listName,5*(position));
                                phone = CreatePhone(listPhone,5*(position));
                                avata = CreateAvata(listAvata,5*(position));

                                myListContact.deferNotifyDataSetChanged();
                                myListContact.clearChoices();

                                myListContact = (ListView)findViewById(R.id.listContact);
                                myListContact.setAdapter(new myAdapter(mainActivity.this,R.layout.item_contact,name,phone,avata));

                                myListContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        txtChoose.setText("You choose: " + name[i]);
                                    }
                                });
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                               //to do nothing
                            }
                        });

                }//else
            }
        });

    }//onCreate


    // random list name
    public static String[] randomName(int n){
        Random rand = new Random();

        String[] lastName = { "Nguyen", "Tran", "Le", "Bui", "Pham" };
        String[] middleName = { "Van", "Thi" };
        String[] firstName = { "A", "B", "C", "D", "E","F","G","H","I","K" };
        String[] output = new String[n];
        for(int i = 0 ; i < n; ++i)
            output[i] = lastName[rand.nextInt(5)] + " " + middleName[rand.nextInt(2)] + " " + firstName[rand.nextInt(10)];
        return output;
    }
    //random list phonenumber
    public static String[] randomPhoneNumber(int n){
        Random rand = new Random();
        String[] phone = {"012392832","012378323","084934343","024761732","0426734334","093642322","089923723"};
        String[] output = new String[n];
        for(int i = 0; i < n; ++i)
                output[i] = phone[rand.nextInt(7)];
        return output;
    }

    //random list avata
    public static Integer[] randomAvata(int n){
        Random rand = new Random();
        Integer[] avata = {R.drawable.icon_alien,R.drawable.icon_angry,R.drawable.icon_happy,R.drawable.icon_sad,R.drawable.icon_superman};
        Integer[] output = new Integer[n];
        for(int i = 0; i < n; ++i){
            output[i] = avata[rand.nextInt(5)];
        }
        return output;
    }
    //create 5 name from list Name
    public static String[] CreateName(String[] ListName,int start){
        String[] output;
        if(start + 5 < ListName.length)
            output = new String[5];
        else output = new String[ListName.length-start];
        for(int i = start; i < start + 5 && i < ListName.length; ++i){
            output[i-start] = ListName[i];
        }

        return output;
    }
    // create 5 phonenumber from list Phone
    public static String[] CreatePhone(String[] ListPhone,int start){
        String[] output ;
        if(start + 5 < ListPhone.length)
            output = new String[5];
        else output = new String[ListPhone.length-start];
        for(int i = start; i < start + 5 && i < ListPhone.length; ++i) {
            output[i-start] = ListPhone[i];
        }
        return output;
    }
    // create 5 avata from list avata
    public static Integer[] CreateAvata(Integer[] ListAvata,int start){
        Integer[] output;
        if(start + 5 < ListAvata.length)
            output = new Integer[5];
        else output = new Integer[ListAvata.length-start];
        for(int i = start; i < start + 5 && i < ListAvata.length; ++i) {
            output[i-start] = ListAvata[i];
        }
        return output;
    }

}