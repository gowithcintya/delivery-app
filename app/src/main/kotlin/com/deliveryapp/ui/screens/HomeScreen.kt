package com.deliveryapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deliveryapp.model.Product
import com.deliveryapp.sampledata.sampleSections
import com.deliveryapp.ui.components.ProductSection
import com.deliveryapp.ui.theme.DeliveryAppTheme

@Composable
fun HomeScreen(sections: Map<String, List<Product>>) {
    LazyColumn(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        for (section in sections) {
            val title = section.key
            val products = section.value
            item {
                ProductSection(
                    title = title,
                    products = products
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    DeliveryAppTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}