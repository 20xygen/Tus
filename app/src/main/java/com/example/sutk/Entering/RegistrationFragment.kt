package com.example.sutk.Entering

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sutk.Client.Client
import com.example.sutk.DataHolder
import com.example.sutk.R
import com.example.sutk.databinding.FragmentRegistrationBinding
import com.example.sutk.dto.User.UltimateUser
import com.example.sutk.dto.User.User
import com.example.sutk.dto.User.UserLoginParams
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RegistrationFragment : Fragment() {

    fun nuuChangeScreen(){
        findNavController().navigate(R.id.action_RegistrationFragment_to_SelectingProfileIconFragment)
    }
    private var _binding: FragmentRegistrationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var user:User = User()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root

    }

    fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    var curUser = User()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonOk.setOnClickListener {
            DataHolder.name = binding.editTextName.text.toString()
            DataHolder.nickname = binding.editTextNick.text.toString()
            DataHolder.telegram = binding.editTextTelegram.text.toString()
            DataHolder.buffUser = User(binding.editTextNick.text.toString(), binding.editTextTelegram.text.toString(), "В поисках интересного...", 1, "", binding.editTextName.text.toString())
            curUser = User(binding.editTextNick.text.toString(), binding.editTextTelegram.text.toString(), "В поисках интересного...", 1, "", binding.editTextName.text.toString())
            if (binding.editTextTextPassword.text.toString() == binding.editTextTextConfirmPassword.text.toString()){
//                DataHolder.loginedUser
//                DataHolder.setPassword(binding.editTextNick.text.toString())
                val userLoginParams = UserLoginParams(0, DataHolder.buffUser.login, binding.editTextTextConfirmPassword.text.toString())
                println(userLoginParams)
                val fragment = this
                CoroutineScope(Dispatchers.IO).launch {
                    val res = Client.registration(userLoginParams)
                    println(res)
                    if (res.response == 200){
                        println("----------------------------\n${DataHolder.buffUser}\n")
                        Client.updateUser(Client.getUserLastId().id, DataHolder.buffUser)
                        println("----------------------------")
                    }
                    withContext(Dispatchers.Main) {
                        DataHolder.saveBuffInt(res.response, fragment)
                        DataHolder.loginedUser = DataHolder.buffUser
                        //DataHolder.ultimateUser = DataHolder.loginedUser as UltimateUser
                        DataHolder.ultimateUser = UltimateUser(DataHolder.buffInt, DataHolder.loginedUser.login, DataHolder.loginedUser.tg, DataHolder.loginedUser.description, DataHolder.loginedUser.imageId, DataHolder.loginedUser.email, DataHolder.loginedUser.name, listOf(), "", listOf(), listOf(), listOf())
//                        \
                        println("Ultimate" + DataHolder.ultimateUser)
                        println(DataHolder.buffInt)
                    }
                }
//                if (DataHolder.buffInt == 200){
//                    DataHolder.loginedUser = user
//
//                    // Сохранить:
//                    user.name
//                    user.description
//                    user.tg
//
//                    findNavController().navigate(R.id.action_RegistrationFragment_to_SelectingProfileIconFragment)
//                }
//                else if (DataHolder.buffInt == 600) {
//                    user = User()
//                    context?.toast("Пользователь не найден")
//                }
//                else if (DataHolder.buffInt == 602) {
//                    user = User()
//                    context?.toast("Имя пользователя занято")
//                }
//                else {
//                    user = User()
//                    context?.toast("Что-то пошло не так")
//                    //findNavController().navigate(R.id.action_RegistrationFragment_to_SelectingProfileIconFragment)
//                }
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
            context?.toast("Пока недоступно")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}