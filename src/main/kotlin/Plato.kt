@Suppress("UNUSED_EXPRESSION")
class Plato(nombre: String, precio: Double, tiempoPreparacion: Int, ingredientes: MutableList<String>) {

   private var nombre: String = nombre
       set(value) {
            try {
                comprobarNombre()
                field = value
            } catch (e: IllegalArgumentException){
                println(e.message)
            }
       }
   private var precio: Double = precio
       set(value) {
           try {
               comprobarPrecio()
               field = value
           } catch (e: IllegalArgumentException){
               println(e.message)
           }
       }

   private var tiempoPreparacion: Int = tiempoPreparacion
       set(value) {
           try {
               comprobarTiempo()
               field = value
           } catch (e: IllegalArgumentException){
               println(e.message)
           }
       }
   private var ingredientes: MutableList<String> = mutableListOf()
       set(value) {
           try {
               ingredientes.forEach { ingrediente -> comprobarIngrediente(ingrediente) }
               field = value
           } catch (e: IllegalArgumentException) {
               println(e.message)
           }
       }

   init {
       this.nombre = nombre
       this.precio = precio
       this.tiempoPreparacion = tiempoPreparacion
       this.ingredientes = ingredientes
   }

    //Metodos privados
    private fun comprobarNombre() {
        require(precio > 0.0) {"PRECIO DEBE SER MAYOR A 0"}
    }

    private fun comprobarPrecio() {
        require(nombre.isNotBlank()) {"NOMBRE NO PUEDE SER VACIO"}
    }

    private fun comprobarTiempo(){
        require(tiempoPreparacion <= 1) {"TIEMPO DE PREPARACION NO PUEDE SER 1 O INFERIOR"}
    }

    private fun comprobarIngrediente(ingrediente: String){
        require(ingrediente.isNotBlank()) {"INGREDIENTE VACIO"}
    }

    //Metodos publicos
    fun agregarIngrediente(ingrediente: String){
        val nuevosIngredientes = ingredientes
        nuevosIngredientes.add(ingrediente)

        ingredientes = nuevosIngredientes

    }

    override fun toString(): String {
        return "$nombre ($tiempoPreparacion min.) -> $precio€ (${ingredientes.dropLast(1).forEach { "$it, " }} y ${ingredientes.last()})"
    }
}