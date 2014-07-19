package com.kettler.geocode

/**
 * Includes address and contains results of Geocode service to get lat/lng
 */
class Geocode {
    String address = ""
    Boolean success = false
    String errorMessage = ""
    String country
    Float lat = 0.0F
    Float lng = 0.0F

    String toString() { "address: ${address}, success: ${success}, lat: ${lat}, lng: ${lng}"}
}
