package com.example.nofights

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.SetOptions
import com.google.firebase.ktx.Firebase

class AddMember : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_member)
        findViewById<Button>(R.id.btAdd).setOnClickListener {
            val text=findViewById<EditText>(R.id.grname).text.toString()
            val name = findViewById<EditText>(R.id.memname).text.toString()
            val email = findViewById<EditText>(R.id.mememail).text.toString()


            if(text.isNotEmpty() && name.isNotEmpty() && email.isNotEmpty()){

                val user= Firebase.auth.currentUser
                val userid= user?.uid
                val username= user?.displayName
                val mem = Member()
                mem.owtome=0
                mem.owtoall=0
                mem.name = name
                mem.email = email
                mem.groupname = text
                if (userid != null) {
                    if (username != null) {
                        FirebaseUtils().fireStoreDatabase.collection("NoFightsDB").document(userid).collection(text).document(name).set(mem, SetOptions.merge())
                    }
                }
                val intent = Intent(this, options::class.java)
                startActivity(intent)
                finish()
              }
        }
        findViewById<Button>(R.id.btCancel).setOnClickListener {
            val intent = Intent(this, options::class.java)
            startActivity(intent)
            finish()

        }
    }
}