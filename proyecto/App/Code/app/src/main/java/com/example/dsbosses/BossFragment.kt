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
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class BossFragment : Fragment() {

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
                getBosses{ bossesList ->
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

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: BossEntity?)
    }

    fun getBosses(callback: (MutableList<BossEntity>) -> Unit ){
        val myActivity: Activity? = activity
        val extra = myActivity?.intent?.extras
        val endPoint: String? = extra?.getString("endpoint")
        val url = Constants.API_URL + endPoint
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null, { response ->
                val jsonList = response.getJSONArray(Constants.BOSSES_PROPERTY).toString()
                val mutableListType = object : TypeToken<MutableList<BossEntity>>(){}.type
                val bossesList = Gson().fromJson<MutableList<BossEntity>>(jsonList, mutableListType)
                callback(bossesList)
            },
            { error ->
                error.printStackTrace()
            }
        )
        var requestQueue = Volley.newRequestQueue(myActivity as Context)
        requestQueue.add(jsonObjectRequest)
    }

}