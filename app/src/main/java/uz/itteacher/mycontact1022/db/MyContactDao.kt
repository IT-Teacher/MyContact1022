package uz.itteacher.mycontact1022.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.itteacher.mycontact1022.model.MyContact

@Dao
interface MyContactDao {

    @Query("SELECT * FROM my_contacts")
    fun getAllContacts(): List<MyContact>

    @Insert
    fun addContact(contact: MyContact)

}