package md.meral.roomtest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import md.meral.roomtest.dao.UserDAO
import md.meral.roomtest.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDAO

    companion object {

        private var instance: UserDatabase? = null

        fun getUserDatabase(context: Context): UserDatabase? {

            if(instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    UserDatabase::class.java,
                    "user.db"
                ).allowMainThreadQueries().build()
            }

            return instance
        }
    }
}