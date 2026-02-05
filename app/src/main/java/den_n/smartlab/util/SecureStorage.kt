package den_n.smartlab.util

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

object SecureStorage {

    private val PREFS_NAME = "smartlab_secure_prefs"

    private fun getSharedPreferences(context: Context): SharedPreferences {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
        return EncryptedSharedPreferences.create(
            context,
            PREFS_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    fun setAuthPassword(context: Context?, password: String) {
        if (context == null) return
        val prefs = getSharedPreferences(context = context)
        prefs.edit().putString("authPassword", password).apply()
    }

    fun getAuthPassword(context: Context?) : String? {
        if (context == null) return null
        val prefs = getSharedPreferences(context = context)
        return prefs.getString("authPassword", null)
    }

    fun cleanAuthPassword(context: Context?) {
        if (context == null) return
        val prefs = getSharedPreferences(context = context)
        prefs.edit().remove("authPassword").apply()
    }

}