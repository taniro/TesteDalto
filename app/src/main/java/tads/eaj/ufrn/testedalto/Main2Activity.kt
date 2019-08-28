package tads.eaj.ufrn.testedalto

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val param = intent.extras

        var codImagem = param?.getInt("codImagem")

        when (codImagem){
            1->imagem.setImageResource(R.drawable.image3)
            2->imagem.setImageResource(R.drawable.image4)
            3->imagem.setImageResource((R.drawable.image5))
        }

        cancelarButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        enviarButton.setOnClickListener {
            var i = Intent()
            i.putExtra("resposta", respostaEdit.text.toString())
            setResult(Activity.RESULT_OK, i)
            finish()
        }

    }
}
