case class Paquete(
    id: String, 
    peso: Double, 
    codigoPostal: String, 
    dniCliente: String, 
    esEntregado: Boolean = false, 
    firma: Option[String] = None, 
    fechaEntrega: Option[String] = None
)
