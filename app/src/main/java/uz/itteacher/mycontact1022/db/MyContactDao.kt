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

    @Query("SELECT * FROM my_contacts WHERE id = :id")
    fun getContactById(id: Int): MyContact?

    @Query("DELETE FROM my_contacts WHERE id = :id")
    fun deleteContactById(id: Int)

    @Query("UPDATE my_contacts SET name = :name, surname = :surname, number = :number WHERE id = :id")
    fun updateContact(id: Int, name: String, surname: String, number: String)


}