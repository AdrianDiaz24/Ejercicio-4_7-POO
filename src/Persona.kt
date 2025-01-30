


class Persona(val dni: String, cuentas: Array<Cuenta?>) {

    init {
        require(dni.length == 9){throw IllegalArgumentException("El DNI debe contener 9 digitos")}
        require(dni[8].isLetter()){throw IllegalArgumentException("El ultimo caracter del DNI debe ser una letra")}
        require(cuentas.size <= 3){throw IllegalArgumentException("Solo puede haber un maximo de 3 cuentas vinculada a la persona")}
    }

    constructor(dni: String): this(dni, cuentas = arrayOf(null, null, null)){

    }

    var cuentas:Array<Cuenta?> = this.añadirCuentasIniciales()

    private fun añadirCuentasIniciales(): Array<Cuenta?>{
        var i = 0
        val cuentasIntroducidas = arrayOf<Cuenta?>(null, null, null)
        for (cuenta in cuentas){
            cuentasIntroducidas[i] = cuenta
            i++
        }
        return cuentasIntroducidas
    }

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
}