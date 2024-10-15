fun isValidCpf(cpf: String): Boolean {
    // Regex para validar o formato do CPF
    val regex = Regex("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
    if (!regex.matches(cpf)) return false

    // Remove caracteres de formatação e mantém apenas os dígitos
    val digits = cpf.replace(".", "").replace("-", "")

    // Verifica se todos os dígitos são iguais (ex: 111.111.111-11)
    if (digits.all { it == digits[0] }) return false

    // Cálculo dos dígitos verificadores
    val firstDigit = calculateDigit(digits, 10)
    val secondDigit = calculateDigit(digits + firstDigit, 11)

    // Valida os dígitos verificadores
    return "$digits[9]$digits[10]" == "$firstDigit$secondDigit"
}

fun calculateDigit(digits: String, factor: Int): Int {
    val sum = digits.take(9).mapIndexed { index, char ->
        char.digitToInt() * (factor - index)
    }.sum()
    val remainder = sum % 11
    return if (remainder < 2) 0 else 11 - remainder
}

fun main() {
    println("Digite o CPF no formato XXX.XXX.XXX-XX:")
    val cpf = readln()

    if (isValidCpf(cpf)) {
        println("O CPF informado é válido.")
    } else {
        println("O CPF informado é inválido.")
    }
}