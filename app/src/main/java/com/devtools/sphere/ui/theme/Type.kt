package com.devtools.sphere.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.devtools.sphere.R


val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontName = GoogleFont("Open Sans")

val openSansFontFamily = FontFamily(
    Font(googleFont = fontName, fontProvider = provider)
)

// Set of Material typography styles to start with
val Typography = Typography(

    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    bodySmall = TextStyle(
        fontFamily = openSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),

    bodyMedium = TextStyle(
        fontFamily = openSansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
    ),


    titleLarge = TextStyle(
        fontFamily = openSansFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),


)