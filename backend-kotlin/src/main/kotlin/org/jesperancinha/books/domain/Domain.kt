package org.jesperancinha.books.domain

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

typealias Author = String

typealias Publisher = String

typealias Category = String

data class Book(
    @JsonProperty
    val kind: String,
    @JsonProperty
    val id: String,
    @JsonProperty
    val etag: String,
    @JsonProperty
    val selflink: String?,
    @JsonProperty
    val volumeInfo: VolumeInfo,
    @JsonProperty
    val layerInfo: LayerInfo,
    @JsonProperty
    val saleInfo: SaleInfo,
    @JsonProperty
    val accessInfo: AccessInfo
)

data class AccessInfo(
    @JsonProperty
    val country: Country,
    @JsonProperty
    val viewability: String,
    @JsonProperty
    val embeddable: Boolean,
    @JsonProperty
    val publicDomain: Boolean,
    @JsonProperty
    val textToSpeechPermission: String,
    @JsonProperty
    val epub: Epub,
    @JsonProperty
    val pdf: Pdf,
    @JsonProperty
    val webReaderLink: String,
    @JsonProperty
    val accessViewStatus: String,
    @JsonProperty
    val quoteSharingAllowed: Boolean
)

data class Epub(
    @JsonProperty
    val isAvailable: Boolean,
    @JsonProperty
    val acsTokenLink: String
)

data class LayerInfo(
    @JsonProperty
    val layers: List<Layer>
)

data class Pdf(
    @JsonProperty
    val isAvailable: Boolean
)

data class SaleInfo(
    @JsonProperty
    val country: Country,
    @JsonProperty
    val saleability: String,
    @JsonProperty
    val isEbook: Boolean,
    @JsonProperty
    val listPrice: ListPrice,
    @JsonProperty
    val retailPrice: RetailPrice?,
    @JsonProperty
    val buyLink: String,
    @JsonProperty
    val offers: List<Offer>
)

data class Offer(
    @JsonProperty
    val finskyOfferType: Int,
    @JsonProperty
    val listPrice: ListPrice,
    @JsonProperty
    val retailPrice: RetailPrice
)

data class RetailPrice(
    @JsonProperty
    val amount: BigDecimal?,
    @JsonProperty
    val currency: Currency?
)

data class ListPrice(
    @JsonProperty
    val amount: BigDecimal? = null,
    @JsonProperty
    val amountInMicros: BigDecimal? = null,
    @JsonProperty
    val currency: Currency?
)

data class Layer(
    @JsonProperty
    val layerId: String,
    @JsonProperty
    val volumeAnnotationsVersion: String
)

data class VolumeInfo(
    @JsonProperty
    val title: String,
    @JsonProperty
    val subtitle: String,
    @JsonProperty
    val authors: List<Author>,
    @JsonProperty
    val publisher: Publisher,
    @JsonProperty
    val publisherDate: LocalDate?,
    @JsonProperty
    val description: String,
    @JsonProperty
    val industryIdentifiers: List<IndustryIdentifier>,
    @JsonProperty
    val readingModes: ReadingModes,
    @JsonProperty
    val pageCount: Long,
    @JsonProperty
    val printedPageCount: Long,
    @JsonProperty
    val dimensions: Dimensions,
    @JsonProperty
    val printType: String,
    @JsonProperty
    val categories: List<Category>,
    @JsonProperty
    val averageRating: BigDecimal,
    @JsonProperty
    val ratingsCount: Int,
    @JsonProperty
    val maturityRating: String,
    @JsonProperty
    val allowAnonLogging: Boolean,
    @JsonProperty
    val contentVersion: String,
    @JsonProperty
    val panelizationSummary: PanelizationSummary,
    @JsonProperty
    val imageLinks: ImageLinks,
    @JsonProperty
    val language: Language,
    @JsonProperty
    val previewLink: String,
    @JsonProperty
    val infoLink: String,
    @JsonProperty
    val canonicalVolumeLink: String
)

data class IndustryIdentifier(
    @JsonProperty
    val type: String,
    @JsonProperty
    val identifier: String
)

data class ReadingModes(
    @JsonProperty
    val text: Boolean,
    @JsonProperty
    val image: Boolean
)

data class Dimensions(
    @JsonProperty
    val height: String
)

data class PanelizationSummary(
    @JsonProperty
    val containsEpubBubbles: Boolean,
    @JsonProperty
    val containsImageBubbles: Boolean
)

data class ImageLinks(
    @JsonProperty
    val smallThumbnail: String,
    @JsonProperty
    val thumbnail: String,
    @JsonProperty
    val small: String,
    @JsonProperty
    val medium: String,
    @JsonProperty
    val large: String
)

enum class Language {
    en, nl
}

enum class Country {
    EN, NL
}