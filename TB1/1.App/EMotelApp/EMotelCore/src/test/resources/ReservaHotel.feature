Feature: Reserva de Hotel
	Como usuario necesito realizar la gestión de hoteles
	
	@tag1
	Scenario: Reserva de hotel
		Given el usuario se encuentra en la vista "Reserva Un Hotel"
		When selecciona hotel
		And selecciona fecha posterior a la fecha actual
		And ingresa numero de dias
		And ingresa numero de personas
		And ingresa numero de cuartos menores o igual 3 y mayores que 0
		And da clic en "Registrar"
		Then Registra en la base de datos la nueva reserva
		
	@tag2
	Scenario: Reserva de hotel fallido
		Given el usuario se encuentra en la vista "Reserva Un Hotel"
		When selecciona hotel
		And selecciona fecha posterior a la fecha actual
		And ingresa numero de dias
		And ingresa numero de personas
		And ingresa numero de cuartos mayores que 3 y menores que 0
		And da clic en "Registrar"
		Then Muestra Alerta de Registro fallido "Ocurrió un Error"
		
	@tag3
	Scenario: Reserva de hotel fallido
		Given el usuario se encuentra en la vista "Reserva Un Hotel"
		When selecciona hotel
		And selecciona fecha anterior a la fecha actual
		And ingresa numero de dias
		And ingresa numero de personas
		And ingresa numero de cuartos menores o igual 3 y mayores que 0
		And da clic en "Registrar"
		Then Muestra Alerta de Registro fallido "Ocurrió un Error"