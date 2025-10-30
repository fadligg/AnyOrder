package lat.pam.anyorder

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lat.pam.anyorder.databinding.ActivityMainBinding // Import the binding class



class MainActivity : AppCompatActivity() {

    // Declare a variable for the binding class
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using the binding class
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Set the root of the binding as the content view
        setContentView(binding.root)

        // Access the button directly and safely through the binding object
        // The ID "button_bottom" becomes "buttonBottom" in camelCase
        binding.buttonBottom.setOnClickListener {
            openSignUpActivity()
        }
    }


    private fun openSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}
