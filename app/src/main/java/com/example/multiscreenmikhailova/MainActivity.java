package com.example.multiscreenmikhailova;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    //Создаем массив данных
    String[]countries = {"Аргентина", "Бразилия", "Чили", "Колумбия", "Уругвай"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Создание наследника адаптера
        ArrayAdapter<String>adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout. simple_list_item_1, countries);
        setListAdapter(adapter);

        //Подключение обработки нажатий
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Создание оператора switch который отслеживает на какую кнопку нажато
                switch (position){
                    case 0:
                        Intent intent1 = new Intent(MainActivity.this, Argentina.class);
                        startActivity(intent1);
                        break;
                    case 1:
                        Intent intent2 = new Intent(MainActivity.this, Brazil.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(MainActivity.this, Chili.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4 = new Intent(MainActivity.this, Columbia.class);
                        startActivity(intent4);
                        break;
                    case 4:
                        Intent intent5 = new Intent(MainActivity.this, Urugvai.class);
                        startActivity(intent5);
                        break;

                }

                //Добавление всплывающего окна которое будет показывать что выбрано
                Toast.makeText(getApplicationContext(),"Вы выбрали" + parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }
        };

        //подключение обработчика который возвращает Listview
        getListView().setOnItemClickListener(itemListener);
    }
}