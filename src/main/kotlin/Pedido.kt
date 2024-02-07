class Pedido(){

    companion object {
        var contPedidos: Int = 0
    }

    init {
        contPedidos++
    }

    val numero = contPedidos

    val platos: MutableList<Plato> = mutableListOf()

    var estado = EstadoPedido.PENDIENTE


    fun agregarPlato(plato: Plato) {
        platos.add(plato)
    }

    fun eliminarPlato(nombrePlato: String){
        platos.forEach { plato ->
            if (plato.obtenerNombrePlato() == nombrePlato){
                platos.remove(plato)
                println("Plato eliminado correctamente")
            } else {
                println("Plato no encontrado")
            }
        }
    }

    fun calcularPrecio(): Double {
        var precioTotal = 0.0
        platos.forEach { plato ->
            precioTotal += plato.obtenerPrecioPlato()
        }

        return precioTotal
    }

    override fun toString(): String {
        var pedido: String = ""

        platos.forEach { plato -> pedido += println(plato) }

        return pedido
    }
}