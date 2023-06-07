package com.gkm.techconn.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gkm.techconn.databinding.FragmentFullScreenImageBinding
import com.squareup.picasso.Picasso

private const val ARG_IMAGE_URL = "image_url"

class FullScreenImageFragment : Fragment() {

    private lateinit var imageUrl:String
    private lateinit var binding: FragmentFullScreenImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

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

        fun newInstance(imageUrl:String):FullScreenImageFragment{
            val fragment = FullScreenImageFragment()
            val args = Bundle()
            args.putString(ARG_IMAGE_URL, imageUrl)
            fragment.arguments = args
            return fragment
        }
    }
}