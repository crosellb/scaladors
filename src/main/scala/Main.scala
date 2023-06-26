object Main {
  def main(args: Array[String]): Unit =
    val zona1 = new Zona(List("CP1", "CP2"), new Repartidor("Ana", "Coche"))
    val zona2 = new Zona(List("CP3", "CP4"), new Repartidor("Lucas", "Furgoneta"))

    val paquete1 = new Paquete("CP1", 1.5, "En transito")
    val paquete2 = new Paquete("CP3", 3.5, "En transito")

    zona1.asignarPaquete(paquete1)
    zona2.asignarPaquete(paquete2)

    asignarVehiculo(paquete1, zona1, zona2)
    asignarVehiculo(paquete2, zona1, zona2)

    println("Estado de entrega de paquete 1: " + paquete1.estadoEntrega)
    println("Fecha y hora de entrega de paquete 1: " + paquete1.fechaHoraEntrega.getOrElse("No entregado"))
    println("Codigo de envio de paquete 1: " + paquete1.codigoEnvio.getOrElse("No entregado"))

    println("Estado de entrega de paquete 2: " + paquete2.estadoEntrega)
    println("Fecha y hora de entrega de paquete 2: " + paquete2.fechaHoraEntrega.getOrElse("No entregado"))
    println("Codigo de envio de paquete 2: " + paquete2.codigoEnvio.getOrElse("No entregado"))


  def getCategoriaPeso(paquete: Paquete): String = {
    if (paquete.peso > 2) "Categoría 1" else "Categoría 2"
  }

  def asignarVehiculo(paquete: Paquete, zona1: Zona, zona2: Zona): Unit = {
    getCategoriaPeso(paquete) match {
      case "Categoría 1" => zona1.repartidor.entregarPaquete(paquete)
      case "Categoría 2" => zona2.repartidor.entregarPaquete(paquete)
    }
  }
}