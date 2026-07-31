package ru.sulgik.mapkit

/**
 * The attribution of information to a specific author.
 */
public data class Attribution(
    /**
     * Additional information about the author.
     */
    val author: Author?,
    /**
     * Link to a specific page on the author's site.
     */
    val link: Link?,
    /**
     * Optional field, can be null.
     */
    val avatarImage: Image?,
) {

    public data class Author(
        val name: String,
        /**
         * A reference to the author's site.
         */
        val uri: String?,
        /**
         * Author's email.
         */
        val email: String?,
    )

    public data class Link(
        val href: String,
    )
}
