package com.example.sutk.Entering

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sutk.BubbleNavigationConstraintView
import com.example.sutk.DataHolder
import com.example.sutk.R
import com.example.sutk.databinding.FragmentRegistrationBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root

    }

    fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonOk.setOnClickListener {
            DataHolder.name = binding.editTextName.text.toString()
            DataHolder.nickname = binding.editTextNick.text.toString()
            DataHolder.telegram = binding.editTextTelegram.text.toString()
            if (binding.editTextTextPassword.text.toString() == binding.editTextTextConfirmPassword.text.toString()){
                DataHolder.setPassword(binding.editTextNick.text.toString())
                findNavController().navigate(R.id.action_RegistrationFragment_to_SelectingProfileIconFragment)
            }
            else {
//                Log.w("Registration", binding.passwordText.text.toString() + binding.confirmPasswordText.text.toString())
                context?.toast("Пароли не совпадают")
            }

        }

        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_RegistrationFragment_to_LoginFragment)
        }

        binding.buttonSkip.setOnClickListener {
            findNavController().navigate(R.id.action_RegistrationFragment_to_SelectingProfileIconFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}