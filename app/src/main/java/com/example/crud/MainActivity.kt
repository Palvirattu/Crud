package com.example.crud

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import com.example.crud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ArrayAdapter<String>
    var arrayList = arrayListOf<String>("Sonia", "Jyoti", "Palvi", "Monika", "Tannu")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        binding.listView.adapter = adapter
        binding.fab.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.customdialog)
            var btnadd = dialog.findViewById<Button>(R.id.btnadd)
            var etname = dialog.findViewById<EditText>(R.id.etname)
            btnadd.setOnClickListener {
                if (etname.text.toString().isNullOrEmpty()) {
                    etname.error = "Enter your name"
                } else {
                    arrayList.add(etname.text.toString())
                    dialog.dismiss()

                }
            }
            dialog.show()

        }
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            System.out.println("parent ${parent} view $view position $position id $id")
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.customdialog2)
            var etname2 = dialog.findViewById<EditText>(R.id.etname2)
         //   etname2.setText(binding.etname2.text.toString())
            var btnupdate = dialog.findViewById<Button>(R.id.btnupdate)
            var btndelet = dialog.findViewById<Button>(R.id.btndelet)
            btnupdate.setOnClickListener {
                if (etname2.text.toString().isNullOrEmpty()) {
                    etname2.error = "Enter your name"
                }else {
                    //update
                    dialog.dismiss()
                }
            }
                btndelet.setOnClickListener{
                    dialog.dismiss()

                }
                    dialog.show()
                }
            }



        }



