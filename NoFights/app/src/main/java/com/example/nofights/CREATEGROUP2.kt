package com.example.nofights

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.nofights.Model.GroupModel
import com.example.nofights.Model.GroupMemberModel
import com.google.firebase.database.*
import com.example.nofights.DialogUtils
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CREATEGROUP2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val db = Firebase.firestore
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creategroup2)
        findViewById<Button>(R.id.btnCreate).setOnClickListener {
            val text=findViewById<EditText>(R.id.txtName).text.toString()
            val ammount = findViewById<EditText>(R.id.txtAmmount).text.toString()

            if(text.isNotEmpty() && ammount.isNotEmpty()){

                val user=Firebase.auth.currentUser
                val userid= user?.uid
                val username= user?.displayName
                val useremail = user?.email
                /*val data=Member()
                data.name = username
                data.email = useremail
                data.owtome=0
                data.owtoall =0
                data.groupname=text
                val staa= GroupName(grouppname = text)
                if (userid != null) {
                    if (username != null) {
                        Toast.makeText(this, "What", Toast.LENGTH_SHORT).show()

                        FirebaseUtils().fireStoreDatabase.collection("NoFightsDB").document(userid).collection(text).document(username).set(data)
                        FirebaseUtils().fireStoreDatabase.collection("Lists").document(userid).collection(userid).document(text).set(staa)
                    }
                }*/
                Toast.makeText(this, "Group Created", Toast.LENGTH_SHORT).show()


                val intent = Intent(this, Eleven::class.java)
                startActivity(intent)
                finish()


            }
        }
        findViewById<Button>(R.id.btnCancel).setOnClickListener {
            val intent = Intent(this, Eleven::class.java)
            startActivity(intent)
            finish()

        }

    }
}