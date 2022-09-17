package com.caganbicakci.spaceexplorer.fragments

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.TextAppearanceSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.caganbicakci.spaceexplorer.R
import com.caganbicakci.spaceexplorer.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentHomeBinding.apply {

            tvHome.text = getString(R.string.lets_explore)

            setTextStyleSpan(tvHome, 18, 30, R.style.orangeOpenSans)
            setTextStyleSpan(tvHome, 36, 44, R.style.orangeOpenSans)

            btnLetsGo.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_planetFragment)
            }
        }

    }

    //spannable feature required min api 28
    private fun setTextStyleSpan(
        textView: TextView,
        startPosition: Int,
        endPosition: Int,
        style: Int
    ) {

        val spannableStr = SpannableString(textView.text)

        spannableStr.setSpan(
            TextAppearanceSpan(context, style),
            startPosition,
            endPosition,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )

        textView.text = spannableStr

    }
}