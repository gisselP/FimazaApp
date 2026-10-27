package com.example.fimazaapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class ContactosFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contactos, container, false)
        
        val etNombre = view.findViewById<EditText>(R.id.etNombre)
        val etCorreo = view.findViewById<EditText>(R.id.etCorreo)
        val etMensaje = view.findViewById<EditText>(R.id.etMensaje)
        val btnEnviar = view.findViewById<Button>(R.id.btnEnviar)
        
        btnEnviar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val correo = etCorreo.text.toString()
            val mensaje = etMensaje.text.toString()
            
            if (nombre.isNotEmpty() && correo.isNotEmpty() && mensaje.isNotEmpty()) {
                Toast.makeText(requireContext(), "Mensaje enviado correctamente", Toast.LENGTH_SHORT).show()
                etNombre.text.clear()
                etCorreo.text.clear()
                etMensaje.text.clear()
            } else {
                Toast.makeText(requireContext(), "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
        
        return view
    }
}
