


class Persona(val dni: String, private val cuentasIniciales: Array<Cuenta?>) {

    init {
        require(dni.length == 9){throw IllegalArgumentException("El DNI debe contener 9 digitos")}
        require(dni[8].isLetter()){throw IllegalArgumentException("El ultimo caracter del DNI debe ser una letra")}
        require(cuentasIniciales.size <= 3){throw IllegalArgumentException("Solo puede haber un maximo de 3 cuentas vinculada a la persona")}
    }

    constructor(dni: String): this(dni, cuentasIniciales = arrayOf(null, null, null)){

    }

    private fun añadirCuentasIniciales(): Array<Cuenta?>{
        var i = 0
        val cuentasIntroducidas = arrayOf<Cuenta?>(null, null, null)
        for (cuenta in cuentasIniciales){
            cuentasIntroducidas[i] = cuenta
            i++
        }
        return cuentasIntroducidas
    }

    var cuentas:Array<Cuenta?> = this.añadirCuentasIniciales()



    fun añadirCuenta(cuentaAñadida: Cuenta){
        var i = 0
        for (cuenta in cuentas){
            if (cuenta == null){
                cuentas[i] = cuentaAñadida
            } else if (i == 2) {
                println("Cuenta no añadida, esta persona ya posee 3 cuentas")
            }
            i++
        }
    }

    fun esMorosa():Boolean{
        for (cuenta in cuentas){
            if (cuenta != null){
                if ((cuenta.saldo ?: 0.0) < 0) {
                    println("Es morosa")
                    return true
                }
            }
        }
        println("No es morosa")
        return false
    }

    fun transferencia(persona1: Persona, persona2: Persona, identificador1 :Int, identificador2: Int, cantidad: Double):Boolean{
        if (cantidad <= 0.0) { throw IllegalArgumentException("No puedes transferir menos de 0€")}
        if (persona1.cuentas[identificador1] == null) {throw IllegalArgumentException("No puedes introducir un nulo")}
        if (persona2.cuentas[identificador2] == null) {throw IllegalArgumentException("No puedes introducir un nulo")}

        if (persona1.cuentas[identificador1]?.saldo?: 0.0 >= cantidad){
            persona1.cuentas[identificador1]?.realizarPago(cantidad)
            persona2.cuentas[identificador2]?.recibirAbono(cantidad)
            println("Transferencia realizada")
            return true
        } else {
            println("No hay suficiente dinero en la cuenta (${persona1.cuentas[identificador1]?.numCuenta}) para realizar la transferencia")
            return false
        }
    }
}