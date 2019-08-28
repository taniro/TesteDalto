package tads.eaj.ufrn.testedalto

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUESTCODE1 = 99
    val REQUESTCODE2 = 100
    val REQUESTCODE3 = 101

    var resultT1:Int? = 0
    var resultT2:Int? = 0
    var resultT3:Int? = 0

    var resultFinal = "Faça o teste"

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var a = savedInstanceState?.getInt("resposta1")?:0

        resp1Text.text = ("$resultT1")
        resp2Text.text = ("$resultT2")
        resp3Text.text = ("$resultT3")

        resultText.text = ("$resultFinal")
    }

    fun clique (v: View){

        var codImagem = 0
        var codRequest = 0


        when (v.id){
            R.id.teste1Button->{
                codImagem = 1
                codRequest = REQUESTCODE1
            }
            R.id.teste2Button->{
                codImagem = 2
                codRequest = REQUESTCODE2
            }
            R.id.teste3Buttob->{
                codImagem = 3
                codRequest = REQUESTCODE3
            }
        }

        var i = Intent(this, Main2Activity::class.java)

        var param = Bundle()
        param.putInt("codImagem", codImagem)

        i.putExtras(param)

        startActivityForResult(i, codRequest)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode){
            REQUESTCODE1->{
                when(resultCode){
                    Activity.RESULT_OK->{
                        resultT1 = data?.getStringExtra("resposta")?.toInt()
                        resp1Text.text = "$resultT1"
                    }
                    Activity.RESULT_CANCELED->{

                    }
                }
            }
            REQUESTCODE2->{
                when(resultCode){
                    Activity.RESULT_OK->{
                        resultT2 = data?.getStringExtra("resposta")?.toInt()
                        resp2Text.text = "$resultT2"
                    }
                    Activity.RESULT_CANCELED->{

                    }
                }
            }
            REQUESTCODE3->{
                when(resultCode){
                    Activity.RESULT_OK->{
                        resultT3 = data?.getStringExtra("resposta")?.toInt()
                        resp3Text.text = "$resultT3"
                    }
                    Activity.RESULT_CANCELED->{

                    }
                }
            }
        }
    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("resposta1", resultT1?:0)
        outState.putInt("resposta2", resultT2?:0)
        outState.putInt("resposta3", resultT3?:0)
    }



    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        resultT1 = savedInstanceState.getInt("resposta1")
        resultT2 = savedInstanceState.getInt("resposta2")
        resultT3 = savedInstanceState.getInt("resposta3")

        resp1Text.text = ("$resultT1")
        resp2Text.text = ("$resultT2")
        resp3Text.text = ("$resultT3")
    }

}
