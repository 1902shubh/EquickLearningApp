package com.equicklearning.models.category

data class Links(
    val about: List<About>,
    val collection: List<Collection>,
    val curies: List<Cury>,
    val self: List<Self>,
    val up: List<Up>,
//    val wp:post_type: List<WpPostType>
)