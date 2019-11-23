Feature: Reserva de Restaurante
	Como usuario necesito realizar la gestión de restaurante
	
	@tag1
	Scenario: Reserva de restaurante
		Given el usuario se encuentra en la vista "Reserva Un Hotel"
		When selecciona restaurante
		And selecciona fecha posterior a la fecha actual
		And ingresa hora
		And ingresa numero de personas
		And Pais coincide con Pais de hotel reservado
		And da clic en "Registrar"
		Then Registra en la base de datos la nueva reserva
		
	@tag2
	Scenario: Reserva de restaurante fallido
		Given el usuario se encuentra en la vista "Reserva Un Hotel"
		When selecciona restaurante
		And selecciona fecha posterior a la fecha actual
		And ingresa hora
		And ingresa numero de personas
		And Pais no coincide con Pais de hotel reservado
		And da clic en "Registrar"
		Then Se muestra una alerta de "Ocurrio un error"
		
	@tag3
	Scenario: Reserva de restaurante fallido
		Given el usuario se encuentra en la vista "Reserva Un Hotel"
		When selecciona restaurante
		And selecciona fecha anterior a la fecha actual
		And ingresa hora
		And ingresa numero de personas
		And Pais coincide con Pais de hotel reservado
		And da clic en "Registrar"
		Then Se muestra una alerta de "Ocurrio un error"