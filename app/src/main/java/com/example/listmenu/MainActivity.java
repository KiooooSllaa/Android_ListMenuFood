package com.example.listmenu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String foodList[] = {"Burger", "Flan Cake", "Pizza", "Soup", "Beef Steak", "Noodle"};
    String tag[] = {"Beef Burger", "Caramel Flan", "Spicy Chiken Pizza", "Vegetable Soup", "Tasty Wagyu Steak", "Spaghetti Recipe"};
    String foodPrices[] = {"$36", "$15", "$40", "$28", "$52", "$28"};
    int foodImages[] = {R.drawable.burger, R.drawable.flan, R.drawable.pizza, R.drawable.soup, R.drawable.dish, R.drawable.noodle};
    String ingredients[][] = {
            {"Beef patty", "Lettuce", "Cheese", "Potato"},
            {"Egg", "Caramel", "Milk"},
            {"Chicken", "Cheese", "Tomato sauce", "Pizza dough"},
            {"Carrot", "Potato", "Peas", "Salt"},
            {"Wagyu beef", "Pepper", "Salt", "Garlic"},
            {"Noodles", "Tomato sauce", "Garlic", "Meatballs"}
    };

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), foodList, foodImages, tag, foodPrices);
        listView.setAdapter(customBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("CUSTOM_LIST_VIEW", "Item is clicked @ Position ::" + position);

                Intent intent = new Intent(MainActivity.this, DetailFood.class);
                intent.putExtra("foodImage", foodImages[position]);
                intent.putExtra("tagName", tag[position]);
                intent.putExtra("foodPrice", foodPrices[position]);
                intent.putExtra("ingredients", ingredients[position]);

                startActivity(intent);
            }

        });
    }
}