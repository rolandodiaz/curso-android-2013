package com.example.registroalumnosenclasefinal;

import android.widget.EditText;
import android.widget.RatingBar;

import com.example.registroalumnosenclasefinal.modelo.Alumno;

public class FormularioHelper {

	private EditText editNombre;
	private EditText editSite;
	private EditText editTelefono;
	private EditText editDireccion;
	private RatingBar ratingNota;

	public FormularioHelper(FormularioActivity formulario) {
		editNombre = (EditText) formulario.findViewById(R.id.nombre);
		editSite = (EditText) formulario.findViewById(R.id.site);
		editTelefono = (EditText) formulario.findViewById(R.id.telefono);
		editDireccion = (EditText) formulario.findViewById(R.id.direccion);
		ratingNota = (RatingBar) formulario.findViewById(R.id.nota);
	}

	public Alumno guardarAlumnoDeFormulario() {
		Alumno alumno = new Alumno();
		alumno.setNombre(editNombre.getText().toString());
		alumno.setSite(editSite.getText().toString());
		alumno.setTelefono(editTelefono.getText().toString());
		alumno.setDireccion(editDireccion.getText().toString());
		alumno.setNota(Double.valueOf(ratingNota.getRating()));
		
		return alumno;
		
	}

	public void colocaAlumnoEnFormulario(Alumno alumnoParaSerModificado) {
		
		editNombre.setText(alumnoParaSerModificado.getNombre());
		editSite.setText(alumnoParaSerModificado.getSite());
		editTelefono.setText(alumnoParaSerModificado.getTelefono());
		editDireccion.setText(alumnoParaSerModificado.getDireccion());
		ratingNota.setRating(alumnoParaSerModificado.getNota().floatValue());
	}

}
