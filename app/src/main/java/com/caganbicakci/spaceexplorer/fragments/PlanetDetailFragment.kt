package com.caganbicakci.spaceexplorer.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity.END
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.caganbicakci.spaceexplorer.BR
import com.caganbicakci.spaceexplorer.databinding.FragmentPlanetDetailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [PlanetDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlanetDetailFragment : Fragment() {

    private lateinit var fragmentPlanetDetailBinding: FragmentPlanetDetailBinding
    private var isCollapsed = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentPlanetDetailBinding = FragmentPlanetDetailBinding.inflate(inflater)
        return fragmentPlanetDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: PlanetDetailFragmentArgs by navArgs()

        fragmentPlanetDetailBinding.apply {
            setVariable(BR.planetModel, args.planetModel)

            tvPlanetDescription.maxLines

            tvPlanetDescription.setOnClickListener(View.OnClickListener {
                if (isCollapsed) {
                    tvPlanetDescription.maxLines = Int.MAX_VALUE
                    tvPlanetDescription.ellipsize = null
                } else {
                    tvPlanetDescription.maxLines = 4
                    tvPlanetDescription.ellipsize = TextUtils.TruncateAt.END
                }
                isCollapsed = !isCollapsed
            })
        }
    }
}