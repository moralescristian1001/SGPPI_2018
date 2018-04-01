package com.mybatis.models;

import java.util.ArrayList;

public class Modulo {
	private String nombre;
	private Object info;
	private int[] permisos;
	private String icono;

	public Modulo(String nombre, Object info, int[] permiso, String icono) {
		this.nombre = nombre;
		this.info = info;
		this.permisos = permiso;
		this.icono = icono;
	}

	public Modulo(String nombre, Object info, int permiso, String icono) {
		this.nombre = nombre;
		this.info = info;
		this.permisos = new int[] { permiso };
		this.icono = icono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public int[] getPermisos() {
		return permisos;
	}

	public void setPermisos(int[] permisos) {
		this.permisos = permisos;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	@SuppressWarnings("unchecked")
	public static String menu(ArrayList<Modulo> modulos, int cargo) {
		String menu = "";
		for (Modulo modulo : modulos) {
			boolean encuentra = false;
			if (cargo == 6) {
				encuentra = true;
			} else {
				for (int i = 0; i < modulo.getPermisos().length; i++) {
					if (modulo.getPermisos()[i] == cargo) {
						encuentra = true;
						break;
					}
				}
			}
			if (encuentra) {
				menu += "<li>";
				String link = modulo.getInfo() instanceof String ? modulo.getInfo() + ".html" : "#";
				menu += "<a href='" + link + "'><i class='fa fa-" + modulo.getIcono() + " fa-fw'></i>"
						+ modulo.getNombre() + "</a>";
				if (modulo.getInfo() instanceof ArrayList<?>) {
					menu += "<ul class='nav nav-second-level'>" + menu((ArrayList<Modulo>) modulo.getInfo(), cargo)
							+ "</ul>";
				}
				menu += "</li>";
			}
		}
		return menu;
	}
}
