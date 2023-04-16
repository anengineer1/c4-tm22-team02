package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class InsertScientistView extends JPanel {
	private JTextField inputDNIScientist;
	private JTextField inputNomApels;

	private JLabel labelDNIScientist;
	private JLabel labelNomApels;

	public InsertScientistView() {

		initializeView();
	}

	private void initializeView() {
		this.setBounds(100, 100, 400, 300);
		this.setLayout(null);

		this.labelDNIScientist = new JLabel("DNI");
		this.labelDNIScientist.setBounds(10, 10, 150, 30);
		this.add(this.labelDNIScientist);

		this.inputDNIScientist = new JTextField();
		AbstractDocument doc = (AbstractDocument) this.inputDNIScientist.getDocument();
		doc.setDocumentFilter(new DocumentFilter() {
		    @Override
		    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
		        int currentLength = currentText.length() - length + text.length();
		        if (currentLength <= 8) {
		            super.replace(fb, offset, length, text, attrs);
		        } else {
		            // Display an error message or perform some other action
		        }
		    }
		});
		this.inputDNIScientist.setBounds(160, 10, 120, 30);
		this.add(this.inputDNIScientist);

		this.labelNomApels = new JLabel("Nombre completo");
		this.labelNomApels.setBounds(10, 50, 150, 30);
		this.add(this.labelNomApels);

		this.inputNomApels = new JTextField();
		this.inputNomApels.setBounds(160, 50, 120, 30);
		this.add(this.inputNomApels);

	}
	
	public String getScientistDNI() {
		return this.inputDNIScientist.getText();
	}
	
	public String getNomApels() {
		return this.inputNomApels.getText();
	}

}
