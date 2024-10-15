fun readUserChoice() : String {
    var opcaoEscolhida : String

    print("Digite o que quer jogar.\npe- Para pedra\npa- Para papel\nte-Para tesoura")

    opcaoEscolhida = readln()

    while(opcaoEscolhida !in arrayOf("pe", "pa", "te")) {
        print("Digite uma opção válida")
        opcaoEscolhida = readln()
    }

    return opcaoEscolhida
}

fun main() {
    val combinacoesDeVitoria = arrayOf("pa-pe", "pe-te", "te-pa")

    print("Escolha do jogador 1")
    val opcaoEscolhida1 = readUserChoice()
    print("Escolha do jogador 2")
    val opcaoEscolhida2 = readUserChoice()

    if(opcaoEscolhida1 == opcaoEscolhida2) {
        print("Deu empate!")
    }
    else if("$opcaoEscolhida1-$opcaoEscolhida2" in combinacoesDeVitoria) {
        print("Jogador 1 venceu!")
    }
    else {
        print("Jogador 2 venceu!")
    }

}