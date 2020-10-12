package id.ac.ui.rahmatfadhilah.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.ac.ui.rahmatfadhilah.lab4.fragments.Fragment1
import id.ac.ui.rahmatfadhilah.lab4.fragments.Fragment2

class MainActivity : AppCompatActivity(), BridgeFragment {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1 = Fragment1()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment1).commit()

    }

    override fun onBackPressed() {
        val fragment1 = Fragment1()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment1).commit()
    }

    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("message", editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragment2 = Fragment2()
        fragment2.arguments = bundle

        transaction.replace(R.id.fragment_container, fragment2)
        transaction.commit()
    }
}