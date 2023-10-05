/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource
import java.util.zip.Inflater

class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    private val dogList = DataSource.dogs

    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val dogImageView = view?.findViewById<ImageView>(R.id.imageView_doggler)
        val dogAgeTextView = view?.findViewById<TextView>(R.id.age_doggler)
        val dogNameTextView = view?.findViewById<TextView>(R.id.name_doggler)
        val dogHobbiesTextView = view?.findViewById<TextView>(R.id.hobbies_doggler)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {

        val adapterLayout = when (layout) {
            Layout.GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item, parent, false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
        }
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }



    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {

        val dogData = dogList[position]
        holder.dogImageView?.setImageResource(dogData.imageResourceId)
        holder.dogNameTextView?.text = dogData.name
        val resources = context?.resources
        holder.dogAgeTextView?.text = resources?.getString(R.string.age_doggler, dogData.age)

        holder.dogHobbiesTextView?.text = resources?.getString(R.string.hobbies_doggler, dogData.hobbies)

    }
}
