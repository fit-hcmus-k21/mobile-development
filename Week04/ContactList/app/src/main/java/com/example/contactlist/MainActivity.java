package com.example.contactlist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {
    Button genBtn;
    EditText numGenEditText;
    Spinner pageSpinner;
    TextView currentItemChooseTextView;
    ListView listContactView;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);

//        bind objects
        genBtn = findViewById(R.id.genBtn);
        numGenEditText = findViewById(R.id.numGenEditText);
        pageSpinner = findViewById(R.id.pageSpinner);
        currentItemChooseTextView = findViewById(R.id.currentItemChooseTextView);
        listContactView = findViewById(R.id.listContactView);

//        define number images
        Integer numImg = 38;    // my prj has currently 38 images

//       load images
        List<Integer> icons = loadListIconIds(numImg);



    }

//    func to generate list name
    private List<String> generateListName(int num) {
        List<String> names = new ArrayList<String>();

        String[] firstNames = {"Bùi", "Trần", "Nguyễn", "Võ", "Đặng", "Lê", "Ngô", "Trương", "Đinh", "Vũ"};
        String[] middleNames = {"Thị Thanh", "Quang", "Anh", "Thị Thúy", "Thanh", "Ngọc", "Đức", "Thị Như", "Thành", "Hoàng Anh", "Thị Như"};
        String[] lastNames = {"Ngân", "Ý", "Trọng", "Vũ", "Kiều", "Chi", "Thọ", "Hà", "Lan", "Diễm" };

        Random generator = new Random();

        for (int i = 0; i < num; i++) {
            Integer idFirstName = generator.nextInt(firstNames.length);
            Integer idMiddleName = generator.nextInt(middleNames.length);
            Integer idLastName = generator.nextInt(lastNames.length);

            String name = firstNames[idFirstName] + " " + middleNames[idMiddleName] + " " + lastNames[idLastName];
            names.add(name);
        }

       return names;
    }

//    func to get list icon
    private List<Integer> loadListIconIds(int num) {
        List<Integer> icons = new ArrayList<Integer>();

//        format of img file name: icon_XX.jpg || XX is number from 01 - 38
        String name = "icon_";

        for (int i = 0; i < num; i++) {
            String id = num < 10 ? "0" + num : String.valueOf(num);
            name += id;
            Integer resId = getResources().getIdentifier(name, "drawable", getPackageName());
            icons.add(resId);
        }

        return icons;
    }

//    generate phone numbers
    private List<String> generatePhoneNumbers (int num) {
        List<String> listPhoneNumbers = new ArrayList<String>();

//        format of number : {id}xxxxxxx  | 10 digits in total
        String[] ids = {"036", "096", "038", "095" };

//        generator
        Random generator = new Random();

        for (int i = 0; i < num; i++) {
            String phoneNumber = ids[i%4];

//            generate 7digits
            Integer ranNum = 1000000 + generator.nextInt(9000000);

            phoneNumber += String.valueOf(ranNum);

            listPhoneNumbers.add(phoneNumber);
        }

        return listPhoneNumbers;
    }

}
