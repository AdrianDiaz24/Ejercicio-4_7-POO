

class Cuenta(numCuenta: Int, saldo: Double = 0.0) {

    val numCuenta = numCuenta
    var saldo = saldo

    override fun toString(): String {
        return "Cuenta ($numCuenta) con $saldo€ de saldo."
    }

    fun recibirAbono(abono: Double){
        saldo += abono
    }

    fun realizarPago(pago: Double){
        saldo -= pago
    }
}