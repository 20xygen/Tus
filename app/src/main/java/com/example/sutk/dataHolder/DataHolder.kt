package com.example.sutk.dataHolder

import android.app.Activity
import android.content.Context
import com.example.sutk.entering.authorisation.RegistrationFragment
import com.example.sutk.global.feed.FeedFragment
import com.example.sutk.global.manage.ManageFragment
import com.example.sutk.global.profile.ProfileFragment
import com.example.sutk.global.feed.PostAdapter
import com.example.sutk.dto.Post.MainInfoPost
import com.example.sutk.dto.Post.Post
import com.example.sutk.dto.Response.Response
import com.example.sutk.dto.Tag.Tag
import com.example.sutk.dto.User.UltimateUser
import com.example.sutk.dto.User.User
import java.math.BigInteger
import java.security.MessageDigest

class DataHolder {
    companion object {
        var demoIsOn = false
        var safeIsOn = false
        var demoConfirm = false

        val ndt = 8 // numOfDefaultTags
        var adapter: PostAdapter? = null
        var context: Context? = null
        var activity: Activity? = null
        var manageFragment: ManageFragment? = null
        var feedFragment: FeedFragment? = null
        var profileFragment: ProfileFragment? = null
        var projectPlaceType: Int? = null

        var mathTags = mutableListOf<Boolean>()
        var physicsTags = mutableListOf<Boolean>()
        var infoTags = mutableListOf<Boolean>()
        var isTags = mutableListOf<Boolean>()
        var langTags = mutableListOf<Boolean>()
        var medicineTags = mutableListOf<Boolean>()
        var economyTags = mutableListOf<Boolean>()
        var otherTags = mutableListOf<Boolean>()

        var ultimateUser: UltimateUser? = null

//        val stack = ArrayDeque(listOf(1, 2, 3)) // stack: [1, 2, 3]
//        stack.addLast(0)                        // stack: [1, 2, 3, 0]         (push)
//        val value = stack.removeLast()

        fun saveBuffInt(buffInt: Int, fragment: RegistrationFragment){
            Companion.buffInt = buffInt
            if (Companion.buffInt == 200){
                fragment.nuuChangeScreen()
            }
            println(Companion.buffInt)
        }

        var postToScreen: Map<String, ArrayDeque<Post>> = mapOf("feed" to ArrayDeque<Post>(listOf()), "manage" to ArrayDeque<Post>(listOf()), "notifications" to ArrayDeque<Post>(listOf()), "profile" to ArrayDeque<Post>(listOf()))
        var postToScreenLast = "feed"
        var listOfAllTags: MutableList<Tag>? = mutableListOf()
        var user: User? = null
        var userTags = mutableListOf<Tag>()
        var registered = false
        var buffRes = Response(777)
        var buffInt = 777
        var buffUser = User()

        val teamId: MutableList<Int> = mutableListOf()

        var loginedUser: User = User("Безымянный пользователь", "", "В поисках интересного...", 0, "")

        var validNick = listOf<String>("abcd", "Денис", "Виктор К", "12345", "user")
        var validPasswd = listOf<String>("1111", "Денис", "1234", "54321", "password")
        var validId = listOf<Int>(1, 4, 2, 20, 5)
        var validTg = listOf<String>("pavel_durov", "TWNTxygen", "shlepa05", "numbersTG", "userInTelegram")
        var validDescription = listOf<String>("Не стоит принимать доброту за слабость, грубость за силу, а подлость за умение жить.", "Не придумал описания", "У самурая нет цели, только путь", "54321", "Никто не ценит того, чего слишком много.")
        var validImageId = listOf<Int>(0, 1, 2, 3, 4)
        var validName = listOf<String>("123 321", "Денис Барилов", "Виктор Кокорев", "Цифра циферкина", "Новый пользователь")
        var validTag = listOf<List<Tag>>(listOf(Tag("Португальский я.", "Лингвистика"), Tag("Русский я.", "Лингвистика"), Tag("Китайский я.", "Лингвистика"), Tag("Сейсмология", "Другое")),
            listOf(Tag("Стереометрия", "Математика"), Tag("Топология", "Математика"), Tag("Android", "Информатика"), Tag("UI", "Информатика"), Tag("Кинематика", "Физика"), Tag("Design", "Информатика"), Tag("Пентест", "ИБ")),
            listOf(Tag("Анализ (математика)", "Математика"), Tag("Android", "Информатика"), Tag("UX", "Информатика"), Tag("Game dev.", "Информатика")),
            listOf(Tag("Астрономия", "Физика"), Tag("Web", "Информатика"), Tag("Китайский я.", "Лингвистика"), Tag("Бухгалтерия", "Экономика")),
            listOf(Tag("Подология", "Медицина"), Tag("Reverse", "ИБ"), Tag("Дизайн", "Другое"), Tag("Бухгалтерия", "Экономика"), Tag("Квантовая ф.", "Физика")))

        var fakeUsers: List<User> = listOf(User(validNick[0], validTg[0], validDescription[0], validImageId[0], "", validName[0]),
            User(validNick[1], validTg[1], validDescription[1], validImageId[1], "", validName[1]),
            User(validNick[2], validTg[2], validDescription[2], validImageId[2], "", validName[2]),
            User(validNick[3], validTg[3], validDescription[3], validImageId[3], "", validName[3]),
            User(validNick[4], validTg[4], validDescription[4], validImageId[4], "", validName[4]))

        var fakePosts: MutableList<Post> = mutableListOf(
            Post(0, "Team Up System", 0,
                "Приложение для поиска единомышленников для объединения в проектные команды.", fakeUsers[1].login,
                "Приложение для поиска единомышленников для объединения в проектные команды. Здесь каждому предоставляется возможность найти как проект, так и единомышленника. Цель - оптимизировать этап коллективизации в проектной практике.",
                listOf(fakeUsers[1], fakeUsers[2]), 0, 0,
                listOf(Tag("Android", "Информатика"), Tag("UI", "Информатика"),
                    Tag("UX", "Информатика"), Tag("Маркетинг", "Экономика"),
                    Tag("Наставничество (физика)", "Физика"), Tag("Дизайн", "Другое")),
                listOf<MainInfoPost>(), listOf<MainInfoPost>()),

            Post(0, "Автобаттлер с ИИ", 0,
                "Исскусственный интеллект, способный предугадывать исход баталии",
                fakeUsers[1].login, "Исскусственный интеллект, способный предугадывать исход баталии, встроен в игру-автобттлер. Нейронная сеть натренирована на милионах конфигураций и способна выдать точный результат при любом размере поля.",
                listOf(fakeUsers[1], fakeUsers[2]), 0, 0,
                listOf(Tag("AI", "Информатика"), Tag("Моделирование (информатика)", "Информатика"),
                    Tag("Исследование (информатика)", "Информатика"), Tag("Моделирование (математика)", "Математика"),
                    Tag("Кинематика", "Физика")),
                listOf<MainInfoPost>(), listOf<MainInfoPost>()),

            Post(0, "Fert", 0,
                "Калькулятор с характером",
                fakeUsers[1].login, "Fert - калькулятор с характером. Одновременно тамагочи и настоящий инструмент. Обучайся играючи, либо просто проведи время нескучно.",
                listOf(fakeUsers[1]), 0, 0,
                listOf(Tag("Android", "Информатика"), Tag("UI", "Информатика"),
                    Tag("UX", "Информатика"), Tag("Маркетинг", "Экономика"),
                    Tag("Наставничество (физика)", "Физика"), Tag("Дизайн", "Другое")),
                listOf<MainInfoPost>(), listOf<MainInfoPost>()),

            Post(0, "TowerDefense", 0,
                "Игра в соответствующем жанре на Android и Desktop.",
                fakeUsers[2].login, "Написана на собственном, написаном почти с нуля, движке.",
                listOf(fakeUsers[2]), 0, 0,
                listOf(Tag("Android", "Информатика"), Tag("Кинематика", "Физика"),
                    Tag("UX", "Информатика"), Tag("Game dev.", "Информатика"),
                    Tag("Т. вероятности", "Математика"), Tag("Планеметрия", "Математика")),
                listOf<MainInfoPost>(), listOf<MainInfoPost>()),

            Post(0, "Обычный проект", 0,
                "Описание этого проекта",
                fakeUsers[0].login, "Здесь более подробное описание выбранного пользователем проекта.",
                listOf(fakeUsers[0], fakeUsers[3], fakeUsers[4]), 0, 0,
                listOf(Tag("Т. вероятности", "Математика"), Tag("Астрономия", "Физика"),
                    Tag("Android", "Информатика"), Tag("Криптография", "ИБ"),
                    Tag("Португальский я.", "Лингвистика"), Tag("Хирургия", "Медицина"),
                Tag("Бухгалтерия", "Экономика"), Tag("География", "Другое")),
                listOf<MainInfoPost>(), listOf<MainInfoPost>()),

            Post(0, "ML-Schedule", 0,
                "Приложение для автоматического составления школьного расписания средствами ML",
                fakeUsers[3].login, "Приложение для автоматического составления школьного расписания средствами ML. Помощь в составлении расписания для школ.",
                listOf(fakeUsers[3], fakeUsers[0]), 0, 0,
                listOf(Tag("Т. вероятности", "Математика"), Tag("Data Sc.", "Информатика"),
                    Tag("AI", "Информатика")),
                listOf<MainInfoPost>(), listOf<MainInfoPost>()),

            Post(0, "Happy Meeting", 0,
                "Приложение для создание веселых сборов",
                fakeUsers[4].login, "Приложение для создание веселых сборов. Встречайтесь и веселитесь",
                listOf(fakeUsers[4], fakeUsers[3]), 0, 0,
                listOf(Tag("Общее (физика)", "Физика"), Tag("Android", "Информатика")),
                listOf<MainInfoPost>(), listOf<MainInfoPost>()),

            Post(0, "Lumet", 0,
                "Простое мобильное приложение",
                fakeUsers[0].login, "Lumet - главная загадка проекта. Что бы это могло значить?",
                listOf(fakeUsers[0], fakeUsers[1]), 0, 0,
                listOf(Tag("Android", "Информатика")),
                listOf<MainInfoPost>(), listOf<MainInfoPost>())
        )

        var name: String? = null

        var nickname: String? = null

        var telegram: String? = null

        var passwordHash: String? = null

        var iconNumber: Int? = 0

        var postIconNumber: Int? = 0

        var loggedIn = false

        var userId: Int? = null

        var bio: String? = null

        fun md5(input:String): String {
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }

        fun setPassword(value: String){
            passwordHash = md5(value)
        }

        fun checkPassword(value: String): Boolean{
            return passwordHash == md5(value)
        }

        fun checkHashPassword(value: String): Boolean{
            return passwordHash == value
        }

        fun getTags(): List<MutableList<Boolean>> {
            return listOf(mathTags, physicsTags, infoTags, isTags, langTags, medicineTags, economyTags, otherTags)
        }

        fun tagRefactor(s: String): String{
            var n: String = ""
            for (i in 1..s.length){
                if (s[i-1] != '(') {
                    n += s[i-1]
                }
                else{
                    break
                }
            }
            return n
        }

        fun getStringTags(): String {
            var total = mathTags + physicsTags + infoTags + isTags + langTags + medicineTags + economyTags + otherTags
            var value = ""
            for(i in 0..(total.size - 1)){
                if (total[i]) value += "1"
                else value += "0"
            }
            return value
        }


        var allFixedTags = mutableListOf<Tag>(Tag("Т. вероятности", "Математика"),
            Tag("Тригонометрия", "Математика"),
            Tag("Стереометрия", "Математика"),
            Tag("Планеметрия", "Математика"),
            Tag("Топология", "Математика"),
            Tag("Т. графов", "Математика"),
            Tag("Моделирование (математика)", "Математика"),
            Tag("Исследование (математика)", "Математика"),
            Tag("Автоматизация (математика)", "Математика"),
            Tag("Общее (математика)", "Математика"),
            Tag("Наставничество (математика)", "Математика"),
            Tag("Анализ (математика)", "Математика"),
            Tag("Оптимизация (математика)", "Математика"),
            Tag("Другое (математика)", "Математика"),

            Tag("Астрономия", "Физика"),
            Tag("Квантовая ф.", "Физика"),
            Tag("Т. относительности", "Физика"),
            Tag("Инженерия", "Физика"),
            Tag("Кинематика", "Физика"),
            Tag("Термодинамика", "Физика"),
            Tag("Электродинамика", "Физика"),
            Tag("Электростатика", "Физика"),
            Tag("Моделирование (физика)", "Физика"),
            Tag("Исследование (физика)", "Физика"),
            Tag("Автоматизация (физика)", "Физика"),
            Tag("Общее (физика)", "Физика"),
            Tag("Наставничество (физика)", "Физика"),
            Tag("Анализ (физика)", "Физика"),
            Tag("Оптимизация (физика)", "Физика"),
            Tag("Другое (физика)", "Физика"),

            Tag("Android", "Информатика"),
            Tag("IOS", "Информатика"),
            Tag("Desktop", "Информатика"),
            Tag("Web", "Информатика"),
            Tag("Linux", "Информатика"),
            Tag("UI", "Информатика"),
            Tag("Инженерия", "Информатика"),
            Tag("UX", "Информатика"),
            Tag("Design", "Информатика"),
            Tag("AI", "Информатика"),
            Tag("Data Sc.", "Информатика"),
            Tag("VR", "Информатика"),
            Tag("Game dev.", "Информатика"),
            Tag("Wear OS", "Информатика"),
            Tag("Моделирование (информатика)", "Информатика"),
            Tag("Исследование (информатика)", "Информатика"),
            Tag("Автоматизация (информатика)", "Информатика"),
            Tag("Общее (информатика)", "Информатика"),
            Tag("Наставничество (информатика)", "Информатика"),
            Tag("Анализ (информатика)", "Информатика"),
            Tag("Оптимизация (информатика)", "Информатика"),
            Tag("Другое (информатика)", "Информатика"),

            Tag("Криптография", "ИБ"),
            Tag("Пентест", "ИБ"),
            Tag("Reverse", "ИБ"),
            Tag("Steganography", "ИБ"),
            Tag("Exploit", "ИБ"),
            Tag("Web", "ИБ"),
            Tag("Forensic", "ИБ"),
            Tag("PPC", "ИБ"),
            Tag("Misc", "ИБ"),
            Tag("Security", "ИБ"),
            Tag("Моделирование (ИБ)", "ИБ"),
            Tag("Исследование (ИБ)", "ИБ"),
            Tag("Автоматизация (ИБ)", "ИБ"),
            Tag("Общее (ИБ)", "ИБ"),
            Tag("Наставничество (ИБ)", "ИБ"),
            Tag("Анализ (ИБ)", "ИБ"),
            Tag("Оптимизация (ИБ)", "ИБ"),
            Tag("Другое (ИБ)", "ИБ"),

            Tag("Португальский я.", "Лингвистика"),
            Tag("Русский я.", "Лингвистика"),
            Tag("Английский я.", "Лингвистика"),
            Tag("Испанский я.", "Лингвистика"),
            Tag("Французский я.", "Лингвистика"),
            Tag("Китайский я.", "Лингвистика"),
            Tag("Японский я.", "Лингвистика"),
            Tag("Немецкий я.", "Лингвистика"),
            Tag("Турецкий я.", "Лингвистика"),
            Tag("Финский я.", "Лингвистика"),
            Tag("Моделирование (лингвистика)", "Лингвистика"),
            Tag("Исследование (лингвистика)", "Лингвистика"),
            Tag("Автоматизация (лингвистика)", "Лингвистика"),
            Tag("Общее (лингвистика)", "Лингвистика"),
            Tag("Наставничество (лингвистика)", "Лингвистика"),
            Tag("Анализ (лингвистика)", "Лингвистика"),
            Tag("Оптимизация (лингвистика)", "Лингвистика"),
            Tag("Другое (лингвистика)", "Лингвистика"),

            Tag("Хирургия", "Медицина"),
            Tag("Офтольмология", "Медицина"),
            Tag("Стоматология", "Медицина"),
            Tag("ЛОР", "Медицина"),
            Tag("Подология", "Медицина"),
            Tag("Неврология", "Медицина"),
            Tag("Кардиология", "Медицина"),
            Tag("Аллергология", "Медицина"),
            Tag("Моделирование (медицина)", "Медицина"),
            Tag("Исследование (медицина)", "Медицина"),
            Tag("Автоматизация (медицина)", "Медицина"),
            Tag("Общее (медицина)", "Медицина"),
            Tag("Наставничество (медицина)", "Медицина"),
            Tag("Анализ (медицина)", "Медицина"),
            Tag("Оптимизация (медицина)", "Медицина"),
            Tag("Другое (медицина)", "Медицина"),

            Tag("Бухгалтерия", "Экономика"),
            Tag("Маркетинг", "Экономика"),
            Tag("Юреспруденция", "Экономика"),
            Tag("Бизнес", "Экономика"),
            Tag("Моделирование (Экономика)", "Экономика"),
            Tag("Исследование (Экономика)", "Экономика"),
            Tag("Автоматизация (Экономика)", "Экономика"),
            Tag("Общее (Экономика)", "Экономика"),
            Tag("Наставничество (Экономика)", "Экономика"),
            Tag("Анализ (Экономика)", "Экономика"),
            Tag("Оптимизация (Экономика)", "Экономика"),
            Tag("Другое (Экономика)", "Экономика"),

            Tag("География", "Другое"),
            Tag("Энергетика", "Другое"),
            Tag("Сейсмология", "Другое"),
            Tag("Дизайн", "Другое"),
            Tag("Химия", "Другое"),
            Tag("Литература", "Другое"),
            Tag("Ветеринария", "Другое"),
            Tag("Биология", "Другое"))
    }




}