package com.excavanger.remember.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.excavanger.remember.R;
import com.excavanger.remember.adapters.ItemAdapters;
import com.excavanger.remember.models.Colors;
import com.excavanger.remember.models.ItemModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    private final FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private final FirebaseUser firebaseUser = mAuth.getCurrentUser();
    private CircleImageView userImage;
    private TextView greetingTV;
    private ImageView calendarIcon;
    private RecyclerView itemRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getViews();
        setViewsData();
    }

    private void getViews() {
        userImage = findViewById(R.id.user_image);
        greetingTV = findViewById(R.id.greeting);
        calendarIcon = findViewById(R.id.calendar_icon);
        itemRecycler = findViewById(R.id.item_recycler_view);
    }

    private void setViewsData() {
        Picasso.get().load(firebaseUser.getPhotoUrl()).into(userImage);
        String greetingText = "Hi, " + firebaseUser.getDisplayName();
        greetingTV.setText(greetingText);
        Calendar myCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
            }
        };
        calendarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(HomeActivity.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        ItemModel itemModel1 = new ItemModel(
                UUID.randomUUID(),
                "#"+ Colors.DEEP_ORANGE.getHexValue(),
                "This is 1st item");

        ItemModel itemModel2 = new ItemModel(
                UUID.randomUUID(),
                "#"+ Colors.DEEP_PURPLE.getHexValue(),
                "This is 2nd item");
        ItemModel itemModel3 = new ItemModel(
                UUID.randomUUID(),
                "#"+ Colors.PURPLE.getHexValue(),
                "This is 1st item");

        ItemModel itemModel4 = new ItemModel(
                UUID.randomUUID(),
                "#"+ Colors.ORANGE.getHexValue(),
                "This is 2nd item");
        ItemModel itemModel5 = new ItemModel(
                UUID.randomUUID(),
                "#"+ Colors.PINK.getHexValue(),
                "This is 1st item");

        ItemModel itemModel6 = new ItemModel(
                UUID.randomUUID(),
                "#"+ Colors.RED.getHexValue(),
                "This is 2nd item");
        List<ItemModel> itemModelList = new ArrayList<>();
        itemModelList.add(itemModel1);
        itemModelList.add(itemModel2);
        itemModelList.add(itemModel3);
        itemModelList.add(itemModel4);
        itemModelList.add(itemModel5);
        itemModelList.add(itemModel6);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        itemRecycler.setLayoutManager(mLayoutManager);
        ItemAdapters itemAdapters = new ItemAdapters(itemModelList);
        itemRecycler.setAdapter(itemAdapters);
        itemAdapters.notifyDataSetChanged();
    }

    private void showDialog(){
        final BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_layout);
        LinearLayout layout = dialog.findViewById(R.id.logout_linear_layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutUser();
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    private void logoutUser() {
        mAuth.signOut();
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}