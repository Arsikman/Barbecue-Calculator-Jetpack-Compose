package com.example.shashlickcompose.cards_ui


import android.view.LayoutInflater
import android.widget.SeekBar
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.shashlickcompose.*
import com.example.shashlickcompose.R
import com.example.shashlickcompose.ui.theme.*


// Hunger
@Composable
fun ChoseHungerUI() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Text(
            text = stringResource(R.string.choose_hunger),
            modifier = Modifier
                .padding(top = 5.dp, start = 13.dp, end = 13.dp),
            color = CardTextColor,
            fontSize = 18.sp,
            style = TextStyle(fontFamily = getTitleFont())
        )

        AndroidView(
            modifier = Modifier
                .fillMaxWidth(),
            factory = { context ->
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.hunger_layout, null, false)
                var sbHunger = view.findViewById<SeekBar>(R.id.sbHunger)

                val dr0 = AppCompatResources.getDrawable(context, R.drawable.face_f1)
                sbHunger.thumb = dr0

                sbHunger.height
                sbHunger.setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                        if (i in 0..24) {

                            val dr1 =
                                AppCompatResources.getDrawable(context, R.drawable.face_f1)
                            sbHunger.thumb = dr1
                            res_hunger = hunger_none

                        } else if (i in 25..49) {
                            val dr2 =
                                AppCompatResources.getDrawable(context, R.drawable.face_f2)
                            sbHunger.thumb = dr2
                            res_hunger = hunger_s

                        } else if (i in 50..74) {
                            val dr3 =
                                AppCompatResources.getDrawable(context, R.drawable.face_f3)
                            sbHunger.thumb = dr3
                            res_hunger = hunger_m

                        } else if (i in 75..100) {
                            val dr4 =
                                AppCompatResources.getDrawable(context, R.drawable.face_f4)
                            sbHunger.thumb = dr4
                            res_hunger = hunger_l

                        }
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar) {}
                    override fun onStopTrackingTouch(seekBar: SeekBar) {}
                })

                // do whatever you want...
                view // return the view
            },
            update = { view ->
                // Update the view
            }
        )
    }
}



