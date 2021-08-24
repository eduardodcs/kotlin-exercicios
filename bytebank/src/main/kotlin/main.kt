fun main() {
    println("Bem vindo ao ByteBank")
    val contaEduardo = Conta(titular = "Eduardo", numeroConta = 1000)
    contaEduardo.deposita(233.0)

    val contaRenaria = Conta("Renaria", 1001)
    contaRenaria.deposita(233.0)

    println(contaEduardo.titular)
    println(contaEduardo.numeroConta)
    println(contaEduardo.saldo)

    println(contaRenaria.titular)
    println(contaRenaria.numeroConta)
    println(contaRenaria.saldo)

    println("Deposito na conta do Eduardo")
    contaEduardo.deposita(50.0)
    println("Novo saldo Eduardo: ${contaEduardo.saldo}")

    println("Deposito na conta do Renaria")
    contaRenaria.deposita(150.0)
    println("Novo saldo Renaria: ${contaRenaria.saldo}")


    println("Saque na conta do Renaria")
    contaRenaria.saca(650.0)
    println("Novo saldo Renaria: ${contaRenaria.saldo}")

    println("Tranferencia Eduardo >> Renaria")
    val resultado = contaEduardo.transfere(contaRenaria, 120.0)
    println(resultado)
    println("Novo saldo Eduardo: ${contaEduardo.saldo}")
    println("Novo saldo Renaria: ${contaRenaria.saldo}")

}


class Conta(
    val titular: String,
    val numeroConta: Int
    ) {
    var saldo: Double = 0.0
        private set

//    constructor(titular: String, numero: Int) : this() {
//        this.titular = titular
//        this.numeroConta = numero
//    }


    fun deposita(valor: Double) {
        if (valor > 0) {
            saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (this.saldo >= valor) {
            this.saldo -= valor
        } else {
            println("Saldo insuficiente")
        }
    }

    fun transfere(contaDestino: Conta, valor: Double): Boolean {
        if (this.saldo >= valor) {
            this.saldo -= valor
            contaDestino.deposita(valor)
            return true
        } else {
            println("Saldo insuficiente")
            return false
        }
    }

}


fun testaLacos() {
    //for (i in 1..5) {
    for (i in 10 downTo 1 step 2) {
        println("Bem vindo ao ByteBank")
        val titular: String = "Eduardo Silva"
        val numeroConta: Int = 1000
        var saldo: Double = 0.0
        saldo -= 100
//    saldo += 200

        println("Titular: $titular")
        println("Número da conta: $numeroConta")
        println("Saldo: $saldo")
    }
}


fun testeCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("Conta é positiva")
    } else if (saldo == 0.0) {
        println("Conta é neutra")
    } else {
        println("Conta negativa")
    }

    //equivalente ao when

    when {
        saldo > 0.0 -> println("Conta é positiva")
        saldo == 0.0 -> println("Conta é neutra")
        else -> println("Conta negativa")
    }
}

