package com.terrinc.rundomnumbers.details.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.terrinc.rundomnumbers.R

class DetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val details = requireArguments().getString(KEY)
        view.findViewById<TextView>(R.id.detailsTextView).text = details
    }

    companion object {
        private const val KEY = "details"
        fun newInstance(details: String) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putString(KEY, details)
            }
        }
    }
}
