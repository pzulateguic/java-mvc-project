package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Alumno;
import controlador.Central;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class FormularioAlumnoModificar extends JFrame {

	private JPanel contentPane;
	private JTextField textoNombre;
	private JTextField textoDia;
	private JTextField textoAnio;

	public FormularioAlumnoModificar(Alumno alumno) {
		
		String[] dateSplitted = alumno.getFechaNacimiento().toString().split("-");
		String dia = dateSplitted[2];
		int mes = Integer.parseInt(dateSplitted[1]) - 1;
		String anio = dateSplitted[0];
		
		setTitle("ID: "+alumno.getId());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Modificar Alumno");
		btnNewButton.setBounds(120, 188, 185, 23);
		contentPane.add(btnNewButton);
		
		textoNombre = new JTextField();
		textoNombre.setBounds(190, 31, 137, 20);
		contentPane.add(textoNombre);
		textoNombre.setColumns(10);
		textoNombre.setText(alumno.getNombre());
		
		textoDia = new JTextField();
		textoDia.setBounds(190, 71, 137, 20);
		contentPane.add(textoDia);
		textoDia.setColumns(10);
		textoDia.setText(dia);
		
		textoAnio = new JTextField();
		textoAnio.setBounds(190, 133, 137, 20);
		contentPane.add(textoAnio);
		textoAnio.setColumns(10);
		textoAnio.setText(anio);
		
		JComboBox comboMes = new JComboBox();
		comboMes.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		comboMes.setBounds(190, 100, 137, 22);
		contentPane.add(comboMes);
		comboMes.setSelectedIndex(mes);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(99, 34, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(99, 74, 46, 14);
		contentPane.add(lblDia);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(99, 104, 46, 14);
		contentPane.add(lblMes);
		
		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setBounds(99, 136, 46, 14);
		contentPane.add(lblAo);
		
		setVisible(true);
		
		/* ACCIONES */
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Llamar al controlador pasandole los datos del alumno
				alumno.setNombre(textoNombre.getText());
				int day = Integer.parseInt(textoDia.getText());
				int month = comboMes.getSelectedIndex();
				int year = Integer.parseInt(textoAnio.getText()) - 1900;
				alumno.setFechaNacimiento(new Date(year, month, day));
				new Central().modificarAlumno(alumno);
			}
		});
	}
}
