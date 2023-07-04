object Main extends App {
  // Creamos los repartidores Ana y Lucas con sus respectivas zonas y rangos de peso
  val ana = new Repartidor(
    nombre = "Ana",
    zonas = List(new Zona(List("CP1", "CP2"))),
    minPeso = 0.0,
    maxPeso = 2.0
  )

  val lucas = new Repartidor(
    nombre = "Lucas",
    zonas = List(new Zona(List("CP3", "CP4"))),
    minPeso = 2.0 + Double.MinPositiveValue,
    maxPeso = Double.PositiveInfinity
  )

  // Creamos la empresa de paquetería
  val empresa = new EmpresaPaqueteria(List(ana, lucas))

  // Creamos algunos paquetes
  val paquete1 = Paquete(id = "1", peso = 1.5, codigoPostal = "CP1", dniCliente = "12345678A")
  val paquete2 = Paquete(id = "2", peso = 2.5, codigoPostal = "CP3", dniCliente = "87654321B")
  val paquete3 = Paquete(id = "3", peso = 0.5, codigoPostal = "CP2", dniCliente = "23456789C")
  val paquete4 = Paquete(id = "4", peso = 3.5, codigoPostal = "CP4", dniCliente = "98765432D")

  // Los paquetes son recibidos por la empresa
  empresa.recibirPaquetes(List(paquete1, paquete2, paquete3, paquete4))

  // Ahora vamos a entregar algunos paquetes
  ana.entregarPaquete("1", "Firma Cliente 1")
  lucas.entregarPaquete("2", "Firma Cliente 2")

  // Finalmente, mostramos los paquetes que no se han entregado aún
  val paquetesNoEntregados = empresa.obtenerPaquetesNoEntregados
  println(s"Paquetes no entregados: $paquetesNoEntregados")
}
