package dev.prabhatpandey.playflix.core.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


private val LightColorScheme = lightColorScheme(
    primary = PlayFlixLightPrimary,
    onPrimary = PlayFlixLightOnPrimary,
    primaryContainer = PlayFlixLightPrimaryContainer,
    onPrimaryContainer = PlayFlixLightOnPrimaryContainer,
    secondary = PlayFlixLightSecondary,
    onSecondary = PlayFlixLightOnSecondary,
    secondaryContainer = PlayFlixLightSecondaryContainer,
    onSecondaryContainer = PlayFlixLightOnSecondaryContainer,
    tertiary = PlayFlixLightTertiary,
    onTertiary = PlayFlixLightOnTertiary,
    tertiaryContainer = PlayFlixLightTertiaryContainer,
    onTertiaryContainer = PlayFlixLightOnTertiaryContainer,
    error = PlayFlixLightError,
    errorContainer = PlayFlixLightErrorContainer,
    onError = PlayFlixLightOnError,
    onErrorContainer = PlayFlixLightOnErrorContainer,
    background = PlayFlixLightBackground,
    onBackground = PlayFlixLightOnBackground,
    surface = PlayFlixLightSurface,
    onSurface = PlayFlixLightOnSurface,
    surfaceVariant = PlayFlixLightSurfaceVariant,
    onSurfaceVariant = PlayFlixLightOnSurfaceVariant
)


private val DarkColorScheme = darkColorScheme(
    primary = PlayFlixDarkPrimary,
    onPrimary = PlayFlixDarkOnPrimary,
    primaryContainer = PlayFlixDarkPrimaryContainer,
    onPrimaryContainer = PlayFlixDarkOnPrimaryContainer,
    secondary = PlayFlixDarkSecondary,
    onSecondary = PlayFlixDarkOnSecondary,
    secondaryContainer = PlayFlixDarkSecondaryContainer,
    onSecondaryContainer = PlayFlixDarkOnSecondaryContainer,
    tertiary = PlayFlixDarkTertiary,
    onTertiary = PlayFlixDarkOnTertiary,
    tertiaryContainer = PlayFlixDarkTertiaryContainer,
    onTertiaryContainer = PlayFlixDarkOnTertiaryContainer,
    error = PlayFlixDarkError,
    errorContainer = PlayFlixDarkErrorContainer,
    onError = PlayFlixDarkOnError,
    onErrorContainer = PlayFlixDarkOnErrorContainer,
    background = PlayFlixDarkBackground,
    onBackground = PlayFlixDarkOnBackground,
    surface = PlayFlixDarkSurface,
    onSurface = PlayFlixDarkOnSurface,
    surfaceVariant = PlayFlixDarkSurfaceVariant,
    onSurfaceVariant = PlayFlixDarkOnSurfaceVariant
)


@Composable
fun PlayFlixTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}