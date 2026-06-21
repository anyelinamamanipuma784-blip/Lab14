package com.example.lab14

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.cornerRadius
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.text.FontWeight

class SimpleWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                MyContent()
            }
        }
    }

    @Composable
    private fun MyContent() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .padding(16.dp)
                .background(GlanceTheme.colors.widgetBackground)
                .cornerRadius(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "¿A dónde quieres dirigirte?",
                style = TextStyle(
                    color = GlanceTheme.colors.onSurface,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = GlanceModifier.padding(bottom = 16.dp)
            )

            // Fila estirada horizontalmente para albergar los botones simétricos
            // Fila estirada horizontalmente para albergar los botones simétricos
            Row(
                modifier = GlanceModifier.fillMaxWidth().padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Botón Home
                Button(
                    text = "Home",
                    onClick = actionStartActivity<MainActivity>(),
                    modifier = GlanceModifier
                        .defaultWeight()
                        .padding(end = 6.dp) // Margen a la derecha
                )

                // Botón Work
                Button(
                    text = "Work",
                    onClick = actionStartActivity<WorkActivity>(),
                    modifier = GlanceModifier
                        .defaultWeight()
                        .padding(start = 6.dp) // ¡CORREGIDO AQUÍ! Margen a la izquierda
                )
            }
        }
    }
}