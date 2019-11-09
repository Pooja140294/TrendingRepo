package com.ginilab.tomafood.ui.main.home.cell

import com.ginilab.tomafood.base.common.Cell
import com.ginilab.tomafood.ui.main.home.response.*

data class HomeSection1ItemCell(val section1List: List<Section1Restaurants>, val title: String, val description: String): Cell

data class HomeSection2ItemCell(val section2List : List<Section2Restaurants>, val title: String, val description: String): Cell

data class HomeSection3ItemCell(val section3List : List<Section3Restaurants>, val title: String, val description: String): Cell

data class HomeSection4ItemCell(val section4List : List<Section4Restaurants>, val title: String, val description: String): Cell

data class HomeSection5ItemCell(val section5List : List<Section5Restaurants>, val title: String, val description: String): Cell