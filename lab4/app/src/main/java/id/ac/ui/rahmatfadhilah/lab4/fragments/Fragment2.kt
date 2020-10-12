package id.ac.ui.rahmatfadhilah.lab4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.ui.rahmatfadhilah.lab4.R
import kotlinx.android.synthetic.main.fragment_fragment2.view.*

class Fragment2 : Fragment() {
    var displayMessage: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_fragment2, container, false)

        displayMessage = arguments?.getString("message")

        view.resultText.text = displayMessage

        return view
    }
}