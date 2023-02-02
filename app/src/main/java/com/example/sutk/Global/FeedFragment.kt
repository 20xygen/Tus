package com.example.sutk.Global

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sutk.Client.Client
import com.example.sutk.DataHolder
import com.example.sutk.PostAdapter
import com.example.sutk.R
import com.example.sutk.navigation.NavigationController
import com.example.sutk.databinding.FragmentFeedBinding
import com.example.sutk.dto.Post.MainInfoPost
import com.example.sutk.dto.Post.Post
import com.example.sutk.dto.Tag.Tag
import com.example.sutk.dto.User.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FeedFragment : Fragment() {

        fun switchToProject() {
            DataHolder.projectPlaceType = 0
            findNavController().navigate(R.id.action_FeedFragment_to_ProjectFragment)
        }
        private var _binding: FragmentFeedBinding? = null
        public var navController: NavigationController? = NavigationController()

        // This property is only valid between onCreateView and
        // onDestroyView.
        private val binding get() = _binding!!

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {

            _binding = FragmentFeedBinding.inflate(inflater, container, false)
            return binding.root

        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            // DataHolder.context =
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
            var adapter = PostAdapter(customFillList())
//            var adapter = PostAdapter(mutableListOf())
            DataHolder.adapter = adapter
            DataHolder.feedFragment = this
            binding.recyclerView.adapter = adapter


            CoroutineScope(Dispatchers.IO).launch {
                val post = Client.getAllPosts()
                withContext(Dispatchers.Main) {
                    adapter.addRange(post?.toMutableList() ?: mutableListOf())
                }
            }

//        navController?.setController(findNavController())

        }

//        private fun fillList(k: Int): MutableList<Post> {
//            var data = mutableListOf<Post>()
//            var cur: Post? = null
//            var tagList: List<String> = listOf("1", "2", "3")
//            for (i in 1+k..10+k){
//
//                cur = Post(i, "Название " + i.toString() + " проекта", "userTelegram",
//                    "Здесь можно прочитать краткое описание  " + i.toString() + " проекта", listOf<Int>(), 0, 0,
//                    tagList, listOf<MainInfoPost>(), listOf<MainInfoPost>())
//                println(cur.title)
//                data.add(cur)
//            }
//            return data
//        }

        private fun customFillList(): MutableList<Post>{
            var data = mutableListOf<Post>()
            var defUsers = listOf<User>(User("Барилов Денис", "TWNTxygen", "Славный парень", 1, "DenBari2005@yandex.ru"),
                User("Кокорев Виктор", "shlepa05", "У самурая нет цели, только путь", 2, "kokorev_vd_09_20@1511.ru"))
            var defTags = listOf<Tag>(Tag("Android", "Информатика"), Tag("Инженерия", "Информатика"), Tag("Дизайн", "Другое"),
                Tag("UX", "Информатика"), Tag("UI", "Информатика"), Tag("Наставничество", "Информатика"))
            var i: Int = 0

            data.add(
                Post(i++, "Онлайн-расписания", 0,
                    "Приложение для автоматического составления школьного расписания средствами ML",
                    "AnyLogin", "Приложение для автоматического составления школьного расписания средствами ML",
                    defUsers, 0, 0,
                    defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
            )

            data.add(
                Post(i++, "Team Up System", 1,
                    "Приложение для поиска единомышленников для объединения в проектные команды.",
                    "AnyLogin", "Приложение для поиска единомышленников для объединения в проектные команды",
                    defUsers, 0, 0,
                    defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
            )

            data.add(
                Post(i++, "Lumet mobile", 2,
                    "Мобильное приложение Lumet",
                    "AnyLogin", "Мобильное приложение Lumet",
                    defUsers, 0, 0,
                    defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
            )

            data.add(
                Post(i++, "Онлайн-расписания", 3,
                    "Приложение для автоматического составления школьного расписания средствами ML",
                    "AnyLogin", "Приложение для автоматического составления школьного расписания средствами ML",
                    defUsers, 0, 0,
                    defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
            )

            data.add(
                Post(i++, "Team Up System", 4,
                    "Приложение для поиска единомышленников для объединения в проектные команды.",
                    "AnyLogin", "Приложение для поиска единомышленников для объединения в проектные команды",
                    defUsers, 0, 0,
                    defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
            )

            data.add(
                Post(i++, "Lumet mobile", 5,
                    "Мобильное приложение Lumet",
                    "AnyLogin", "Мобильное приложение Lumet",
                    defUsers, 0, 0,
                    defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
            )

            data.add(
                Post(i++, "Онлайн-расписания", 6,
                    "Приложение для автоматического составления школьного расписания средствами ML",
                    "AnyLogin", "Приложение для автоматического составления школьного расписания средствами ML",
                    defUsers, 0, 7,
                    defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
            )

            data.add(
                Post(i++, "Team Up System", 8,
                    "Приложение для поиска единомышленников для объединения в проектные команды.",
                    "AnyLogin", "Приложение для поиска единомышленников для объединения в проектные команды",
                    defUsers, 0, 0,
                    defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
            )

            data.add(
                Post(i++, "Lumet mobile", 9,
                    "Мобильное приложение Lumet",
                    "AnyLogin", "Мобильное приложение Lumet",
                    defUsers, 0, 0,
                    defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
            )

            data.add(
                Post(i++, "Онлайн-расписания", 10,
                    "Приложение для автоматического составления школьного расписания средствами ML",
                    "AnyLogin", "Приложение для автоматического составления школьного расписания средствами ML",
                    defUsers, 0, 0,
                    defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
            )

            data.add(
                Post(i++, "Team Up System", 11,
                    "Приложение для поиска единомышленников для объединения в проектные команды.",
                    "AnyLogin", "Приложение для поиска единомышленников для объединения в проектные команды",
                    defUsers, 0, 0,
                    defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
            )

            data.add(
                Post(i++, "Lumet mobile", 12,
                    "Мобильное приложение Lumet",
                    "AnyLogin", "Мобильное приложение Lumet",
                    defUsers, 0, 0,
                    defTags, listOf<MainInfoPost>(), listOf<MainInfoPost>())
            )

//            data.add(Post(1, "Team Up System", "userTelegram",
//                "Приложение для поиска единомышленников для объединения в проектные команды.", listOf<Int>(), 0, 0,
//                listOf("2", "7", "2"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(2, "Happy Meeting", "userTelegram",
//                "Приложение для создание веселых сборов", listOf<Int>(), 0, 0,
//                listOf("2", "2", "2"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(3, "Анти-прокрастинатор", "userTelegram",
//                "Мобильное приложение для борьбы с прокрастинацией", listOf<Int>(), 0, 0,
//                listOf("2", "0", "7"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(4, "Cooker", "userTelegram",
//                "Мобильная социальная сеть для любителей готовки", listOf<Int>(), 0, 0,
//                listOf("2", "4", "6"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(5, "Lumet mobile", "userTelegram",
//                "Мобильное приложение Lumet", listOf<Int>(), 0, 0,
//                listOf("0", "1", "2"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(6, "Планировщик бюджета", "userTelegram",
//                "Мобильное для планирования семейного бюджета и отслеживания трат", listOf<Int>(), 0, 0,
//                listOf("6", "2", "6"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(7, "Головоломки", "userTelegram",
//                "Головоломки с машиной Тьюринга", listOf<Int>(), 0, 0,
//                listOf("2", "0", "7"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(8, "Joker Club", "userTelegram",
//                "Социальная сеть для просмотра и публикации развлекательного контента", listOf<Int>(), 0, 0,
//                listOf("0", "2", "7"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(9, "Поиск кейлоггера", "userTelegram",
//                "Обнаружение кейлоггеров в систему Windows", listOf<Int>(), 0, 0,
//                listOf("3", "2", "7"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(10, "Трекер привычек", "userTelegram",
//                "Телеграм-бот трекер привычек", listOf<Int>(), 0, 0,
//                listOf("2", "4", "7"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(11, "Поиск болезни", "userTelegram",
//                "Прогнозирование потенциальной болезни", listOf<Int>(), 0, 0,
//                listOf("5", "5", "5"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(12, "Менеджер ГС", "userTelegram",
//                "Очистка голосовых сообщений", listOf<Int>(), 0, 0,
//                listOf("1", "0", "2"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(13, "Математический сканер", "userTelegram",
//                "Создание системы по распознаванию текста с математическими формулами ", listOf<Int>(), 0, 0,
//                listOf("0", "2", "0"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(14, "Автоизмеритель", "userTelegram",
//                "Автоматизированный измерительный модуль", listOf<Int>(), 0, 0,
//                listOf("0", "1", "2"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(15, "Досмотрщик", "userTelegram",
//                "Распознавание запрещенных вещей в багаже", listOf<Int>(), 0, 0,
//                listOf("2", "2", "2"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(16, "Мультисоцсеть", "userTelegram",
//                "Сборник соцсетей", listOf<Int>(), 0, 0,
//                listOf("2", "4", "2"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))
//
//            data.add(Post(17, "Умный врач", "userTelegram",
//                "Прогнозирование потенциальной болезни", listOf<Int>(), 0, 0,
//                listOf("2", "5", "2"), listOf<MainInfoPost>(), listOf<MainInfoPost>()))

            return data
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
