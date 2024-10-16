fun cpfValido(cpf: String): Boolean {
    val regex = Regex("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
    if (!regex.matches(cpf)) return false

    val digitos = cpf.replace(".", "").replace("-", "")

    if (digitos.all { it == digitos[0] }) return false

    val primeiroDigito = calcularDigitoVerificador(digitos.substring(0, 9))
    val segundoDigito = calcularDigitoVerificador(digitos.substring(0, 9) + primeiroDigito)

    return "$primeiroDigito$segundoDigito" == "${digitos[9]}${digitos[10]}"
}

fun calcularDigitoVerificador(digitos: String): Int {
    val soma = digitos.mapIndexed { index, caractere ->
        caractere.digitToInt() * (digitos.length + 1 - index)
    }.sum()

    val resto = soma % 11

    return if (resto < 2) 0 else 11 - resto
}

fun main() {
    println("Digite o CPF no formato XXX.XXX.XXX-XX:")
    val cpf = readln()

    if (cpfValido(cpf)) {
        println("O CPF informado é válido.")
    } else {
        println("O CPF informado é inválido.")
    }
}