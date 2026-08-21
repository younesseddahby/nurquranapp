package com.eddahby.quran

import androidx.appfunctions.AppFunctionContext
import androidx.appfunctions.AppFunction
import android.content.Intent
import android.net.Uri

/**
 * AppFunctions for Nur-Quran.
 * Allows system-level access to open surahs and search ayahs.
 */
class QuranAppFunctions {

    /**
     * Opens a specific surah by its number.
     *
     * @param context The execution context.
     * @param surahNumber The number of the surah (1-114).
     */
    @AppFunction(isDescribedByKDoc = true)
    suspend fun openSurah(context: AppFunctionContext, surahNumber: Int) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://quran.eddahby.com/surah/$surahNumber"))
        intent.setPackage(context.androidContext.packageName)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.androidContext.startActivity(intent)
    }

    /**
     * Searches for ayahs containing a specific keyword or phrase.
     *
     * @param context The execution context.
     * @param query The keyword or phrase to search for.
     */
    @AppFunction(isDescribedByKDoc = true)
    suspend fun searchAyah(context: AppFunctionContext, query: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://quran.eddahby.com/quran?q=${Uri.encode(query)}"))
        intent.setPackage(context.androidContext.packageName)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.androidContext.startActivity(intent)
    }
}
