package com.deliveryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delivery_app.R
import com.deliveryapp.extensions.toBrazilianCurrency
import com.deliveryapp.model.Product
import com.deliveryapp.ui.theme.DeliveryAppTheme
import com.deliveryapp.ui.theme.Purple500
import com.deliveryapp.ui.theme.Teal200
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    DeliveryAppTheme {
        Surface {
            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Spacer(Modifier)
                ProductSection()
                ProductSection()
                ProductSection()
                Spacer(Modifier)
            }
        }
    }
}

@Composable
fun ProductSection() {
    Column {
        Text(
            text = stringResource(R.string.promoções),
            Modifier.padding(
                start = 16.dp,
                end = 16.dp
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .padding(
                    top = 8.dp,
                )
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState(0)),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier)
            ProductItem(
                Product(
                    name = stringResource(R.string.hamburguer),
                    price = BigDecimal("12.99"),
                    image = R.drawable.burger
                )
            )
            ProductItem(
                Product(
                    name = stringResource(R.string.pizza),
                    price = BigDecimal("19.99"),
                    image = R.drawable.pizza
                )
            )
            ProductItem(
                Product(
                    name = stringResource(R.string.batata_frita),
                    price = BigDecimal("7.99"),
                    image = R.drawable.fries
                )
            )
            Spacer(Modifier)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        elevation = 4.dp
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple500, Teal200
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(
                        id = product.image
                    ),
                    contentDescription = stringResource(R.string.imagem_produto),
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(BottomCenter),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis

                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    App()
}

@Preview(showBackground = true)
@Composable
fun ProductSectionPreview() {
    ProductSection()
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(
        Product(
            name = LoremIpsum(50).values.first(),
            price = BigDecimal("14.99"),
            image = R.drawable.ic_launcher_background
        )
    )
}