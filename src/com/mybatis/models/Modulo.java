package com.mybatis.models;

import java.util.ArrayList;

public class Modulo {
	private String nombre;
	private Object info;
	private int[] permisos;

	public Modulo(String nombre, Object info, int[] permiso) {
		this.nombre = nombre;
		this.info = info;
		this.permisos = permiso;
	}

	public Modulo(String nombre, Object info, int permiso) {
		this.nombre = nombre;
		this.info = info;
		this.permisos = new int[] { permiso };
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

	public int[] getPermiso() {
		return permisos;
	}

	public void setPermiso(int[] permiso) {
		this.permisos = permiso;
	}

	@SuppressWarnings("unchecked")
	public static String menu(ArrayList<Modulo> modulos, int cargo) {
		String menu = "";
		for (Modulo modulo : modulos) {
			boolean encuentra = false;
			for (int i = 0; i < modulo.getPermiso().length; i++) {
				if (modulo.getPermiso()[i] == cargo) {
					encuentra = true;
					break;
				}
			}
			if (encuentra) {
				menu += "<li>";
				String link = modulo.getInfo() instanceof String ? modulo.getInfo()+".html" : "#";  
				menu += "<a href='"+link+ "'><i class='fa fa-dashboard fa-fw'></i>"
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
