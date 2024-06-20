package org.d3if3150.laptopkita.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import org.d3if3150.laptopkita.ui.theme.GrayTextCard
import org.d3if3150.laptopkita.ui.theme.OrangeIco
import org.d3if3150.laptopkita.ui.theme.OrangePastel
import org.d3if3150.laptopkita.ui.theme.WhiteBG

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    value: String = "",
    onSearchAction: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onSearchAction,
        modifier = modifier.fillMaxWidth(),
        shape = CircleShape,
        maxLines = 1,
        singleLine = true,
        placeholder = {
            SmallText(text = "Search something..", color = GrayTextCard)
        },
        trailingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search", tint = OrangeIco)
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = WhiteBG,
            focusedContainerColor = WhiteBG,
            unfocusedBorderColor = OrangeIco,
            focusedBorderColor = OrangeIco
        ),
        textStyle = TextStyle(
            fontSize = 14.sp,
            fontFamily = Poppins,
            color = GrayTextCard
        ),
    )
}

@Preview
@Composable
private fun SearchBarPrev() {
    SearchBar(
        value = "",
        onSearchAction = {

        },
    )
}