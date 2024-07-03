package sumagoscope.madipt.b1menus;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Toolbar toolBar;
    Button btnPopup;
    Button btnContextMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBar=findViewById(R.id.toolBar);
        btnPopup=findViewById(R.id.btnPopup);
        btnContextMenu=findViewById(R.id.btnContext);
        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle("Home");
        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu=new PopupMenu(MainActivity.this,btnPopup);
                popupMenu.inflate(R.menu.popup_menu);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    popupMenu.setForceShowIcon(true);
                }
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        if(item.getItemId()==R.id.action_home)
                        {
                            Toast.makeText(MainActivity.this, "Clicked On Home", Toast.LENGTH_SHORT).show();
                        }
                        if(item.getItemId()==R.id.action_phone)
                        {
                            Toast.makeText(MainActivity.this, "Clicked On Phone...", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        registerForContextMenu(btnContextMenu);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if(item.getItemId()==R.id.action_home)
        {
            //Toast.makeText(MainActivity.this, "Clicked On Home", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
        if(item.getItemId()==R.id.action_phone)
        {
            Toast.makeText(MainActivity.this, "Clicked On Phone...", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_home)
        {
            Toast.makeText(MainActivity.this, "Clicked On Home", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.action_phone)
        {
            Toast.makeText(MainActivity.this, "Clicked On Phone...", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}