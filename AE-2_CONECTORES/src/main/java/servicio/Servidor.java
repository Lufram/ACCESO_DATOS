package servicio;

import java.util.Scanner;

import servicio.modelo.entidad.Coche;
import servicio.modelo.entidad.Pasajero;
import servicio.modelo.persistencia.DaoCocheMySql;
import servicio.modelo.persistencia.DaoPasajeroMySql;

public class Servidor {

	public static void main(String[] args) {
		System.out.println("-----------------------------------");
		System.out.println("-----------------------------------");
		System.out.println("        ALMACEN TARTANACAR      ");
		System.out.println("-----------------------------------");

		// Bloque try, abre el escaner y lo cierra al terminar el bloque.
		try (Scanner sc = new Scanner(System.in)) {

			// --------------------- MENU --------------------------//

			// boolean para controlar la salida del do while.
			boolean finAplicacion = true;
			DaoCocheMySql dc = new DaoCocheMySql();
			DaoPasajeroMySql dp = new DaoPasajeroMySql();
			Conexion conexionBBDD = new Conexion();
			System.out.println("Iniciando Base de datos");
			conexionBBDD.crearBBDD();

			do {
				// Pinta el menu
				menu();

				// Lee la respuesta del usuario por consola.
				String answer = sc.nextLine();

				// Bucle que solicita un numero hasta que el valor introducido sea 1 2 3 4 5 6
				// 7.
				while (!answer.equals("1") && !answer.equals("2") && !answer.equals("3") && !answer.equals("4")
						&& !answer.equals("5") && !answer.equals("6") && !answer.equals("7")) {
					System.out.println("Tiene que escoger una de las 7 opciones");
					// Lee la respuesta del usuario por consola.
					answer = sc.nextLine();
				}

				// Respuesta del programa segun la eleccion del usuario.
				switch (answer) {

				case "1": // Ingresar nuevo coche

					// Informa de la eleccion del cliente
					System.out.println("Ha seleccionado dar de alta un vehiculo");
					System.out.println("---------------------------------------");

					Coche c = new Coche();

					// Solicita por consola informacion del vehiculo.
					System.out.println("Introduce la matricula del vehiculo");
					c.setMatricula(sc.nextLine());
					System.out.println("Introduce la marca del vehiculo");
					c.setMarca(sc.nextLine());
					System.out.println("Introduce el modelo del vehiculo");
					c.setModelo(sc.nextLine());
					System.out.println("Introduce el color del vehiculo");
					c.setColor(sc.nextLine());
					// Pasa el objeto al DAO para darlo de alta
					dc.alta(c);

					break;

				case "2": // Borrar un coche por Id

					boolean borrado;
					// Solicita por consola el ID del coche
					System.out.println("Introduce el ID del vehiculo que deseas borrar: ");
					try {
						// Pasa el ID al DAO para dar de baja el coche
						borrado = dc.baja(Integer.parseInt(sc.nextLine()));
						if (borrado == true) {
							System.out.println("VEHICULO DADO DE BAJA");
						} else {
							System.out.println("No se ha podido dar de baja el vehiculo");
						}
					} catch (NumberFormatException e) {
						System.out.println("ERROR de formato, dato no válido");
					}

					break;

				case "3": // Consultar coche por Id

					// Solicita por consola el ID del coche
					System.out.println("Introduce el ID del vehiculo que deseas encontrar: ");
					try {
						Coche c1 = new Coche();
						// Pasa el ID al DAO para consultar el coche
						c1 = dc.obtener(Integer.parseInt(sc.nextLine()));
						if (c1 == null) {
							System.out.println("No existe el coche");
						} else {
							System.out.println(c1);
						}
					} catch (NumberFormatException e) {
						System.out.println("ERROR de formato, dato no válido");
					}

					break;

				case "4":// Modificar coche por Id
					try {

						Coche c2 = new Coche();
						System.out.println("Introduce el ID del vehiculo que deseas modificar");
						c2.setId(Integer.parseInt(sc.nextLine()));
						System.out.println("Introduce la matricula del vehiculo");
						c2.setMatricula(sc.nextLine());
						System.out.println("Introduce la marca del vehiculo");
						c2.setMarca(sc.nextLine());
						System.out.println("Introduce el modelo del vehiculo");
						c2.setModelo(sc.nextLine());
						System.out.println("Introduce el color del vehiculo");
						c2.setColor(sc.nextLine());
						// Pasa el objeto al DAO para modificarlo
						dc.modificar(c2);
					} catch (NumberFormatException e) {
						System.out.println("ERROR de formato, dato no válido");
					}

					break;

				case "5": // Listar todos los coches
					
					if (dc.listar().isEmpty()) {
						System.out.println("No hay coches en la base de datos");
					} else {
						// Imprime la lista de coches
						System.out.println(dc.listar());
					}

					break;

				case "6":
					boolean finSubMenu = true;
					do {
						// Imprime el submenu
						subMenu();

						// Lee la respuesta del usuario por consola.
						String answerSub = sc.nextLine();

						// Bucle que solicita un numero hasta que el valor introducido sea 1 2 3 4 5 6 7
						// o 8.
						while (!answer.equals("1") && !answer.equals("2") && !answer.equals("3") && !answer.equals("4")
								&& !answer.equals("5") && !answer.equals("6") && !answer.equals("7")
								&& !answer.equals("8")) {

							System.out.println("Tiene que escoger una de las 8 opciones");

							// Lee la respuesta del usuario por consola.
							answerSub = sc.nextLine();
						}

						// Respuesta del programa segun la eleccion del usuario.
						switch (answerSub) {

						case "1": // Ingresar nuevo pasajero

							// Informa de la eleccion del cliente
							System.out.println("Ha seleccionado dar de alta un pasajero");
							System.out.println("---------------------------------------");

							Pasajero p = new Pasajero();
							try {
								// Solicita por consola informacion del vehiculo.
								System.out.println("Introduce el nombre del pasajero");
								p.setNombre(sc.nextLine());
								System.out.println("Introduce la edad del pasajero");
								p.setEdad(Integer.parseInt(sc.nextLine()));
								System.out.println("Introduce el peso del pasajero");
								p.setPeso(Integer.parseInt(sc.nextLine()));
								// Pasa el objeto al DAO para darlo de alta
								dp.alta(p);
							} catch (NumberFormatException e) {
								System.out.println("ERROR de formato, dato no válido");
							}

							break;

						case "2": // Borrar un pasajero por Id

							boolean borradoPasajero;
							// Solicita por consola el ID del pasajero
							System.out.println("Introduce el ID del pasajero que deseas borrar: ");
							try {
								// Pasa el ID al DAO para dar de baja el pasajero
								borradoPasajero = dp.baja(Integer.parseInt(sc.nextLine()));
								if (borradoPasajero == true) {
									System.out.println("PASAJERO DADO DE BAJA");
								} else {
									System.out.println("No se ha podido dar de baja el pasajero");
								}
							} catch (NumberFormatException e) {
								System.out.println("ERROR de formato, dato no válido");
							}

							break;

						case "3": // Consultar pasajero por Id

							// Solicita por consola el ID del pasajero
							System.out.println("Introduce el ID del pasajero que deseas encontrar: ");
							try {
								Pasajero p1 = new Pasajero();
								// Pasa el ID al DAO para consultar el pasajero
								p1 = dp.obtener(Integer.parseInt(sc.nextLine()));

								if (p1 == null) {
									System.out.println("No existe el pasajero");
								} else {
									System.out.println(p1);
								}
							} catch (NumberFormatException e) {
								System.out.println("ERROR de formato, dato no válido");
							}

							break;

						case "4":// Listar todos los pasajeros
							
							if (dp.listar().isEmpty()) {
								System.out.println("No hay pasajeros en la base de datos");
							} else {
								// Imprime la lista de pasajeros
								System.out.println(dp.listar());
							}

							break;

						case "5": // Añadir pasajero a coche
							
							System.out.println("Introduce el id del pasajero");
							int idPasajero = Integer.parseInt(sc.nextLine());
							if (dp.validarIdPasajero(idPasajero) == false) {
								System.out.println("El pasajero no existe");
							} else {
								if (dc.listar().isEmpty()) {
									System.out.println("No hay vehiculos disponibles");
								} else {
									System.out.println("Estos son los coches disponibles: ");
									System.out.println(dc.listar());
									System.out.println("Introduce el id del coche");
									int idCoche = Integer.parseInt(sc.nextLine());
									if (dc.validarIdCoche(idCoche) == false) {
										System.out.println("El coche no existe");
									} else {
										// Pasa el ID del coche y el del pasajero al DAO para asignarlo
										dp.anadirPasajero(idCoche, idPasajero);
									}
								}

							}

							break;

						case "6": // Eliminar pasajero de un coche
							if (dc.listar().isEmpty()) {
								System.out.println("No hay vehiculos disponibles");
							} else {
								System.out.println("Estos son los coches disponibles y sus pasajeros: ");
								dc.mostrarCochesConPasajeros();
								System.out.println("Introduce el id del coche");
								int idCoche = Integer.parseInt(sc.nextLine());
								if (dc.validarIdCoche(idCoche) == false) {
									System.out.println("El coche no existe");
								} else {
									System.out.println("Introduce el id del pasajero");
									int idPasajero2 = Integer.parseInt(sc.nextLine());
									if (dp.validarIdPasajero(idPasajero2) == false) {
										System.out.println("El pasajero no existe");
									} else {
										// Pasa el ID del coche y el del pasajero al DAO para borrar el pasajero del
										// coche
										dp.borrarPasajero(idCoche, idPasajero2);
									}
								}
							}
							

							break;

						case "7": // Listar todos los pasajeros de un coche

							System.out.println("Introduce el id del coche:");
							int idCoche2 = Integer.parseInt(sc.nextLine());
							if (dc.validarIdCoche(idCoche2) == false) {
								System.out.println("El coche no existe");
							} else {
								System.out.println("Datos del coche : " + dc.obtener(idCoche2));
								if (dc.listarPasajeros(idCoche2).isEmpty()) {
									System.out.println("No hay pasajeros asociados al coche");
								} else {
									// Imprime la lista de pasajeros asociados a un coche
									System.out.println("Pasajeros asociados : " + dc.listarPasajeros(idCoche2));
								}
							}

							break;

						case "8": // Volver al menu principal
							// Cambia el boolean para salir del do while.
							finSubMenu = false;

							break;

						}

					} while (finSubMenu); // Fin del do while, comprueba si el boolean es true.

					break;

				case "7": // Salir del programa
					System.out.println("CERRANDO APLICACION");
					// Cambia el boolean para salir del do while.
					finAplicacion = false;

					break;

				}

			} while (finAplicacion); // Fin del do while, comprueba si el boolean es true.

			// Captura las posibles excepciones.
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
		}

	}

	// Metodo para imprimir el menu
	private static void menu() {
		System.out.println("-----------------------------------\n" + "MENU PRINCIPAL"
				+ "\n Tiene que elegir una de estas opciones:" + "\n 1-. Anadir nuevo coche"
				+ "\n 2-. Borrar coche por id" + "\n 3-. Consulta coche por id" + "\n 4-. Modificar coche por id"
				+ "\n 5-. Listado de coches" + "\n 6-. Gestion de pasajeros" + "\n 7-. Salir de la aplicacion"
				+ "\n-----------------------------------");

	}
	
	// Metodo para imprimir el submenu
	private static void subMenu() {
		System.out.println("-----------------------------------\n" + "MENU PASAJEROS"
				+ "\n Tiene que elegir una de estas opciones:" + "\n 1-. Anadir nuevo pasajero"
				+ "\n 2-. Borrar pasajero por id" + "\n 3-. Consulta pasajero por id"
				+ "\n 4-. Listar todos los pasajeros" + "\n 5-. Anadir pasajero a coche"
				+ "\n 6-. Eliminar pasajero de un coche" + "\n 7-. Listar todos los pasajeros de un coche"
				+ "\n 8-. Volver al menu principal" + "\n-----------------------------------");

	}

}
