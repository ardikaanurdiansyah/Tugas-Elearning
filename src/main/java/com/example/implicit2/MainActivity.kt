package com.example.implicit2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val websiteEditText: EditText = findViewById(R.id.website_edit_text)
        val openWebsiteButton: Button = findViewById(R.id.open_website_button)
        openWebsiteButton.setOnClickListener {
            val websiteUrl = websiteEditText.text.toString()
            openWebsite(websiteUrl)
        }

        val locationEditText: EditText = findViewById(R.id.location_edit_text)
        val locationButton: Button = findViewById(R.id.location_button)
        locationButton.setOnClickListener {
            val locationName = locationEditText.text.toString()
            openLocation(locationName)
        }

        val shareTextButton: Button = findViewById(R.id.share_text_button)
        shareTextButton.setOnClickListener {
            val shareText = "Website: ${websiteEditText.text}, Location: ${locationEditText.text}"
            shareText(shareText)
        }

        val implicitEdit: EditText = findViewById(R.id.implicit_edit_text)
        val implicitButton: Button = findViewById(R.id.implicit_button)
        implicitButton.setOnClickListener {
            val sendText = implicitEdit.text.toString()
            sendData(sendText)
        }
    }

    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun openLocation(location: String) {
        val uri = Uri.parse("geo:0,0?q=$location")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }

    private fun shareText(text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(intent, "Share Text"))
    }

    private fun sendData(text: String) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("INI DIKIRIM", text)
        startActivity(intent)
    }

    fun sharetext(view: View) {}
    fun sendData(view: View) {}
    fun openlocation(view: View) {}
    fun openwebsite(view: View) {}
}
