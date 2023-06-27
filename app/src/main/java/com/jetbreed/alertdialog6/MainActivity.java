package com.jetbreed.alertdialog6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Button and TextView instances
    Button bOpenAlertDialog;
    TextView tvSelectedItemPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // register both UI elements with their appropriate IDs.
        bOpenAlertDialog = findViewById(R.id.openAlertDialogButton);
        tvSelectedItemPreview = findViewById(R.id.selectedItemPreview);

        // single item array instance to store which element is selected by user initially
        // it should be set to zero meaning none of the element is selected by default
        final int[] checkedItem = {-1};

        // handle the button to open the alert dialog with the single item selection when clicked
        bOpenAlertDialog.setOnClickListener(v -> {
            // AlertDialog builder instance to build the alert dialog
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

            // set the custom icon to the alert dialog
            alertDialog.setIcon(R.drawable.image_logo);

            // title of the alert dialog
            alertDialog.setTitle("Choose an Item");

            // list of the items to be displayed to the user in the
            // form of list so that user can select the item from
            final String[] listItems = new String[]{"Android Development", "Web Development", "Machine Learning"};

            // the function setSingleChoiceItems is the function which
            // builds the alert dialog with the single item selection
            alertDialog.setSingleChoiceItems(listItems, checkedItem[0], (dialog, which) -> {
                // update the selected item which is selected by the user so that it should be selected
                // when user opens the dialog next time and pass the instance to setSingleChoiceItems method
                checkedItem[0] = which;

                // now also update the TextView which previews the selected item
                tvSelectedItemPreview.setText("Selected Item is : " + listItems[which]);

                // when selected an item the dialog should be closed with the dismiss method
                dialog.dismiss();
            });

            // set the negative button if the user is not interested to select or change already selected item
            alertDialog.setNegativeButton("Cancel", (dialog, which) -> {

            });

            // create and build the AlertDialog instance with the AlertDialog builder instance
            AlertDialog customAlertDialog = alertDialog.create();

            // show the alert dialog when the button is clicked
            customAlertDialog.show();
        });
    }
}
