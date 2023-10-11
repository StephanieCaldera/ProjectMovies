package entitties;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Movie {
   //Se define los atributos de la clase
	private int codigo;
	private String titulo;
	private MovieGenre genero;
	private String url;
	private String rutaImagen;
	private Image imagen;
	
	//se crea el constructor con parametros
	

	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(int codigo, String titulo, MovieGenre genero, String url, String rutaImagen) throws IOException {
		super();
		this.titulo = titulo;
		this.codigo = codigo;
		this.url = url;
		this.genero = genero;
		this.rutaImagen = rutaImagen;
		this.imagen = ImageIO.read(new File (rutaImagen));
		if (imagen == null) {
			throw new IOException("no se pudo cargar la imgen desde el archivo.");
		}
	}
	
	
	public Movie(String titulo, MovieGenre genero, String url, String rutaImagen) throws IOException {
		super();
		this.titulo = titulo;
		this.url = url;
		this.genero = genero;
		this.rutaImagen = rutaImagen;
		this.imagen = ImageIO.read(new File (rutaImagen));
		if (imagen == null) {
			throw new IOException("no se pudo cargar la imgen desde el archivo.");
		}
	}
	
	
	//metodos get y set
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public MovieGenre getGenero() {
		return genero;
	}

	public void setGenero(MovieGenre genero) {
		this.genero = genero;
	}
	
	public Image getImagen() {
		return imagen;
	}
	

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	
	//otros metodos
	@Override
	public String toString() {
		return "Movie [titulo=" + titulo + ", codigo=" + codigo + ", url=" + url + ", genero=" + genero + ", imagen="
				+ imagen + "]";		 
	}
	
	


	
	

}
