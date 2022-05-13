package sopt.android.assignment.data.remote.entity.response

data class SignUpResponse(
    val data: Data,
    val message: String,
    val status: Int,
) {
    data class Data(
        val id: Int
    )
}
