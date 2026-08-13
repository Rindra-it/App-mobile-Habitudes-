package com.example.habitudes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habitudes.ui.theme.HabitudesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitudesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        //nom:  ANDRIAVELOMANANA Tolojanahary Rindra
                        // L2, N°: 06
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CountPill(text: String, color: Color, background: Color) {
    Surface(
        shape = RoundedCornerShape(50),
        color = background
    ) {
        Text(
            text = text,
            color = color,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp)
        )
    }
}

@Composable
fun HabitRow(labelRes: Int) {
    var addCount by remember { mutableIntStateOf(0) }
    var subCount by remember { mutableIntStateOf(0) }

    val rowBg = colorResource(id = R.color.rowbg)
    val primaryGreen = colorResource(id = R.color.primarygreen)
    val primaryGreenDark = colorResource(id = R.color.primarygreendark)
    val accentCoral = colorResource(id = R.color.accentcoral)
    val pillGreenBg = colorResource(id = R.color.pillgreenbg)
    val pillCoralBg = colorResource(id = R.color.pillcoralbg)

    Surface(
        shape = RoundedCornerShape(14.dp),
        color = rowBg,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ElevatedButton(
                onClick = { addCount++ },
                shape = CircleShape,
                contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = primaryGreen,
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 3.dp)
            ) {
                Text(stringResource(R.string.add), fontWeight = FontWeight.Bold)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    text = stringResource(labelRes),
                    color = primaryGreenDark,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )
                if (addCount > 0 || subCount > 0) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        if (addCount > 0) CountPill("+$addCount", primaryGreenDark, pillGreenBg)
                        if (subCount > 0) CountPill("-$subCount", accentCoral, pillCoralBg)
                    }
                }
            }

            ElevatedButton(
                onClick = { subCount++ },
                shape = CircleShape,
                contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = accentCoral,
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 3.dp)
            ) {
                Text(stringResource(R.string.sous), fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val backgroundTop = colorResource(id = R.color.backgroundTop)
    val backgroundBottom = colorResource(id = R.color.backgroundbottom)
    val primaryGreen = colorResource(id = R.color.primarygreen)
    val primaryGreenDark = colorResource(id = R.color.primarygreendark)
    val accentCoral = colorResource(id = R.color.accentcoral)
    val cardWhite = colorResource(id = R.color.cardwhite)
    val pillGreenBg = colorResource(id = R.color.pillgreenbg)
    val pillCoralBg = colorResource(id = R.color.pillcoralbg)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(backgroundTop, backgroundBottom)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = cardWhite),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(104.dp)
                                .shadow(8.dp, CircleShape)
                                .background(
                                    Brush.linearGradient(
                                        colors = listOf(primaryGreen, accentCoral)
                                    ),
                                    CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.pexels_joerg_hartmann_626385254_17494564_1_),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(96.dp)
                                    .clip(CircleShape)
                                    .border(3.dp, Color.White, CircleShape)
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .weight(2f)
                            .padding(start = 14.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = stringResource(R.string.vie),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = primaryGreenDark
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        CountPill(stringResource(R.string.exp), primaryGreenDark, pillGreenBg)
                        Spacer(modifier = Modifier.height(6.dp))
                        CountPill(stringResource(R.string.mp), accentCoral, pillCoralBg)
                    }

                }
            }

            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(6.dp, 26.dp)
                        .background(primaryGreen, RoundedCornerShape(50))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.habitudes),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = primaryGreenDark
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(16.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = cardWhite),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HabitRow(labelRes = R.string.mediter)
                    HabitRow(labelRes = R.string.boire)
                    HabitRow(labelRes = R.string.sport)
                    HabitRow(labelRes = R.string.manger)
                    HabitRow(labelRes = R.string.etudier)
                    HabitRow(labelRes = R.string.dormir)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HabitudesTheme {
        Greeting()
    }
}
