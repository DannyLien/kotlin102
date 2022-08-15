package com.tom.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tom.shop.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    lateinit var cities: Array<String>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cities = requireContext().resources.getStringArray(R.array.cities)
        binding.recycler.layoutManager = LinearLayoutManager(context)
        binding.recycler.setHasFixedSize(true)
        binding.recycler.adapter = object : RecyclerView.Adapter<CityViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
                val view = LayoutInflater.from(context).inflate(
                    R.layout.cow_cites, parent, false
                )
                return CityViewHolder(view)
            }

            override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
                holder.citeName.text = cities[position]
            }

            override fun getItemCount(): Int {
                return cities.size
            }

        }

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    class CityAdapter():RecyclerView.Adapter<CityViewHolder>(){}

    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val citeName: TextView = itemView.findViewById(R.id.cityName)
    }

}

