package dto;

import java.sql.Date;

public class PersonaDTO
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String email;
	private Date cumpleaños;
	private String calle;
	private String altura;
	private String piso;  
	private String dpto;
	
	private String categoria;
	private String localidad;
	
	private String zodiaco;

	public PersonaDTO(int idPersona, String nombre, String telefono, String email, 
						Date cumpleaños,String calle, String altura, String piso,
						String dpto, String localidad, String categoria)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.cumpleaños = cumpleaños;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.dpto = dpto;
		this.categoria = categoria;
		this.localidad = localidad;
		
		this.zodiaco = setZodiaco();
	}
	
	public String getZodiaco() {
		return zodiaco;
	}

	public int getIdPersona() 
	{
		return this.idPersona;
	}
	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}
	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}

	public Date getCumpleaños()
	{
		return cumpleaños;
	}
	public void setCumpleaños(Date cumpleaños)
	{
		this.cumpleaños = cumpleaños;
	}

	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDpto() {
		return dpto;
	}
	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getLocalidad() {
		return localidad;
	}
	
	@SuppressWarnings("deprecation")
	public String setZodiaco() {
		int dia = cumpleaños.getDate();
		int mes = cumpleaños.getMonth();
		
		String signo = "";
	    switch (mes) {
	        case 0:
	            if (dia > 21) {
	                signo = "Acuario";
	            } else {
	                signo = "Capricornio";
	            }
	            break;
	        case 1:
	                if (dia > 19) {
	                    signo = "Piscis";
	                } else {
	                    signo = "Acuario";
	                }
	                break;
	        case 2:
	                if (dia > 20) {
	                    signo = "Aries";
	                } else {
	                    signo = "Piscis";
	                }
	                break;
	        case 3:
	                if (dia > 20) {
	                    signo = "Tauro";
	                } else {
	                    signo = "Aries";
	                }
	                break;
	        case 4:
	                if (dia > 21) {
	                    signo = "Geminis";
	                } else {
	                    signo = "Tauro";
	                }
	                break;
	        case 5:
	                if (dia > 20) {
	                    signo = "Cancer";
	                } else {
	                    signo = "Geminis";
	                }
	                break;
	        case 6:
	                if (dia > 22) {
	                    signo = "Leo";
	                } else {
	                    signo = "Cancer";
	                }
	                break;
	        case 7:
	                if (dia > 21) {
	                    signo = "Virgo";
	                } else {
	                    signo = "Leo";
	                }
	                break;
	        case 8:
	                if (dia > 22) {
	                    signo = "Libra";
	                } else {
	                    signo = "Virgo";
	                }
	                break;
	        case 9:
	                if (dia > 22) {
	                    signo = "Escorpio";
	                } else {
	                    signo = "Libra";
	                }
	                break;
	        case 10:
	                if (dia > 21) {
	                    signo = "Sagitario";
	                } else {
	                    signo = "Escorpio";
	                }
	                break;
	        case 11:
	                if (dia > 21) {
	                    signo = "Capricornio";
	                } else {
	                    signo = "Sagitario";
	                }
	        break;
	    }
	    return signo;
	}
}
