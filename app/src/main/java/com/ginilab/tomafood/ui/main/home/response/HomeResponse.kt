package com.ginilab.tomafood.ui.main.home.response

import com.ginilab.tomafood.base.common.Cell
import com.squareup.moshi.Json

data class HomeResponse(
    @Json(name = "status") val status: Boolean,
    @Json(name = "listing") val listing: Listing
    ): Cell

data class Listing(
    @Json(name = "section1") val section_1: Section1,
    @Json(name = "section2") val section_2: Section2,
    @Json(name = "section3") val section_3: Section3,
    @Json(name = "section4") val section_4: Section4,
    @Json(name = "section5") val section_5: Section5
): Cell

data class Section1(
    @Json(name = "title") val title: String = "",
    @Json(name = "description") val description: String = "",
    @Json(name = "restaurants") val restaurants: List<Section1Restaurants>
): Cell

data class Section2(
    @Json(name = "title") val title: String = "",
    @Json(name = "description") val description: String = "",
    @Json(name = "restaurants") val restaurants: List<Section2Restaurants>
): Cell

data class Section3(
    @Json(name = "title") val title: String = "",
    @Json(name = "description") val description: String = "",
    @Json(name = "restaurants") val restaurants: List<Section3Restaurants>
): Cell

data class Section4(
    @Json(name = "title") val title: String = "",
    @Json(name = "description") val description: String = "",
    @Json(name = "restaurants") val restaurants: List<Section4Restaurants>
): Cell

data class Section5(
    @Json(name = "title") val title: String = "",
    @Json(name = "description") val description: String = "",
    @Json(name = "restaurants") val restaurants: List<Section5Restaurants>
): Cell

data class Section1Restaurants(
    @Json(name = "id") val id: String = "",
    @Json(name = "restaurant_type") val restaurant_type: String = "",
    @Json(name = "restaurant_name") val restaurant_name: String = "",
    @Json(name = "restaurant_summary") val restaurant_summary: String = "",
    @Json(name = "house") val house: String = "",
    @Json(name = "address") val address: String = "",
    @Json(name = "city") val city: String = "",
    @Json(name = "county") val county: String = "",
    @Json(name = "postcode") val postcode: String = "",
    @Json(name = "phone") val phone: String = "",
    @Json(name = "email") val email: String = "",
    @Json(name = "website") val website: String = "",
    @Json(name = "is_halal") val is_halal: String = "",
    @Json(name = "card_service_charge") val card_service_charge: String = "",
    @Json(name = "min_delivery_charge") val min_delivery_charge: String = "",
    @Json(name = "exclude_discount") val exclude_discount: String = "",
    @Json(name = "website_logo") val website_logo: String = "",
    @Json(name = "category_name") val category_name: String = "",
    @Json(name = "app_image") val app_image: String = "",
    @Json(name = "total_review") val total_review: String = "",
    @Json(name = "rating") val rating: String = "",
    @Json(name = "open") val open: String = "",
    @Json(name = "opening_times") val opening_times: OpeningTime

    ): Cell

data class Section2Restaurants(
    @Json(name = "id") val id: String = "",
    @Json(name = "restaurant_type") val restaurant_type: String = "",
    @Json(name = "restaurant_name") val restaurant_name: String = "",
    @Json(name = "restaurant_summary") val restaurant_summary: String = "",
    @Json(name = "house") val house: String = "",
    @Json(name = "address") val address: String = "",
    @Json(name = "city") val city: String = "",
    @Json(name = "county") val county: String = "",
    @Json(name = "postcode") val postcode: String = "",
    @Json(name = "phone") val phone: String = "",
    @Json(name = "email") val email: String = "",
    @Json(name = "website") val website: String = "",
    @Json(name = "is_halal") val is_halal: String = "",
    @Json(name = "card_service_charge") val card_service_charge: String = "",
    @Json(name = "min_delivery_charge") val min_delivery_charge: String = "",
    @Json(name = "exclude_discount") val exclude_discount: String = "",
    @Json(name = "website_logo") val website_logo: String = "",
    @Json(name = "category_name") val category_name: String = "",
    @Json(name = "app_image") val app_image: String = "",
    @Json(name = "total_review") val total_review: String = "",
    @Json(name = "rating") val rating: String = "",
    @Json(name = "open") val open: String = "",
    @Json(name = "opening_times") val opening_times: OpeningTime

): Cell

