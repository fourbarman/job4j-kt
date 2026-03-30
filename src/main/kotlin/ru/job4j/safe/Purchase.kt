package ru.job4j.safe

import java.time.LocalDate

data class Purchase(
    val name: String,
    val created: LocalDate,
    val address: Address?
)

data class Address(
    val street: String?,
    val home: String?,
    val zip: Zip?
)

data class Zip(val code: String)

fun generateTable(purchases: List<Purchase>): String {
    val sb = StringBuilder()
    sb.append("<!DOCTYPE html>\n")
    sb.append("<html>\n")
    sb.append("<head>\n")
    sb.append("<title>Purchase list</title>\n")
    sb.append("</head>\n")
    sb.append("<body>\n")
    sb.append("<table>\n")
    sb.append("<tr><th>Name</th><th>Created</th><th>Address</th></tr>\n")

    for (purchase in purchases) {
        sb.append("<tr>")
        sb.append("<td>${purchase.name}</td>")
        sb.append("<td>${purchase.created}</td>")
        sb.append("<td>${purchase.address?.zip?.code ?: ""} ${purchase.address?.street ?: ""} ${purchase.address?.home ?: ""}</td>")
        sb.append("</tr>\n")
    }

    sb.append("</table>\n")
    sb.append("</body>\n")
    sb.append("</html>")
    return sb.toString()
}
