package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    lateinit var mBinding:ActivityMainBinding
     lateinit var animAlpha: Animation
     var brCount=0
      fun substrPr(a:String){
          if(mBinding.txtUp.text!="")
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
            mBinding.txtUp.text=mBinding.txtUp.text.toString()+"0"
            it.startAnimation(animAlpha)

        }
        mBinding.btn1.setOnClickListener(){
            mBinding.txtUp.text=mBinding.txtUp.text.toString()+"1"
            it.startAnimation(animAlpha)
        }
        mBinding.btn2.setOnClickListener(){
            mBinding.txtUp.text=mBinding.txtUp.text.toString()+"2"
            it.startAnimation(animAlpha)}

        mBinding.btn3.setOnClickListener(){
            mBinding.txtUp.text=mBinding.txtUp.text.toString()+"3"
            it.startAnimation(animAlpha)
        }
        mBinding.btn4.setOnClickListener(){
            mBinding.txtUp.text=mBinding.txtUp.text.toString()+"4"
            it.startAnimation(animAlpha)}
        mBinding.btn5.setOnClickListener(){
            mBinding.txtUp.text=mBinding.txtUp.text.toString()+"5"
            it.startAnimation(animAlpha)
        }
        mBinding.btn6.setOnClickListener(){
            mBinding.txtUp.text=mBinding.txtUp.text.toString()+"6"
            it.startAnimation(animAlpha)
        }
        mBinding.btn7.setOnClickListener(){
            mBinding.txtUp.text=mBinding.txtUp.text.toString()+"7"
            it.startAnimation(animAlpha)}
        mBinding.btn8.setOnClickListener(){
            mBinding.txtUp.text=mBinding.txtUp.text.toString()+"8"
            it.startAnimation(animAlpha)
        }
        mBinding.btn9.setOnClickListener(){
            mBinding.txtUp.text=mBinding.txtUp.text.toString()+"9"
            it.startAnimation(animAlpha)
        }
        mBinding.btnMult.setOnClickListener(){
            substrPr("x")
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
            mBinding.txtUp.text=""
            mBinding.txtBottom.text=""
        }
        mBinding.btnComma.setOnClickListener(){
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
           str= str.replace('x','*',true)
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
                else  mBinding.txtBottom.text="="+res.toString()
            }
            catch(e:Exception){
                Log.d("Ошибка","Message: ${e.message}")
            }
        }

            mBinding.btnDel.setOnClickListener(){
                mBinding.txtUp.text=mBinding.txtUp.text.toString().dropLast(1)
            }

    }
}
