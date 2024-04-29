package com.inuceng.evdesaglik.repository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.inuceng.evdesaglik.data.User
class UserRepository(val db: FirebaseFirestore = Firebase.firestore) {
    companion object {
        const val DATABASE_TABLE_USERS = "kullanicilar" }
    lateinit var currentUser: User
    fun registerUser(user: User, onSuccess: () -> Unit) {
        val yeniKullanici = hashMapOf(
            "tc" to user.tc,
            "isim" to user.name,
            "sifre" to user.password,
            "lastName" to user.lastName,
            "dateOfBrith" to user.dateOfBirth,)
        db.collection(DATABASE_TABLE_USERS)
            .add(yeniKullanici)
            .addOnSuccessListener { documentReference ->
                onSuccess.invoke() } }
    fun loginUser(tc: String, password: String , onSuccess: (User) -> Unit) {
        db.collection(DATABASE_TABLE_USERS)
            .whereEqualTo("tc", tc)
            .whereEqualTo("sifre", password)
            .get()
            .addOnSuccessListener { documents ->
                if (documents.isEmpty.not()) {
                    val user = User(
                        name = documents.first().get("isim").toString(),
                        tc = tc,
                        password = password,
                        lastName = documents.first().get("lastName").toString(),
                        dateOfBirth = documents.first().get("dateOfBirth").toString())
                    currentUser = user
                    onSuccess.invoke(
                        user
                    )
                }
            }
    }
}