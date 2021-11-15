package com.example.mydz11;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_toast).setOnClickListener(view -> showToast());
        findViewById(R.id.button_snack_bar_with_action).setOnClickListener(view -> showSnackBarWithAction());
        findViewById(R.id.container_view).setOnClickListener(veiw ->showSnackBar() );
        findViewById(R.id.button_alert_dialog).setOnClickListener(view -> showAlertDialog());
        findViewById(R.id.button_alert_dialog_with_view).setOnClickListener(view -> showAlertDialogWithCustomView());
        Button alertDialog = findViewById(R.id.alertDialog);
        alertDialog.setOnClickListener(clickListenerDialog);

    }

    private final View.OnClickListener clickListenerDialog = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.exclamation)
                    .setMessage(R.string.message)
                    .setPositiveButton(R.string.yes, dialogListener)
                    .setNegativeButton(R.string.no, dialogListener);

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };


    private DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

        }
    };

    private void showAlertDialogWithCustomView() {
        final View customView = getLayoutInflater().inflate(R.layout.prob_costom, null);
        customView.findViewById(R.id.button_custom_view).setOnClickListener(view -> showToast());

        new AlertDialog.Builder(this)
                .setTitle("AlertDialog with custom view")
                .setView(customView)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Yes!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "No!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Cancel", null)
                .show();
    }


    private void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("AlertDialog!")
                .setMessage("Your message here")
                //.setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Yes!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "No!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Cancel", null)
                .show();
    }







    private void showSnackBarWithAction() {
        Snackbar.make(findViewById(R.id.container_view), "SnackBar with Action", Snackbar.LENGTH_INDEFINITE)
                .setAction("Push me", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showToast();
                    }
                })
                .show();
    }
    private void showToast() {
        Toast.makeText(this, "Toast", Toast.LENGTH_SHORT).show();
    }
    private void showSnackBar() {
        Snackbar.make(findViewById(R.id.container_view), "SnackBar", Snackbar.LENGTH_SHORT).show();
    }


}
