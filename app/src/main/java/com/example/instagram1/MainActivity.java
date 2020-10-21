package com.example.instagram1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.instagram1.fragments.ComposeFragment;
import com.example.instagram1.fragments.PostsFragment;
import com.example.instagram1.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class MainActivity extends Activity {

    public static  final String TAG = "MainActivity";

    final FragmentManager fragmentManager = getSupportFragmentManager();
    private BottomNavigationView bottomNavigationView;

    private PatternSyntaxException post;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);

          bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
              @Override
              public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                  Fragment fragment;
                  switch (menuItem.getItemId()) {
                      case R.id.action_home:
                          //todo update fragment
                          fragment = new PostsFragment();
                          break;
                      case R.id.action_compose:
                          fragment = new ComposeFragment();
                          break;
                      case R.id.action_profile:
                      default:
                          fragment = new ProfileFragment();
                          break;
                  }
                  fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                  return true;
              }
          });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }


    public FragmentManager getSupportFragmentManager() {
        return supportFragmentManager;
    }

    public void setSupportFragmentManager(FragmentManager supportFragmentManager) {
        this.supportFragmentManager = supportFragmentManager;
    }
}