data class Section3Restaurants(
    @Json(name = "id") val id: String = "",
    @Json(name = "restaurant_type") val restaurant_type: String = "",
    @Json(name = "restaurant_name") val restaurant_name: String = "",
    @Json(name = "restaurant_summary") val restaurant_summary: String = "",
    @Json(name = "house") val house: String = "",
    @Json(name = "address") val address: String = "",
    @Json(name = "city") val city: String = "",
    @Json(name = "county") val county: String = "",
    @Json(name = "postcode") val postcode: String = "",
    @Json(name = "phone") val phone: String = "",
    @Json(name = "email") val email: String = "",
    @Json(name = "website") val website: String = "",
    @Json(name = "is_halal") val is_halal: String = "",
    @Json(name = "card_service_charge") val card_service_charge: String = "",
    @Json(name = "min_delivery_charge") val min_delivery_charge: String = "",
    @Json(name = "exclude_discount") val exclude_discount: String = "",
    @Json(name = "website_logo") val website_logo: String = "",
    @Json(name = "category_name") val category_name: String = "",
    @Json(name = "app_image") val app_image: String = "",
    @Json(name = "total_review") val total_review: String = "",
    @Json(name = "rating") val rating: String = "",
    @Json(name = "open") val open: String = "",
    @Json(name = "opening_times") val opening_times: OpeningTime

): Cell

data class Section4Restaurants(
    @Json(name = "id") val id: String = "",
    @Json(name = "restaurant_type") val restaurant_type: String = "",
    @Json(name = "restaurant_name") val restaurant_name: String = "",
    @Json(name = "restaurant_summary") val restaurant_summary: String = "",
    @Json(name = "house") val house: String = "",
    @Json(name = "address") val address: String = "",
    @Json(name = "city") val city: String = "",
    @Json(name = "county") val county: String = "",
    @Json(name = "postcode") val postcode: String = "",
    @Json(name = "phone") val phone: String = "",
    @Json(name = "email") val email: String = "",
    @Json(name = "website") val website: String = "",
    @Json(name = "is_halal") val is_halal: String = "",
    @Json(name = "card_service_charge") val card_service_charge: String = "",
    @Json(name = "min_delivery_charge") val min_delivery_charge: String = "",
    @Json(name = "exclude_discount") val exclude_discount: String = "",
    @Json(name = "website_logo") val website_logo: String = "",
    @Json(name = "category_name") val category_name: String = "",
    @Json(name = "app_image") val app_image: String = "",
    @Json(name = "total_review") val total_review: String = "",
    @Json(name = "rating") val rating: String = "",
    @Json(name = "open") val open: String = "",
    @Json(name = "opening_times") val opening_times: OpeningTime

): Cell

