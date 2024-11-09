package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import co.edu.unbosque.model.Especialista;

/**
 * La clase FileHandler proporciona métodos estáticos para gestionar la lectura y escritura
 * de archivos, tanto en formato de texto plano como en formato serializado. Se utiliza para
 * manejar archivos de datos y configuraciones de la aplicación, garantizando que las carpetas
 * necesarias existan y proporcionando una interfaz sencilla para leer y escribir archivos.
 * 
 * <p>Soporta operaciones como verificar la existencia de carpetas, cargar archivos de propiedades,
 * y manejar archivos de texto y objetos serializados.</p>
 * 
 * @author David Esteban Caicedo Saldaña
 * @version 1.0
 * @since 2024-11-10
 */
public class FileHandler {

	/**
     * Objeto utilizado para leer el contenido de un archivo.
     */
    private static Scanner sc;

    /**
     * Objeto utilizado para escribir contenido en un archivo.
     */
    private static PrintWriter pw;

    /**
     * Representa el archivo de operaciones de lectura y escritura.
     */
    private static File archivo;

    /**
     * Nombre de la carpeta donde se almacenan los archivos de datos.
     */
    private static final String FOLDER_NAME = "data";

    /**
     * Nombre de la carpeta donde se almacenan los archivos de configuración.
     */
    private static final String CONFIG_FOLDER_NAME = "config";

    /**
     * Flujo de salida para escribir archivos serializados.
     */
    private static FileOutputStream fos;

    /**
     * Objeto para serializar objetos en un archivo.
     */
    private static ObjectOutputStream oos;

    /**
     * Flujo de entrada para leer archivos serializados.
     */
    private static FileInputStream fis;

    /**
     * Objeto para deserializar objetos desde un archivo.
     */
    private static ObjectInputStream ois;

    /**
     * Verifica si la carpeta de almacenamiento de datos existe, y si no, la crea.
     * La carpeta se llama "data".
     */
    public static void checkFolder() {
		archivo = new File(FOLDER_NAME);
		if (archivo.exists() && archivo.isDirectory()) {
			return;
		} else {
			archivo.mkdir();
		}
	}

    /**
     * Verifica si la carpeta de configuración existe, y si no, la crea.
     * La carpeta se llama "config".
     */
	public static void checkPropertiesFolder() {

		archivo = new File(CONFIG_FOLDER_NAME);
		if (archivo.exists() && archivo.isDirectory()) {
			return;
		} else {
			archivo.mkdir();
		}

	}

	/**
     * Carga un archivo de propiedades desde la carpeta de configuración.
     * 
     * @param url Ruta del archivo de propiedades (relativa a la carpeta "config").
     * @return Las propiedades cargadas desde el archivo.
     */
	public static Properties loadProperties(String url) {

		Properties prop = null;

		prop = new Properties();

		try {
			prop.load(new FileInputStream(CONFIG_FOLDER_NAME + "/" + url));
		} catch (FileNotFoundException e) {
			System.out.println("RUTA DEL ARCHIVO DE PROPIEDADES NO ENCONTRADO (PROPERTIES)");
			System.out.println(CONFIG_FOLDER_NAME + "/" + url);
		} catch (IOException e) {
			System.out.println("ERROR AL LEER EL ARCHIVO DE PROPIEDADES");
		}

		return prop;

	}

	/**
     * Escribe un objeto serializado en un archivo dentro de la carpeta "data".
     * 
     * @param url El nombre del archivo en el que se guardará el objeto.
     * @param content El objeto a serializar y guardar.
     */
	public static void writeSerialized(String url, Object content) {

		try {
			archivo = new File(FOLDER_NAME + "/" + url);

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			fos = new FileOutputStream(archivo); // Write file
			oos = new ObjectOutputStream(fos); // To write file
			oos.writeObject(content); // writer
			fos.close();
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR EN CREAR ARCHIVO (Serialized)");
		}

	}

	/**
     * Lee un objeto serializado desde un archivo dentro de la carpeta "data".
     * 
     * @param url El nombre del archivo desde el que se leerá el objeto.
     * @return El objeto leído desde el archivo, o null si ocurre un error.
     */
	public static Object readSerialized(String url) {

		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);

			Object content = ois.readObject();

			fis.close();
			ois.close();
			return content;

		} catch (IOException e) {
			System.out.println("ERROR EN LECTURA DE ARCHIVO (SERIALIZED)");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR AL LEER LOS DATOS DEL SERIALIZED(CLASS NOT FOUND");
		}

		return null;
	}

	 /**
     * Escribe contenido de texto en un archivo dentro de la carpeta "data".
     * 
     * @param url El nombre del archivo en el que se guardará el contenido.
     * @param content El contenido de texto a escribir.
     */
	public static void writeFile(String url, String content) {
		try {

			archivo = new File(FOLDER_NAME + "/" + url); // la instancia solo apunta a esa posicion en el disco
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			pw = new PrintWriter(archivo);
			pw.write(content);
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR EN LA ESCRITURA DEL ARCHIVO (PLAIN TEXT)");
			// e.printStackTrace();
		} catch (IOException e) {

			System.out.println("ERROR EN LA CREACION DEL ARCHIVO (PLAIN TEXT)");
			// e.printStackTrace();
		}

	}

	 /**
     * Lee el contenido de un archivo de texto desde la carpeta "data".
     * 
     * @param url El nombre del archivo desde el que se leerá el contenido.
     * @return El contenido del archivo en formato de texto, o null si ocurre un error.
     */
	public static String readFile(String url) {

		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			sc = new Scanner(archivo);
			String content = "";
			while (sc.hasNext()) {
				content += sc.nextLine() + "\n";
			}

			return content;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	 /**
     * Lee el contenido de un archivo de texto de forma más eficiente utilizando
     * BufferedReader.
     * 
     * @param url El nombre del archivo desde el que se leerá el contenido.
     * @return El contenido del archivo en formato de texto.
     */
	public static String readFile2(String url) {
		url = FOLDER_NAME + "/" + url;
		String archivoCadena = null;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(url));
			
			try {
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();

			    while (line != null) {
			        sb.append(line);
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			    }
			    String everything = sb.toString();
			    archivoCadena = everything;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
			    try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return archivoCadena;
		
	}
	
}
