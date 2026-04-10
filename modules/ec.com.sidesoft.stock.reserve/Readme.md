Carnidem

Descripcion
El modulo presente nos permite crear reserva de existencias, la presente funcionalidad nace cuando se requiere aumentar un paso mas al flujo del POS al momento de 
crear nuevos pedidos, pero se ha encontrado una limitacion para implementar este desarrollo en el flujo del POS ya que en cuanto a su esquema que maneja el POS no puede ejecutar procesos directos de la BDD ya que al momento de terminar todo el flujo de un pedido aun se encuentra ese registro solo en el ORM de java (sesion) pero aun no esta comiteado en la BDD. Por lo cual no se puede generar una reserva de existencias ya que consume funciones de BDD y fuentes de datos, por lo cual se realiza una reunion para coordinar una solucion alternativa entre la parte consultora y tecnica y se decide desarrollar un background 'Reserva de Existencias'


Autores ✒️
Esteban Cuasapaz - Ticket 17349 - Revisión y cambio de estado en los pedidos de Reserva del POS
