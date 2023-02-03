package com.example.sutk.entering.authorisation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sutk.client.Client
import com.example.sutk.dataHolder.DataHolder
import com.example.sutk.R
import com.example.sutk.databinding.FragmentLoginBinding
import com.example.sutk.dto.Achievement.Achievement
import com.example.sutk.dto.Mark.MarkWithPost
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

//            try{
//
//            } catch (e: Exception){
//
//            }

            try{
                if (DataHolder.demiIsOn) throw Exception("Demo is on")
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
                            findNavController().navigate(R.id.action_LoginFragment_to_MainFragment)

                        } else {
                            println("============================")
                        }
                    }
                    println(res)
                }
            } catch (e: Exception){
                var nick = DataHolder.validNick
                var validPasswd = DataHolder.validPasswd
                var validId = DataHolder.validId
                var validTg = DataHolder.validTg
                var validDescription = DataHolder.validNick
                var validImageId = DataHolder.validImageId
                var validName = DataHolder.validName
                var validTag = DataHolder.validTag
                if (login in nick){
                    if (validPasswd[nick.indexOf(login)] == password){
                        Toast.makeText(DataHolder.activity?.getApplicationContext(), "Успешный фиктивный вход", Toast.LENGTH_SHORT).show()
                        var user = UltimateUser(
                            id = validId[nick.indexOf(login)],
                            login = login,
                            tg = validTg[nick.indexOf(login)],
                            description = validDescription[nick.indexOf(login)],
                            imageId = validImageId[nick.indexOf(login)],
                            email = "",
                            name = validName[nick.indexOf(login)],
                            achievement = listOf<Achievement>(),
                            cityName = "",
                            userJob = listOf<String>(),
                            userMark = listOf<MarkWithPost>(),
                            tag = validTag[nick.indexOf(login)],
                        )
                        var liteUser = User(login, user.tg, user.description, user.imageId, user.email, user.name)
                        DataHolder.ultimateUser = user
                        DataHolder.loginedUser = liteUser
                        findNavController().navigate(R.id.action_LoginFragment_to_MainFragment)
                    }
                    else{
                        Toast.makeText(DataHolder.activity?.getApplicationContext(), "Неверный пароль", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(DataHolder.activity?.getApplicationContext(), "Пользователь не найден", Toast.LENGTH_SHORT).show()
                }
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