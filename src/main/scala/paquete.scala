class Paquete(val codigoPostal: String, val peso: Double, var estadoEntrega: String) {
  var fechaHoraEntrega: Option[String] = None
  var codigoEnvio: Option[String] = None
}