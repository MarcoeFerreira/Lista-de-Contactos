package ipca.lista_de_contactos.a26530

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class AddActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)


        val butaoConfirmar = findViewById<Button>(R.id.confirmButtonId)

        butaoConfirmar.setOnClickListener{
            criarContacto()
            //volta para a main(porque é a janela anterior) ao dar finish
            finish()
        }
    }
        fun criarContacto() {
            val db = FirebaseFirestore.getInstance()


            val nome = findViewById<EditText>(R.id.editTextNome).text.toString()
            val numero = findViewById<EditText>(R.id.editTextPhone).text.toString()

            //Tranfere os dados das variaveis para o firebade////documento:Contacto
            val contacto = hashMapOf(
                "nome" to nome,
                "numero" to numero
            )
            db.collection("dbContactos").add(contacto)
        }
}