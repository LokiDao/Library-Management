package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.BookController;
import controller.MemberController;
import dto.Book;
import dto.Member;
import util.Validator;

public class AddBook extends Container implements ActionListener {
	JTextField id;
	JTextField name;
	JTextField dob;
	JTextField author;
	JTextField publisher;
	JLabel errorMsg;
	BookController controller;
	
	public AddBook() {
		this.initScreen();
	    this.setIdValidation();
	    this.setNameValidation();
	    this.setDoBValidation();
	    
	    Main.frame.setVisible(true);
	}
	
	private void initScreen() {
		Container content = Main.frame.getContentPane();
		content.removeAll();
		Main.frame.setVisible(true);
		
		JLabel label1 = new JLabel("Book ID");
		id = new JTextField(20);
		JLabel label2 = new JLabel("Title");
		name = new JTextField(20);
		JLabel label3 = new JLabel("Publised Date");
		dob = new JTextField(20);
		JLabel label4 = new JLabel("Author");
		author = new JTextField(20);
		JLabel label5 = new JLabel("Publisher");
		publisher = new JTextField(20);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(this);
		
		errorMsg = new JLabel();
		errorMsg.setForeground(Color.RED);
		
		JPanel panel = new JPanel();	
		panel.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    c.insets = new Insets(5, 0, 0, 5);

	    c.gridx = 1;
	    c.gridy = 1;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(label1, c);
	    
	    c.gridx = 2;
	    c.gridy = 1;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(id, c);
	    
	    c.gridx = 1;
	    c.gridy = 2;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(label2, c);
	    
	    c.gridx = 2;
	    c.gridy = 2;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(name, c);
	    
	    c.gridx = 1;
	    c.gridy = 3;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(label3, c);
	    
	    c.gridx = 2;
	    c.gridy = 3;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(dob, c);
	    
	    c.gridx = 1;
	    c.gridy = 4;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(label4, c);
	    
	    c.gridx = 2;
	    c.gridy = 4;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(author, c);
	    
	    c.gridx = 1;
	    c.gridy = 5;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(label5, c);
	    
	    c.gridx = 2;
	    c.gridy = 5;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(publisher, c);
	    
	    c.gridx = 2;
	    c.gridy = 6;
	    c.anchor = GridBagConstraints.SOUTH;
	    panel.add(errorMsg, c);
	    
	    c.gridx = 2;
	    c.gridy = 7;
	    c.anchor = GridBagConstraints.CENTER;
	    panel.add(submit, c);
	    
	    content.add(panel);
	}
	
	private void setIdValidation() {
		id.getDocument().addDocumentListener(new DocumentListener()
	    {
	      @Override
	      public void removeUpdate(DocumentEvent e)
	      {
	    	  if(!Validator.isSet(id.getText())) {
	    		  errorMsg.setText("ID cannot be blank.");
	    		  id.requestFocus();
	    	  } else if(!Validator.isNumber(id.getText())) {
	    		  errorMsg.setText("ID must be a number.");
	    		  id.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }

	      @Override
	      public void insertUpdate(DocumentEvent e)
	      {
	    	  if(!Validator.isSet(id.getText())) {
	    		  errorMsg.setText("ID cannot be blank.");
	    		  id.requestFocus();
	    	  } else if(!Validator.isNumber(id.getText())) {
	    		  errorMsg.setText("ID must be a number.");
	    		  id.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }

	      @Override
	      public void changedUpdate(DocumentEvent e) {
	    	  if(!Validator.isSet(id.getText())) {
	    		  errorMsg.setText("ID cannot be blank.");
	    		  id.requestFocus();
	    	  } else if(!Validator.isNumber(id.getText())) {
	    		  errorMsg.setText("ID must be a number.");
	    		  id.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }
	    });
	}
	
	private void setNameValidation() {
		name.getDocument().addDocumentListener(new DocumentListener()
	    {
	      @Override
	      public void removeUpdate(DocumentEvent e)
	      {
	    	  if(!Validator.isSet(name.getText())) {
	    		  errorMsg.setText("Title cannot be blank.");
	    		  name.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }

	      @Override
	      public void insertUpdate(DocumentEvent e)
	      {
	    	  if(!Validator.isSet(name.getText())) {
	    		  errorMsg.setText("Title cannot be blank.");
	    		  name.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }

	      @Override
	      public void changedUpdate(DocumentEvent e) {
	    	  if(!Validator.isSet(name.getText())) {
	    		  errorMsg.setText("Title cannot be blank.");
	    		  name.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }
	    });
	}
	
	private void setDoBValidation() {
		dob.getDocument().addDocumentListener(new DocumentListener()
	    {
	      @Override
	      public void removeUpdate(DocumentEvent e)
	      {
	    	  if(Validator.isSet(dob) && !Validator.isDate(dob.getText())) {
	    		  errorMsg.setText("Wrong date format");
	    		  dob.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }

	      @Override
	      public void insertUpdate(DocumentEvent e)
	      {
	    	  if(Validator.isSet(dob) && !Validator.isDate(dob.getText())) {
	    		  errorMsg.setText("Wrong date format");
	    		  dob.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }

	      @Override
	      public void changedUpdate(DocumentEvent e) {
	    	  if(Validator.isSet(dob) && !Validator.isDate(dob.getText())) {
	    		  errorMsg.setText("Wrong date format");
	    		  dob.requestFocus();
	    	  }
	    	  else errorMsg.setText("");
	      }
	    });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!Validator.isSet(id.getText())) {
	  		  errorMsg.setText("ID cannot be blank.");
	  		  id.requestFocus();
  	  	} else if(!Validator.isNumber(id.getText())) {
	  		  errorMsg.setText("ID must be a number.");
	  		  id.requestFocus();
  	  	} else if(!Validator.isSet(name.getText())) {
	  		  errorMsg.setText("Title cannot be blank.");
	  		  name.requestFocus();
  	  	} else if(Validator.isSet(dob) && !Validator.isDate(dob.getText())) {
	  		  errorMsg.setText("Wrong date format");
	  		  dob.requestFocus();
  	  	} else {
  	  	controller = new BookController();
			Book mem = new Book(id.getText(), name.getText(), dob.getText(), author.getText(), publisher.getText());
			int rs = controller.add(mem);
			String msg = null;
        	if(rs == -3) msg = "An error occured.";
        	else if(rs == -2) msg = "Data source is still not opened yet.";
        	else if(rs == -1) msg = "Book " + mem.getId() + " is already existed.";
        	else if(rs == 0) msg = "There is no data provided.";
        	else if(rs == 1) msg = "Book " + mem.getId() + " has been added.";
        	else msg = "Unkow error";
        	JOptionPane.showMessageDialog(null, msg);
			if(rs == 1) new ListBook(msg);
  	  	}
	}
}
