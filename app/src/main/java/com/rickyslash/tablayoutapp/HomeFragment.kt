package com.rickyslash.tablayoutapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class HomeFragment : Fragment() {

    companion object {
        const val ARG_SECTION_NUMBER = "section_number"

        // this variable set by purpose IF want 'send data' from 'Activity to Fragment'
        const val ARG_NAME = "app_name"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvLabel: TextView = view.findViewById(R.id.section_label)
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)

        // this for IF want 'send data' from 'Activity to Fragment'
        // this 'WILL GET' the 'data' from Activity
        val name = arguments?.getString(ARG_NAME)

        tvLabel.text = getString(R.string.content_tab_text, index)
    }
}