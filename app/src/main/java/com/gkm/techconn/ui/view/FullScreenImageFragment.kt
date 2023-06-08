package com.gkm.techconn.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gkm.techconn.databinding.FragmentFullScreenImageBinding
import com.squareup.picasso.Picasso

class FullScreenImageFragment : Fragment() {

    private var imageUrl:String? = null
    private lateinit var binding: FragmentFullScreenImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageUrl = it.getString(ARG_IMAGE_URL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFullScreenImageBinding.inflate(inflater,container,false)

        if(!imageUrl.isNullOrEmpty()){
            fullImage()
        }

        return binding.root//inflater.inflate(R.layout.fragment_full_screen_image, container, false)
    }

    private fun fullImage() {
        Picasso.get()
            .load(imageUrl)
            .into(binding.imgFullScreen)
    }


    companion object {
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