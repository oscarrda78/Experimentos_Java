Feature: Inicio de Sesion
	Como usuario necesito iniciar sesion
	
	@tag1
	Scenario: Inicio de sesion
		Given el usuario se encuentra en la vista "Home"
		When selecciona el boton Iniciar Sesion
		And ingresa correo
		And ingresa password
		And da clic en "Ingresar"
		Then muestra pantalla de listado de Hoteles
	
	
	@tag2
	Scenario: Inicio de sesion fallido
		Given el usuario se encuentra en la vista "Home"
		When selecciona el boton Iniciar Sesion
		And ingresa correo incorrecto
		And ingresa password
		And da clic en "Ingresar"
		Then muestra pantalla de listado de Hoteles	
	@tag3
	Scenario: Inicio de sesion fallido
		Given el usuario se encuentra en la vista "Home"
		When selecciona el boton Iniciar Sesion
		And ingresa correo 
		And ingresa password incorrecto
		Then muestra mensaje de error "Cuenta Invalida"
		And da clic en "Ingresar"
		Then muestra mensaje de error "Cuenta Invalida"