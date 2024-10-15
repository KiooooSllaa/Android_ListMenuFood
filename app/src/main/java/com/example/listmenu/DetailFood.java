package com.example.listmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DetailFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_food);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        int foodImage = intent.getIntExtra("foodImage", 0);
        String tagName = intent.getStringExtra("tagName");
        String foodPrice = intent.getStringExtra("foodPrice");
        String[] ingredients = intent.getStringArrayExtra("ingredients"); // Nhận danh sách thành phần

        // Khởi tạo các view trong layout
        TextView foodNameView = findViewById(R.id.foodName);
        TextView foodPriceView = findViewById(R.id.foodPrice);
        ImageView foodImageView = findViewById(R.id.foodImage);
        LinearLayout ingredientsLayout = findViewById(R.id.ingredientsLayout); // Layout để chứa thành phần

        foodNameView.setText(tagName);
        foodPriceView.setText(foodPrice);
        foodImageView.setImageResource(foodImage);


        if (ingredients != null) {
            for (String ingredient : ingredients) {
                TextView ingredientTextView = new TextView(this);
                ingredientTextView.setText("- " + ingredient);
                ingredientTextView.setTextSize(16);
                ingredientsLayout.addView(ingredientTextView);
            }
        }
    }
}
