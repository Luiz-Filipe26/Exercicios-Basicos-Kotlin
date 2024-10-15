fun main() {
    val qtdNotasDisponiveis = arrayOf(
        intArrayOf(10, 2), // valor da nota no índice 0, quantidade no índice 1
        intArrayOf(5, 10),
        intArrayOf(1, 10)
    )

    val precoAPagar = readIntInput("Por favor, digite o preço a ser pago: ")

    if (precoAPagar > 80) {
        println("Não há notas de dinheiro o suficiente para pagar a conta.")
        return
    }

    var precoRestante = precoAPagar

    print("Notas usadas para o pagamento:\n")

    for (i in qtdNotasDisponiveis.indices) {
        val valorNota = qtdNotasDisponiveis[i][0]
        val quantidadeDisponivel = qtdNotasDisponiveis[i][1]

        val quantidadeUsar = (precoRestante / valorNota).coerceAtMost(quantidadeDisponivel)

        qtdNotasDisponiveis[i][1] -= quantidadeUsar

        precoRestante -= quantidadeUsar * valorNota

        if (quantidadeUsar > 0) {
            println("$quantidadeUsar nota(s) de $valorNota reais.")
        }
    }
}
