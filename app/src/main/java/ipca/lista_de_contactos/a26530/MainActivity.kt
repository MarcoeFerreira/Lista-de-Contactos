package ipca.lista_de_contactos.a26530

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestoreSettings


class MainActivity : AppCompatActivity() {


    val contactList = arrayListOf<Contacto>()
    val adapter = ContactAdapter()

//Firebase
    fun fetchContacts()
    {
        var db = FirebaseFirestore.getInstance()

        contactList.clear()

        db.collection("dbContactos").get()
            .addOnSuccessListener {
                documents ->
                if (documents != null)
                {
                    for (document in documents){

                        val  nomeDocument = document.getString("nome")
                        val  numeroDocumet = document.getString("numero")

                        contactList.add(Contacto(nomeDocument,numeroDocumet ))
                    }
                    // Notifique o adapter que os dados mudaram
                    adapter.notifyDataSetChanged()
                }
                else{
                    Log.d("fetchContacts", "Não existe nenhum documento na collection")
                }
            }



    }
/////////////////





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Ação ao clicar no botão
        val botaoAdd = findViewById<Button>(R.id.buttonAdd)

        botaoAdd.setOnClickListener{
            val intent = Intent(this@MainActivity, AddActivity::class.java)
            startActivity(intent)

        }


        var listViewContact = findViewById<ListView>(R.id.listViewId)
        listViewContact.adapter = adapter
    }

    override fun onResume() {
        super.onResume()

        fetchContacts()
    }


    inner class ContactAdapter: BaseAdapter() {
        override fun getCount(): Int {
            return contactList.size
        }
        override fun getItem(position: Int): Any {
            return contactList[position]
        }
        override fun getItemId(position: Int): Long {
           return 0
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val rootview = layoutInflater.inflate(R.layout.contact_row, parent,false)
            val contactoAtual = getItem(position) as Contacto

            val textViewNome  = rootview.findViewById<TextView>(R.id.nomeId)
            val textViewContacto  = rootview.findViewById<TextView>(R.id.contactId)

            textViewContacto.text = contactoAtual.number
            textViewNome.text = contactoAtual.nome

            return rootview
        }
    }


}