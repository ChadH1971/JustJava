package com.example.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayQuantity(quantity);
    }

    /**
     * This method increments the quantity value on the screen.
     */
    public void plusQuantity(View view) {
        quantity += 1;
        displayQuantity(quantity);
    }

    /**
     * This method decrements the quantity value on the screen.
     */
    public void minusQuantity(View view) {
        if (quantity > 0) {
            quantity -= 1;
        } else {
            quantity = 0;
        }
        displayQuantity(quantity);
    }

    /**
     * This method is called when the ORDER button is clicked.
     */
    public void submitOrder(View view) {
        double price = calculatePrice(quantity, 2.95);
        String displayCurrency = displayPrice(price);
        String priceMessage = "Total: " + displayCurrency + "\nThank You! Have a nice day.";
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method calculates the total based on quantity and item price
     *
     * @param numItems  the number of the items
     * @param itemPrice the price of the item being ordered
     * @return the product of the quantity and the itemPrice
     */
    private double calculatePrice(int numItems, double itemPrice) {

        return numItems * itemPrice;
    }

    /**
     * This method formats the price to the local currency.
     */
    private String displayPrice(double number) {
        String currency = NumberFormat.getCurrencyInstance().format(number);
        return currency;
    }

    /**
     * This method displays the given text on the screen.
     */
    public void displayMessage(String message) {
        TextView quantityTextView = (TextView) findViewById(R.id.orderSummary);
        quantityTextView.setText(message);
    }
}