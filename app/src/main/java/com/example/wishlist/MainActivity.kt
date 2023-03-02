package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnLongClickListener
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var WishlistItems = mutableListOf<Wishlist>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Create a variable that references each of your EditTextViews
        val name = findViewById<EditText>(R.id.nameET)
        val price = findViewById<EditText>(R.id.priceET)
        val url = findViewById<EditText>(R.id.urlET)
        //Create a variable that references your button and counter
        val button = findViewById<Button>(R.id.Submission)

        // Lookup the RecyclerView in activity layout
        val itemsRv = findViewById<RecyclerView>(R.id.itemsRv)
        // Create adapter passing in the list of wishlist items
        val itemsRvAdapter = WishlistAdapter(WishlistItems)

        // Attach the adapter to the RecyclerView to populate items
        itemsRv.adapter = itemsRvAdapter
        // Set layout manager to position the items
        itemsRv.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            //Create 3 variables that translates the values
            // from the EditTextViews into a readable string
            val userinputname = name.text.toString()
            val userinputprice = price.text.toString()
            val userinputstore = url.text.toString()
            //Create a variable that calls the Wishlist (Model Class) function and pass the 3 parameters.
            // Those 3 parameters will be the 3 placeholder variables you created.
            val wishlistitems = Wishlist(userinputname, userinputprice, userinputstore)
            //Set what you named your adapter object variable to call the NotifyItemInserted and inside
            //the parameter, pass in the size of the variable for our mutable list - 1
            WishlistItems.add(wishlistitems)
            itemsRvAdapter.notifyItemInserted(WishlistItems.size-1)
            name.text.clear()
            price.text.clear()
            url.text.clear()
        }
    }
}