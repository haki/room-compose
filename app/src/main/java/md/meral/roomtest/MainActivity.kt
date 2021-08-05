package md.meral.roomtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import md.meral.roomtest.database.UserDatabase
import md.meral.roomtest.model.User

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val userDatabase: UserDatabase? = UserDatabase.getUserDatabase(this)

            /** userDatabase?.userDao()?.deleteAllUsers()

            userDatabase?.userDao()?.insert(User(1, "JREnginar", "vgV@$"))
            userDatabase?.userDao()?.insert(User(2, "VenoseA", "sGDG:#@$%V"))
            userDatabase?.userDao()?.insert(User(3, "Nykhschills", "@:$@#REFW"))
            userDatabase?.userDao()?.insert(User(4, "hakanmeral", "@:#fAWFQ#4"))
            userDatabase?.userDao()?.insert(User(5, "hakanmeral99", "@#FC@$@#"))
            userDatabase?.userDao()?.insert(User(6, "meral3432", "2f234x")) **/

            HomeContent(users = userDatabase?.userDao()?.getAllUsers())
        }
    }
}

@Composable
fun HomeContent(users: List<User>?) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(users!!.size) {
            UserListItem(user = users[it])
        }
    }
}

@Composable
fun UserListItem(user: User) {
    Card(

        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxSize(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        
        Row {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
                    .align(Alignment.CenterVertically)
            ) {
                
                Text(text = user.username)
                Text(text = user.password)
                Text(text = user.id.toString())
            }
        }
    }
}
