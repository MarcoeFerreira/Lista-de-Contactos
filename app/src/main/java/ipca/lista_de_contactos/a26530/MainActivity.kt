package ipca.lista_de_contactos.a26530

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
class MainActivity : AppCompatActivity() {

    val contactList = arrayListOf<Contacto>(
        Contacto("Marco", "+351 960119793"),
        Contacto("Antonio", "+352 912532531")
    )




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listViewContact = findViewById<ListView>(R.id.listViewId)
        listViewContact.adapter = ContactAdapter()

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