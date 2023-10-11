package com.example.contactlist;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {
    Button genBtn;
    EditText numGenEditText;
    Spinner pageSpinner;
    TextView currentItemChooseTextView;
    ListView listContactView;

    //        define number images
    final Integer NUMBER_ICONS = 38;    // my prj has currently 38 images

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        //       load images
        Resources rs = getApplicationContext().getResources();
        List<Integer> listIcons = loadListIconIds(NUMBER_ICONS, rs);

//        bind objects
        genBtn = findViewById(R.id.genBtn);
        numGenEditText = findViewById(R.id.numGenEditText);
        pageSpinner = findViewById(R.id.pageSpinner);
        currentItemChooseTextView = findViewById(R.id.currentItemChooseTextView);
        listContactView = findViewById(R.id.listContactView);

//       get number of line contact that use entered
        genBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer num = Integer.parseInt(numGenEditText.getText().toString());
//                Toast.makeText(getApplication(), "Generate " + String.valueOf(num) + " contacts", Toast.LENGTH_SHORT).show();


//                define number contact per page
                final Integer CONTACT_PER_PAGE = 5;


                //                generate names and phone numbers
                List<String> listNames = generateListName(num);
                List<String> phoneNumbers = generatePhoneNumbers(num);

//                divide contacts for all pages | 5 people per page
                List<List<String>> pageNames = new ArrayList<>();
                List<List<String>> pagePhoneNumbers = new ArrayList<>();
                List<List<Integer>> pageIcons = new ArrayList<>();

                for (int i = 0; i < listNames.size(); i += CONTACT_PER_PAGE) {
                    int endIndex = Math.min(i + CONTACT_PER_PAGE, listNames.size());

//                    get sub list from parent list
                    List<String> names = listNames.subList(i, endIndex);
                    List<String> numbers = phoneNumbers.subList(i, endIndex);
                    List<Integer> icons = new ArrayList<>();

                    if (i + CONTACT_PER_PAGE > NUMBER_ICONS) {
                        icons = listIcons.subList(i % NUMBER_ICONS, endIndex % NUMBER_ICONS);
                    } else {
                        icons = listIcons.subList(i, endIndex);
                    }

//                    add to list of list per page
                    pageNames.add(names);
                    pagePhoneNumbers.add(numbers);
                    pageIcons.add(icons);

                }

//                handle spinner
//                create and store page number into a list and pass to adapter of spinner
                List<String> pageNumberSpinner = new ArrayList<String>();
                if (num % CONTACT_PER_PAGE == 0) {
                    for (int i = 1; i <= num / CONTACT_PER_PAGE; i++) {
                        pageNumberSpinner.add(String.valueOf(i));
                    }
                } else {
                    for (int i = 1; i <= num / CONTACT_PER_PAGE + 1; i++) {
                        pageNumberSpinner.add(String.valueOf(i));
                    }
                }



//              set adapter for spinner
                ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getApplication(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, pageNumberSpinner);
                pageSpinner.setAdapter(spinnerAdapter);


                pageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
//                        current page
                        int currentPage = pos ;

//                        get list contact for current page
                        List<String> currentNames = pageNames.get(pos);
                        List<String> currentPhoneNumbers = pagePhoneNumbers.get(pos);
                        List<Integer> currentIcons = pageIcons.get(pos);


//                set adapter for ListView
                        CustomContactItemAdapter adapter = new CustomContactItemAdapter(getApplication(), R.layout.custom_contact_item, currentNames, currentPhoneNumbers, currentIcons);
                        listContactView.setAdapter(adapter);

//                        set on click for item
                        listContactView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                                currentItemChooseTextView.setText("You choose: " + listNames.get(currentPage * CONTACT_PER_PAGE + pos));
                            }
                        });


                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

            }
        });


    }

    //    func to generate list name
    private List<String> generateListName(int num) {
        List<String> names = new ArrayList<String>();

        String[] firstNames = {"Bùi", "Trần", "Nguyễn", "Võ", "Đặng", "Lê", "Ngô", "Trương", "Đinh", "Vũ"};
        String[] middleNames = {"Thị Thanh", "Quang", "Anh", "Thị Thúy", "Thanh", "Ngọc", "Đức", "Thị Như", "Thành", "Hoàng Anh", "Thị Như"};
        String[] lastNames = {"Ngân", "Ý", "Trọng", "Vũ", "Kiều", "Chi", "Thọ", "Hà", "Lan", "Diễm"};

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
    private List<Integer> loadListIconIds(int num, Resources rs) {
        List<Integer> icons = new ArrayList<Integer>();
        if (rs == null) {
            Toast.makeText(getApplication(), "null resources", Toast.LENGTH_SHORT).show();
        }

//        format of img file name: icon_XX.jpg || XX is number from 01 - 38
        String name = "icon_";

        for (int i = 0; i < num; i++) {
            String id = num < 10 ? "0" + num : String.valueOf(num);
            name += id;
            Integer resId = rs.getIdentifier(name, "drawable", getPackageName());
            icons.add(resId);
        }

        return icons;
    }

    //    generate phone numbers
    private List<String> generatePhoneNumbers(int num) {
        List<String> listPhoneNumbers = new ArrayList<String>();

//        format of number : {id}xxxxxxx  | 10 digits in total
        String[] ids = {"036", "096", "038", "095"};

//        generator
        Random generator = new Random();

        for (int i = 0; i < num; i++) {
            String phoneNumber = ids[i % 4];

//            generate 7digits
            Integer ranNum = 1000000 + generator.nextInt(9000000);

            phoneNumber += String.valueOf(ranNum);

            listPhoneNumbers.add(phoneNumber);
        }

        return listPhoneNumbers;
    }

}
