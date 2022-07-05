package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import controller.BookController;
import controller.MemberController;
import dto.Member;
import util.Validator;

public class ListBook extends Container implements ActionListener {
	JLabel errorMsg;
	String err;
	BookController memController;
	
	public ListBook(String err) {
		this.err = err;
		memController = new BookController();
		this.initScreen();
	    
	    Main.frame.setVisible(true);
	}
	
	private void initScreen() {
		Container content = Main.frame.getContentPane();
		content.removeAll();
		Main.frame.setVisible(true);
		
		JPanel panel = new JPanel();	
		panel.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    c.insets = new Insets(5, 0, 0, 5);

		errorMsg = new JLabel(this.err);
		errorMsg.setForeground(Color.RED);

		Vector<Vector<String>> mems = memController.getMultiple(null);
		
		for(Vector<String> r : mems) {
			r.add("Delete");
		}
		
		Vector<String> header = new Vector<String>();
		header.add("ID");
		header.add("Title");
		header.add("Published Date");
		header.add("Author");
		header.add("Publisher");
		header.add("Actions");
		
		TableModel model = new DefaultTableModel(mems, header);
		   
		JTable table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {

			        int row = table.getSelectedRow();
			        int col = table.getSelectedColumn();
			        String id = (String) table.getValueAt(row, 0);
			        
			        if(col == 5) {
			        	int rs = memController.delete(id);
			        	String msg = null;
			        	if(rs == -3) msg = "An error occured.";
			        	else if(rs == -2) msg = "Data source is still not opened yet.";
			        	else if(rs == -1) msg = "Member " + id + " does not exist.";
			        	else if(rs == 0) msg = "There is no data provided.";
			        	else if(rs == 1) msg = "Member " + id + " has been deleted.";
			        	else msg = "Unkow error";
			        	JOptionPane.showMessageDialog(null, msg);
			        	new ListBook(msg);
			        }
			        else new UpdateBook(id);
			      }
			    });
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		c.gridx = 1;
	    c.gridy = 1;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(this.errorMsg, c);
		
	    c.gridx = 1;
	    c.gridy = 2;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(scrollPane, c);
	    
	    content.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
