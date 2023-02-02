package com.example.sutk.Entering

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.sutk.Client.Client
import com.example.sutk.DataHolder
import com.example.sutk.R
import com.example.sutk.databinding.FragmentLoginBinding
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
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonOk.setOnClickListener {
            DataHolder.nickname = binding.editTextNick.text.toString()
            DataHolder.setPassword(binding.editTextTextPassword.text.toString())

            val login = binding.editTextNick.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            val userLoginParams = UserLoginParams(0, login, password)

            CoroutineScope(Dispatchers.IO).launch {
                val res = Client.authorisation(userLoginParams)
                withContext(Dispatchers.Main) {
                    if (res.response == 200) {
                        val id: Int = Client.getIdByUserLogin(userLoginParams)
                        val u = Client.getUserById(id)
                        val user = UltimateUser(
                            id = id,
                            login = userLoginParams.login,
                            tg = Client.getUserById(id).tg,
                            description = u.description,
                            imageId = u.imageId,
                            email = u.email,
                            name = u.name,
                            achievement = Client.getUserAchievementById(id).achievement,
                            cityName = Client.getUserCityById(id).cityName,
                            userJob = Client.getUserJobById(id).userJob,
                            userMark = Client.getUserMarkById(id).userMark,
                            tag = Client.getUserTagById(id).tag,
                        )
                        println(user)
                        DataHolder.ultimateUser = user
                        findNavController().navigate(R.id.action_LoginFragment_to_SelectingProfileIconFragment)

                    } else {
                        println("8============================э")
                    }
                }
                println(res)
            }

        }

        binding.buttonRegister.setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_RegistrationFragment)
        }

        binding.buttonSkip.setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_SelectingProfileIconFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}