fun readIntInput(askingText: String): Int {
    print(askingText)
    return readlnOrNull()?.toInt() ?: 0
}

fun main() {

    val horaInicio = readIntInput("Por favor, digite a hora de início do jogo: ")
    val horaFim = readIntInput("Por favor, digite a hora de fim do jogo: ")

    var duracao = if(horaInicio < horaFim) horaFim - horaInicio else 24 - (horaInicio - horaFim)

    print("A duração do jogo foi de $duracao horas")

}