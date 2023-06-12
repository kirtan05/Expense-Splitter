package com.example.nofights

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nofights.Model.GroupModel
import com.google.firebase.database.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class Groups : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groups)
        val recyclerview = findViewById<RecyclerView>(R.id.groupRecycler)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<GroupsData>()
        val user= Firebase.auth.currentUser
        val userid= user?.uid
        var k=0
        var str = "hi"
        //val db=Firebase.firestore
        /*val db = FirebaseFirestore.getInstance()
        if (userid != null) {
            data.add(GroupsData(R.drawable.groupps,userid))
            db.collection("Lists").document(userid)
                .collection(userid)
                .get().addOnSuccessListener{  task->

                    for (document in task) {
                        str+=document.id
                        data.add(GroupsData(R.drawable.groupps, "FF"))

                    }



            }
            var t="hi-ii"
            db.collection("Lists").document(userid).collection(userid).get().addOnCompleteListener {
                it.apply {
                    if (isSuccessful) {
                        for (document in result) {
                            val myObject = document.toObject(GroupName::class.java)
                            val s=myObject.grouppname
                            val k = document.id
                            data.add(GroupsData(R.drawable.groupps, "FF"))

                            s?.let { it1 -> GroupsData(R.drawable.groupps, it1) }
                                ?.let { it2 -> data.add(it2) }

                            Log.d(TAG, "${document.id} => ${document.data}")
                        }
                    } else {
                        Log.d(TAG, "Error: ", exception)
                    }
                }
            }



        }
        str+="FFF"
        data.add(GroupsData(R.drawable.groupps,str))
        for (i in 0..20) {
            data.add(GroupsData(R.drawable.groupps, "Item " + i))
        }*/
        //data.add(GroupsData(R.drawable.groupps, "Item" ))
        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter
        findViewById<Button>(R.id.kol).setOnClickListener()
        {
            val intent = Intent(this, CreateGroup::class.java)
            startActivity(intent)
            finish()
        }
        findViewById<Button>(R.id.goptions).setOnClickListener()
        {
            val intent = Intent(this, options::class.java)
            startActivity(intent)
            finish()
        }




    }


}