package com.caganbicakci.spaceexplorer.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.caganbicakci.spaceexplorer.BR
import com.caganbicakci.spaceexplorer.R
import com.caganbicakci.spaceexplorer.databinding.FragmentPlanetDetailBinding

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

            /**
             * tvPlanetOrder.text = eg. "Planet order: 3" for Earth
             */
            tvPlanetOrder.text = getString(R.string.planet_order, args.planetModel.planetOrder)


            /**
             * tvPlanetDescription.text applied max lines as 4.
             * If it clicked in ui, expands text and if it clicked again it collapse.
             * and has ellipsize at end "..."
             */

            tvPlanetDescription.setOnClickListener {

                tvPlanetDescription.apply {
                    if (isCollapsed) {
                        maxLines = Int.MAX_VALUE
                        ellipsize = null
                    } else {
                        maxLines = 4
                        ellipsize = TextUtils.TruncateAt.END
                    }
                    isCollapsed = !isCollapsed
                }
            }


            //for opening wikipedia link from planetModel on browser
            wikiLinkCard.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(args.planetModel.wikiLink))
                startActivity(intent)
            }

            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}