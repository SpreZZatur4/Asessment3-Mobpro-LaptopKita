package org.d3if3150.laptopkita.ui.screen

import android.graphics.Bitmap
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import org.d3if3150.laptopkita.ui.theme.GrayTextCard
import org.d3if3150.laptopkita.ui.theme.GreenPastel
import org.d3if3150.laptopkita.ui.theme.OrangeIco
import org.d3if3150.laptopkita.ui.theme.OrangePastel

@Composable
fun ImageDialog(
    bitmap: Bitmap?,
    onDismissRequest: () -> Unit,
    onConfirmation: (String, String, String) -> Unit
) {
    var title by remember { mutableStateOf("") }
    var brand by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier.padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = cardColors(containerColor = OrangePastel, contentColor = GrayTextCard)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    bitmap = bitmap!!.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                )
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = {
                        RegularText(text = "Laptop Title")
                    },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    textStyle = TextStyle(color = GrayTextCard, fontFamily = Poppins)
                )
                OutlinedTextField(
                    value = brand,
                    onValueChange = { brand = it },
                    label = {
                        RegularText(text = "Brand")
                    },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    textStyle = TextStyle(color = GrayTextCard, fontFamily = Poppins)
                )
                OutlinedTextField(
                    value = price,
                    onValueChange = { price = it },
                    prefix = {
                             RegularText(text = "Rp. ")
                    },
                    label = {
                        RegularText(text = "Price")
                    },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier.padding(top = 8.dp),
                    textStyle = TextStyle(color = GrayTextCard, fontFamily = Poppins)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedButton(
                    onClick = { onDismissRequest() },
                    modifier = Modifier.padding(8.dp),
                    border = BorderStroke(1.dp, GrayTextCard)
                ) {
                    RegularText(text = "Cancel", color = GrayTextCard)
                }
                OutlinedButton(
                    onClick = { onConfirmation(title, brand, price) },
                    enabled = title.isNotEmpty() && brand.isNotEmpty() && price.isNotEmpty(),
                    modifier = Modifier.padding(8.dp),
                    border = BorderStroke(
                        1.dp, if (title.isNotEmpty() && brand.isNotEmpty() && price.isNotEmpty()) Color.Transparent else GrayTextCard
                    ),
                    colors = buttonColors(containerColor = if (title.isNotEmpty() && brand.isNotEmpty() && price.isNotEmpty()) GreenPastel else OrangeIco)
                ) {
                        RegularText(text = "Save", color = GrayTextCard)
                }
            }
        }
    }
}

@Composable
fun RadiOptions(label: String, isSelected: Boolean, modifier: Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = isSelected, onClick = null)
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
