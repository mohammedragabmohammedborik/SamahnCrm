package com.ismart.samahncrm.crmhome;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ismart.samahncrm.R;
import com.ismart.samahncrm.databinding.ActivityCrmBinding;

public class CrmHoneActivity extends AppCompatActivity {
    private ActivityCrmBinding activityCrmBinding;
    private NavController navController;
   private AppBarConfiguration appBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCrmBinding= DataBindingUtil.setContentView(this,R.layout.activity_crm);
        setSupportActionBar(activityCrmBinding.homeIdContainer.toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //
        navController = Navigation.findNavController(this, R.id.fragment2);

        appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph())
                        .setDrawerLayout(activityCrmBinding.drawerlayout)
                        .build();


        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        NavigationUI.setupWithNavController(activityCrmBinding.navigationview, navController);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

            }
        });

       // NavigationUI.setupWithNavController(bottomNavigationId, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        NavController navController = Navigation.findNavController(this, R.id.fragment2);
//        if(item.getItemId()==R.id.list_show_aqar1){
//            if(!checkF){
//                navController.navigate(R.id.list_show_aqar);
////                if (inputManager.isActive()) {
////                    inputManager.hideSoftInputFromWindow(new View(this).getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
////
////                }
//                checkF=true;
//            }else {
//                navController.navigate(R.id.homeFragment);
//                checkF=false;
//            }
//            // Log.w(TAG, "onOptionsItemSelected: "+checkF );
//        }
//        else if (item.getItemId()==R.id.notificationFragment1 )
//        {
//            String token =SharedPrefManager.getInstance(MainActivity.this).getToken();
//            if (token!=null)
//            {
//                navController.navigate(R.id.notificationFragment);
//
//            }
//            else {
//                ShowAlertDialog();
//            }
//        }
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }
}
