package sopt.android.assignment.data.remote.entity.response

data class SignInResponse(
    val data: Data,
    val message: String,
    val status: Int,
) {
    data class Data(
        val email: String,
        val name: String,
    )
}
