package com.example.rkuplace;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import android.view.View;

//initialization

public class Home extends AppCompatActivity {
    private NavigationView nav;
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawerLayout;
    private ImageSlider imageSlider;
    private FirebaseAuth mAuth;
    private ProgressDialog mDialog,mDialog1;
    private ImageView btncompanies,btncompanies1;
    String https;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mDialog= new ProgressDialog(this);
        mDialog1= new ProgressDialog(this);
        imageSlider = findViewById(R.id.imageSlider);

        //ImageSlider Array list
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://rku.ac.in/images/placement/round-graph.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://images.shiksha.com/mediadata/images/articles/1658722034php2awt94.jpeg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://rku.ac.in/images/newhomepage/NAAC_2.png", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://rku.ac.in/images/newhomepage/aria-slider.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://rku.ac.in/images/newhomepage/nirf-ranking-slider.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://rku.ac.in/images/newhomepage/NAAC_1.jpg", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mAuth=FirebaseAuth.getInstance();
        nav = (NavigationView) findViewById(R.id.navmenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        //Function call for company
        companyfunc();


        //Function call for notification
        notifyfunc();

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                //Switchcase for sidemenu

                //All side menu intent
                switch (menuItem.getItemId()) {

                    case R.id.home_menu:
                        Intent intent = new Intent(Home.this, Home.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.prominent_menu:
                        Intent j = new Intent(Home.this, Prominent.class);
                        startActivity(j);
                        break;

                    case R.id.payment_menu:
                        Intent pay = new Intent(Home.this, Payment.class);
                        startActivity(pay);
                        break;

                    case R.id.quiz_menu:
                        Intent m = new Intent(Home.this, quiz.class);
                        startActivity(m);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.about_menu:
                        Intent k = new Intent(Home.this, About.class);
                        startActivity(k);
                        break;

                    case R.id.share:
                        Intent myIntent = new Intent(Intent.ACTION_SEND);
                        myIntent.setType("text/plain");
                        String body = "https://drive.google.com/file/d/1px4VfCsze1SqVQvkYGFZs53_W2Mqzhl4/view?usp=share_link";
                        String sub = "Your Subject";
                        myIntent.putExtra(Intent.EXTRA_SUBJECT, sub);
                        myIntent.putExtra(Intent.EXTRA_TEXT, body);
                        startActivity(Intent.createChooser(myIntent, "Share Using"));
                        break;


                    case R.id.facebook:
                        Uri uri = Uri.parse(String.format("https://www.facebook.com/rkuindia"));
                        Intent intent1 = new Intent(Intent.ACTION_VIEW);
                        intent1.setData(uri);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent1);
                        break;

                    case R.id.google:
                        Uri uri1 = Uri.parse(String.format("https://rku.ac.in/about-training-and-placement"));
                        Intent intent2 = new Intent(Intent.ACTION_VIEW);
                        intent2.setData(uri1);
                        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent2);
                        break;

                    case R.id.linkedin:
                        Uri uri4 = Uri.parse(String.format("https://www.linkedin.com/school/rkuniversity/"));
                        Intent intent4 = new Intent(Intent.ACTION_VIEW);
                        intent4.setData(uri4);
                        intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent4);
                        break;


                    case R.id.twitter:
                        Uri uri3 = Uri.parse(String.format("https://twitter.com/RKUniversity"));
                        Intent intent3 = new Intent(Intent.ACTION_VIEW);
                        intent3.setData(uri3);
                        intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent3);
                        break;

                    case R.id.changepassword:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        changepassword();
                        break;

                    case R.id.logout_menu:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        logout();
                        break;

                    case R.id.exit_menu:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        exit();
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + menuItem.getItemId());
                }

                return true;
            }
        });


    }

        //Change Password function
    public void changepassword() {
        EditText resetMail = new EditText(this);
        android.app.AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(this);
        passwordResetDialog.setTitle("Change Password?");
        passwordResetDialog.setMessage("Enter your email to received change password link.");
        passwordResetDialog.setView(resetMail);

        passwordResetDialog.setPositiveButton("Change", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                startActivity(new Intent(getApplicationContext(),Home.class));
                String mail = resetMail.getText().toString();
                mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Home.this, "Change Password Link Sent To your Email.", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Home.this, "Error ! Change Password is not Sent To your Email." + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
        passwordResetDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

            }
        });
        passwordResetDialog.create().show();
    }








    //Logout function

    public void logout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout?");
        builder.setMessage("Are you sure want to logout?")
                        .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        FirebaseAuth.getInstance().signOut();
                                        SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
                                        SharedPreferences.Editor editor = pref.edit();
                                        editor.putBoolean("flag",false);
                                        editor.apply();
                                        Toast.makeText(getApplicationContext(),"Logout Sucessfully  ",Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(),login.class));
                                        finish();
                                    }
                                })
                                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.cancel();
                                            }
                                        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

//Exit functionalities
    public void exit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit?");
        builder.setMessage("Are you sure want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                        Toast.makeText(getApplicationContext(),"Exit  ",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),login.class));
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }



//Intent Activity

    private void companyfunc() {
        btncompanies = findViewById(R.id.btncompanies);



        btncompanies.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),our_companies.class));



            }
        });



    }

    //Motification method

    private void notifyfunc() {
        btncompanies1 = findViewById(R.id.btncompanies1);

        btncompanies1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),notification.class));




            }
        });



    }


//Intent Activity

    public void liaison_officers(View view) {
        Intent liaison = new Intent(Home.this, liaison_officers.class);
        startActivity(liaison);
    }


    public void study_material(View view) {
        Intent study_material = new Intent(Home.this, Study_Material.class);
        startActivity(study_material);
    }

    public void apply_company(View view) {
        Intent exam = new Intent(Home.this,apply_company_form.class);
        startActivity(exam);
    }

    public void complaints(View view) {
        Intent complaints = new Intent(Home.this, Complaints.class);
        startActivity(complaints);
    }

    public void contact_us(View view) {
        Intent contact_us = new Intent(Home.this, Contact_Us.class);
        startActivity(contact_us);
    }

    public void notification(View view) {
        Intent notif = new Intent(Home.this, notification.class);
        startActivity(notif);
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure want to exit ?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("no", null).show();
    }
}