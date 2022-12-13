package com.example.dsbosses

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.dsbosses.placeholder.PlaceholderContent
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * A fragment representing a list of Items.
 */
class BossFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1
    private var listener: OnListFragmentInteractionListener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_boss_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                val bossesNames: MutableList<String> = arrayListOf()
                getBosses{ bossesList ->
                    /*for(item in bossesList) {
                        bossesNames.add(item.name)
                    }*/
                    adapter = MyBossRecyclerViewAdapter(bossesList, listener)
                }
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: BossEntity?)
    }

    fun getBosses(callback: (MutableList<BossEntity>) -> Unit ){
        val url = Constants.API_URL + Constants.DS1_PATH
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null, { response ->
                /*val status = response.optInt(Constants.STATUS, Constants.ERROR)
                if (status == Constants.SUCCESS) {*/
                val jsonList = response.getJSONArray(Constants.BOSSES_PROPERTY).toString()
                val mutableListType = object : TypeToken<MutableList<BossEntity>>(){}.type
                val bossesList = Gson().fromJson<MutableList<BossEntity>>(jsonList, mutableListType)
                callback(bossesList)
            },
            { error ->
                error.printStackTrace()
            }
        )
        val myActivity: Activity? = activity
        var requestQueue = Volley.newRequestQueue(myActivity as Context)
        requestQueue.add(jsonObjectRequest)
    }

}