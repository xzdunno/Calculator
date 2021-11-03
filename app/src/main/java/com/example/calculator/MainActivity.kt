package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var mBinding:ActivityMainBinding
     lateinit var animAlpha: Animation
     var brCount=0
      fun substrPr(a:String){
          if(mBinding.txtUp.text!="O")
          mBinding.txtUp.text=mBinding.txtUp.text.toString()+a
      }
    fun zeroCh(a:String){
        if(mBinding.txtUp.text=="O")
            mBinding.txtUp.text=a
        else
            mBinding.txtUp.text=mBinding.txtUp.text.toString()+a
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        mBinding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(mBinding.root)
          animAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha)
    }

    override fun onResume() {
        super.onResume()

        mBinding.btn0.setOnClickListener(){
            zeroCh("0")
            it.startAnimation(animAlpha)

        }
        mBinding.btn1.setOnClickListener(){
            zeroCh("1")
            it.startAnimation(animAlpha)
        }
        mBinding.btn2.setOnClickListener(){
            zeroCh("2")
            it.startAnimation(animAlpha)}

        mBinding.btn3.setOnClickListener(){
            zeroCh("3")
            it.startAnimation(animAlpha)
        }
        mBinding.btn4.setOnClickListener(){
            zeroCh("4")
            it.startAnimation(animAlpha)}
        mBinding.btn5.setOnClickListener(){
            zeroCh("5")
            it.startAnimation(animAlpha)
        }
        mBinding.btn6.setOnClickListener(){
            zeroCh("6")
            it.startAnimation(animAlpha)
        }
        mBinding.btn7.setOnClickListener(){
            zeroCh("7")
            it.startAnimation(animAlpha)}
        mBinding.btn8.setOnClickListener(){
            zeroCh("8")
            it.startAnimation(animAlpha)
        }
        mBinding.btn9.setOnClickListener(){
            zeroCh("9")
            it.startAnimation(animAlpha)
        }
        mBinding.btnMult.setOnClickListener(){
            substrPr("×")
            it.startAnimation(animAlpha)
        }
        mBinding.btnDiv.setOnClickListener(){
            substrPr("÷")
            it.startAnimation(animAlpha)}
        mBinding.btnPlus.setOnClickListener(){
            substrPr("+")
            it.startAnimation(animAlpha)
        }
        mBinding.btnMin.setOnClickListener(){
            substrPr("-")
            it.startAnimation(animAlpha)
        }
        mBinding.btnC.setOnClickListener(){
            it.startAnimation(animAlpha)
            mBinding.txtUp.text="O"
            mBinding.txtBottom.text=""
        }
        mBinding.btnComma.setOnClickListener(){
            if(mBinding.txtUp.text=="O")
                mBinding.txtUp.text="0,"
            else
            mBinding.txtUp.text=mBinding.txtUp.text.toString()+","
            it.startAnimation(animAlpha)
        }
        mBinding.btnProc.setOnClickListener(){
            substrPr("%")
            it.startAnimation(animAlpha)
        }
        mBinding.btnBracket.setOnClickListener(){
            if(brCount%2==0) mBinding.txtUp.text=mBinding.txtUp.text.toString()+"("
            else mBinding.txtUp.text=mBinding.txtUp.text.toString()+")"
            brCount++
            it.startAnimation(animAlpha)

        }
        mBinding.btnEq.setOnClickListener(){

            var str=mBinding.txtUp.text.toString()
            if(str=="12345678"){
                val intent= Intent(this, NoteActivity::class.java)
                startActivity(intent)
            }
           str= str.replace('×','*',true)
           str= str.replace('÷','/',true)
            str= str.replace(',','.',true)
            str= str.replace("%","/100",true)

            try{
                it.startAnimation(animAlpha)
                val exp=ExpressionBuilder(str).build()
                val res=exp.evaluate()
                val longRes=res.toLong()
                if(res==longRes.toDouble())
                    mBinding.txtBottom.text="="+longRes.toString()
                else  mBinding.txtBottom.text="="+res.toString().replace(".",",",true)
            }
            catch(e:Exception){
                Log.d("Ошибка","Message: ${e.message}")
            }
        }

            mBinding.btnDel.setOnClickListener(){
                mBinding.txtUp.text=mBinding.txtUp.text.toString().dropLast(1)
                if(mBinding.txtUp.text==""){
                    mBinding.txtUp.text="O"
                }
            }

    }
}
