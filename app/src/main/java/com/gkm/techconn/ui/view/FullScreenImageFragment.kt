package com.gkm.techconn.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gkm.techconn.R
import com.gkm.techconn.databinding.FragmentFullScreenImageBinding
import com.squareup.picasso.Picasso

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FullScreenImageFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var imageUrl:String
    private lateinit var binding: FragmentFullScreenImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

            imageUrl = it.getString(ARG_IMAGE_URL,"")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFullScreenImageBinding.inflate(inflater,container,false)

        Picasso.get()
            .load(imageUrl)
            .into(binding.imgFullScreen)

        return binding.root//inflater.inflate(R.layout.fragment_full_screen_image, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FullScreenImageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
        private const val ARG_IMAGE_URL = "image_url"

        fun newInstance(imageUrl:String):FullScreenImageFragment{
            val fragment = FullScreenImageFragment()
            val args = Bundle()
            args.putString(ARG_IMAGE_URL, imageUrl)
            fragment.arguments = args
            return fragment
        }
    }
}