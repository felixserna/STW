

CarritoBeanModule:	Módulo EJB que implementa CarritoBean. Ofrece únicamente un interface remoto.

webCarritoRemoto: app web que utiliza el CarritoBean anterior de forma remota.

webCarritoLocal: app web igual a la anterior, pero utiliza un bean Carrito de forma local (el EJB 
				 en este caso reside en la misma aplicación). No hace uso de "CarritoBeanModule".