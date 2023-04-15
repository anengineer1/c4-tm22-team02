package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class InsertProjectView extends JPanel {

	private JTextField inputIdProject;
	private JTextField inputProjectName;
	private JTextField inputHours;

	private JLabel labelIdProject;
	private JLabel labelProjectName;
	private JLabel labelHours;

	public InsertProjectView() {

		initializeView();
	}

	private void initializeView() {
		this.setBounds(350, 100, 400, 300);
		this.setLayout(null);

		this.labelIdProject = new JLabel("Id Proyecto");
		this.labelIdProject.setBounds(10, 10, 150, 30);
		this.add(this.labelIdProject);

		this.inputIdProject = new JTextField();
		AbstractDocument doc = (AbstractDocument) this.inputIdProject.getDocument();
		doc.setDocumentFilter(new DocumentFilter() {
		    @Override
		    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
		        int currentLength = currentText.length() - length + text.length();
		        if (currentLength <= 4) {
		            super.replace(fb, offset, length, text, attrs);
		        } else {
		            // Do nothing
		        }
		    }
		});
		this.inputIdProject.setBounds(160, 10, 120, 30);
		this.add(this.inputIdProject);

		this.labelProjectName = new JLabel("Nombre de proyecto");
		this.labelProjectName.setBounds(10, 50, 150, 30);
		this.add(this.labelProjectName);

		this.inputProjectName = new JTextField();
		this.inputProjectName.setBounds(160, 50, 120, 30);
		this.add(this.inputProjectName);

		this.labelHours = new JLabel("Número de horas");
		this.labelHours.setBounds(10, 90, 150, 30);
		this.add(this.labelHours);

		this.inputHours = new JTextField();
		this.inputHours.setBounds(160, 90, 120, 30);
		AbstractDocument doc_int = (AbstractDocument) inputHours.getDocument();
		doc_int.setDocumentFilter(new DocumentFilter() {
		    @Override
		    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
		        String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
		        if (newText.matches("-?\\d*")) {
		            super.replace(fb, offset, length, text, attrs);
		        } else {
		            // Do nothing
		        }
		    }
		});
		this.add(this.inputHours);

	}

	public String getIdProject() {
		return this.inputIdProject.getText();
	}

	public String getProjectName() {
		return this.inputProjectName.getText();
	}

	public String getHours() {
		return this.inputHours.getText();
	}

}
