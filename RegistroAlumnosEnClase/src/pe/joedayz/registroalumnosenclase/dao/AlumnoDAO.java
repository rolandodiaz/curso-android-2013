package pe.joedayz.registroalumnosenclase.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import pe.joedayz.registroalumnosenclase.modelo.Alumno;

public class AlumnoDAO extends SQLiteOpenHelper{

	private static final String DATABASE = "RegistroAlumnosEnClase";
	private static final int VERSION = 1;

	public AlumnoDAO(Context context) {
		super(context, DATABASE, null, VERSION);
	}

	public void grabar(Alumno alumno) {
		ContentValues values = new ContentValues();
		values.put("nombre", alumno.getNombre());
		values.put("site", alumno.getSite());
		values.put("direccion", alumno.getDireccion());
		values.put("nota", alumno.getNota());
		values.put("foto", alumno.getFoto());
		values.put("telefono", alumno.getTelefono());
		getWritableDatabase().insert("Alumnos", null, values);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String ddl = "CREATE TABLE Alumnos (" + "id PRIMARY KEY,"
				+ "nombre TEXT UNIQUE NOT NULL," + "telefono TEXT,"
				+ "direccion TEXT," + "site TEXT," + "foto TEXT,"
				+ "nota REAL);";
		db.execSQL(ddl);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String ddl = "DROP TABLE IF EXISTS Alumnos";
		db.execSQL(ddl);

		this.onCreate(db);
		
	}

	public List<Alumno> getLista() {
		// 0, 1, 2 ...
		String[] columnas = { "id", "nombre", "site", "telefono", "direccion",
				"foto", "nota" };
		
		Cursor cursor = getWritableDatabase().query("Alumnos", columnas, null,
				null, null, null, null, null);
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		while (cursor.moveToNext()) {

			Alumno alumno = new Alumno();
			alumno.setId(cursor.getLong(0));
			alumno.setNombre(cursor.getString(1));
			alumno.setSite(cursor.getString(2));
			alumno.setTelefono(cursor.getString(3));
			alumno.setDireccion(cursor.getString(4));
			alumno.setFoto(cursor.getString(5));
			alumno.setNota(cursor.getDouble(6));
			alumnos.add(alumno);
		}
		
		return alumnos;
	}

}