data class Section5Restaurants(
    @Json(name = "id") val id: String = "",
    @Json(name = "restaurant_type") val restaurant_type: String = "",
    @Json(name = "restaurant_name") val restaurant_name: String = "",
    @Json(name = "restaurant_summary") val restaurant_summary: String = "",
    @Json(name = "house") val house: String = "",
    @Json(name = "address") val address: String = "",
    @Json(name = "city") val city: String = "",
    @Json(name = "county") val county: String = "",
    @Json(name = "postcode") val postcode: String = "",
    @Json(name = "phone") val phone: String = "",
    @Json(name = "email") val email: String = "",
    @Json(name = "website") val website: String = "",
    @Json(name = "is_halal") val is_halal: String = "",
    @Json(name = "card_service_charge") val card_service_charge: String = "",
    @Json(name = "min_delivery_charge") val min_delivery_charge: String = "",
    @Json(name = "exclude_discount") val exclude_discount: String = "",
    @Json(name = "website_logo") val website_logo: String = "",
    @Json(name = "category_name") val category_name: String = "",
    @Json(name = "app_image") val app_image: String = "",
    @Json(name = "total_review") val total_review: String = "",
    @Json(name = "rating") val rating: String = "",
    @Json(name = "open") val open: String = "",
    @Json(name = "opening_times") val opening_times: OpeningTime

): Cell

data class OpeningTime(
    @Json(name = "monday") val monday: Monday,
    @Json(name = "tuesday") val tuesday: Tuesday,
    @Json(name = "wednesday") val wednesday: Wednesday,
    @Json(name = "friday") val friday: Friday,
    @Json(name = "saturday") val saturday: Saturday,
    @Json(name = "sunday") val sunday: Sunday,
    @Json(name = "thursday") val thursday: Thursday
    ): Cell

data class Monday(
    @Json(name = "week_day") val week_day: String = "",
    @Json(name = "start_hour") val start_hour: String = "",
    @Json(name = "start_min") val start_min: String = "",
    @Json(name = "end_hour") val end_hour: String = "",
    @Json(name = "end_min") val end_min: String = "",
    @Json(name = "restaurant_id") val restaurant_id: String = ""
    ): Cell

data class Tuesday(
    @Json(name = "week_day") val week_day: String = "",
    @Json(name = "start_hour") val start_hour: String = "",
    @Json(name = "start_min") val start_min: String = "",
    @Json(name = "end_hour") val end_hour: String = "",
    @Json(name = "end_min") val end_min: String = "",
    @Json(name = "restaurant_id") val restaurant_id: String = ""
): Cell

data class Wednesday(
    @Json(name = "week_day") val week_day: String = "",
    @Json(name = "start_hour") val start_hour: String = "",
    @Json(name = "start_min") val start_min: String = "",
    @Json(name = "end_hour") val end_hour: String = "",
    @Json(name = "end_min") val end_min: String = "",
    @Json(name = "restaurant_id") val restaurant_id: String = ""
): Cell

data class Thursday(
    @Json(name = "week_day") val week_day: String = "",
    @Json(name = "start_hour") val start_hour: String = "",
    @Json(name = "start_min") val start_min: String = "",
    @Json(name = "end_hour") val end_hour: String = "",
    @Json(name = "end_min") val end_min: String = "",
    @Json(name = "restaurant_id") val restaurant_id: String = ""
): Cell

data class Friday(
    @Json(name = "week_day") val week_day: String = "",
    @Json(name = "start_hour") val start_hour: String = "",
    @Json(name = "start_min") val start_min: String = "",
    @Json(name = "end_hour") val end_hour: String = "",
    @Json(name = "end_min") val end_min: String = "",
    @Json(name = "restaurant_id") val restaurant_id: String = ""
): Cell

data class Saturday(
    @Json(name = "week_day") val week_day: String = "",
    @Json(name = "start_hour") val start_hour: String = "",
    @Json(name = "start_min") val start_min: String = "",
    @Json(name = "end_hour") val end_hour: String = "",
    @Json(name = "end_min") val end_min: String = "",
    @Json(name = "restaurant_id") val restaurant_id: String = ""
): Cell

data class Sunday(
    @Json(name = "week_day") val week_day: String = "",
    @Json(name = "start_hour") val start_hour: String = "",
    @Json(name = "start_min") val start_min: String = "",
    @Json(name = "end_hour") val end_hour: String = "",
    @Json(name = "end_min") val end_min: String = "",
    @Json(name = "restaurant_id") val restaurant_id: String = ""
): Cell