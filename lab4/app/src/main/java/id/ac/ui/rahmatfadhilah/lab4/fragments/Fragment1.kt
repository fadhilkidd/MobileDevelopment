package id.ac.ui.rahmatfadhilah.lab4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.ui.rahmatfadhilah.lab4.BridgeFragment
import id.ac.ui.rahmatfadhilah.lab4.R
import kotlinx.android.synthetic.main.fragment_fragment1.view.*

class Fragment1 : Fragment() {

    private lateinit var bridge: BridgeFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment1, container, false)

        bridge = activity as BridgeFragment

        view.buttonSubmit.setOnClickListener {
            bridge.passDataCom(view.inputText.text.toString())
        }
        return view
    }
}