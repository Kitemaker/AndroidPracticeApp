package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity =  2;
    int pricepercup = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display(quantity);
        displayPrice(quantity * pricepercup);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String message = "Order for " + String.valueOf(quantity) + " no of coffe \n Price is " +
                String.valueOf(quantity * pricepercup);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order From Saleem");
        intent.putExtra(Intent.EXTRA_TEXT , message );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_View);
        quantityTextView.setText("" + number);
    }
    private void  displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number * pricepercup));
    }

    public void increment(View view){
        quantity++;
        display(quantity);
        displayPrice(quantity);
    }
    public void decrement(View view){
        if(quantity>=1) {
            quantity--;
        }
        else{quantity =0;}
        display(quantity);
        displayPrice(quantity);
    }

}
