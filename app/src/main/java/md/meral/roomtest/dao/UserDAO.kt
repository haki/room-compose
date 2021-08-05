package md.meral.roomtest.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import md.meral.roomtest.model.User

@Dao
interface UserDAO {

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Query("DELETE FROM users")
    fun deleteAllUsers()
}